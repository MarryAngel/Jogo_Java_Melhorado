package jogoMagoRede;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JogoServidor {
	
	private static ServerSocket ligarServidor(int porta)
	{
		ServerSocket serverSocket = null;
		try {
		      serverSocket = new ServerSocket(porta);
		    } catch (IOException e) {
		      System.out.println("Nao pode escutaro o porto: " + porta + ".\n" + e);
		      System.exit(1);
		    }
		return serverSocket;
	}
	
	private static void receberClientes(int numMaximoJogadores,ServerSocket serverSocket,Jogo jogo)
	{
		for (int i = 0; i < numMaximoJogadores; i++) {
	        Socket clientSocket = null;
	        try {
	          System.out.println("Esperando conexao de um jogador.");
	          clientSocket = serverSocket.accept();
	        } catch (IOException e) {
	          System.out.println("Accept falhou!");
	          System.exit(1);
	        }
	        System.out.println("Accept Funcionou!");
	        jogo.adicionaJogador(clientSocket);
	      }
	}
	
  public static void main(String[] args) {
	ServerSocket serverSocket = null;
	int porta = 25582;

	serverSocket = ligarServidor(porta);
	
	int numMaximoJogadores = 2;
	Jogo jogo = new Jogo(numMaximoJogadores, false);
	receberClientes(numMaximoJogadores,serverSocket,jogo);
	jogo.iniciaLogica();
	jogo.inicia();
	System.out.println("desligando");
	try {
		serverSocket.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
}