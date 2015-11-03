import java.util.Random;

public class Nino implements Runnable {

	int numJug1;
	int numJug2;
	GestorJuguetes gestorjuguetes;
	String nombre;
	
	public Nino(GestorJuguetes gj, int p_izq, int p_der, String nombre){
		this.numJug1=p_der;
		this.numJug2=p_izq;
		this.gestorjuguetes=gj;
		this.nombre=nombre;
	}
	
	public void run() {
		String miNombre=Thread.currentThread().getName();
		Random generador=new Random();
		while(true){
			//Jugar
			
			//Intentar coger juguetes
			while(gestorjuguetes.sePuedenCogerAmbosJuguetes(numJug1, numJug2, nombre)){
				//Juega
			}
						
			int milisegs=(1+generador.nextInt(2)*1000);
			try {
				Thread.sleep(milisegs);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			gestorjuguetes.soltarJuguetes(numJug1, numJug2, nombre);
			
			//Dormir
			milisegs=(1+generador.nextInt(2)*1000);
			try {
				Thread.sleep(milisegs);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
