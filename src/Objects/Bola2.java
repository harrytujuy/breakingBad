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
    SoundClip ball;
    SoundClip fall;
    
    public Bola2(){
		super();
                try{
                    imagen = ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/ball.gif"));
                }catch(IOException e){
                    e.printStackTrace();
                }
                setPosX(450);
                setPosY(408);
                try{
                    ball = new SoundClip("/Resources/Sounds/ball.wav");
                    fall = new SoundClip("/Resources/Sounds/fall.wav");
                }catch(Exception e){
                        e.printStackTrace();
                }
    }
    
    public void getNextPosition(){
        if(upleft){
            setPosX(getPosX() - 3);
            setPosY(getPosY() - 3);
        }
        else if(downleft){
            setPosX(getPosX() - 3);
            setPosY(getPosY() + 3);
        }
        else if(upright){
            setPosX(getPosX() + 3);
            setPosY(getPosY() - 3);
        }
        else if(downright){
            setPosX(getPosX() + 3);
            setPosY(getPosY() + 3);
        }
    }
    
    public void checkCollision(){
        if(getPosX() < GamePanel.WIDTH/2 + 13 && upleft){
            upleft = false;
            upright = true;
            ball.play();
        }
        if(getPosX() < GamePanel.WIDTH/2 + 13 && downleft){
            downleft = false;
            downright = true;
            ball.play();
        }
        if(getPosY() < 0 && upleft){
            upleft = false;
            downleft = true;
            ball.play();
        }
        if(getPosY() < 0 && upright){
            upright = false;
            downright = true;
            ball.play();
        }
        if(getPosX() + 20 > GamePanel.WIDTH && upright){
            upright = false;
            upleft = true;
            ball.play();
        }
        if(getPosX() + 20 > GamePanel.WIDTH && downright){
            downright = false;
            downleft = true;
            ball.play();
        }
        if(getPosY() + 20 > GamePanel.HEIGHT){
            setPosX(getPosX());
            setPosY(getPosY() - 60);
            if(downright)
                upright = true;
            else
                upleft = true;
            downright = downleft = false;
            fall.play();
        }
    }
    
    public void update(){
        if(getMovement()){
            getNextPosition();
            setPosition(x,y);
            checkCollision();
        }
    }
    
    public void draw(Graphics2D g){
        g.drawImage(imagen, getPosX(), getPosY(), null);
    }
}