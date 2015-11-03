package com.ies;

public class ServidorCalculo {

	public int extraerNumero(String linea){
		/* 1.Comprobar si es un número
		 * 2.Ver si el número es correcto (32a75)
		 * 3.Ver si tiene de 1 a 8 cifras
		 */
		int numero;
		try{
			numero=Integer.parseInt(linea);
		}catch(NumberFormatException e){
			numero=0;
		}
		
		if(numero>100000000){
			numero=0;
		}
		
		return numero;
	}
	public void escuchar(){
		System.out.println("Arrancado el servidor");
		
		while(true){
			
		}
	}
}
