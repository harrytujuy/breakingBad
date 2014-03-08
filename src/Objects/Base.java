/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

/**
 *
 * @author Szerch
 */
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;

public class Base {
	
	public int posX;    //posicion en x.       
	public int posY;	//posicion en y.
        public int posCX;
        public int posCY;
        private int vel;
        public int direccion;
        protected int x;
        protected int y;
        protected int dx;
        protected int dy;
        protected boolean left = true;
        protected boolean right = true;
        protected boolean upright;
        protected boolean downright;
        protected boolean upleft;
        protected boolean downleft;
        protected boolean movement;
	private ImageIcon icono;    //icono.
	
	/**
	 * Metodo constructor usado para crear el objeto
	 * @param posX es la <code>posicion en x</code> del objeto.
	 * @param posY es la <code>posicion en y</code> del objeto.
	 * @param image es la <code>imagen</code> del objeto.
	 */
	public Base() {
		icono = new ImageIcon();
	}
	
	/**
	 * Metodo modificador usado para cambiar la posicion en x del objeto 
	 * @param posX es la <code>posicion en x</code> del objeto.
	 */
        
        public void setVelocidad(int vel){
            this.vel = vel;
        }
        
        public int getVelocidad(){
            return vel;
        }
        
        public void setLeft(boolean b){
            left = b;
        }
        public boolean getLeft(){
            return left;
        }
        public void setRight(boolean b){
            right = b;
        }
        public boolean getRight(){
            return right;
        }
        public void setUpRight(boolean b){
            upright = b;
        }
        public void setDownRight(boolean b){
            downright = b;
        }
        
        public void setUpLeft(boolean b){
            upleft = b;
        }
        public void setDownLeft(boolean b){
            downleft = b;
        }
        
        public boolean getDownRight(){
            return downright;
        }
        
        public boolean getDownLeft(){
            return downleft;
        }
        
        public boolean getUpRight(){
            return upright;
        }
        
        public boolean getUpLeft(){
            return upleft;
        }
        
        public void setMovement(boolean b){
            movement = b;
        }
        
        public boolean getMovement(){
            return movement;
        }
        
	public void setPosX(int posX) {
		this.x = posX;
	}
	
	/**
	 * Metodo de acceso que regresa la posicion en x del objeto 
	 * @return posX es la <code>posicion en x</code> del objeto.
	 */
	public int getPosX() {
		return x;
	}
	
	/**
	 * Metodo modificador usado para cambiar la posicion en y del objeto 
	 * @param posY es la <code>posicion en y</code> del objeto.
	 */
	public void setPosY(int posY) {
		this.y = posY;
	}
	
	/**
	 * Metodo de acceso que regresa la posicion en y del objeto 
	 * @return posY es la <code>posicion en y</code> del objeto.
	 */
	public int getPosY() {
		return y;
	}
        
        public void setPosition(int x, int y){
            this.x = x;
            this.y = y;
        }
	
	/**
	 * Metodo modificador usado para cambiar el icono del objeto 
	 * @param icono es el <code>icono</code> del objeto.
	 */
	public void setImageIcon(ImageIcon icono) {
		this.icono = icono;
	}
	
	/**
	 * Metodo de acceso que regresa el icono del objeto 
	 * @return icono es el <code>icono</code> del objeto.
	 */
	public ImageIcon getImageIcon() {
		return icono;
	}
	
	/**
	 * Metodo de acceso que regresa el ancho del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el ancho del icono.
	 */
	public int getAncho(){
            return icono.getIconWidth();
        }
	
	/**
	 * Metodo de acceso que regresa el alto del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el alto del icono.
	 */
	public int getAlto() {
		return icono.getIconHeight();
	}
	
	/**
	 * Metodo de acceso que regresa la imagen del icono 
	 * @return un objeto de la clase <code>Image</code> que es la imagen del icono.
	 */
	public Image getImagenI() {
		return icono.getImage();
	}
	
	/**
	 * Metodo de acceso que regresa un nuevo rectangulo
	 * @return un objeto de la clase <code>Rectangle</code> que es el perimetro 
	 * del rectangulo
	 */
	public Rectangle getPerimetro(){
		return new Rectangle(getPosX(),getPosY(),getAncho(),getAlto());
	}
	
	/**
	 * Checa si el objeto <code>Animal</code> intersecta a otro <code>Animal</code>
	 *
	 * @return un valor boleano <code>true</code> si lo intersecta <code>false</code>
	 * en caso contrario
	 */
	public boolean intersecta(Base obj){
		return getPerimetro().intersects(obj.getPerimetro());
	}
}