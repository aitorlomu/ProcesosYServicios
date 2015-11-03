import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
	public void escuchar() throws IOException{
		ServerSocket socket;
		try{
			socket=new ServerSocket(9876);
		}
		catch(Exception e){
			System.out.println("No se pudo arrancar");
			return ;
		}
		while (true){
			System.out.println("Servidor esperando");
			Socket conexionCliente=	socket.accept();
			System.out.println("Alguien conect�");
			Peticion p=	new Peticion(conexionCliente);
			Thread hiloAsociado=new Thread(p);
			hiloAsociado.start();
		}
	} // Fin del m�todo escuchar
	public static void enciendeServidor(){
		Servidor s=new Servidor();
		try {
			s.escuchar();
		} catch (Exception e){
			System.out.println("No se pudo arrancar");
			System.out.println(" el cliente o el serv");
		}
	}
}
