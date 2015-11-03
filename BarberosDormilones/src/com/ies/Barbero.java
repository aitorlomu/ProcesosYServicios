package com.ies;

import java.util.Random;

public class Barbero implements Runnable {
	private String 				nombre;
	private GestorConcurrencia 	gc;
	private Random				generador;
	private int					MAX_ESPERA_SEGS=5;
	public Barbero(GestorConcurrencia gc,String nombre){
		this.nombre		=nombre;
		this.gc			=gc;
		this.generador	=new Random();
	}

	public void esperarTiempoAzar(int max){
		/* Se calculan unos milisegundos al azar*/
		int msgs=(1+generador.nextInt(max))*1000;
		try {
			Thread.currentThread().sleep(msgs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run(){
		while (true){
			int num_silla=gc.atenderAlgunCliente();
			while (num_silla==-1){
				/* Mientras no haya nadie a quien 
				 * atender, dormimos
				 */
				esperarTiempoAzar(MAX_ESPERA_SEGS);
				num_silla=gc.atenderAlgunCliente();
			}
			/* Si llegamos aqui es que había algún cliente
			 * Simulamos un tiempo de afeitado
			 */
			esperarTiempoAzar(MAX_ESPERA_SEGS);
			/* Tras ese tiempo de afeitado se
			 * libera la silla
			 */
			gc.liberarSilla(num_silla);
			/* Y vuelta a empezar*/
		}
	}
}