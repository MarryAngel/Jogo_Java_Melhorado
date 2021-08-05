package jogoMago;

public class Logica {
	private Manipulador manipulador;
	
	public Logica(Manipulador manipulador) {
		this.manipulador=manipulador;
	}
	
	 public void clicar(char botao) {
		 switch(botao) {
		 case 'D':
			 System.out.println("apertei D");
			 manipulador.getJogador().setVelX(manipulador.getJogador().getVelX()+10);
			 break;
		 case 'A':
			 System.out.println("apertei A");
			 manipulador.getJogador().setVelX(manipulador.getJogador().getVelX()-10);
			 break;
		 case 'W':
			 System.out.println("apertei W");
			 break;
		 case 'S':
			 System.out.println("apertei S");
			 break;
		 case ' ':
			 System.out.println("apertei SPACE");
			 break;
		 }
	 }
	 
	 public void soltar(char botao) {
		 switch(botao) {
		 case 'D':
			 System.out.println("soltei D");
			 manipulador.getJogador().setVelX(manipulador.getJogador().getVelX()-10);
			 break;
		 case 'A':
			 System.out.println("soltei A");
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
		 }
	 }

}
