package jogoMago;

public class Mago extends Objetos
{
	String tipo;
	public Mago(int x, int y, int larg, int alt, String tipo)
	{
		this.x=x;
		this.y=y;
		this.largura=larg;
		this.altura=alt;
		this.tipo=tipo;
		this.nome=tipo;
		this.estado="Parado";
		this.frame=0;
		if(tipo=="Gelo")
			this.invertido=true;
	}
}
