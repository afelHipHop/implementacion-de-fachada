/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import interfaz.Pantalla;
import interfaz.Sprite;

/**
 *
 * @author personal
 */
public class TileGrass extends Tile {
    
    public TileGrass(Sprite sprite) {
        super(sprite);
    }
    
    @Override
    public void mostrar(int x, int y, Pantalla pantalla){
        pantalla.dibujarCuadro(x, y, this);
    }
    
    
            
}
