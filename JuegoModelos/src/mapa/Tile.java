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
public abstract class Tile {
    
    public int x;
    public int y;
    public Sprite sprite;
    
    //coleccion de tiles
    
    public static final Tile GRASS = new TileGrass(Sprite.PRADO);
    
    //fin coleccion de tiles
    
    public Tile(Sprite sprite){
        this.sprite = sprite;
    }
    
    public void mostrar(int x, int y, Pantalla pantalla){
    
    }
    
    public boolean esSolido(){
        return false;
    }
    
}
