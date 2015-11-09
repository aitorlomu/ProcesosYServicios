package com.ies.ComunicacionesSeguras;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;



public class Servidor {
	ServerSocket socketServidor;	
	private final int PUERTO=9876;
	
	
	public void escuchar() throws IOException{
		
		socketServidor=new ServerSocket(PUERTO);
		
		try {
			while(true){		
				
				Socket conexion=socketServidor.accept();
				Peticion p=new Peticion(conexion);
				Thread hiloAsociado=new Thread(p);
				hiloAsociado.start();
				
			}
		} catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			
			e.printStackTrace();//Imprime la pila de llamadas
		}
	}
	
	public static void main(String[] args) throws IOException{
		Servidor s=new Servidor();
		s.escuchar();
		
	}
}
