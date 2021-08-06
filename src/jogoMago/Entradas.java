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
            if(e.getKeyCode() == 39) {
            	logica.clicar('d');
            }
            if(e.getKeyCode() == 37) {
            	logica.clicar('a');
            }
            if(e.getKeyCode() == 38) {
            	logica.clicar('w');
            }
            if(e.getKeyCode() == 40) {
            	logica.clicar('s');
            }
            if(e.getKeyCode() == 16) {
            	logica.clicar('c');
            }
            if(e.getKeyCode() == KeyEvent.VK_C) {
            	logica.clicar('c');
            }
            if(e.getKeyCode() == KeyEvent.VK_J) {
            	logica.clicar('j');
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
        if(e.getKeyCode() == 39) {
        	logica.soltar('d');
        }
        if(e.getKeyCode() == 37) {
        	logica.soltar('a');
        }
        if(e.getKeyCode() == 38) {
        	logica.soltar('w');
        }
        if(e.getKeyCode() == 40) {
        	logica.soltar('s');
        }
        if(e.getKeyCode() == 16) {
        	logica.soltar('c');
        }
        if(e.getKeyCode() == KeyEvent.VK_C) {
        	logica.soltar('c');
        }
        
    }
    
}