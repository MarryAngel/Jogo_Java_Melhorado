package jogoMago;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Organizador {

	public static Image getImagem(String nome, String estado, int frame)
	{
		return new ImageIcon(nome+estado+frame).getImage();
	}
}
