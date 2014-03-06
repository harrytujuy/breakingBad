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

public class Level1State extends GameState{
    
    private Background bg;
    public Player barra;
    private Bola bola;
    private Cuadro cuadro;
    private Graphics g2;
    
    boolean empieza;
    
    
    public Level1State(GameStateManager gsm){
        
        this.gsm = gsm;
        
        try{
            bg = new Background("/Resources/Backgrounds/level1.jpg",1);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        barra = new Player();
        bola = new Bola();
        
        empieza = false;
    }
    
    public void init(){
        
    }
    
    public void update(){
        bg.update();
        barra.update();
        bola.update();
        if(barra.intersecta(bola)){
            System.out.println("Intersecta");
            if(bola.getDownLeft()){
                bola.setDownLeft(false);
                bola.setUpLeft(true);
            }
            else if(bola.getDownRight()){
                bola.setDownRight(false);
                bola.setUpRight(true);
            }
        }
    }
    
    public void draw(Graphics2D g){
        bg.draw(g);
        barra.draw(g);
        bola.draw(g);
    }
    
    public void keyPressed(int k){
        
        if(k == KeyEvent.VK_SPACE){
            empieza = true;
            bola.setUpRight(true);
        }
        if(empieza){
            if(k == KeyEvent.VK_LEFT)
                barra.setLeft(true);
            if(k == KeyEvent.VK_RIGHT)
                barra.setRight(true);
        }
    }
    
    public void keyReleased(int k){
        if(k == KeyEvent.VK_LEFT)
            barra.setLeft(false);
        if(k == KeyEvent.VK_RIGHT)
            barra.setRight(false);
    }
}
