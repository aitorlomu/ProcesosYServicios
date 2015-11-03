
public class GestorPalillos {

	private boolean[] palillos;
	
	public GestorPalillos(int num_filosofos){
		palillos= new boolean[num_filosofos];
		
		for(int i=0;i<palillos.length;i++){
			palillos[i]=false;
			
		}
	}
	
	public synchronized boolean sePuedenCogerAmbosPalillos(int num1, int num2){	
		
		if((palillos[num1]==false) && (palillos[num2]==false)){
			palillos[num1]=true;
			palillos[num2]=true;
			System.out.println("Alguien cogió los palillos "+num1 +" y "+num2);
			return true;
		}
		else{
			return false;
		}
	}

	public synchronized void soltarPalillos(int num1, int num2){
		if((palillos[num1]==true) && (palillos[num2]==true)){
			palillos[num1]=false;
			palillos[num2]=false;	
			System.out.println("Se soltaron los palillos "+num1 +" y "+num2);
		}
	}
}
