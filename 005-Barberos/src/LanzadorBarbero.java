import java.io.IOException;


public class LanzadorBarbero {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Barberia barberia;
		Barbero barbero;
		Cliente cliente;
		barberia=new Barberia(20);
		cliente=new Cliente(barberia);
		cliente.start();
		barbero=new Barbero(barberia);
		barbero.start();
	}
}

