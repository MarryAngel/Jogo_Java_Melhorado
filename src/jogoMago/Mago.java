package jogoMago;

public class Mago extends Objetos{
	
	
	public Mago(int x, int y, int larg, int alt, String tipo, Manipulador manipulador){
		this.x=x;
		this.y=y;
		this.largura=larg;
		this.altura=alt;
		this.nome=tipo;
		this.estado="Parado";
		this.frame=0;
		this.manipulador=manipulador;
		if(tipo=="Gelo")
			this.invertido=true;
	}
	
	public void tick() {
		super.tick();
		this.analisarEstado();
		if(this.estado == "Pula")
		{
			if(frame == frameMax)
				this.setEstado("Parado");
		}
	}
	
	private void analisarEstado()
	{
		if(this.estado == "Anda" || this.estado == "Parado")
		{
			if(this.velx != 0)
			{
				this.setEstado("Anda");
			}
			else
			{
				this.setEstado("Parado");
			}
		}
		if(this.estado=="Abaixado" && this.frame == this.frameMax)
		{
			this.contador=velocidadeAnimacao;
		}
		
		if(this.estado=="Ataque" && this.frame == this.frameMax && this.contador == this.velocidadeAnimacao)
		{
			this.estado = "Parado";
			this.frameMax=4;
			this.frame = 4;
		}
	}
	public void pular()
	{
		if(this.estado != "Pula")
		{
			this.velocidadeAnimacao=12;
			setVelY(-20);
			setEstado("Pula");
		}
	}
	
	public void abaixar()
	{
		if(this.estado != "Ataque")
			this.setEstado("Abaixado");
	}
	
	public void levantar()
	{
		if(this.estado != "Ataque")
			this.setEstado("Parado");
	}
	
	public void atacar()
	{
		this.frameMax = 6;
		this.setEstado("Ataque");
	}
	
}
