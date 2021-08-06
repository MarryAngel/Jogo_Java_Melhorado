package jogoMago;

import java.awt.Color;
import java.awt.Graphics;

public class Mago extends Objetos{
	private int vidaMago=400;
	private CaixaColisao colisao;
	private CaixaColisao ataque;
	
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
		this.ataque=null;
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
	    	  g.fillRect(this.manipulador.getLargura()-410-15, 20, 400, 50);
	    	  g.setColor(new Color(255-255*vidaMago/400,200*vidaMago/400,255*vidaMago/400));
	    	  g.fillRect(this.manipulador.getLargura()-10-vidaMago-15, 20, vidaMago, 50);
	      }
	      
	      if(manipulador.isDebug())
	      {
		      colisao.render(g);
		      if(ataque!=null)
		    	  ataque.render(g);
	      }
	}
	
	public void tick() {
		super.tick();
		colisao.refazer(x, y, largura, altura);
		this.analisarEstado();
		if(this.estado == "Pula"){
			if(frame == frameMax)
			{
				this.velocidadeAnimacao = 6;
				this.setEstado("Parado");
			}
		}
		if(this.estado == "Machucado"){
			if(frame == frameMax && this.contador == this.velocidadeAnimacao)
			{
				this.setEstado("Parado");
			}
		}
		
		if(this.ataque !=null)
		{
			if(this.invertido)
				this.ataque.refazer(this.x-50-80-20,this.y+30,100,140);
			else
				this.ataque.refazer(this.x+this.largura+50,this.y+30,100,140);
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
		if(this.estado=="Ataque" && this.frame == this.frameMax-1 && this.contador == 1){
			if(this.invertido)
				this.ataque = new CaixaColisao(this.x-50-80,this.y+50,80,100);
			else
				this.ataque = new CaixaColisao(this.x+this.largura+50,this.y+50,80,100);
		}
		if(this.estado=="Ataque" && this.frame == this.frameMax){
			this.contador=velocidadeAnimacao;
		}
	}
	
	public void pular(){
		if(this.estado != "Ataque")
		{
			if(this.estado != "Pula"){
				this.velocidadeAnimacao=12;
				setVelY(-20);
				setEstado("Pula");
			}
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
	
	public void pararAtacar(){
		this.ataque = null;
		this.frameMax = 4;
		this.setEstado("Parado");
	}
	
	public boolean estaAtacando()
	{
		return this.ataque != null;
	}
	
	public CaixaColisao getAtaque()
	{
		return this.ataque;
	}
	
	public CaixaColisao getColisao()
	{
		return this.colisao;
	}
	
	public void machucar(){
		this.estado = "Machucado";
		this.frameMax = 4;
		this.velocidadeAnimacao = 6;
		this.vidaMago-=1;
	}
	
	public boolean estaAbaixado()
	{
		return (this.estado == "Abaixado" && this.frame>2);
	}
	
}
