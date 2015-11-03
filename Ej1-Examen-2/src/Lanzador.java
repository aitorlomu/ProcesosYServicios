

import java.util.Random;

public class Lanzador {
	
	public static void main(String[] args) {
	
		int MAX_TRABAJADORES=1;
		int MAX_PUERTAS=2;
		int MAX_CLIENTES=200;
		int MAX_PRODUCTOS =100;
		int MAX_ESPERA_SEGS=1;
		Almacen gc;
		gc=new Almacen(MAX_PUERTAS,MAX_PRODUCTOS);
	
		
		Thread[] vhTrabajador	=new Thread[MAX_TRABAJADORES];
		for (int i=0; i<MAX_TRABAJADORES;i++){
			Trabajador b=new Trabajador(gc, "Trabajador "+i);
			Thread hilo=new Thread(b);
			vhTrabajador[i]=hilo;
			hilo.start();
		}
		
				
		Random generador=new Random();
		while(gc.getProductosRestantes()>0){
			
			for (int i=0; i<MAX_CLIENTES; i++){
				Cliente c			=new Cliente(gc,i);
				Thread hiloCliente	=new Thread(c);
				hiloCliente.start();
			
				int msegs=generador.nextInt(MAX_ESPERA_SEGS)*1000;
				try {
					Thread.sleep(msegs);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
		}
		
		

	
		   
	}
}