
public class LanzadorJuegos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int NUM_NINOS=3;
		
		Nino[] ninos=new Nino[NUM_NINOS];
		Thread[] hilosAsociados=new Thread[NUM_NINOS];
		GestorJuguetes gestorCompartido=new GestorJuguetes(NUM_NINOS);
		ninos[0]=new Nino(gestorCompartido,0,1,"Antonio");
		ninos[1]=new Nino(gestorCompartido,1,2,"Sara");
		ninos[2]=new Nino(gestorCompartido,2,0,"María");
		
		for(int i=0;i<NUM_NINOS;i++){

			Thread hilo=new Thread(ninos[i]);

			hilosAsociados[i]=hilo;
			hilo.start();
		}
		//No usar
		for(int i=0;i<NUM_NINOS;i++){
			try {
				hilosAsociados[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
