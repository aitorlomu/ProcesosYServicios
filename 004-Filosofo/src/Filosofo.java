import java.util.Random;


public class Filosofo implements Runnable{

	int num_palillo_izq;
	int num_palillo_der;
	GestorPalillos gestorPalillos;
	
	public Filosofo(GestorPalillos gp, int p_izq, int p_der){
		this.num_palillo_der=p_der;
		this.num_palillo_izq=p_izq;
		this.gestorPalillos=gp;
	}
	
	public void run() {
		String miNombre=Thread.currentThread().getName();
		Random generador=new Random();
		while(true){
			//Comer
			
			//Intentar coger palillos
			while(gestorPalillos.sePuedenCogerAmbosPalillos(num_palillo_izq, num_palillo_der)){
				//Si los coge
				//System.out.println(miNombre+"comiendo...");
			}
			
			
			
			int milisegs=(1+generador.nextInt(5)*1000);
			try {
				Thread.sleep(milisegs);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//Recordar que hay que soltar los palillos
			gestorPalillos.soltarPalillos(num_palillo_izq, num_palillo_der);
			
			//Pensando
			//System.out.println("Filósofo pensando");
			milisegs=(1+generador.nextInt(5)*1000);
			try {
				Thread.sleep(milisegs);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

