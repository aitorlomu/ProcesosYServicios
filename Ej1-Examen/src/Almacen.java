import java.util.Random;


public class Almacen {

	private boolean [] puertas;
	private boolean ocupado;
	private int pilaProductos;
	int ultimaPuertaAtendida;
	
	public Almacen(int pilaProductos, int numPuertas){
		this.ocupado=false;
		this.pilaProductos=pilaProductos;
		this.puertas=new boolean [numPuertas];
		for(int i=0;i<numPuertas;i++){
			if(i==0){
				this.puertas[i]=true;
				//true es atendible la puerta/}
			}
			

			else {
				this.puertas[i]=false;
				}
			}
		
		
	}

	public synchronized void cogerSitioEnPuerta(int numCliente){
		for (int i=0; i<puertas.length; i++){
			/* Si está libre la puerta ...*/
			if (puertas[i]) {
				/* ...se marca como ocupada*/
				puertas[i]=false;
				System.out.println("Cliente "+numCliente+" esperando en la puerta "+i);
				/*.. y devolvemos i...*/
			}
		}
	}
	
	public synchronized int atenderAlgunCliente(){
		
		for(int pasos=0;pasos<clienteEstaAtendido.length;pasos++){
			
		
			if(clienteEstaAtendido[numUltimaSillaExaminada]==false)
			{
				clienteEstaAtendido[numUltimaSillaExaminada]=true;
				return numUltimaSillaExaminada;
			}
			else{
				//Mirar en las sillas siguientes
				numUltimaSillaExaminada=(numUltimaSillaExaminada+1)%clienteEstaAtendido.length;
				
			}			
		}	
		return -1;
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
		return consigueAcceder;
	}
	
	public void salirCliente(String numcliente){
		this.ocupado=false;
		puertas[ultimaPuertaAtendida]=true;
		System.out.println(	"Se marcha el "+numcliente+". La puerta "+ultimaPuertaAtendida+" está libre");
	}

	
}
