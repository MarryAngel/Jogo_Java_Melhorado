package jogoMago;

public class Logica {
	private Manipulador manipulador;
	
	public Logica(Manipulador manipulador) {
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
		 default:
			 break;
		 }
	 }

}
