package jogoMagoRede;

import java.io.PrintStream;
import java.util.Scanner;

public class Logica {
	private Manipulador manipulador;
	private String comandos;
	
	public Logica(Manipulador manipulador) {
		this.manipulador=manipulador;
		comandos = "";
	}
	
	public void executar(String comandos)
	{
		for(int i = 0;i<comandos.length();i++)
		{
			if(comandos.charAt(i)==',' || comandos.charAt(i)=='\n')
			{
				continue;
			}
			if(comandos.charAt(i)=='!')
			{
				this.soltar(comandos.charAt(i+1),false);
				continue;
			}
			this.clicar(comandos.charAt(i),false);
		}
	}
	
	public void resetManipulador(Manipulador manipulador)
	{
		this.manipulador=manipulador;
	}
	
	private void adicionarComando(String string)
	{
		if(this.comandos != "")
			this.comandos+=",";
		this.comandos+=string;
	}
	
	public String getComandos(boolean zerar)
	{
		String retorno = this.comandos;
		if(zerar)
			this.comandos = "";
		return retorno;
	}
	
	 public void clicar(char botao,boolean anotar) {
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

	public void entradaSaida(Scanner entrada, PrintStream saida) {
		while(entrada.hasNextLine())
		{
			String linha = entrada.nextLine();
			this.executar(linha);
		}
		saida.println(this.comandos);
		saida.flush();
	}
	 
}
