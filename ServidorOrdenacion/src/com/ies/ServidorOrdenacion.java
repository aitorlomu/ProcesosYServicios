package com.ies;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorOrdenacion {

	public void escuchar() throws IOException{
		ServerSocket socket = null;
		try{
			socket=new ServerSocket(9876);
		}
		catch(Exception e){
			System.out.println("Exception "+e+" No se pudo arrancar");
		}
		
		while(true){
			Socket conexionCliente=	socket.accept();
			Peticion p=new Peticion(conexionCliente);
			
			Thread hiloAsociado=new Thread(p);
			hiloAsociado.start();
			
			
		}
	}
}
