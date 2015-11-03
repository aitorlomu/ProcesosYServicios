import java.util.Random;


public class Cliente implements Runnable {

	private String numcliente;
	private int intentos;
	private boolean entrado;
	private GestorConcurrencia gc;
	
	public Cliente(GestorConcurrencia gc, String numcliente){
		this.numcliente=numcliente;
		this.intentos=10;
		this.gc=gc;
		this.entrado=false;
	}
	
	public void run(){
		Random generador=new Random();
		while(intentos>0 && entrado==false){
			entrado=gc.accederAlmacen(numcliente);
			if(entrado==false){				
				this.intentos--;
				
			}

		}
		if(intentos==0){
			System.out.println("El cliente ha desistido de intentar entrar");
		}
				
	}
	

}
