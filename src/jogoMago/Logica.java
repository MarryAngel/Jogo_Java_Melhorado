package jogoMago;

public class Logica {
	private Manipulador manipulador;
	
	public Logica(Manipulador manipulador) {
		this.manipulador=manipulador;
	}
	
	public void resetManipulador(Manipulador manipulador)
	{
		this.manipulador=manipulador;
	}
	
	 public void clicar(char botao) {
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
		 case ' ':
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
	 
	 public void soltar(char botao) {
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
		 case ' ':
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
