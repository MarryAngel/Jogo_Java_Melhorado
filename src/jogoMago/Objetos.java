package jogoMago;

import java.awt.Image;

public abstract class Objetos {
	private int x;
	private int y;
	private String nome;
	private String estado;
	private int frame;
	
	private Image getImage()
	{
		return Organizador.getImagem(nome,estado,frame);
	}
	
	public abstract void render();
}
