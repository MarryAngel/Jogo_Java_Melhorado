package jogoMagoRede;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Jogo extends Thread
{
	private int altJanela=1080*3/5, largJanela=altJanela/9*16;
	private Timer t;
	private Janela janela;
	private Manipulador manipulador;
	private Logica logica;
	
	private PrintStream[] os;
	private Scanner[] is;
	private int nJogadores=0;;
	private static boolean rodando;
	private boolean cliente;
	
	
	public Jogo(int numMaximoJogadores, boolean cliente){
		rodando = true;
		os = new PrintStream[numMaximoJogadores];
	    is = new Scanner[numMaximoJogadores];
	    this.cliente = cliente;
	}
	
	public void iniciaLogica() {
		this.manipulador = new Manipulador(largJanela, altJanela);
		this.logica = new Logica(this.manipulador);
	}
	
	public void inicia()
	{
		if(cliente)
		{
			this.janela = new Janela(largJanela, altJanela, this);
			this.janela.addKeyListener(new Entradas(logica));
		}
		
		t = new Timer(10, new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		tick();
	    	} 	
	    });
		t.start();
		
		for(int i =0;i<this.nJogadores;i++)
		{
			iniciaThreadLeitura(i);
		}
		
		while(rodando)
		{
			String comandos = logica.getComandos(true);
			if(!comandos.equals(""))
				System.out.println("comandos:"+comandos+".");
			for(int i =0;i<this.nJogadores;i++)
			{
				os[i].println(comandos);
			}
		}
		t.stop();
	}
	
	void iniciaThreadLeitura(int numDoJogador) {
	    new Thread(new Runnable() {
	      int numJogador = numDoJogador;

	      public void run() {
	  		while(rodando)
	  		{
				try {
					String comando = is[numJogador].nextLine();
					//System.out.println(comando);
					logica.executar(comando,cliente);
				} catch (Exception e) {
					rodando = false;
				}
	  			
	  		}
	  		rodando = false;
	      }
	    }).start();

	  }
	
	private void tick(){
		this.manipulador.tick();
		if(cliente) this.janela.repaint();
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

	public void adicionaJogador(Socket clientSocket) {
		try {
			os[nJogadores] = new PrintStream(clientSocket.getOutputStream());
			is[nJogadores] = new Scanner(clientSocket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.nJogadores++;
		
		
	}



}
