import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Peticion 	implements Runnable {
	private final static String terminador="\n";
	Socket conexionParaAtender;
	public Peticion ( Socket s ){
		this.conexionParaAtender=s;
	}

	public void run() {
		try{			
			PrintWriter flujoEscritura=	Utilidades.getFlujoEscritura(this.conexionParaAtender);
			BufferedReader flujoLectura=Utilidades.getFlujoLectura(conexionParaAtender);
			int num=Protocolo.getNumAleatorio();
			System.out.println("generado "+num);
			String saludo=	Protocolo.getMensaje(flujoLectura.readLine());
			System.out.println("Recibido -> "+saludo);
			
			if (saludo.equals("HOLA")){		
				
				//System.out.println("Enviando -> BIENVENIDO");
				//System.out.println("Enviando número generado -> "+num);
				
				flujoEscritura.write("BIENVENIDO"+terminador);		
				flujoEscritura.flush();
				flujoEscritura.write(num+terminador);
				flujoEscritura.flush();

				String codigo=Protocolo.getMensaje(flujoLectura.readLine());
				
				if (saludo.equals("CODIGO")){
					int calc=Integer.parseInt(flujoLectura.readLine());
					System.out.println("Recibido "+calc);
					if(Protocolo.compruebaCalculo(num,calc)){
						flujoEscritura.write("Enhorabuena usuario "+num+". Te has validado y has conseguido hacer bien este ejercicio"+terminador);
						flujoEscritura.flush();
					}

					

				}
			}
			flujoEscritura.close();
			flujoLectura.close();

			
		}
		catch (IOException e){
			System.out.println(	"No se pudo crear algún flujo");
			return ;
		}
	}
}
