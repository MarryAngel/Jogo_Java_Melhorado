package jogoMago;

import java.awt.Graphics;
import java.util.LinkedList;

public class Manipulador{
	private int largJanela, altJanela;
	private LinkedList<Objetos> objJogo = new LinkedList<Objetos>();
	private Mago jogador;
	private Mago adversario;
	
	public Manipulador(int largJanela, int altJanela){
		this.largJanela=largJanela;
		this.altJanela=altJanela;
		objJogo.add(new Fundo(0,0,largJanela,altJanela, this));
		//Criando os jogadores
		jogador = new Mago(400, 100, largJanela*100/305/2, altJanela*100/158/2, "Fogo", this);
		adversario = new Mago(600, 100, largJanela*100/305/2, altJanela*100/158/2, "Gelo", this);
		//Adicionando os jogadores ao jogo por meio de uma lista
		objJogo.add(jogador);
		objJogo.add(adversario);
		
	}
	
	public void render(Graphics g){
		for(int i=0; i<objJogo.size(); i++){
			objJogo.get(i).render(g);
		}
	}
	
	public void tick(){
		for(int i=0; i<objJogo.size(); i++) {
			objJogo.get(i).tick();
		}
	}
	
	public int getAltura() {return this.altJanela;}
	
	public int getLargura() {return this.largJanela;}
	
	public Mago getJogador() {return this.jogador;}

	public Mago getAdversario() {return this.adversario;}
}
