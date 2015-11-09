package com.ies.ComunicacionesSeguras;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import com.ies.cifradobasico.GestorCifrado;

public final class Cliente {

	Socket conexion;
	private String ipServidor="localhost";
	private int puerto=9876;
	Cipher cifradorMensajesParaServidor;
	
	@SuppressWarnings("resource")
	public void enviarMensaje(String msg) throws NoSuchAlgorithmException, NoSuchPaddingException{
		Socket conexion; 
		GestorCifrado gestorCifrado=new GestorCifrado();
		InetSocketAddress direccion=new InetSocketAddress(ipServidor, puerto); 
		
		try {
			conexion=new Socket();
			conexion.connect(direccion);
			
			InputStream flujoLectura=conexion.getInputStream();
			OutputStream flujoEscritura=conexion.getOutputStream();
			
			PublicKey clavePublicaCliente=gestorCifrado.getPublica();
			byte[] bytesClavePublicaCliente=clavePublicaCliente.getEncoded();
			PrintWriter pw=new PrintWriter(flujoEscritura);
			
			pw.print(bytesClavePublicaCliente);
			
			
			
			flujoEscritura.write(bytesClavePublicaCliente);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main (String[]args) throws NoSuchAlgorithmException, NoSuchPaddingException{
		Cliente c=new Cliente();
		c.enviarMensaje("Hola ");
	}
}
