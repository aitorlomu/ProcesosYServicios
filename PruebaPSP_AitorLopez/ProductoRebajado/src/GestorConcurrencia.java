import java.util.Random;


public class GestorConcurrencia {

	private boolean ocupado;
	private int pilaProductos;
	public GestorConcurrencia(int pilaProductos){
		this.ocupado=false;
		this.pilaProductos=pilaProductos;
		
	}

	public synchronized boolean accederAlmacen(String numcliente){
		boolean consigueAcceder=false;
		if(pilaProductos>0 && ocupado==false){
			ocupado=true;
			consigueAcceder=true;
			System.out.println(numcliente+" accedió al almacén");
			pilaProductos--;			
			System.out.println(numcliente+ " Ha comprado un producto de la pila. Quedan "+pilaProductos+" restantes");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			salirCliente(numcliente);			
		}
		else{
			if(ocupado==true){
				System.out.println("El "+numcliente+" no ha podido acceder porque el almacén está lleno de clientes");
			}
			else{
				if(pilaProductos==0){
					consigueAcceder=true;
					System.out.println("Ya no quedan productos en la pila");
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			salirCliente(numcliente);
		}
		return consigueAcceder;
	}
	
	public void salirCliente(String numcliente){
		this.ocupado=false;
		System.out.println(	"Se marcha el "+numcliente);
	}
	
}
