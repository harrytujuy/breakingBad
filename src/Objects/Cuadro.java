/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Szerch
 */
public class Cuadro extends Base{
    
    BufferedImage imagen;
    
    public Cuadro(){
		super();
                try{
                    imagen = ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/cuadro1.jpg"));
                }catch(IOException e){
                    e.printStackTrace();
                }
    }
    
    public void draw(Graphics2D g){
        g.drawImage(imagen, getPosX(), getPosY(), null);
    }
}
