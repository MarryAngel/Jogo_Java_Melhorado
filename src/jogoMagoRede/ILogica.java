package jogoMagoRede;

public interface ILogica {

	public String getComandos(boolean b);

	public void executar(String comando, boolean b);

	public void danificar();

	public void resetManipulador(Manipulador manipulador);

	public void clicar(char c, boolean b);

	public void soltar(char c, boolean b);

}
