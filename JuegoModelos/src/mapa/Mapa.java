/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import interfaz.Pantalla;

/**
 *
 * @author personal
 */
public abstract class Mapa {

    private int ancho;
    private int alto;
    
    private int tiles[] = new int[ancho*alto];
    
    public Mapa(String ruta) {
        cargarMapa(ruta);
    }
    
    public void cargarMapa(String ruta){
    
    }
    
    public void actualizar(){
    
    }
    
    public void mostrar(int compesacionX, int compesacionY, Pantalla pantalla){
    
    }
}
