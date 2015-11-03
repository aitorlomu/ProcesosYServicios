
public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cifrador cif=new Cifrador();
		int clave=3;
		String original="Hola Mundo";
		String dev=cif.cifrar(original, clave);
		System.out.println("Mensaje original: "+original+" ; Mensaje cifrado: "+dev);
		dev=cif.descifrar(dev, clave);
		System.out.println("Mensaje original: "+original+" ; Mensaje descifrado: "+dev);
	}

}
