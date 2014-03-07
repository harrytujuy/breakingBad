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
import java.util.LinkedList;

public class Level1State extends GameState{
    
    private Background bg;
    public Player barra;
    private Bola bola;
    private Cuadro cuadro;
    private LinkedList<Cuadro> lista;
    
    boolean empieza;
    SoundClip ball;
    SoundClip breaking;
    
    
    public Level1State(GameStateManager gsm){
        
        this.gsm = gsm;
        
        try{
            bg = new Background("/Resources/Backgrounds/level1.jpg",1);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
                    ball = new SoundClip("/Resources/Sounds/ball.wav");
                    breaking = new SoundClip("/Resources/Sounds/cuadro.wav");
                }catch(Exception e){
                        e.printStackTrace();
                }
        
        barra = new Player();
        bola = new Bola();
        lista = new LinkedList();
        
                cuadro = new Cuadro();
                cuadro.setPosX(220);
                cuadro.setPosY(100);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(260);
                cuadro.setPosY(100);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(300);
                cuadro.setPosY(100);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(340);
                cuadro.setPosY(100);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(380);
                cuadro.setPosY(100);
                lista.add(cuadro);
                cuadro = new Cuadro(); //Carga de la imagen a los 10 Malos
                cuadro.setPosX(100); //Ingreso de la ubicación en X del Malo
                cuadro.setPosY(180); //Ingreso de la ubicacion en Y del Malo
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(140);
                cuadro.setPosY(180);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(180);
                cuadro.setPosY(180);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(220);
                cuadro.setPosY(180);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(260);
                cuadro.setPosY(180);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(300);
                cuadro.setPosY(180);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(340);
                cuadro.setPosY(180);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(380);
                cuadro.setPosY(180);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(420);
                cuadro.setPosY(180);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(460);
                cuadro.setPosY(180);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(500);
                cuadro.setPosY(180);
                lista.add(cuadro);
      
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
        if(bola.getPosX() > barra.getPosX() && bola.getPosX() + 20 < barra.getPosX() + 93 && bola.getPosY() + 20 >= barra.getPosY() && bola.getDownLeft()){
            bola.setDownLeft(false);
            bola.setUpLeft(true);
            ball.play();
        }
        if(bola.getPosX() > barra.getPosX() && bola.getPosX() + 20 < barra.getPosX() + 93 && bola.getPosY() + 20 == barra.getPosY() && bola.getDownRight()){
            bola.setDownRight(false);
            bola.setUpRight(true);
            ball.play();
        }
        for(Cuadro cuadro: lista){
            if(bola.getPosX() > cuadro.getPosX() && bola.getPosX() + 20 < cuadro.getPosX() + 40 && bola.getPosY() < cuadro.getPosY() && bola.getPosY() + 20 >= cuadro.getPosY() && bola.getDownLeft()){
                bola.setDownLeft(false);
                bola.setUpLeft(true);
                breaking.play();
            }
            if(bola.getPosX() > cuadro.getPosX() && bola.getPosX() + 20 < cuadro.getPosX() + 40 && bola.getPosY() < cuadro.getPosY() && bola.getPosY() + 20 >= cuadro.getPosY() && bola.getDownRight()){               
                bola.setDownRight(false);
                bola.setUpRight(true);
                breaking.play();
            }
            if(bola.getPosX() > cuadro.getPosX() && bola.getPosX() + 20 < cuadro.getPosX() + 40 && bola.getPosY() > cuadro.getPosY() && bola.getPosY() < cuadro.getPosY() + 40 && bola.getUpLeft()){                
                bola.setUpLeft(false);
                bola.setDownLeft(true);
                breaking.play();
            }
            if(bola.getPosX() > cuadro.getPosX() && bola.getPosX() + 20 < cuadro.getPosX() + 40 && bola.getPosY() > cuadro.getPosY() && bola.getPosY() < cuadro.getPosY() + 40 && bola.getUpRight()){               
                bola.setUpRight(false);
                bola.setDownRight(true);
                breaking.play();
            }
        }
                
    }
    
    public void draw(Graphics2D g){
        bg.draw(g);
        barra.draw(g);
        bola.draw(g);
        for(Cuadro cuadro: lista){
            cuadro.draw(g);
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
