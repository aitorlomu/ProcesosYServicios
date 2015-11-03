import java.util.Random;
public class Filosofo implements Runnable{
	int num_palillo_izq;
	int num_palillo_der;
	GestorPalillos gestorPalillos;
	public Filosofo(GestorPalillos gp,
			int p_izq, int p_der){
		this.gestorPalillos=gp;
		this.num_palillo_der=p_der;
		this.num_palillo_izq=p_izq;
	}
	public void run(){
		String miNombre=Thread.currentThread().getName();
		Random generador=new Random();
		while (true){
			/* Comer*/
			/* Intentar coger palillos*/
			while(!gestorPalillos.sePuedenCogerAmbosPalillos
					(
							num_palillo_izq, num_palillo_der
							))
			{
			}
			/* Si los coge:*/
			int milisegs=(1+generador.nextInt(5))*1000;
			esperarTiempoAzar(miNombre, milisegs);
			/* Pensando...*/
			//Recordemos soltar los palillos
			gestorPalillos.soltarPalillos(num_palillo_izq, num_palillo_der);
			milisegs=(1+generador.nextInt(5))*1000;
			esperarTiempoAzar(miNombre, milisegs);
		}
	}
	private void esperarTiempoAzar(String miNombre, int milisegs) {
		try {
			Thread.sleep(milisegs);
		} catch (InterruptedException e) {
			System.out.println(
					miNombre+" interrumpido!!. Saliendo...");
			return ;
		}
	}
}
