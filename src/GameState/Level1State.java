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
    public Barra barra;
    private Bola bola;
    private Cuadro cuadro;
    private Graphics g2;
    
    // barra
    private final int x_pos;
    private final int y_pos;
    private int dx;
    private int direccion;          //Se declara la direccion que tendra la cubeta
    private boolean choqueDer;      //Se declara el boleano que controle las colisiones derechas de la cubeta
    private boolean choqueIzq;      //Se declara el boleano que controle las colisiones izquierdas de la cubeta
    
    // bola
    private final int x_bola;
    private final int y_bola;
    private int dxbola;
    private int dybola;
    private int velocidad;
    
    boolean empieza = false;
    
    
    public Level1State(GameStateManager gsm){
        
        this.gsm = gsm;
        
        try{
            bg = new Background("/Resources/Backgrounds/level1.jpg",1);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        // barra
        x_pos = 200;
        y_pos = 450;
        dx = 0;
        direccion = 0;
        choqueDer = choqueIzq = false;
        barra = new Barra();
        
        // bola
        x_bola = 100;
        y_bola = 100;
        velocidad = 3;
        dxbola = dybola = 0;
        bola = new Bola();
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
