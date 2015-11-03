
public class ColaLimitada {

	int[] cola;
	int posParaEncolar;
	
	public ColaLimitada(int numElementos){
		cola=new int[numElementos];
		posParaEncolar=0;
	}
	
	public synchronized void ponerEnCola(int numero){
		if(posParaEncolar==cola.length){
			//cola llena
			System.out.println("Cola LLena, debe Vd. esperar");
			return;
		}
		//aun queda sitio
		cola[posParaEncolar]=numero;
		posParaEncolar++;
	}
	
	public synchronized int sacarPrimero(){
		if(posParaEncolar==0){
			System.out.println("Warning:cola vacía, devolviendo 0");
		}
		int elementoInicial=cola[0];
		//Movemos los elementos hacia delante
		for(int pos=1;pos<cola.length;pos++){
			cola[pos-1]=cola[pos];
		}
		//Ahora la posParaEncolar ha disminuido 
		posParaEncolar--;
		return elementoInicial;
	}
	
	public synchronized String toString(){
		String cadenaCola="";
		for(int pos=0;pos<posParaEncolar;pos++){
			cadenaCola+=cola[pos]+"-";
		}
		
		cadenaCola+="FIN";
		return cadenaCola;
	}
	
}
