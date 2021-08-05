package jogoMago;

public class Mago extends Objetos{
	private int contador;
	
	
	public Mago(int x, int y, int larg, int alt, String tipo, Manipulador manipulador){
		this.x=x;
		this.y=y;
		this.largura=larg;
		this.altura=alt;
		this.nome=tipo;
		this.estado="Parado";
		this.frame=0;
		this.manipulador=manipulador;
		this.contador=0;
		if(tipo=="Gelo")
			this.invertido=true;
	}
	
	public void tick() {
		super.tick();
		if(estado=="Parado" && contador==0)
			this.frame=FuncoesAuxiliares.ciclo(this.frame, 4);
		this.contador=FuncoesAuxiliares.ciclo(this.contador, 10);
	}
	
}
