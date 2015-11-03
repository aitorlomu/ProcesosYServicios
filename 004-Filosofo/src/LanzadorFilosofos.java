
public class LanzadorFilosofos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int MAX_FILOSOFOS=5;
		Filosofo[] filosofos=new Filosofo[MAX_FILOSOFOS];
		Thread[] hilosAsociados=new Thread[MAX_FILOSOFOS];
		GestorPalillos gestorCompartido=new GestorPalillos(MAX_FILOSOFOS);
		for(int i=0;i<MAX_FILOSOFOS;i++){
			if(i==0){
				filosofos[i]=new Filosofo(gestorCompartido,i,MAX_FILOSOFOS-1);
			}
			else{
				filosofos[i]=new Filosofo(gestorCompartido,i,i-1);
			}			
			Thread hilo=new Thread(filosofos[i]);
			hilo.setName("Filosofo "+i);
			hilosAsociados[i]=hilo;
			hilo.start();
		}
		//No usar
		for(int i=0;i<MAX_FILOSOFOS;i++){
			try {
				hilosAsociados[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
