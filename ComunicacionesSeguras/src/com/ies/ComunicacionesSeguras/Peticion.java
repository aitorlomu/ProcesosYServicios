package com.ies.ComunicacionesSeguras;

import java.net.Socket;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import com.ies.cifradobasico.GestorCifrado;

public class Peticion implements Runnable {
	GestorCifrado gestorCifrado;
	Socket conexion;
	
	public Peticion (Socket s) throws NoSuchAlgorithmException, NoSuchPaddingException{
		this.conexion=s;
		gestorCifrado=new GestorCifrado();
	}
	
	public void run(){
		System.out.println("Llego una conexion");
		
		
	}

}
