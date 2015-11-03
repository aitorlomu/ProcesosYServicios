import java.util.Random;


public class Productor implements Runnable{

	private Random generadorAzar;
	private GestorColasConcurrentes gc;
	
	public Productor(GestorColasConcurrentes gc){
		this.gc=gc;
		this.generadorAzar=new Random();
	}
	
	public void run(){
		while(true){
			int numero=generadorAzar.nextInt(20);
			gc.ponerEnCola(numero);
			int milisegs=generadorAzar.nextInt(2);
			try {
				Thread.currentThread().sleep(milisegs*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Productor Interrumpido");
				return;
			}
		}
	}
	
}
