/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import control.Teclado;
import logica.Player;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

/**
 *
 * @author personal
 */
public class Ventana extends Canvas implements Runnable{
    
    private static int aps = 0;
    private static int fps = 0;
    
    private static JFrame ventana;
    private static final int ALTO = 300;
    private static final int ANCHO = 400;
    private static final String NOMBRE = "Prueba";
    
    private static Thread hilo;
    private static volatile boolean ejecucion = false;//volatile=para que no se use al tiempo en ambos hilos
    
    private Teclado teclado;
    private Pantalla pantalla;
    private static Player jugador;
    
    private BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_ARGB);
    private int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();//devuelve un array de enteros que representa los pixeles de la imagen
    
    public Ventana(){
        setPreferredSize(new Dimension(ANCHO, ALTO));
        
        teclado = new Teclado();
        addKeyListener(teclado);
        
        jugador = new Player(ANCHO/2,ALTO/2,teclado,'s',false);
        
        pantalla = new Pantalla(ANCHO, ALTO);
        
        
        
        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);//el canvas sale en el centro de la ventana, asi solo se vera una cosa
        ventana.pack();//Para que todo se ajuste al alto y ancho usado antes
        ventana.setLocationRelativeTo(null);//salga al centro de la pantalla
        ventana.setVisible(true);
    }
    
    public synchronized void iniciar(){
        ejecucion = true;
        hilo = new Thread(this, "Graficos");
        hilo.start();
    }
    
    public synchronized void detener(){
        ejecucion = false;
        
        try{
            hilo.join();//para que el hilo se acabe de ejecutar y luego se detenga
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    private void actualizar(){
        teclado.actualizar();
        
        jugador.actualizar();
        
        
        aps++;
    }
    
    private void mostrar(){
        BufferStrategy estrategia = getBufferStrategy();//espacios de memoria para que el proceso de cargado de la imagen sea mas rapido
        
        if(estrategia == null){
            createBufferStrategy(3);//crea 3 espacios de memoria
            return;
        }
        
        pantalla.limpiar();
        pantalla.dibujar(jugador.getXCoor(), jugador.getYCoor());
        
        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);//(array que se va a copiar, posicion desde el cual se va a copiar, array donde se copiara, inicio del array donde se copiara, tamaño del array al que vamos a copiar)
        
        Graphics g = estrategia.getDrawGraphics();//g se encarga de dibujar/mostrar lo que esta en estrategia(el buffer)
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.black);
        g.fillRect(ANCHO/2, ALTO/2, 32, 32);
        g.dispose();
        
        estrategia.show();
        
        fps++;
    }

    @Override
    public void run() {
        
        final int NS_POR_SEGUNDO = 1000000000;//nanosegundos_por_segundo
        final byte APS_OBJETIVO = 60;//Actualizaciones Por Segundo, entre menor sea este numero mejor, pero con una buena fluidez 
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO/APS_OBJETIVO;//cuantos nanosegundos tienen que transcurrir para llegar al objetivo de 60 veces por segundo
        
        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        
        double tiempoTranscurrido;
        double delta = 0;//cantidad de tiempo que ha transcurrido desde qu ese realiza una actualizacion
        
        requestFocus();
        
        while(ejecucion){
            final long inicioBucle = System.nanoTime();//toma referencia del tiempo exacto en el que inicio el bucle
            
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;//cuanto ha pasado desde que inicio el juego y cuando inicio el bucle 
            referenciaActualizacion = inicioBucle;//cuando vuelva a iniciar el bucle tendra el valor de la ultima actualizacion hecha
            
            delta += tiempoTranscurrido/NS_POR_ACTUALIZACION;
            
            while(delta>=1){
                actualizar();//se ejecutara aprox. 60 veces por segundo si todo el algoritmo anterior sale bien                
                delta--;
            }
            
            mostrar();
            
            if((System.nanoTime()-referenciaContador)>NS_POR_SEGUNDO){
                ventana.setTitle(NOMBRE + " APS: "+ aps + " FPS: "+ fps);
                aps=0;
                fps=0;
                referenciaContador = System.nanoTime();
            }
        }
    }
}
