package jogoMago;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Desenho extends JPanel{
	private static final long serialVersionUID = 1L;
	private Graphics graficos = null;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("redesenhando");
		g.setColor(new Color(0,255,255));
		g.fillRect(0,0,100,100);
		this.graficos=g;
	    //Toolkit.getDefaultToolkit().sync();
	}
	
	public Graphics getGraficos(){
		return graficos;
	}

}
