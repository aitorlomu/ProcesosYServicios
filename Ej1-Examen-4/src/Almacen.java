

public class Almacen {
	/* Vector que indica cuantas sillas hay y
	 * si están libres o no
	 */
	boolean[] puertas;	//Para ver si en alguna puerta hay algún cliente esperando
	boolean almacenOcupado;
	int numUltimaPuertaExaminada;
	int productos;

	public Almacen(int numPuertas, int numProductos){
		/*Construimos los vectores...*/
		puertas		=new boolean[numPuertas];
		almacenOcupado=false;
		this.productos=numProductos;
		/* ... los inicializamos*/
		for (int i=0; i<numPuertas;i++){
			puertas[i]			=true;
		}
	}

	/**
	 * Permite obtener una coger sitio en la puerta que esté libre
	 * @return Devuelve el número de la primera silla que está libre o -1 si no hay ninguna 
	 */
	public synchronized boolean accederAlAlmacen(int numcliente){
		boolean entra=false;
		for (int i=0; i<puertas.length; i++){
			/* Si está libre la puerta ...*/
			if (puertas[i]) {
				/* ...se marca como ocupada*/
				puertas[i]=false;
				System.out.println("Cliente "+numcliente+" esperando en puerta "+i);
				/*.. y devolvemos i...*/
				entra=true;
			}
		}
		/* Si llegamos aquí es que no había nada libre*/
		return entra;
	}

	
	public synchronized int atenderAlgunCliente(){
		
		if(almacenOcupado==false){
			
		}
		for(int i=0;i<clienteEstaAtendido.length;i++){
			
			if(numUltimaPuertaExaminada==0){
				numUltimaPuertaExaminada=1;
				return numUltimaPuertaExaminada;
			}
			else{
				numUltimaPuertaExaminada=0;
				return numUltimaPuertaExaminada;
			}
			
//			if(clienteEstaAtendido[numUltimaPuertaExaminada]==false)
//			{
//				clienteEstaAtendido[numUltimaPuertaExaminada]=true;
//				return numUltimaPuertaExaminada;
//			}
//			else{
//				//Mirar en las sillas siguientes
//				numUltimaPuertaExaminada=(numUltimaPuertaExaminada+1)%clienteEstaAtendido.length;
//				return numUltimaPuertaExaminada;
//			}			
		}	
		return -1;
	}

	/* El cliente de esa silla, se marcha, por lo
	 * que se marca esa silla como "libre" 
	 * y como "sin atender"
	 */
	public synchronized void liberarAlmacen(int i){
		puertas[i]			=true;
		clienteEstaAtendido[i]	=false;
		System.out.println(	"Se marcha el cliente que había entrado por la puerta "+i);
	}
	
	public void comprarProducto(){
		this.productos--;
	}
	public int getProductosRestantes(){
		return productos;
	}
}