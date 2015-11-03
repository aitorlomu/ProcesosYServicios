package com.ies;

public class GestorConcurrencia {
	/* Vector que indica cuantas sillas hay y
	 * si est�n libres o no
	 */
	boolean[] sillasLibres;
	/* Indica si el cliente sentado en esa
	 * silla est� atendido por un barbero o no
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
	 * en alg�n sitio o irse
	 * @return Devuelve el n�mero de la primera silla
	 * que est� libre o -1 si no hay ninguna 
	 */
	public synchronized int getSillaLibre(){
		for (int i=0; i<sillasLibres.length; i++){
			/* Si est� libre la silla ...*/
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
		/* Si llegamos aqu� es que no hab�a nada libre*/
		return -1;
	}

	/**
	 * Nos dice qu� silla tiene algun cliente
	 * que no est� atendido
	 * @return un n�mero de silla o -1 si no
	 * hay clientes sin atender
	 */
	public synchronized int atenderAlgunCliente_old(){
		for (int i=0; i<sillasLibres.length; i++){
			/* Si una silla est� ocupada (no libre, false)
			 * y est� marcado como "sin atender" (false)
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