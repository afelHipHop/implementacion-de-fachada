/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author personal
 */
public abstract class PlayerDecorator implements IPlayer {
    
    private IPlayer iplayer;

    public PlayerDecorator(IPlayer iplayer) {
        this.iplayer = iplayer;
    }

    public IPlayer getIplayer() {
        return iplayer;
    }

    public void setIplayer(IPlayer iplayer) {
        this.iplayer = iplayer;
    }
    
    
    
}
