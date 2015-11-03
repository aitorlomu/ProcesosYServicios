package com.ies;

import java.util.Random;

public class Lanzador {
	
	public static void main(String[] args) {
	
		int MAX_BARBEROS	=2;
		int MAX_SILLAS		=MAX_BARBEROS+1;
		int MAX_CLIENTES	=MAX_BARBEROS*10;
		int MAX_ESPERA_SEGS	= 3;
		GestorConcurrencia gc;
		gc=new GestorConcurrencia(MAX_SILLAS);
	
		Thread[] vhBarberos	=new Thread[MAX_BARBEROS];
		for (int i=0; i<MAX_BARBEROS;i++){
			Barbero b=new Barbero(gc, "Barbero "+i);
			Thread hilo=new Thread(b);
			vhBarberos[i]=hilo;
			hilo.start();
		}
	
		/* Generamos unos cuantos clientes
		 * a intervalos aleatorios
		 */
		Random generador=new Random();
		for (int i=0; i<MAX_CLIENTES; i++){
			Cliente c			=new Cliente(gc);
			Thread hiloCliente	=new Thread(c);
			hiloCliente.start();
		
			int msegs=
					generador.nextInt(MAX_ESPERA_SEGS)*1000;
			try {
				Thread.sleep(msegs);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} /* Fin del for*/    
	}
}