package jogoMago;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Jogo
{
	private int altJanela=1080*3/5, largJanela=altJanela/9*16;
	private Timer t;
	private int x=0,y=0;
	private Janela janela;
	private Manipulador manipulador;
	
	public Jogo(){
		this.janela = new Janela(largJanela, altJanela, this);
		t = new Timer(10, new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		tick();
	    	} 	
	    });
		t.start();
		this.manipulador = new Manipulador(largJanela, altJanela);
		
	}
	
	private void tick(){
		x++;
		y++;
		this.manipulador.tick();
		this.janela.repaint();
	}
	
	public void render(Graphics g){
		this.manipulador.render(g);
		g.setColor(new Color(0,255,255));
		g.fillRect(x,y,100,100);
	}

}
