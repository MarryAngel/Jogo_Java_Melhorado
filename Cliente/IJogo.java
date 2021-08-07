package jogoMagoRede;

import java.net.Socket;

public interface IJogo {

	public void adicionaJogador(Socket clientSocket);

	public void iniciaLogica();

	public void inicia();

}
