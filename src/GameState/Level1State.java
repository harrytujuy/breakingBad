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
    private Player barra;
    private Bola bola;
    private Cuadro cuadro;
    private LinkedList<Cuadro> lista;
    
    private boolean empieza;
    private boolean pausa;
    public int vidas;
    private int cont;
    private SoundClip ball;
    private SoundClip breaking;
    private SoundClip fondo;
    
    
    public Level1State(GameStateManager gsm){
        
        this.gsm = gsm;
        
        try{
            bg = new Background("/Resources/Backgrounds/Breaking-Bad.jpg",1);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
                    ball = new SoundClip("/Resources/Sounds/ball.wav");
                    breaking = new SoundClip("/Resources/Sounds/cuadro.wav");
                    fondo = new SoundClip("/Resources/Sounds/Single_Player.wav");
                }catch(Exception e){
                        e.printStackTrace();
                }
        
        barra = new Player();
        bola = new Bola();
        lista = new LinkedList();
        
                cuadro = new Cuadro();
                cuadro.setPosX(60);
                cuadro.setPosY(40);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(100);
                cuadro.setPosY(40);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(140);
                cuadro.setPosY(40);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(60);
                cuadro.setPosY(80);
                lista.add(cuadro);
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
                cuadro = new Cuadro();
                cuadro.setPosX(100);
                cuadro.setPosY(180);
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
                cuadro = new Cuadro();
                cuadro.setPosX(460);
                cuadro.setPosY(40);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(500);
                cuadro.setPosY(40);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(540);
                cuadro.setPosY(40);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(540);
                cuadro.setPosY(80);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(220);
                cuadro.setPosY(260);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(260);
                cuadro.setPosY(260);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(300);
                cuadro.setPosY(260);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(340);
                cuadro.setPosY(260);
                lista.add(cuadro);
                cuadro = new Cuadro();
                cuadro.setPosX(380);
                cuadro.setPosY(260);
                lista.add(cuadro);
        
        pausa = true;
        empieza = false;
        barra.setMovement(true);
        bola.setMovement(true);
        vidas = 3;
        cont = 0;
        fondo.setLooping(true);
    }
    
    public void init(){        
        fondo.play();
    }
    
    public void update(){
        bg.update();
        barra.update();
        bola.update();
        checaColision();
        if(bola.getPierdeVidas()){
            vidas--;
            if(vidas == 0)
                gsm.setState(GameStateManager.MENUSTATE);
            bola.setPierdeVidas(false);
        }
        if(cont == 29){
            gsm.setState(GameStateManager.LEVEL2STATE);
            fondo.stop();
        }
    }
    
    public void checaColision(){
        //Checa colision entre la barra y la pelota
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
            //Checa colision con cuadro por la izquierda y bola hacia abajo
            if((bola.getPosX() + 20 == cuadro.getPosX() && bola.getPosY() > cuadro.getPosY() && bola.getPosY() < cuadro.getPosY() + 40) || (bola.getPosX() + 20 == cuadro.getPosX() && bola.getPosY() + 20 > cuadro.getPosY() && bola.getPosY() + 20 < cuadro.getPosY() + 40) && bola.getDownRight()){
                bola.setDownRight(false);
                bola.setDownLeft(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont++;
            }
            
            //Checa colision con cuadro por la izquierda y bola hacia arriba
            else if((bola.getPosX() + 20 == cuadro.getPosX() && bola.getPosY() > cuadro.getPosY() && bola.getPosY() < cuadro.getPosY() + 40) || (bola.getPosX() + 20 == cuadro.getPosX() && bola.getPosY() + 20 > cuadro.getPosY() && bola.getPosY() + 20 < cuadro.getPosY() + 40) && bola.getUpRight()){
                bola.setUpRight(false);
                bola.setUpLeft(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont++;
            }
            
            //Checa colision con cuadro por arriba y bola hacia la derecha
            else if((bola.getPosY() + 20 == cuadro.getPosY() && bola.getPosX() > cuadro.getPosX() && bola.getPosX() + 20 < cuadro.getPosX() + 40) || (bola.getPosY() + 20 == cuadro.getPosY() && bola.getPosX() + 20 > cuadro.getPosX() && bola.getPosX() + 20 < cuadro.getPosX() + 40) && bola.getDownRight()){
                bola.setDownRight(false);
                bola.setUpRight(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont++;
            }
            
            //Checa colision con cuadro por arriba y bola hacia la izquierda
            else if((bola.getPosY() + 20 == cuadro.getPosY() && bola.getPosX() > cuadro.getPosX() && bola.getPosX() + 20 < cuadro.getPosX() + 40) || (bola.getPosY() + 20 == cuadro.getPosY() && bola.getPosX() + 20 > cuadro.getPosX() && bola.getPosX() + 20 < cuadro.getPosX() + 40) && bola.getDownLeft()){
                bola.setDownLeft(false);
                bola.setUpLeft(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont++;
            }
            
            //Checa colision con cuadro por derecha y bola hacia arriba
            else if((bola.getPosX() == cuadro.getPosX() + 40 && bola.getPosY() > cuadro.getPosY() && bola.getPosY() < cuadro.getPosY() + 40) || (bola.getPosX() == cuadro.getPosX() + 40 && bola.getPosY() + 20 > cuadro.getPosY() && bola.getPosY() + 20 < cuadro.getPosY() + 40) && bola.getUpLeft()){
                bola.setUpLeft(false);
                bola.setUpRight(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont++;
            }
            
            //Checa colision con cuadro por derecha y bola hacia abajo
            else if((bola.getPosX() == cuadro.getPosX() + 40 && bola.getPosY() > cuadro.getPosY() && bola.getPosY() < cuadro.getPosY() + 40) || (bola.getPosX() == cuadro.getPosX() + 40 && bola.getPosY() + 20 > cuadro.getPosY() && bola.getPosY() + 20 < cuadro.getPosY() + 40) && bola.getDownLeft()){
                bola.setDownLeft(false);
                bola.setDownRight(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont++;
            }
            
            //Checa colision con cuadro por abajo y bola hacia la izquierda
            else if((bola.getPosY() == cuadro.getPosY() + 40 && bola.getPosX() > cuadro.getPosX() && bola.getPosX() < cuadro.getPosX() + 40) || (bola.getPosY() == cuadro.getPosY() + 40 && bola.getPosX() +20 > cuadro.getPosX() && bola.getPosX() + 20 < cuadro.getPosX() + 40) && bola.getPosX() + 20 < cuadro.getPosX() + 40 && bola.getUpLeft()){
                bola.setUpLeft(false);
                bola.setDownLeft(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont++;
            }
            
            //Checa colision con cuadro por abajo y bola hacia la derecha
            else if((bola.getPosY() == cuadro.getPosY() + 40 && bola.getPosX() > cuadro.getPosX() && bola.getPosX() < cuadro.getPosX() + 40) || (bola.getPosY() == cuadro.getPosY() + 40 && bola.getPosX() +20 > cuadro.getPosX() && bola.getPosX() + 20 < cuadro.getPosX() + 40) && bola.getUpRight()){
                bola.setUpRight(false);
                bola.setDownRight(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont++;
            }
            
            //Checa colision esquina superior izquierda del cuadro
            else if(bola.getPosX() + 20 == cuadro.getPosX() && bola.getPosY() + 20 == cuadro.getPosY() && bola.getDownRight()){
                bola.setDownRight(false);
                bola.setUpLeft(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont++;
            }
            
            //Checa colision esquina superior derecha del cuadro
            else if(bola.getPosX() == cuadro.getPosX() + 40 && bola.getPosY() + 20 == cuadro.getPosY() && bola.getDownLeft()){
                bola.setDownLeft(false);
                bola.setUpRight(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont++;
            }
            
            //Checa colision esquina inferior derecha del cuadro
            else if(bola.getPosX() == cuadro.getPosX() + 40 && bola.getPosY() == cuadro.getPosY() + 40 && bola.getUpLeft()){
                bola.setUpLeft(false);
                bola.setDownRight(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont++;
            }
            
            //Checa colision esquina inferior izquierda del cuadro
            else if(bola.getPosX() + 20 == cuadro.getPosX() && bola.getPosY() == cuadro.getPosY() + 40 && bola.getUpRight()){
                bola.setUpRight(false);
                bola.setDownLeft(true);
                breaking.play();
                cuadro.setPosX(700);
                cuadro.setPosY(700);
                cont++;
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
        if(vidas <= 1)
            g.setColor(Color.RED);
        g.drawString("Vidas: "+vidas,560,20);
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
            if(k == KeyEvent.VK_P){
                pausa = !pausa;
                barra.setMovement(pausa);
                bola.setMovement(pausa);
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
