import java.util.Random;

class Contador{
	int cuenta;
	public Contador(){
		this.cuenta=0;
	}
	public synchronized void incrementar(){
		this.cuenta++;
	}
	public synchronized int getCuenta(){
		return cuenta;
	}
	
}

class TareaCompleja implements Runnable{
	Contador contador;
	public TareaCompleja(Contador contador){
		this.contador=contador;
	}
	public void run() {
		Random generador=new Random();
		int numAzar=(1+generador.nextInt(5))*100;
		for(int i=0;i<numAzar;i++){
			int a=1*3;
			contador.incrementar();
		}
		Thread hiloActual=Thread.currentThread();
		String miNombre=hiloActual.getName();
		System.out.println("Finalizando el hilo "+miNombre);
		int cuentaTotal=contador.getCuenta();
		System.out.println("Ops hechas: "+cuentaTotal);
		
	}
	
}
public class LanzadorHilos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int NUM_HILOS=100;
		Thread[] hilosAsociados;
		Contador contador=new Contador();
		hilosAsociados=new Thread [NUM_HILOS];
		for(int i=0;i<NUM_HILOS;i++){
			TareaCompleja t=new TareaCompleja(contador);
			Thread hilo=new Thread(t);
			hilo.setName("Hilo: "+i);
			hilo.start();
			hilosAsociados[i]=hilo;
		}
		
		for(int i=0;i<NUM_HILOS;i++){
			Thread hilo=hilosAsociados[i];
			try {
				//Espera a que el hilo acabe
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Algún hilo acabó antes de tiempo "+e);
			}
		}
		
		
		
	}

}
