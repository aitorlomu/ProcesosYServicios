package ies;

import java.io.File;

public class Lanzador {
    public void lanzarSumador(Integer n1,
                    Integer n2, String ruta){
            String rutaDir="C:\\Users\\ALUMNOM\\Desktop\\WorkspacePSP\\Sumador\\bin";
            File dir=new File(rutaDir);
            ProcessBuilder pb;
            try {
                    pb = new ProcessBuilder(
                                    "java","ies.Sumador",
                                    n1.toString(),
                                    n2.toString());
                    pb.directory(dir);
                    pb.redirectError(new File("error.txt"));
                    pb.redirectOutput(new File(ruta));
                    pb.start();
                    
            } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
    }
    public static void main(String[] args){
            Lanzador l=new Lanzador();
            l.lanzarSumador(1, 51, "resul1.txt");
            l.lanzarSumador(51, 100,"resul2.txt");
            System.out.println("Ok");
    }
}