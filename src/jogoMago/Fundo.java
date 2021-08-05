package jogoMago;

public class Fundo extends Objetos{
	public Fundo(int x, int y, int larg, int alt, Manipulador manipulador){
		this.x=x;
		this.y=y;
		this.largura=larg;
		this.altura=alt;
		this.nome="fundo";
		this.estado="Floresta";
		this.frame=0;
		this.manipulador=manipulador;
	}
	
	public void tick() {}

}
