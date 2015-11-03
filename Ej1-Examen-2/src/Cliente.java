

public class Cliente implements Runnable{
	Almacen 	gc;
	int numcliente;
	public Cliente(Almacen gc,int numcliente){
		this.gc		=gc;
		this.numcliente=numcliente;
	}
	public void run(){
		gc.cogerSitioPuerta(numcliente);		
	}
}