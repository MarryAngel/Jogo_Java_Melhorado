package jogoMago;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Jogo
{
	private int altJanela=1080*3/5, largJanela=altJanela/9*16;
	private Timer t;
	private Janela janela;
	private Manipulador manipulador;
	private Logica logica;
	
	public Jogo(){
		this.manipulador = new Manipulador(largJanela, altJanela);
		this.logica = new Logica(this.manipulador);
		this.janela = new Janela(largJanela, altJanela, this);
		this.janela.addKeyListener(new Entradas(logica));
		
		t = new Timer(10, new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		tick();
	    	} 	
	    });
		t.start();
	}
	
	private void tick(){
		this.manipulador.tick();
		this.janela.repaint();
		try {
			this.logica.danificar();
		} catch (Fim e) {
			JOptionPane.showMessageDialog(janela, e);
			this.reset();
		}
	}
	
	private void reset() {
		this.manipulador = new Manipulador(largJanela, altJanela);
		logica.resetManipulador(this.manipulador);
		
	}

	public void render(Graphics g){
		this.manipulador.render(g);
		
	}

}
