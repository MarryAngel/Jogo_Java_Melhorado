import java.awt.Dimension;
import javax.swing.*;

public class Janela extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Desenho des;
	
	public Janela(int LARGURA, int ALTURA, Jogo jogo,String titulo){
		super(titulo);//"A Grande Batalha"
		des = new Desenho(jogo);
		this.setPreferredSize(new Dimension(LARGURA,ALTURA));
		this.setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(des);                           
		pack();				       	    
		setVisible(true);
	}
	
}
