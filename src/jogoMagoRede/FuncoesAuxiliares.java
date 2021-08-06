package jogoMago;

public abstract class FuncoesAuxiliares {
	
	public static int prendedor(int num, int min, int max) {
		if(num<min)
			return min;
		if(num>max)
			return max;
		return num;
	}
	
	public static int ciclo(int cicloAtual, int qtdMaxCiclos) {
		if(cicloAtual+1>qtdMaxCiclos)
			return 0;
		return cicloAtual+1;
	}
	
	public static boolean colideRecRec(CaixaColisao a, CaixaColisao b) {
		//a em b
		if(colideRecPonto(a,b.getX(),b.getY()) || colideRecPonto(a,b.getX()+b.getLargura(),b.getY()))
			return true;
		if(colideRecPonto(a,b.getX(),b.getY()+b.getAltura())||colideRecPonto(a,b.getX()+b.getLargura(),b.getY()+b.getAltura()))
			return true;
		
		//b em a
		if(colideRecPonto(b,a.getX(),a.getY()) || colideRecPonto(b,a.getX()+a.getLargura(),a.getY()))
			return true;
		if(colideRecPonto(b,a.getX(),a.getY()+a.getAltura())||colideRecPonto(b,a.getX()+a.getLargura(),a.getY()+a.getAltura()))
			return true;
		return false;
	}
	
	public static boolean colideRecPonto(CaixaColisao a, int x, int y) {
		if(x>a.getX() && x<a.getX()+a.getLargura())
			if(y>a.getY() && y<a.getY()+a.getAltura())
				return true;
			
		return false;
	}
	
	
	
}
