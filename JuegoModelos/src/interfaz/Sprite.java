/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

/**
 *
 * @author personal
 */
public class Sprite {
    
    private final int lado;
    private int x;
    private int y;
    public int pixeles[];
    private final HojaSprites hoja;
    
    //Coleccion de sprites
    public static final Sprite PRADO = new Sprite(32,0,0, HojaSprites.prado);
    //Fin coleccion hoja de sprites
    
    
    public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja){
        this.lado = lado;
        pixeles = new int[lado*lado];
        
        this.x = columna*lado;
        this.y = fila*lado;
        
        this.hoja=hoja;
        
        for(int i = 0;i<lado;i++){
            for(int j = 0;j<lado;j++){
                pixeles[j+(i*lado)] = hoja.pixeles[(j+this.x)+(i+this.y)*hoja.getAncho()];
            }
        }
    }

    public int getLado() {
        return lado;
    }
    
    
}
