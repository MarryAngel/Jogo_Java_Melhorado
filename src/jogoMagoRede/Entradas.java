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
                logica.clicar('D',true);
            }
            if(e.getKeyCode() == KeyEvent.VK_A) {
                logica.clicar('A',true);
            }
            if(e.getKeyCode() == KeyEvent.VK_W) {
                logica.clicar('W',true);
            }
            if(e.getKeyCode() == KeyEvent.VK_S) {
                logica.clicar('S',true);
            }
            if(e.getKeyCode() == KeyEvent.VK_E) {
                logica.clicar('E',true);
            }
            if(e.getKeyCode() == 39) {
                logica.clicar('d',true);
            }
            if(e.getKeyCode() == 37) {
                logica.clicar('a',true);
            }
            if(e.getKeyCode() == 38) {
                logica.clicar('w',true);
            }
            if(e.getKeyCode() == 40) {
                logica.clicar('s',true);
            }
            if(e.getKeyCode() == 16) {
                logica.clicar('c',true);
            }
            if(e.getKeyCode() == KeyEvent.VK_C) {
                logica.clicar('c',true);
            }
            if(e.getKeyCode() == KeyEvent.VK_J) {
                logica.clicar('j',true);
            }
            if(e.getKeyCode() == KeyEvent.VK_O) {
                System.out.println(this.logica.getComandos(true));
            }
            pressionados[e.getKeyCode()]=true;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        pressionados[e.getKeyCode()]=false;
        if(e.getKeyCode() == KeyEvent.VK_D) {
            logica.soltar('D',true);
        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
            logica.soltar('A',true);
        }
        if(e.getKeyCode() == KeyEvent.VK_W) {
            logica.soltar('W',true);
        }
        if(e.getKeyCode() == KeyEvent.VK_S) {
            logica.soltar('S',true);
        }
        if(e.getKeyCode() == KeyEvent.VK_E) {
            logica.soltar('E',true);
        }
        if(e.getKeyCode() == 39) {
            logica.soltar('d',true);
        }
        if(e.getKeyCode() == 37) {
            logica.soltar('a',true);
        }
        if(e.getKeyCode() == 38) {
            logica.soltar('w',true);
        }
        if(e.getKeyCode() == 40) {
            logica.soltar('s',true);
        }
        if(e.getKeyCode() == 16) {
            logica.soltar('c',true);
        }
        if(e.getKeyCode() == KeyEvent.VK_C) {
            logica.soltar('c',true);
        }
        
    }
    
}