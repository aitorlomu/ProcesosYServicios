package com.ies;

public class GestorConcurrencia {
	/* Vector que indica cuantas sillas hay y
	 * si están libres o no
	 */
	boolean[] sillasLibres;
	/* Indica si el cliente sentado en esa
	 * silla está atendido por un barbero o no
	 */
	boolean[] clienteEstaAtendido;
	int numUltimaSillaExaminada;

	public GestorConcurrencia(int numSillas){
		/*Construimos los vectores...*/
		sillasLibres		=new boolean[numSillas];
		clienteEstaAtendido	=new boolean[numSillas];
		/* ... los inicializamos*/
		for (int i=0; i<numSillas;i++){
			sillasLibres[i]			=true;
			clienteEstaAtendido[i]	=false;
		}
	}

	/**
	 * Permite obtener una silla libre, usado por la
	 * clase Cliente para saber si puede sentarse
	 * en algún sitio o irse
	 * @return Devuelve el número de la primera silla
	 * que está libre o -1 si no hay ninguna 
	 */
	public synchronized int getSillaLibre(){
		for (int i=0; i<sillasLibres.length; i++){
			/* Si está libre la silla ...*/
			if (sillasLibres[i]) {
				/* ...se marca como ocupada*/
				sillasLibres[i]=false;
				System.out.println(
					"Cliente sentado en silla "+i
						);
				/*.. y devolvemos i...*/
				return i;
			}
		}
		/* Si llegamos aquí es que no había nada libre*/
		return -1;
	}

	/**
	 * Nos dice qué silla tiene algun cliente
	 * que no está atendido
	 * @return un número de silla o -1 si no
	 * hay clientes sin atender
	 */
	public synchronized int atenderAlgunCliente_old(){
		for (int i=0; i<sillasLibres.length; i++){
			/* Si una silla está ocupada (no libre, false)
			 * y está marcado como "sin atender" (false)
			 * entonces la marcamos como atendida
			 */
			if (clienteEstaAtendido[i]==false){
				clienteEstaAtendido[i]=true;
				System.out.println(
						"Afeitando cliente en silla "+i);
				return i;
			}
		}
		return -1;
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

	/* El cliente de esa silla, se marcha, por lo
	 * que se marca esa silla como "libre" 
	 * y como "sin atender"
	 */
	public synchronized void liberarSilla(int i){
		sillasLibres[i]			=true;
		clienteEstaAtendido[i]	=false;
		System.out.println(
				"Se marcha el cliente de la silla "+i);
	}
}