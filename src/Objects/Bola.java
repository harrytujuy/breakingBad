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
public class Bola extends Base{
    
    private BufferedImage imagen;
    private SoundClip ball;
    private SoundClip fall;
    private boolean pierde;
    
    public Bola(){
		super();
                try{
                    imagen = ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/ball.gif"));
                }catch(IOException e){
                    e.printStackTrace();
                }
                setPosX(140);
                setPosY(408);
                try{
                    ball = new SoundClip("/Resources/Sounds/ball.wav");
                    fall = new SoundClip("/Resources/Sounds/fall.wav");
                }catch(Exception e){
                        e.printStackTrace();
                }
                pierde = false;
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
        if(getPosX() < 0 && upleft){
            upleft = false;
            upright = true;
            ball.play();
        }
        if(getPosX() < 0 && downleft){
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
            pierde = true;
        }
        /*if(bola.getPosX() > barra.getPosX() && bola.getPosX() < barra.getPosX() + barra.getAncho() && bola.getPosY() <= barra.getPosY() && bola.getDownRight()){
            bola.setDownRight(false);
            bola.setUpRight(true);
        }
        if(bola.getPosX() > barra.getPosX() && bola.getPosX() < barra.getPosX() + barra.getAncho() && bola.getPosY() <= barra.getPosY() && bola.getDownLeft()){
            bola.setDownLeft(false);
            bola.setUpLeft(true);
        }*/
    }
    
    public boolean getPierdeVidas(){
        return pierde;
    }
    
    public void setPierdeVidas(boolean b){
        pierde = b;
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