

public class Lanzador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int MAX_CLIENTES=100;
		int MAX_PRODUCTOS=100;
		int NUM_PUERTAS=2;
		Almacen gc=new Almacen(MAX_PRODUCTOS,NUM_PUERTAS);
		
		Thread[] hclientes	=new Thread[MAX_CLIENTES];
		for (int i=0; i<MAX_CLIENTES;i++){
			Cliente b=new Cliente(gc,i);
			Thread hilo=new Thread(b);
			hclientes[i]=hilo;
			hilo.start();
		}
		
	}

}
