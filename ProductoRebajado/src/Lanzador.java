

public class Lanzador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int MAX_CLIENTES=300;
		int MAX_PRODUCTOS=100;
		GestorConcurrencia gc;
		gc=new GestorConcurrencia(MAX_PRODUCTOS);
		
		Thread[] hclientes	=new Thread[MAX_CLIENTES];
		for (int i=0; i<MAX_CLIENTES;i++){
			Cliente b=new Cliente(gc, "Cliente "+i);
			Thread hilo=new Thread(b);
			hclientes[i]=hilo;
			hilo.start();
		}
		
	}

}
