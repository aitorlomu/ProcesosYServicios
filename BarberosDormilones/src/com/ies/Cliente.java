package com.ies;

public class Cliente implements Runnable{
	GestorConcurrencia 	gc;
	public Cliente(GestorConcurrencia gc){
		this.gc		=gc;
	}
	public void run(){
		/* Los clientes no esperan que haya
		 * sillas libres, no hay bucle infinito.
		 * Si no hay sillas libres se van...
		 */
		gc.getSillaLibre();		
	}
}