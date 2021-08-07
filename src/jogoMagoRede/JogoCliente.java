//package jogoMagoRede;
//
//import java.awt.Rectangle;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//
//import javax.swing.JFrame;
//
//public class JogoCliente extends JFrame {
//  Rectangle[] rect;
//  Rede rede = new Rede();
//
//  Ambiente ambiente;
//
//  JogoCliente() {
//    super("Jogo");
//    ambiente = new Ambiente(this);
//    rede.recebeDadosIniciais(ambiente);
//    setDefaultCloseOperation(EXIT_ON_CLOSE);
//    add(ambiente);
//    pack();
//    setResizable(false);
//    setVisible(true);
//
//    addKeyListener(new KeyAdapter() {
//      public void keyPressed(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//          rede.enviaComandosEDadosDoJogador(Jogador.ANDA0);
//        } else if (e.getKeyCode() == KeyEvent.VK_P) {
//          rede.enviaComandosEDadosDoJogador(Jogador.PARADO);
//        } else if (e.getKeyCode() == KeyEvent.VK_S) {
//          rede.enviaComandosEDadosDoJogador(Jogador.SOCO0);
//        }
//      }
//    });
//
//    new Thread(new Runnable() {
//      public void run() {
//        while (true) {
//          rede.recebeSituacao(ambiente.jogador);
//          rede.recebeSituacao(ambiente.adversario);
//          rede.recebePlacar(ambiente);
//          ambiente.repaint();
//        }
//      }
//    }).start();
//  }
//
//  static public void main(String[] args) {
//    new JogoCliente();
//  }
//}

package jogoMagoRede;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class JogoCliente {
	
	private static Socket iniciarCliente(String ip,int porta)
	{
		Socket cliente = null;
		try {
            System.out.println("Conectando cliente ao servidor!");
            cliente = new Socket("127.0.0.1",porta);
        }catch (UnknownHostException e) {
           System.err.println("Erro ao conectar com o IP.");
        } catch (IOException e) {
          System.err.println("Couldn't get I/O for the connection to host");
        }
        System.out.println("Conectei ao server!");
        return cliente;
	}
	
  public static void main(String[] args) {
	Socket cliente = null;
	int porta = 25582;
	String ip = "127.0.0.1";

	cliente = iniciarCliente(ip,porta);
	
	int numMaximoJogadores = 1;
	Jogo jogo = new Jogo(numMaximoJogadores, true);
	jogo.adicionaJogador(cliente);
	jogo.iniciaLogica();
	jogo.inicia();
	
	
	try {
		PrintStream escrever = new PrintStream(cliente.getOutputStream());
		escrever.println("close");
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	
	
	try {
		cliente.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
}
