
public class Lanzador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Servidor sv= new Servidor();
		sv.enciendeServidor();
		for(int i=0;i<10;i++){
			Cliente cl= new Cliente();
			cl.arrancaCliente();
		}

	}

}
