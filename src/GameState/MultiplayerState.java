/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

/**
 *
 * @author Szerch
 */
import TileMap.Background;
import Objects.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MultiplayerState extends GameState{
    
    private Background bg;
    private Player1 p1;
    private Player2 p2;
    private Bola1 bola1;
    private Bola2 bola2;
    private Cuadro cuadro;
    private Graphics g2;
    
    boolean empieza;
    
    public MultiplayerState(GameStateManager gsm){
        this.gsm = gsm;
        
        try{
            bg = new Background("/Resources/Backgrounds/breaking_bad_colors.jpg",1);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        p1 = new Player1();
        p2 = new Player2();
        bola1 = new Bola1();
        bola2 = new Bola2();
        
        empieza = false;
    }
    
    public void init(){
        
    }
    
    public void update(){
        p1.update();
        p2.update();
        bola1.update();
        bola2.update();
        checaColision();
    }
    
    public void checaColision(){
        if(bola1.getPosX() > p1.getPosX() && bola1.getPosX() + 20 < p1.getPosX() + 93 && bola1.getPosY() + 20 >= p1.getPosY() && bola1.getDownRight()){
            bola1.setDownRight(false);
            bola1.setUpRight(true);
            //ball.play();
        }
        if(bola1.getPosX() > p1.getPosX() && bola1.getPosX() + 20 < p1.getPosX() + 93 && bola1.getPosY() + 20 == p1.getPosY() && bola1.getDownLeft()){
            bola1.setDownLeft(false);
            bola1.setUpLeft(true);
            //ball.play();
        }
        if(bola2.getPosX() > p2.getPosX() && bola2.getPosX() + 20 < p2.getPosX() + 93 && bola2.getPosY() + 20 >= p2.getPosY() && bola2.getDownRight()){
            bola2.setDownRight(false);
            bola2.setUpRight(true);
            //ball.play();
        }
        if(bola2.getPosX() > p2.getPosX() && bola2.getPosX() + 20 < p2.getPosX() + 93 && bola2.getPosY() + 20 == p2.getPosY() && bola2.getDownLeft()){
            bola2.setDownLeft(false);
            bola2.setUpLeft(true);
            //ball.play();
        }
    }
    
    public void draw(Graphics2D g){
        bg.draw(g);
        p1.draw(g);
        p2.draw(g);
        bola1.draw(g);
        bola2.draw(g);
    }
    
    public void keyPressed(int k){
        if(k == KeyEvent.VK_SPACE){
            bola1.setUpRight(true);
            bola2.setUpRight(true);
            empieza = true;
        }
        if(empieza){
            if(k == KeyEvent.VK_LEFT && p1.getLeft()){
                p1.setRight(true);
                p1.direccion = 1;
            }
            if(k == KeyEvent.VK_RIGHT && p1.getRight()){
                p1.setLeft(true);
                p1.direccion = 2;
            }
            if(k == KeyEvent.VK_A && p2.getLeft()){
                p2.setRight(true);
                p2.direccion = 1;
            }
            if(k == KeyEvent.VK_D && p2.getRight()){
                p2.setLeft(true);
                p2.direccion = 2;
            }
        }
    }
    
    public void keyReleased(int k){
        if(k == KeyEvent.VK_LEFT)
            p1.direccion = 0;
        if(k == KeyEvent.VK_RIGHT)
            p1.direccion = 0;
        if(k == KeyEvent.VK_A)
            p2.direccion = 0;
        if(k == KeyEvent.VK_D)
            p2.direccion = 0;
    }
}
