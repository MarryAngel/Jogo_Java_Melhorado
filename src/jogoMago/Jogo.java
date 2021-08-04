package jogoMago;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Jogo{
	private int altJanela=1080*3/5, largJanela=altJanela/9*16;
	private Janela janela;
	private Graphics g;
	private Thread thread;
	private boolean running = false;
	private Timer t;
	
	public Jogo() {
		this.janela = new Janela(largJanela, altJanela);
		t = new Timer(10, new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		g = janela.getGraficos();
	    		tick();
	    	}
	    });
		t.start();
	}
	
	private void tick()
	{
		render();
	}
	
	private void render()
	{
		g.setColor(new Color(0,255,255));
		g.fillRect(0,0,100,100);
		janela.reDes();
	}

	
	
}
