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
import Objects.SoundClip;
import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HelpState extends GameState{
    
    private Font titleFont;
    private Font subTitleFont;
    private Font font;
    private Color colorLeft;
    private Color colorRight;
    
    private Background bg;
    private SoundClip fondo;
    
    public HelpState(GameStateManager gsm){
        this.gsm = gsm;
        try{
            bg = new Background("/Resources/Backgrounds/negro.png",1);
            titleFont = new Font("Arial", Font.PLAIN, 28);
            subTitleFont = new Font("Times New Roman",Font.PLAIN,22);
            font = new Font("Times New Roman",Font.PLAIN,18);
            colorLeft = new Color(40,70, 128);
            colorRight = new Color(128,70,40);
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            fondo = new SoundClip("/Resources/Sounds/Menu.wav");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void init(){
        fondo.play();
    }
    
    public void update(){
        bg.update();
    }
    
    public void draw(Graphics2D g){
        bg.draw(g);
        g.setFont(titleFont);
        g.setColor(Color.WHITE);
        g.drawString("¿Cómo jugar?", 240, 60);
        g.setFont(font);
        g.drawString("El objetivo del juego es destruir todos los bloques que aparezcan en la pantalla", 40, 100);
        g.setFont(subTitleFont);
        g.drawString("Controles", 260, 180);
        g.setFont(font);
        g.drawString("1 Jugador:", 40, 200);
        g.setColor(colorLeft);
        g.drawString("Las teclas <- y -> sirven para moverte de izquierda a derecha", 40, 220);
        g.drawString("El juego inicia al presionar la barra espaciadora", 40, 240);
        g.setColor(Color.WHITE);
        g.drawString("2 Jugadores", 40, 280);
        g.setColor(colorRight);
        g.drawString("Mientras que el jugador 1 se mueve con las flechas, el jugador 2 usa A y D", 40, 300);
        g.drawString("Tambien en este modo se inicia el juego con la barra espaciadora", 40, 320);
        g.drawString("En este modo compiten para ver quien destruye todos los bloques primero!", 40, 340);        
        g.setColor(Color.WHITE);
        g.drawString("Pulsa la tecla P para pausar el juego en cualquier momento!", 40, 380);
        g.setFont(titleFont);
        g.drawString("Presiona SPACE para volver al menú", 80, 460);
    }
    
    public void keyPressed(int k){
        if(k == KeyEvent.VK_SPACE){
            gsm.setState(GameStateManager.MENUSTATE);
            fondo.stop();
        }
    }
    
    public void keyReleased(int k){}
}
