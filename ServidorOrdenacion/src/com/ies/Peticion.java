package com.ies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Peticion implements Runnable{

	Socket conexionParaAtender;
	
	Peticion(Socket s){
		this.conexionParaAtender=s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		InputStream is;
		try {
			is = conexionParaAtender.getInputStream();
			InputStreamReader isr=
			new InputStreamReader(is);
			BufferedReader bf=
			new BufferedReader(isr);
			String l1=bf.readLine();
			String l2=bf.readLine();
			/* Calculamos el resultado*/
			
			String[] result=this.ordernar(l1, l2);
			
			OutputStream os=conexionParaAtender.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			pw.write(result.toString()+"\n");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String[] ordernar(String l1, String l2){
		String[] ordenada=new String[2];
		if(l1.charAt(1)=='1'){
			ordenada[0]=l1;
			ordenada[1]=l2;
			return ordenada;
		}
		else{
			ordenada[0]=l2;
			ordenada[1]=l1;
			return ordenada;
		}
		
	}



}
