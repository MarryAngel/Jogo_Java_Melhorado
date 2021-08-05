package jogoMago;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class Entradas extends KeyAdapter {
	private Logica logica;
	private boolean pressionados[] = new boolean[256];
	
	
	public Entradas(Logica logica) {
		this.logica=logica;
		Arrays.fill(pressionados, false);
	}
	
    public void keyPressed(KeyEvent e) {
    	if(!pressionados[e.getKeyCode()]) {
            if(e.getKeyCode() == KeyEvent.VK_D) {
            	logica.clicar('D');
            }
            if(e.getKeyCode() == KeyEvent.VK_A) {
            	logica.clicar('A');
            }
            if(e.getKeyCode() == KeyEvent.VK_W) {
            	logica.clicar('W');
            }
            if(e.getKeyCode() == KeyEvent.VK_S) {
            	logica.clicar('S');
            }
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            	logica.clicar(' ');
            }
            pressionados[e.getKeyCode()]=true;
    	}
    }
    
    public void keyReleased(KeyEvent e) {
    	pressionados[e.getKeyCode()]=false;
        if(e.getKeyCode() == KeyEvent.VK_D) {
        	logica.soltar('D');
        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
        	logica.soltar('A');
        }
        if(e.getKeyCode() == KeyEvent.VK_W) {
        	logica.soltar('W');
        }
        if(e.getKeyCode() == KeyEvent.VK_S) {
        	logica.soltar('S');
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
        	logica.soltar(' ');
        }
    }
    
}