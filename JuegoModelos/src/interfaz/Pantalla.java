/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import mapa.Tile;

/**
 *
 * @author personal
 */
public class Pantalla {
    
    private final int ancho;
    private final int alto;
    
    public final int[] pixeles; //cantidad de pixeles en la pantalla
    
    //TEMPORAL
    private final static int LADO_SPRITE = 32;
    private final static int MASCARA_SPRITE = LADO_SPRITE - 1;
    //FIN TEMPORAL
    
    public Pantalla(final int ancho, final int alto){
        
        this.ancho = ancho;
        this.alto = alto;   
        pixeles = new int[ancho*alto];
    
    }
    
    
    //borra todo lo que hay en panatalla
    public void limpiar(){
        for(int i = 0; i<pixeles.length; i++)
            pixeles[i]=0;
    }
    
    //Temporal
    //redibuja en la pantalla
    public void dibujar(int movimientoX, int movimientoY){
        for(int y=0; y < alto; y++){
            int posicionY = y+movimientoY;
            if(posicionY<0||posicionY>=alto)
                continue;//rompe el for de Y y continua con el for de X si se sale de la pantalla
            for(int x=0; x < ancho; x++){
                int posicionX = x+movimientoX;
                if(posicionX<0||posicionX>=ancho)
                    continue;//rompe el for de X si se sale de la pantalla
                
                pixeles[posicionX + (posicionY * ancho)] = Sprite.PRADO.pixeles[(x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) * LADO_SPRITE];
            }
        }
    }
    
    public void dibujarCuadro(int movimientoX, int movimientoY, Tile tile){
        for(int y = 0; y < tile.sprite.getLado(); y++){
            int posicionY = y+movimientoY;
            for(int x = 0; x < tile.sprite.getLado(); x++){
                int posicionX = x+movimientoX;
                if(posicionX<0||posicionX>=ancho || posicionY<0||posicionY>=alto)
                    break;
                pixeles[posicionX + (posicionY * ancho)] = tile.sprite.pixeles[x + (y *tile.sprite.getLado())];
            }
        }
    }
    
}
