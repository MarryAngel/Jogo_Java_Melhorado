package jogoMagoRede;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Desenho extends JPanel{
	private static final long serialVersionUID = 1L;
	private Jogo jogo;
	
	public Desenho(Jogo jogo)
	{
		this.jogo = jogo;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		jogo.render(g);
	    Toolkit.getDefaultToolkit().sync();
	}

}
