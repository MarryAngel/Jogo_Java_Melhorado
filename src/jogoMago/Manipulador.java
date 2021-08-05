package jogoMago;

import java.awt.Graphics;
import java.util.LinkedList;

public class Manipulador{
	LinkedList<Objetos> objJogo = new LinkedList<Objetos>();
	public Manipulador(int largJanela, int altJanela){
		objJogo.add(new Fundo(0,0,largJanela,altJanela));
		objJogo.add(new Mago(400, 400, largJanela*100/305/2, altJanela*100/158/2, "Fogo"));
		objJogo.add(new Mago(600, 400, largJanela*100/305/2, altJanela*100/158/2, "Gelo"));
	}
	
	public void render(Graphics g){
		for(int i=0; i<objJogo.size(); i++) {
			objJogo.get(i).render(g);
		}
	}
	
	public void tick(){
		for(int i=0; i<objJogo.size(); i++) {
			objJogo.get(i).tick();
		}
	}
}
