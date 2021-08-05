package jogoMago;

public abstract class FuncoesAuxiliares {
	
	public static int prendedor(int num, int min, int max) {
		if(num<min)
			return min;
		if(num>max)
			return max;
		return num;
	}
	
}
