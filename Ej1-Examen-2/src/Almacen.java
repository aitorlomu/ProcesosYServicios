

public class Almacen {

	boolean[] puertas;	//Para ver si en alguna puerta hay algún cliente esperando
	boolean[] clienteEstaAtendido;
	int numUltimaPuertaExaminada;
	int productos;

	public Almacen(int numPuertas, int numProductos){
		/*Construimos los vectores...*/
		puertas		=new boolean[numPuertas];
		clienteEstaAtendido	=new boolean[numPuertas];
		this.productos=numProductos;
		/* ... los inicializamos*/
		for (int i=0; i<numPuertas;i++){
			puertas[i]			=true;
			clienteEstaAtendido[i]	=false;
		}
	}

	public void comprarProducto(){
		this.productos--;
	}
	public int getProductosRestantes(){
		return productos;
	}
	
	public char nombrePuerta(int i){
		if(i==0){return 'A';}
		else{return 'B';}
	}
	
		
	public synchronized int atenderAlgunCliente(){
		
		for(int i=0;i<clienteEstaAtendido.length;i++){
			
			if(numUltimaPuertaExaminada==0){
				numUltimaPuertaExaminada=1;
				return numUltimaPuertaExaminada;
			}
			else{
				numUltimaPuertaExaminada=0;
				return numUltimaPuertaExaminada;
			}		
		}	
		return -1;
	}

	public synchronized void liberarAlmacen(int i){
		puertas[i]			=true;
		clienteEstaAtendido[i]	=false;
		System.out.println(	"Se marcha el cliente que había entrado por la puerta "+nombrePuerta(i));
	}
	
	public synchronized int cogerSitioPuerta(int numcliente){
		int puertaCogida=-1;
		for (int i=0; i<puertas.length; i++){
			if (puertas[i]) 
			{
				puertas[i]=false;
				System.out.println("Cliente "+numcliente+" esperando en puerta "+nombrePuerta(i));
				puertaCogida= i;
			}
		}
		return puertaCogida;
	}
	

}