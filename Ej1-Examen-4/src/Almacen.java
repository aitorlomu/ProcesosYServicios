

public class Almacen {
	/* Vector que indica cuantas sillas hay y
	 * si est�n libres o no
	 */
	boolean[] puertas;	//Para ver si en alguna puerta hay alg�n cliente esperando
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
	 * Permite obtener una coger sitio en la puerta que est� libre
	 * @return Devuelve el n�mero de la primera silla que est� libre o -1 si no hay ninguna 
	 */
	public synchronized boolean accederAlAlmacen(int numcliente){
		boolean entra=false;
		for (int i=0; i<puertas.length; i++){
			/* Si est� libre la puerta ...*/
			if (puertas[i]) {
				/* ...se marca como ocupada*/
				puertas[i]=false;
				System.out.println("Cliente "+numcliente+" esperando en puerta "+i);
				/*.. y devolvemos i...*/
				entra=true;
			}
		}
		/* Si llegamos aqu� es que no hab�a nada libre*/
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
		System.out.println(	"Se marcha el cliente que hab�a entrado por la puerta "+i);
	}
	
	public void comprarProducto(){
		this.productos--;
	}
	public int getProductosRestantes(){
		return productos;
	}
}