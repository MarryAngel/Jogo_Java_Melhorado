package jogoMagoRede;

import java.awt.Color;
import java.awt.Graphics;

public class CaixaColisao {
	private int x, y, largura, altura;
	
	
	public CaixaColisao(int x, int y, int largura, int altura) {	
		this.x=x;
		this.y=y;
		this.largura=largura;
		this.altura=altura;
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(255, 0, 0));
		g.drawRect(x, y, largura, altura);
	}
	
	public int getX() {return this.x;}
	
	public int getY() {return this.y;}
	
	public int getLargura() {return this.largura;}
	
	public int getAltura() {return this.altura;}
	
	public void refazer(int x, int y, int largura, int altura) {	
		this.x=x;
		this.y=y;
		this.largura=largura;
		this.altura=altura;
	}
	
}
