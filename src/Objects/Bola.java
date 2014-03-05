/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author Szerch
 */
public class Bola extends Base{
    
    BufferedImage imagen;
    
    public Bola(){
		super();
                try{
                    imagen = ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/ball.gif"));
                }catch(Exception e){
                    e.printStackTrace();
                }
    }
    
    public void getNextPosition(){
        if(upleft){
            setPosX(getPosX() - 2);
            setPosY(getPosY() - 2);
        }
        else if(downleft){
            setPosX(getPosX() - 2);
            setPosY(getPosY() + 2);
        }
        else if(upright){
            setPosX(getPosX() + 2);
            setPosY(getPosY() - 2);
        }
        else if(downright){
            setPosX(getPosX() + 2);
            setPosY(getPosY() + 2);
        }
    }
    
    public void checkCollision(){
        if(getPosX() < 100 && upleft){
            upleft = false;
            upright = true;
        }
        if(getPosX() < 100 && downleft){
            downleft = false;
            downright = true;
        }
        if(getPosY() < 100 && upleft){
            upleft = false;
            downleft = true;
        }
        if(getPosY() < -100 && upright){
            upright = false;
            downright = true;
        }
        if(getPosX() + imagen.getWidth() > 100 && upright){
            upright = false;
            upleft = true;
        }
        if(getPosX() + imagen.getWidth() > 100 && downright){
            downright = false;
            downleft = true;
        }
        if(getPosY() + imagen.getHeight() > 100 && downleft){
            downleft = false;
            upleft = true;
        }
        if(getPosY() + imagen.getHeight() > 100 && downright){
            downright = false;
            upright = true;
        }
    }
    
    public void update(){
        getNextPosition();
        setPosition(x,y);
        checkCollision();
    }
    
    public void draw(Graphics2D g){
        g.drawImage(imagen, getPosX()+GamePanel.WIDTH - 300, getPosY()+GamePanel.HEIGHT - 71, null);
    }
}
