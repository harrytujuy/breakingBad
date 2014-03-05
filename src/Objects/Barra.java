/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

/**
 *
 * @author Szerch
 */
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Szerch
 */
public class Barra extends Base{
    
    BufferedImage imagen;
    
    public Barra(){
		super();
                try{
                    imagen = ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/barra.png"));
                }catch(Exception e){
                    e.printStackTrace();
                }
    }
    
    public void getNextPosition(){
        if(left)
            dx -= 3;
        else if(right)
            dx += 3;
        else{
            if(dx > 0){
                dx -= 3;
                if(dx < 0)
                    dx = 0;
            }
            else if(dx < 0){
                dx += 3;
                if(dx > 0)
                    dx = 0;
            }
        }
    }
    
    public void update(){
        getNextPosition();
        setPosition(x,y);
    }
    
    public void draw(Graphics2D g){
        g.drawImage(imagen, 0, 0, null);
    }
}