/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author personal
 */
public class HojaSprites {
    
    private final int ancho;
    private final int alto;
    public final int[] pixeles;
    
    //coleccion hoja de sprites
    public static HojaSprites prado = new HojaSprites("/Imagenes/SpritesT.png", 320, 320);
    //fin coleccion hoja de sprites
    
    public HojaSprites(final String ruta, final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;
        
        pixeles = new int[ancho*alto];
        
        
        try {
            BufferedImage imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
}
