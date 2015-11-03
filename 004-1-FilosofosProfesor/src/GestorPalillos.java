public class GestorPalillos {
	/* False significa que no están cogidos*/
	private boolean[] palillos;
	public GestorPalillos(int num_filosofos){
		palillos=new boolean[num_filosofos];
		for (int i=0;i<palillos.length;i++){
			palillos[i]=false;
		}
	}
	public synchronized boolean
	sePuedenCogerAmbosPalillos(
			int num1,int num2){
		if ( (palillos[num1]==false) &&
				(palillos[num2]==false) ) {
			palillos[num1]=true;
			palillos[num2]=true;
			System.out.println(
					"Alguien consiguio los palillos "+num1+" y "+num2);
			return true;
		}
		return false;
	}
	public synchronized void soltarPalillos(int num1, int num2){
		palillos[num1]=false;
		palillos[num2]=false;
		System.out.println(
				"Alguien liberó los palillos "+num1+" y "+num2);
	}
}