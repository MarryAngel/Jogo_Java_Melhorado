package jogoMago;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Jogo{
	private int altJanela=1080*3/5, largJanela=altJanela/9*16;
	private Timer t;
	
	public Jogo() {
		new Janela(largJanela, altJanela, this);
		t = new Timer(10, new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		tick();
	    	}
	    });
		t.start();
	}
	
	private void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(new Color(0,255,255));
		g.fillRect(0,0,100,100);
	}

	
	
}
