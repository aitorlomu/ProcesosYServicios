

import java.util.Random;

public class Lanzador {
	
	public static void main(String[] args) {
	
		int MAX_TRABAJADORES=1;
		int MAX_PUERTAS		=2;
		int MAX_CLIENTES	=100;
		int MAX_PRODUCTOS =100;
		int MAX_ESPERA_SEGS	= 3;
		Almacen gc;
		gc=new Almacen(MAX_PUERTAS,MAX_PRODUCTOS);
	
		
		Thread[] vhTrabajador	=new Thread[MAX_TRABAJADORES];
		for (int i=0; i<MAX_TRABAJADORES;i++){
			Trabajador b=new Trabajador(gc, "Trabajador "+i);
			Thread hilo=new Thread(b);
			vhTrabajador[i]=hilo;
			hilo.start();
		}
		
		
		
		/* Generamos unos cuantos clientes
		 * a intervalos aleatorios
		 */
		Random generador=new Random();
		
		
		for (int i=0; i<MAX_CLIENTES*2; i++){
			Cliente a=new Cliente(gc,i,'A');
			Thread hiloClienteA	=new Thread(a);
			hiloClienteA.start();
		
			int msegs=generador.nextInt(MAX_ESPERA_SEGS)*1000;
			try {
				Thread.sleep(msegs);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			Cliente b=new Cliente(gc,i,'B');
			Thread hiloClienteB	=new Thread(b);
			hiloClienteB.start();
		
			 msegs=generador.nextInt(MAX_ESPERA_SEGS)*1000;
			try {
				Thread.sleep(msegs);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		/* Fin del for*/ 
		

	
		   
	}
}