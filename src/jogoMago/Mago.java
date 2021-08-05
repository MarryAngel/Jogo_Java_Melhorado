package jogoMago;

import java.awt.Color;
import java.awt.Graphics;

public class Mago extends Objetos{
	private int vidaMago=400;
	private CaixaColisao colisao;
	
	public Mago(int x, int y, int larg, int alt, String tipo, Manipulador manipulador){
		this.x=x;
		this.y=y;
		this.largura=larg;
		this.altura=alt;
		this.nome=tipo;
		this.estado="Parado";
		this.frame=0;
		this.manipulador=manipulador;
		this.colisao=new CaixaColisao(x, y, largura, altura);
		if(tipo=="Gelo")
			this.invertido=true;
	}
	
	public void render(Graphics g){
		if(invertido)
			g.drawImage(this.getImage(), this.x+largura, this.y, -this.getImage().getWidth(null)/2, this.getImage().getHeight(null)/2, null);
		else
			g.drawImage(this.getImage(), this.x, this.y, this.getImage().getWidth(null)/2,  this.getImage().getHeight(null)/2, null);
	      g.setColor(new Color(110,110,110));
	      if(nome=="Fogo") {
	    	  g.fillRect(10, 20, 400, 50);
	    	  g.setColor(new Color(255,130*vidaMago/400,0)); //255,0,0
	    	  g.fillRect(10, 20, vidaMago, 50);
	      }else {
	    	  g.fillRect(this.manipulador.getLargura()-410, 20, 400, 50);
	    	  g.setColor(new Color(255-255*vidaMago/400,200*vidaMago/400,255*vidaMago/400));
	    	  g.fillRect(this.manipulador.getLargura()-10, 20, -vidaMago, 50);
	      }
	      colisao.render(g);
	}
	
	public void tick() {
		super.tick();
		colisao.refazer(x, y, largura, altura);
		this.analisarEstado();
		if(this.estado == "Pula"){
			if(frame == frameMax)
				this.setEstado("Parado");
		}
	}
	
	private void analisarEstado(){
		if(this.estado == "Anda" || this.estado == "Parado"){
			if(this.velx != 0){
				this.setEstado("Anda");
			}else{
				this.setEstado("Parado");
			}
		}
		if(this.estado=="Abaixado" && this.frame == this.frameMax){
			this.contador=velocidadeAnimacao;
		}
		
		if(this.estado=="Ataque" && this.frame == this.frameMax && this.contador == this.velocidadeAnimacao){
			this.estado = "Parado";
			this.frameMax=4;
			this.frame = 4;
		}
	}
	
	public void pular(){
		if(this.estado != "Pula"){
			this.velocidadeAnimacao=12;
			setVelY(-20);
			setEstado("Pula");
		}
	}
	
	public void abaixar(){
		if(this.estado != "Ataque")
			this.setEstado("Abaixado");
	}
	
	public void levantar(){
		if(this.estado != "Ataque")
			this.setEstado("Parado");
	}
	
	public void atacar(){
		this.frameMax = 5;
		this.setEstado("Ataque");
	}
	
	
	
}
