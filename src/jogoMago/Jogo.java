package jogoMago;

import java.awt.Graphics;

public class Jogo implements Runnable{
	private int altJanela=1080*3/5, largJanela=altJanela/9*16;
	private Janela janela = null;
	private Graphics g = null;
	private Thread thread;
	private boolean running = false;
	
	public Jogo() {
		this.janela = new Janela(largJanela, altJanela);
		g = janela.getGraficos();
		
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running=true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running=false;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void run() {
		
	}
	
}
