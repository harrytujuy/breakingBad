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
public class Player1 extends Base{
    
    BufferedImage imagen;
    
    public Player1(){
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
        switch(direccion){
            case 0:{
                setPosX(getPosX());
                break;
            }
            case 1:{
                setPosX(getPosX() - 4);
                break;
            }
            case 2:{
                setPosX(getPosX() + 4);
                break;
            }
        }
    }
    
    public void update(){
        if(getMovement()){
            getNextPosition();
            setPosition(x,y);
            checkCollision();
        }
    }
    
    public void checkCollision(){
        if(getPosX() < 0){
            setLeft(false);
            direccion = 0;
        }
        if(getPosX() + 93 > GamePanel.WIDTH/2){
            setRight(false);
            direccion = 0;
        }
    }
    
    public void draw(Graphics2D g){
        g.drawImage(imagen, getPosX(), getPosY(), null);
    }
    
}
