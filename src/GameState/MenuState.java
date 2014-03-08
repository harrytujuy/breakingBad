package GameState;

import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {
	
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {
		"1 Jugador",
		"2 Jugadores",
		"Ayuda",
                "Salir"
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background("/Resources/Backgrounds/breakingbad.jpg", 1);
			bg.setVector(-0.1, 0);
			
			titleColor = new Color(10,0,120);
			titleFont = new Font("Arial",Font.PLAIN, 50);
			
			font = new Font("Times New Roman", Font.PLAIN, 22);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void init() {}
	
	public void update() {
		bg.update();
	}
	
	public void draw(Graphics2D g) {
		
		// draw bg
		bg.draw(g);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Breaking Bad", 180, 100);
		
		// draw menu options
		g.setFont(font);
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.CYAN);
			}
			else {
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 280, 220 + i * 30);
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










