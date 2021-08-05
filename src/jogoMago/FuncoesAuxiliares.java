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
	
}
