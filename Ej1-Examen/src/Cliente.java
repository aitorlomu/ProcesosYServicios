import java.util.Random;


public class Cliente implements Runnable {

	int numcliente;
	private Almacen gc;
	
	public Cliente(Almacen gc, int numcliente){
		this.numcliente=numcliente;
		this.gc=gc;
	}
	
	public void run(){
		Random generador=new Random();
		gc.cogerSitioEnPuerta(numcliente);
	}
				
}
	


