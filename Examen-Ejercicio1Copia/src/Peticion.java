import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Peticion 	implements Runnable {
	Socket conexionParaAtender;
	public Peticion ( Socket s ){
		this.conexionParaAtender=s;
	}

	public void run() {
		try{
			PrintWriter flujoEscritura=	Utilidades.getFlujoEscritura(this.conexionParaAtender);
			BufferedReader flujoLectura=Utilidades.getFlujoLectura(conexionParaAtender);
			int num=Protocolo.getNumAleatorio();
			
			String saludo=	Protocolo.getMensaje(flujoLectura.readLine());
			if (saludo.equals("HOLA")){			
				flujoEscritura.println("BIENVENIDO");
				
				System.out.println("Generado "+num);
				flujoEscritura.println(num);
				flujoEscritura.flush();

			}

			String codigo=Protocolo.getMensaje(flujoLectura.readLine());
			if (saludo.equals("CODIGO")){
				int calc=Integer.parseInt(flujoLectura.readLine());
				System.out.println("Recibido "+calc);
				if(Protocolo.compruebaCalculo(num,calc)){
					flujoEscritura.println("Enhorabuena usuario "+num+". Te has validado y has conseguido hacer bien este ejercicio");
					flujoEscritura.flush();
				}

				

			}
		}
		catch (IOException e){
			System.out.println(	"No se pudo crear algún flujo");
			return ;
		}
	}
}
