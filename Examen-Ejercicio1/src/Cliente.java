import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;


public class Cliente {

	
	public static void main(String[] args) {
		
		//Cambiar datos de conexión
		String destino="localhost";
		int puertoDestino=9876;
		Socket socket=new Socket();
		InetSocketAddress direccion=new InetSocketAddress(
		destino, puertoDestino);
		try {
			socket.connect(direccion);
			
			InputStream is=socket.getInputStream();
			OutputStream os=socket.getOutputStream();
			
			//Flujos que manejan caracteres
			InputStreamReader isr=	new InputStreamReader(is);
			OutputStreamWriter osw=	new OutputStreamWriter(os);
			
			//Flujos de líneas
			BufferedReader bReader=	new BufferedReader(isr);
			PrintWriter pWriter=	new PrintWriter(osw);
			
			System.out.println("Enviando saludo");
			pWriter.println("HOLA");
			pWriter.flush();
			
			System.out.println("Enviado saludo");
			
			String bienvenida=bReader.readLine();
			int num=Integer.parseInt(bReader.readLine());
			System.out.println(bienvenida);
			
			System.out.println("El número recibido es "+num);
			int res=num*2;
			System.out.println(num+" se multiplicará por 2 y se enviará el resultado, el cual es: "+res);
			pWriter.println("CODIGO");
			pWriter.println(res+"");
			pWriter.flush();
			
			System.out.println(bReader.readLine());
			
			pWriter.close();
			bReader.close();
			isr.close();
			osw.close();
			is.close();



		
		} catch (IOException e) {
			System.out.println("No se pudo establecer la conexion o hubo un fallo al leer datos.");
		}
	}

}
