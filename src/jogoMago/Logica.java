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
			 manipulador.getJogador().setVelY(-20);
			 break;
		 case 'S':
			 System.out.println("apertei S");
			 break;
		 case ' ':
			 System.out.println("apertei SPACE");
			 break;
		 case 'd':
			 manipulador.getAdversario().setVelX(manipulador.getAdversario().getVelX()+10);
			 break;
		 case 'a':
			 manipulador.getAdversario().setVelX(manipulador.getAdversario().getVelX()-10);
			 break;
		 case 'w':
			 manipulador.getAdversario().setVelY(-20);
			 break;
		 case 's':
			 System.out.println("apertei s");
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
			 System.out.println("soltei W");
			 break;
		 case 'S':
			 System.out.println("soltei S");
			 break;
		 case ' ':
			 System.out.println("soltei SPACE");
			 break;
			 
		 case 'd':
			 manipulador.getAdversario().setVelX(manipulador.getAdversario().getVelX()-10);
			 break;
		 case 'a':
			 manipulador.getAdversario().setVelX(manipulador.getAdversario().getVelX()+10);
			 break;
		 case 'w':
			 System.out.println("soltei w");
			 break;
		 case 's':
			 System.out.println("soltei s");
			 break;
		 }
	 }

}
