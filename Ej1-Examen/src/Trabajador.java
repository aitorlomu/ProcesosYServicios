import java.util.Random;

import com.ies.GestorConcurrencia;


public class Trabajador implements Runnable{
	private Almacen 	gc;
	
	public Trabajador(Almacen gc){
		this.gc			=gc;
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
