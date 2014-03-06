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
public class Bola2 extends Base{
    
    BufferedImage imagen;
    
    public Bola2(){
		super();
                try{
                    imagen = ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/ball.gif"));
                }catch(IOException e){
                    e.printStackTrace();
                }
                setPosX(450);
                setPosY(408);
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
        if(getPosX() < GamePanel.WIDTH/2 && upleft){
            upleft = false;
            upright = true;
        }
        if(getPosX() < GamePanel.WIDTH/2 && downleft){
            downleft = false;
            downright = true;
        }
        if(getPosY() < 0 && upleft){
            upleft = false;
            downleft = true;
        }
        if(getPosY() < 0 && upright){
            upright = false;
            downright = true;
        }
        if(getPosX() + 20 > GamePanel.WIDTH && upright){
            upright = false;
            upleft = true;
        }
        if(getPosX() + 20 > GamePanel.WIDTH && downright){
            downright = false;
            downleft = true;
        }
        if(getPosY() + 20 > GamePanel.HEIGHT && downleft){
            downleft = false;
            upleft = true;
        }
        if(getPosY() + 20 > GamePanel.HEIGHT && downright){
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
        g.drawImage(imagen, getPosX(), getPosY(), null);
    }
}