
public class Protocolo {
	private final static String terminador="\n";
	
	public static String getMensaje(String cadena){
		return cadena+terminador;
	}
	
	public static int getNumAleatorio(){
		int num=(int)Math.floor(Math.random()*100);
		return num;
	}

	public static boolean compruebaCalculo(int num, int calc) {
		if((num*2)==calc){
			return true;
		}
		else{
			return false;
		}
	}
}
