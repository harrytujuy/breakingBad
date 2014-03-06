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
    private Bola1 bola;
    private Bola2 bola2;
    private Cuadro cuadro;
    private Graphics g2;
    
    boolean empieza;
    
    public MultiplayerState(GameStateManager gsm){
        this.gsm = gsm;
        
        try{
            bg = new Background("/Resources/Backgrounds/level2.jpg",1);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        p1 = new Player1();
        p2 = new Player2();
        bola = new Bola1();
        bola2 = new Bola2();
        
        empieza = false;
    }
    
    public void init(){
        
    }
    
    public void update(){
        p1.update();
        p2.update();
        bola.update();
        bola2.update();
    }
    
    public void draw(Graphics2D g){
        bg.draw(g);
        p1.draw(g);
        p2.draw(g);
        bola.draw(g);
        bola2.draw(g);
    }
    
    public void keyPressed(int k){
        if(k == KeyEvent.VK_SPACE){
            bola.setUpRight(true);
            bola2.setUpRight(true);
            empieza = true;
        }
        if(empieza){
            if(k == KeyEvent.VK_LEFT)
                p1.setLeft(true);
            if(k == KeyEvent.VK_RIGHT)
                p1.setRight(true);
            if(k == KeyEvent.VK_A)
                p2.setLeft(true);
            if(k == KeyEvent.VK_D)
                p2.setRight(true);
        }
    }
    
    public void keyReleased(int k){
        if(k == KeyEvent.VK_LEFT)
            p1.setLeft(false);
        if(k == KeyEvent.VK_RIGHT)
            p1.setRight(false);
        if(k == KeyEvent.VK_A)
            p2.setLeft(false);
        if(k == KeyEvent.VK_D)
            p2.setRight(false);
    }
}
