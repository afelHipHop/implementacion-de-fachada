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
public class Player implements IPlayer{
    
    private int xCoor;
    private int yCoor;
    private Teclado teclado;
    private char orientation;
    private boolean movement;

    public Player(int xCoor, int yCoor, Teclado teclado,char orientation, boolean movement) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.teclado = teclado;
        this.orientation = orientation;
        this.movement = movement;
    }

    @Override
    public int getXCoor() {
        return xCoor;
    }

    @Override
    public void setXCoor(int xCoor) {
        this.xCoor = xCoor;
    }
    
    @Override
    public int getYCoor(){
        return yCoor;
    }
    
    @Override
    public void setYCoor(int yCoor){
        this.yCoor = yCoor;
    }
    
    @Override
    public char getOrinetation() {
        return orientation;
    }

    @Override
    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }
    
    @Override
    public boolean isMovement() {
        return movement;
    }

    @Override
    public void setMovement(boolean movement) {
        this.movement = movement;
    }
    
    public Teclado getTeclado(){
        return teclado;
    }
    
    public void setTeclado(Teclado teclado){
        this.teclado = teclado;
    }

    @Override
    public void actualizar() {
        int moveX = 0;
        int moveY = 0;
        
        if(teclado.arriba)
            moveY--;
        if(teclado.abajo)
            moveY++;
        if(teclado.izquierda)
            moveX--;
        if(teclado.derecha)
            moveX++;
        
        if(moveX != 0 || moveY != 0)
            mover(moveX, moveY);
    }

    @Override
    public void mostrar() {
        
    }
    
    public void mover(int moveX, int moveY){
        if(moveX > 0)
            setOrientation('e');
        if(moveX < 0)
            setOrientation('o');
        if(moveY > 0)
            setOrientation('s');
        if(moveY < 0)
            setOrientation('n');
       xCoor += moveX;
       yCoor += moveY;
    }
    
}
