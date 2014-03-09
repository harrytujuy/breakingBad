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

public class GameOverState extends GameState{
    
    private Font titleFont;
    private Font subTitleFont;
    private Font font;
    private Color colorLeft;
    private Color colorRight;
    
    private Background bg;
    private SoundClip fondo;
    
    public GameOverState(GameStateManager gsm){
        this.gsm = gsm;
        try{
            bg = new Background("/Resources/Backgrounds/gameover.jpg",1);
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
    }
    
    public void keyPressed(int k){
        if(k == KeyEvent.VK_SPACE){
            gsm.setState(GameStateManager.MENUSTATE);
            fondo.stop();
        }
    }
    
    public void keyReleased(int k){}
}
