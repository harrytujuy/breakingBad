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
import java.util.LinkedList;

public class MultiplayerState extends GameState{
    
    private Background bg;
    private Player1 p1;
    private Player2 p2;
    private Bola1 bola1;
    private Bola2 bola2;
    private Cuadro cuadro;
    private LinkedList<Cuadro> lista1;
    private LinkedList<Cuadro> lista2;
    SoundClip ball;
    SoundClip breaking;
    
    private boolean empieza;
    private boolean pausa;
    private int cont1;
    private int cont2;
    private boolean gana;
    
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
        
        lista1 = new LinkedList();
        lista2 = new LinkedList();
        
        try{
            ball = new SoundClip("/Resources/Sounds/ball.wav");
            breaking = new SoundClip("/Resources/Sounds/cuadro.wav");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cuadro = new Cuadro();
        cuadro.setPosX(40);
        cuadro.setPosY(100);
        lista1.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(80);
        cuadro.setPosY(100);
        lista1.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(120);
        cuadro.setPosY(100);
        lista1.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(160);
        cuadro.setPosY(100);
        lista1.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(200);
        cuadro.setPosY(100);
        lista1.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(240);
        cuadro.setPosY(100);
        lista1.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(120);
        cuadro.setPosY(180);
        lista1.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(160);
        cuadro.setPosY(180);
        lista1.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(40);
        cuadro.setPosY(260);
        lista1.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(80);
        cuadro.setPosY(260);
        lista1.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(120);
        cuadro.setPosY(260);
        lista1.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(160);
        cuadro.setPosY(260);
        lista1.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(200);
        cuadro.setPosY(260);
        lista1.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(240);
        cuadro.setPosY(260);
        lista1.add(cuadro);
        
        cuadro = new Cuadro();
        cuadro.setPosX(360);
        cuadro.setPosY(100);
        lista2.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(400);
        cuadro.setPosY(100);
        lista2.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(440);
        cuadro.setPosY(100);
        lista2.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(480);
        cuadro.setPosY(100);
        lista2.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(520);
        cuadro.setPosY(100);
        lista2.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(560);
        cuadro.setPosY(100);
        lista2.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(440);
        cuadro.setPosY(180);
        lista2.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(480);
        cuadro.setPosY(180);
        lista2.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(360);
        cuadro.setPosY(260);
        lista2.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(400);
        cuadro.setPosY(260);
        lista2.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(440);
        cuadro.setPosY(260);
        lista2.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(480);
        cuadro.setPosY(260);
        lista2.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(520);
        cuadro.setPosY(260);
        lista2.add(cuadro);
        cuadro = new Cuadro();
        cuadro.setPosX(560);
        cuadro.setPosY(260);
        lista2.add(cuadro);
        
        pausa = true;
        gana = false;
        empieza = false;
        
        p1.setMovement(true);
        p2.setMovement(true);
        bola1.setMovement(true);
        bola2.setMovement(true);
        
        cont1 = cont2 = 0;
    }
    
    public void init(){
        
    }
    
    public void update(){
        p1.update();
        p2.update();
        bola1.update();
        bola2.update();
        checaColision();
        if(cont1 == 14 || cont2 == 14)
            gana = true;
    }
    
