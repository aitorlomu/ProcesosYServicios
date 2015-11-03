
public class Cifrador {

	public String cifrar (String mensaje, int clave){
		mensaje=mensaje.toUpperCase();
		char[] msj=mensaje.toCharArray();
		String mensajecifrado="";
		for(int i=0;i<mensaje.length();i++){
			mensajecifrado+=(char)(msj[i]+clave);		
		}
		
		System.out.println(mensajecifrado);
		return mensajecifrado;
	}
	
	public String descifrar(String mensaje, int clave){
		String mensajedescifrado="";
		char[] msj=mensaje.toCharArray();
		for(int i=0;i<mensaje.length();i++){
			mensajedescifrado+=(char)(msj[i]-clave);		
		}
		
		return mensajedescifrado;
	}
}
