/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import control.Teclado;

/**
 *
 * @author personal
 */
public interface IPlayer {
    
    public int getXCoor();
    public void setXCoor(int xCoor);
    public int getYCoor();
    public void setYCoor(int yCoor);
    public char getOrinetation();
    public void setOrientation(char orientation);
    public boolean isMovement();
    public void setMovement(boolean movement);
    public void actualizar();
    public void mostrar();
    
}
