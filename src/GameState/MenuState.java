package GameState;

import Objects.SoundClip;
import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {
	
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {
		"1 Jugador",
		"2 Jugadores (Demo)",
		"Ayuda",
                "Salir"
	};
	
	private Font font;
        private SoundClip fondo;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background("/Resources/Backgrounds/breaking bad fondo.jpg", 1);
			
			font = new Font("Times New Roman", Font.PLAIN, 22);
                        fondo = new SoundClip("/Resources/Sounds/Menu.wav");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
                fondo.setLooping(true);
                fondo.play();
	}
	
	public void init() {
            fondo.play();
        }
	
	public void update() {
		bg.update();
	}
	
	public void draw(Graphics2D g) {
		
		// draw bg
		bg.draw(g);
		
		// draw menu options
		g.setFont(font);
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.CYAN);
			}
			else {
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 440, 120 + i * 30);
		}
		
	}
	
	private void select() {
		if(currentChoice == 0) {
			// 1 jugador
                        gsm.setState(GameStateManager.LEVEL1STATE);
		}
		if(currentChoice == 1) {
			// 2 jugadores
                        gsm.setState(GameStateManager.MULTIPLAYERSTATE);
		}
		if(currentChoice == 2) {
			gsm.setState(GameStateManager.HELPSTATE);
		}
                if(currentChoice == 3){
                    //salir
                    System.exit(0);
                }
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
                    fondo.stop();
                    select();
		}
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}
	public void keyReleased(int k) {}
	
}