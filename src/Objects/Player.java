/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Szerch
 */
public class Player extends Base{
    
    BufferedImage imagen;
    
    public Player(){
		super();
                dx = 0;
                try{
                    imagen = ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/barra.png"));
                }catch(IOException e){
                    e.printStackTrace();
                }
                setPosX(130);
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