    public void checaColision(){
        if(bola1.getPosX() > p1.getPosX() && bola1.getPosX() + 20 < p1.getPosX() + 93 && bola1.getPosY() + 20 >= p1.getPosY() && bola1.getDownRight()){
            bola1.setDownRight(false);
            bola1.setUpRight(true);
            ball.play();
        }
        if(bola1.getPosX() > p1.getPosX() && bola1.getPosX() + 20 < p1.getPosX() + 93 && bola1.getPosY() + 20 == p1.getPosY() && bola1.getDownLeft()){
            bola1.setDownLeft(false);
            bola1.setUpLeft(true);
            ball.play();
        }
        if(bola2.getPosX() > p2.getPosX() && bola2.getPosX() + 20 < p2.getPosX() + 93 && bola2.getPosY() + 20 >= p2.getPosY() && bola2.getDownRight()){
            bola2.setDownRight(false);
            bola2.setUpRight(true);
            ball.play();
        }
        if(bola2.getPosX() > p2.getPosX() && bola2.getPosX() + 20 < p2.getPosX() + 93 && bola2.getPosY() + 20 == p2.getPosY() && bola2.getDownLeft()){
            bola2.setDownLeft(false);
            bola2.setUpLeft(true);
            ball.play();
        }
        for(Cuadro cuadro: lista1){
            if(bola1.getPosX() > cuadro.getPosX() && bola1.getPosX() + 20 < cuadro.getPosX() + 40 && bola1.getPosY() < cuadro.getPosY() && bola1.getPosY() + 20 >= cuadro.getPosY() && bola1.getDownLeft()){
                bola1.setDownLeft(false);
                bola1.setUpLeft(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont1++;
            }
            if(bola1.getPosX() > cuadro.getPosX() && bola1.getPosX() + 20 < cuadro.getPosX() + 40 && bola1.getPosY() < cuadro.getPosY() && bola1.getPosY() + 20 >= cuadro.getPosY() && bola1.getDownRight()){               
                bola1.setDownRight(false);
                bola1.setUpRight(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont1++;
            }
            if(bola1.getPosX() > cuadro.getPosX() && bola1.getPosX() + 20 < cuadro.getPosX() + 40 && bola1.getPosY() > cuadro.getPosY() && bola1.getPosY() < cuadro.getPosY() + 40 && bola1.getUpLeft()){                
                bola1.setUpLeft(false);
                bola1.setDownLeft(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont1++;
            }
            if(bola1.getPosX() > cuadro.getPosX() && bola1.getPosX() + 20 < cuadro.getPosX() + 40 && bola1.getPosY() > cuadro.getPosY() && bola1.getPosY() < cuadro.getPosY() + 40 && bola1.getUpRight()){               
                bola1.setUpRight(false);
                bola1.setDownRight(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont1++;
            }
        }
        for(Cuadro cuadro: lista2){
            if(bola2.getPosX() > cuadro.getPosX() && bola2.getPosX() + 20 < cuadro.getPosX() + 40 && bola2.getPosY() < cuadro.getPosY() && bola2.getPosY() + 20 >= cuadro.getPosY() && bola2.getDownLeft()){
                bola2.setDownLeft(false);
                bola2.setUpLeft(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont2++;
            }
            if(bola2.getPosX() > cuadro.getPosX() && bola2.getPosX() + 20 < cuadro.getPosX() + 40 && bola2.getPosY() < cuadro.getPosY() && bola2.getPosY() + 20 >= cuadro.getPosY() && bola2.getDownRight()){               
                bola2.setDownRight(false);
                bola2.setUpRight(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont2++;
            }
            if(bola2.getPosX() > cuadro.getPosX() && bola2.getPosX() + 20 < cuadro.getPosX() + 40 && bola2.getPosY() > cuadro.getPosY() && bola2.getPosY() < cuadro.getPosY() + 40 && bola2.getUpLeft()){                
                bola2.setUpLeft(false);
                bola2.setDownLeft(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont2++;
            }
            if(bola2.getPosX() > cuadro.getPosX() && bola1.getPosX() + 20 < cuadro.getPosX() + 40 && bola2.getPosY() > cuadro.getPosY() && bola2.getPosY() < cuadro.getPosY() + 40 && bola2.getUpRight()){               
                bola2.setUpRight(false);
                bola2.setDownRight(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont2++;
            }
        }
    }
    
    public void draw(Graphics2D g){
        bg.draw(g);
        p1.draw(g);
        p2.draw(g);
        bola1.draw(g);
        bola2.draw(g);
        for(Cuadro cuadro: lista1)
            cuadro.draw(g);
        for(Cuadro cuadro: lista2)
            cuadro.draw(g);
        if(gana){
            g.setColor(Color.BLACK);
            if(cont1 == 14)
                g.drawString("Gana jugador 1!", 200, 200);
            else
                g.drawString("Gana jugador 2!", 200, 200);
        }
    }
    
    public void keyPressed(int k){
        if(k == KeyEvent.VK_SPACE){
            bola1.setUpRight(true);
            bola2.setUpRight(true);
            empieza = true;
        }
        if(empieza){
            if(k == KeyEvent.VK_LEFT && p2.getLeft()){
                p2.setRight(true);
                p2.direccion = 1;
            }
            if(k == KeyEvent.VK_RIGHT && p2.getRight()){
                p2.setLeft(true);
                p2.direccion = 2;
            }
            if(k == KeyEvent.VK_A && p1.getLeft()){
                p1.setRight(true);
                p1.direccion = 1;
            }
            if(k == KeyEvent.VK_D && p1.getRight()){
                p1.setLeft(true);
                p1.direccion = 2;
            }
            if(k == KeyEvent.VK_P){
                pausa = !pausa;
                p1.setMovement(pausa);
                p2.setMovement(pausa);
                bola1.setMovement(pausa);
                bola2.setMovement(pausa);
            }
        }
    }
    
    public void keyReleased(int k){
        if(k == KeyEvent.VK_LEFT)
            p2.direccion = 0;
        if(k == KeyEvent.VK_RIGHT)
            p2.direccion = 0;
        if(k == KeyEvent.VK_A)
            p1.direccion = 0;
        if(k == KeyEvent.VK_D)
            p1.direccion = 0;
    }
}
