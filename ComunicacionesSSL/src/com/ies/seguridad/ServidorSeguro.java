package com.ies.seguridad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLServerSocket;

public class ServidorSeguro {
	
	int PUERTO=9876;
	String almacen,clave;
	
	public ServidorSeguro(String almacenClaves, String clave){
		this.almacen=almacenClaves;
		this.clave=clave;
	}
	
	public SSLServerSocket getSocket() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{
		SSLServerSocket socket=null;
		KeyStore almacen;
		almacen=KeyStore.getInstance(KeyStore.getDefaultType());
		FileInputStream fichero=new FileInputStream(this.almacen);
		almacen.load(fichero,  this.clave.toCharArray());
		
		KeyManager adm;
		KeyManagerFactory fabrica;		
		fabrica=KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		
		
		return socket;
	}
	
	public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{
		ServidorSeguro serv=new ServidorSeguro("C:\\Users\\ALUMNOM\\seguridad_java\\claves_servidor","123456");
		serv.getSocket();
		System.out.println("Ok");
		
	}
}
