

import java.util.Random;

public class Trabajador implements Runnable {
	
	private Almacen gc;
	private Random generador;
	private int MAX_ESPERA_SEGS=5;
	
	public Trabajador(Almacen gc,String nombre){
		this.gc=gc;
		this.generador=new Random();
	}

	public void run(){
		while (true){
			int numPuerta=gc.atenderAlgunCliente();
			
			while (numPuerta==-1){
				//Si no hay ning�n cliente
				esperarTiempoAzar(MAX_ESPERA_SEGS);
				numPuerta=gc.atenderAlgunCliente();
				//System.out.println(numPuerta);//TRAZA

			}			
			
			System.out.println(	"Dejando pasar a cliente en puerta "+gc.nombrePuerta(numPuerta));
			
			if(gc.getProductosRestantes()>0){
				gc.comprarProducto();
				System.out.println("Cliente compra un producto rebajado. Quedan "+gc.getProductosRestantes()+ " productos");
			}
			else{
				System.out.println("No quedan productos disponibles");
			}
			
			esperarTiempoAzar(MAX_ESPERA_SEGS);
			gc.liberarAlmacen(numPuerta);
		}
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
}