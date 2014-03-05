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
    private Barra barra;
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
        barra = new Barra(x_pos,y_pos, Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Resources/Sprites/barra.png")));
        
        // bola
        x_bola = 220;
        y_bola = 430;
        velocidad = 3;
        dxbola = dybola = 0;
    }
    
    public void init(){
        
    }
    
    public void update(){
        bg.update();
    }
    
    public void draw(Graphics2D g){
        bg.draw(g);
        g.drawImage(barra.getImagenI(), x_pos, y_pos, null);
    }
    
    public void keyPressed(int k){
        
    }
    
    public void keyReleased(int k){
        
    }
}
