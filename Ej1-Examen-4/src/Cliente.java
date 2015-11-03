

public class Cliente implements Runnable{
	Almacen 	gc;
	int numcliente;
	char puerta;
	public Cliente(Almacen gc,int numcliente,char puerta){
		this.gc		=gc;
		this.numcliente=numcliente;
		this.puerta=puerta;
	}
	public void run(){
		/* Los clientes no esperan que haya
		 * sillas libres, no hay bucle infinito.
		 * Si no hay sillas libres se van...
		 */
		while(gc.accederAlAlmacen(numcliente)==false){
			System.out.println(	"Dejando pasar a cliente "+numcliente+" en puerta "+puerta);		
		}
	}
}