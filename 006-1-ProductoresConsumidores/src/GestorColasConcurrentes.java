
public class GestorColasConcurrentes {

	private ColaLimitada colaProtegida;
	
	public GestorColasConcurrentes(int numElementos){
		colaProtegida=new ColaLimitada(numElementos);
	}
	
	public synchronized void ponerEnCola(int elemento){		
			colaProtegida.ponerEnCola(elemento);		
	}
	
	public synchronized int sacarDeCola(){
		return colaProtegida.sacarPrimero();
	}
}
