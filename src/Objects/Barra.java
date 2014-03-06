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
import Main.GamePanel;
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
                dx = 0;
                try{
                    imagen = ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/barra.png"));
                }catch(Exception e){
                    e.printStackTrace();
                }
                setPosX(330);
                setPosY(430);
    }
    
    public void getNextPosition(){
        if(left)
            setPosX(getPosX() - 4);
        else if(right)
            setPosX(getPosX() + 4);
    }
    
    public void update(){
        getNextPosition();
        setPosition(x,y);
        checkCollision();
    }
    
    public void checkCollision(){
        if(getPosX() < 0){
            left = false;
            setPosX(getPosX());
        }
        if(getPosX() + getAncho() > GamePanel.WIDTH)
            right = false;
    }
    
    public void draw(Graphics2D g){
        g.drawImage(imagen, getPosX(), getPosY(), null);
    }
}