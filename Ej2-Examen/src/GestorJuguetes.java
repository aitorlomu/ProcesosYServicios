
public class GestorJuguetes {

private boolean[] juguetes;
private String[] nomJuguetes={"Elmo","Gustavo","Dora la exploradora"};

	
	public GestorJuguetes(int num_ninos){
		juguetes= new boolean[num_ninos];
		
		for(int i=0;i<juguetes.length;i++){
			juguetes[i]=false;
			
		}
		
	}
	
	public synchronized boolean sePuedenCogerAmbosJuguetes(int num1, int num2, String nombre){	
		
		if((juguetes[num1]==false) && (juguetes[num2]==false)){
			juguetes[num1]=true;
			juguetes[num2]=true;
			System.out.println(nombre+" cogió los juguetes "+nomJuguetes[num1] +" y "+nomJuguetes[num2]);
			return true;
		}
		else{
			return false;
		}
	}

	public synchronized void soltarJuguetes(int num1, int num2, String nombre){
		if((juguetes[num1]==true) && (juguetes[num2]==true)){
			juguetes[num1]=false;
			juguetes[num2]=false;	
			System.out.println(nombre+ " soltó los jueguetes "+nomJuguetes[num1] +" y "+nomJuguetes[num2]);
		}
	}
}
