package jogoMagoRede;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

public abstract class Objetos {
	protected int contador=0;
	protected int x, y;
	protected int velx, vely;
	protected final int gravidade=1;
	protected int largura, altura;
	protected boolean invertido=false;
	protected String nome;
	protected String estado;
	protected int frame;
	protected Manipulador manipulador;
	protected int frameMax=4;
	protected int velocidadeAnimacao = 6;
	
	protected Image getImage(){
		try {
			return Organizador.getImagem(nome,estado,frame);
		} catch (IOException e) {
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
		this.y=FuncoesAuxiliares.prendedor(this.y+this.vely, 0, this.manipulador.getAltura()-this.altura-37);
		this.vely+=gravidade;
		if(contador==0)
			this.frame=FuncoesAuxiliares.ciclo(this.frame, frameMax);
		this.contador=FuncoesAuxiliares.ciclo(this.contador, velocidadeAnimacao);
		if(velx!=0)
			this.invertido=velx<0;
	}
	
	public int getVelX() {return this.velx;}
	
	public int getVelY() {return this.vely;}
	
	public void setVelX(int velx) {this.velx=velx;}
	
	public void setVelY(int vely) {this.vely=vely;}
	
	public void setDir(boolean esquerda) {this.invertido=esquerda;}
	
	public void setEstado(String estado) {
		if(estado == this.estado)
			return;
		this.estado = estado;
		this.contador=0;
		this.frame=0;
	}
	
}
