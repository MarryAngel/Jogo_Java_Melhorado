package jogoMagoRede;

public class Logica implements ILogica{
	private Manipulador manipulador;
	private String comandos;
	
	public Logica(Manipulador manipulador) {
		this.manipulador=manipulador;
		comandos = "";
	}
	
	public void executar(String comandos, boolean anotar)
	{
		System.out.println("ignorar: "+anotar);
		for(int i = 0;i<comandos.length();i++)
		{
			if(comandos.charAt(i)==',' || comandos.charAt(i)=='\n')
			{
				continue;
			}
			if(comandos.charAt(i)=='!')
			{
				System.out.println("soltando "+comandos.charAt(i+1));
				this.soltar(comandos.charAt(i+1),anotar);
				i++;
				continue;
			}
			System.out.println("clicando "+comandos.charAt(i));
			this.clicar(comandos.charAt(i),anotar);
		}
	}
	
	public void resetManipulador(Manipulador manipulador)
	{
		this.manipulador=manipulador;
	}
	
	private void adicionarComando(String string)
	{
		System.out.println("adicionando comando");
		if(this.comandos != "")
			this.comandos+=",";
		this.comandos+=string;
		System.out.println("comando adicionado");
	}
	
	public String getComandos(boolean zerar)
	{
		String retorno = this.comandos;
		if(zerar)
			this.comandos = "";
		
		return retorno;
	}
	
	 public void clicar(char botao,boolean anotar) {
		 System.out.println("clicado "+botao+" anotar: "+anotar);
		 if(anotar)
		 {
			 this.adicionarComando(""+botao);
			 return;
		 }
		 switch(botao) {
		 case 'D':
			 manipulador.getJogador().setVelX(manipulador.getJogador().getVelX()+10);
			 break;
		 case 'A':
			 manipulador.getJogador().setVelX(manipulador.getJogador().getVelX()-10);
			 break;
		 case 'W':
			 manipulador.getJogador().pular();
			 break;
		 case 'S':
			 manipulador.getJogador().abaixar();
			 break;
		 case 'E':
			 manipulador.getJogador().atacar();
			 break;
		 case 'd':
			 manipulador.getAdversario().setVelX(manipulador.getAdversario().getVelX()+10);
			 break;
		 case 'a':
			 manipulador.getAdversario().setVelX(manipulador.getAdversario().getVelX()-10);
			 break;
		 case 'w':
			 manipulador.getAdversario().pular();
			 break;
		 case 's':
			 manipulador.getAdversario().abaixar();
			 break;
		 case 'c':
			 manipulador.getAdversario().atacar();
			 break;
		 case 'j':
			 manipulador.alternarDebug();
			 break;
		 default:
			 break;
		 }
	 }
	 
	 public void soltar(char botao, boolean anotar) {
		 System.out.println("soltado "+botao+" anotar: "+anotar);
		 if(anotar)
		 {
			 this.adicionarComando("!"+botao);
			 return;
		 }
		 switch(botao) {
		 case 'D':
			 manipulador.getJogador().setVelX(manipulador.getJogador().getVelX()-10);
			 break;
		 case 'A':
			 manipulador.getJogador().setVelX(manipulador.getJogador().getVelX()+10);
			 break;
		 case 'W':
			 break;
		 case 'S':
			 manipulador.getJogador().levantar();
			 break;
		 case 'E':
			 manipulador.getJogador().pararAtacar();
			 break;
		 case 'd':
			 manipulador.getAdversario().setVelX(manipulador.getAdversario().getVelX()-10);
			 break;
		 case 'a':
			 manipulador.getAdversario().setVelX(manipulador.getAdversario().getVelX()+10);
			 break;
		 case 'w':
			 break;
		 case 's':
			 manipulador.getAdversario().levantar();
			 break;
		 case 'c':
			 manipulador.getAdversario().pararAtacar();
			 break;
		 default:
			 break;
		 }
	 }

	 public void danificar() {
		 if(manipulador.getJogador().estaAtacando())
		 {
			 if(FuncoesAuxiliares.colideRecRec(manipulador.getJogador().getAtaque(),manipulador.getAdversario().getColisao()))
			 {
				 if(!manipulador.getAdversario().estaAbaixado())
				 {
					 manipulador.getAdversario().machucar();
				 }
				 
			 }
		 }
		 if(manipulador.getAdversario().estaAtacando())
		 {
			 if(FuncoesAuxiliares.colideRecRec(manipulador.getAdversario().getAtaque(),manipulador.getJogador().getColisao()))
			 {
				 if(!manipulador.getJogador().estaAbaixado())
				 {
					 manipulador.getJogador().machucar();
				 }
			 }
		 }
		 if(manipulador.getJogador().getMorto())
		 {
			 throw new GeloWin();
		 }
		 if(manipulador.getAdversario().getMorto())
		 {
			 throw new FogoWin();
		 }
	 }
	 
}
