package jogoMago;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Jogo{
	private int altJanela=1080*3/5, largJanela=altJanela/9*16;
	private Timer t;
	private int x=0,y=0;
	private Janela janela;
	private Fundo fundo = new Fundo(0,0,largJanela,altJanela);
	private Mago magoFogo = new Mago(400, 400, largJanela*100/305/2, altJanela*100/158/2, "Fogo");
	private Mago magoGelo = new Mago(600, 400, largJanela*100/305/2, altJanela*100/158/2, "Gelo");
	
	
	public Jogo() {
		System.out.println("larguraJanela: "+largJanela);
		System.out.println("altJanela: "+altJanela);
		this.janela = new Janela(largJanela, altJanela, this);
		t = new Timer(10, new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		tick();
	    	}
	    });
		t.start();
	}
	
	private void tick()
	{
		x++;
		y++;
		this.janela.repaint();
	}
	
	public void render(Graphics g)
	{
		fundo.render(g);
		magoFogo.render(g);
		magoGelo.render(g);
		g.setColor(new Color(0,255,255));
		g.fillRect(x,y,100,100);
	}

	
	
}
