package jogoMago;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

public abstract class Objetos {
	protected int x, y;
	protected int largura, altura;
	protected boolean invertido=false;
	protected String nome;
	protected String estado;
	protected int frame;
	
	private Image getImage()
	{
		try {
			return Organizador.getImagem(nome,estado,frame);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void render(Graphics g)
	{
		if(invertido)
			g.drawImage(this.getImage(), this.x+largura, this.y, -largura, altura, null);
		else
			g.drawImage(this.getImage(), this.x, this.y, largura, altura, null);
	}
}
