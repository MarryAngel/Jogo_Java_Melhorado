package jogoMago;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Organizador {
	private static String caminho="imagens/";
	
	private static Map<String, Image> mapaImagens = new HashMap<String, Image>();
	
	public static Image getImagem(String nome, String estado, int frame) throws IOException
	{
		
		try {
			if(mapaImagens.get(nome+estado+frame) == null)
			   mapaImagens.put(nome+estado+frame, ImageIO.read(new File(""+caminho+nome+estado+frame+".png")));
			return mapaImagens.get(nome+estado+frame);
		} catch (IOException e) {
			System.out.println("Tentei ler "+nome+estado+frame);
			return null;
		}
	}
	
}
