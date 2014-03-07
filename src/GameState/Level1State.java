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
import Main.GamePanel;

public class Level1State extends GameState{
    
    private Background bg;
    public Player barra;
    private Bola bola;
    private Cuadro [] cuadro;
    private Graphics g2;
    
    boolean empieza;
    SoundClip ball;
    
    
    public Level1State(GameStateManager gsm){
        
        this.gsm = gsm;
        
        try{
            bg = new Background("/Resources/Backgrounds/level1.jpg",1);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
                    ball = new SoundClip("/Resources/Sounds/ball.wav");
                }catch(Exception e){
                        e.printStackTrace();
                }
        
        barra = new Player();
        bola = new Bola();
        cuadro = new Cuadro[10];
        for(int i = 0; i < 10; i++) { //Ciclo para construir los Malos en la parte superior de la pantalla.
                int posCX = (int)(Math.random()* GamePanel.WIDTH); //Creación de los malos en un lugar random de lo largo
                int posCY = (int)(Math.random()* GamePanel.HEIGHT/2 - 0); //Creacion de los malos en la parte superior del applet
                cuadro[i] = new Cuadro(); //Carga de la imagen a los 10 Malos
                cuadro[i].setPosX(posCX); //Ingreso de la ubicación en X del Malo
                cuadro[i].setPosY(posCY); //Ingreso de la ubicacion en Y del Malo
        }
        
        empieza = false;
    }
    
    public void init(){
        
    }
    
    public void update(){
        bg.update();
        barra.update();
        bola.update();
        checaColision();
    }
    
    public void checaColision(){
        if(bola.getPosX() > barra.getPosX() && bola.getPosX() + 20 < barra.getPosX() + 93 && bola.getPosY() + 20 >= barra.getPosY() && bola.getDownRight()){
            bola.setDownRight(false);
            bola.setUpRight(true);
            ball.play();
        }
        if(bola.getPosX() > barra.getPosX() && bola.getPosX() + 20 < barra.getPosX() + 93 && bola.getPosY() + 20 == barra.getPosY() && bola.getDownLeft()){
            bola.setDownLeft(false);
            bola.setUpLeft(true);
            ball.play();
        }
    }
    
    public void draw(Graphics2D g){
        bg.draw(g);
        barra.draw(g);
        bola.draw(g);
        for(int i = 0; i < 10; i++){
            cuadro[i].draw(g);
        }
    }
    
    public void keyPressed(int k){
        
        if(k == KeyEvent.VK_SPACE){
            empieza = true;
            bola.setUpRight(true);
        }
        if(empieza){
            if(k == KeyEvent.VK_LEFT && barra.getLeft()){
                barra.setRight(true);
                barra.direccion = 1;
            }
            if(k == KeyEvent.VK_RIGHT && barra.getRight()){
                barra.setLeft(true);
                barra.direccion = 2;
            }
        }
    }
    
    public void keyReleased(int k){
        if(k == KeyEvent.VK_LEFT)
            barra.direccion = 0;
        if(k == KeyEvent.VK_RIGHT)
            barra.direccion = 0;
    }
}
