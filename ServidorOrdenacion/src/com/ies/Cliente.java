package com.ies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {

	public static BufferedReader getFlujo(InputStream is){
		InputStreamReader isr=
		new InputStreamReader(is);
		BufferedReader bfr=
		new BufferedReader(isr);
		return bfr;
		}
	
	public static void ordenar(String s1,String s2){
		InetSocketAddress direccion=new InetSocketAddress("10.13.0.5",9876);
		Socket conexion=new Socket();
		try {
			conexion.connect(direccion);
			
			BufferedReader bfr=Cliente.getFlujo(
					conexion.getInputStream());
			PrintWriter pw=new
			PrintWriter(conexion.getOutputStream());
			pw.print(s1);
			pw.print(s2);
			pw.flush();
			String resultado=bfr.readLine();
			System.out.println("El resultado fue:"+resultado);
					
		} catch (IOException e) {
			System.out.println("1. Quizá el cortafuegos bloqueó la conexión");
			System.out.println("2. Quizá no tiene permisos para realizar la conexión");
			System.out.println("3. No se encontró el servidor");
		}
		
		//Ahora hay que crear flujos de salida, enviar cadenas por allí y esperar los resultados.
	}
	
	public static void main(String[] args) throws IOException {
		String s1="v1 hola mundo \n";
		String s2="v2 adios";
		ordenar(s1,s2);
	}
	
}
