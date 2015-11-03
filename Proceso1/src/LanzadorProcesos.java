import java.io.File;
import java.io.IOException;

public class LanzadorProcesos {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		String[] ruta={"java","ies.Sumador","1","5"};
		LanzadorProcesos lp=new LanzadorProcesos();
		lp.ejecutar(ruta);
		//ruta="java C:\\Users\\ALUMNOM\\Desktop\\WorkspacePSP\\Sumador\\bin\\Sumador 51 100";
		lp.ejecutar(ruta);
		
		
	}
	
	public void ejecutar(String[] ruta) throws IOException{
		String[] list=ruta;
		ProcessBuilder pb=new ProcessBuilder(list);
		String cadDirectorio="C:\\Users\\ALUMNOM\\Desktop\\WorkspacePSP\\Sumador\\bin";
		File directorio=new File(cadDirectorio);
		if (directorio.exists()){
			System.out.println("La ruta"+cadDirectorio+" existe");
			pb.directory(directorio);
			pb.start();
		} else {
			System.out.println("La ruta"+cadDirectorio+" no existe");
		}
			
		
	}

}
