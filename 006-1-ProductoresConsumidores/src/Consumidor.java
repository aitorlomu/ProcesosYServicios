import java.util.Random;


public class Consumidor implements Runnable {
	private Random generadorAzar;
	private GestorColasConcurrentes gc;
	
	public Consumidor(GestorColasConcurrentes gc){
		this.gc=gc;
		this.generadorAzar=new Random();
	}
	
	public void run(){
		while(true){
			int num=gc.sacarDeCola();
			int milisegs=generadorAzar.nextInt(2);
			try {
				Thread.currentThread().sleep(milisegs*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Consumidor interrumpido");
				return;
			}
		}
	}
}
