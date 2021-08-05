package jogoMago;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

public abstract class Objetos {
	protected int x, y;
	protected int velx, vely;
	protected final int gravidade=2;
	protected int largura, altura;
	protected boolean invertido=false;
	protected String nome;
	protected String estado;
	protected int frame;
	protected Manipulador manipulador;
	
	private Image getImage(){
		try {
			return Organizador.getImagem(nome,estado,frame);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void render(Graphics g){
		if(invertido)
			g.drawImage(this.getImage(), this.x+largura, this.y, -largura, altura, null);
		else
			g.drawImage(this.getImage(), this.x, this.y, largura, altura, null);
	}
	
	public void tick() {
		this.x=FuncoesAuxiliares.prendedor(this.x+this.velx, 0, this.manipulador.getLargura()-this.largura);
		this.y=FuncoesAuxiliares.prendedor(this.y+this.vely, 0, this.manipulador.getAltura()-this.altura-39);
		this.vely+=gravidade;
	}
	
	public int getVelX() {return this.velx;}
	
	public int getVelY() {return this.vely;}
	
	public void setVelX(int velx) {this.velx=velx;}
	
	public void setVelY(int vely) {this.vely=vely;}
	
}
