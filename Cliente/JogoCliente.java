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
	int porta = 25581;
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
