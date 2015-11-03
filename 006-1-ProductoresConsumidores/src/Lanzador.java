
public class Lanzador {

	public void test(){
		
		ColaLimitada c=new ColaLimitada(5);
		if(c.sacarPrimero()!=0){
			System.out.println("Error, no se comprueba el caso cola vacía");
		}
		c.ponerEnCola(10);
		c.ponerEnCola(20);
		String cadenaCola=c.toString();
		if(!cadenaCola.equals("10-20-FIN")){
			System.out.println("Fallos al encolar");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ColaLimitada c=new ColaLimitada(5);
//		c.ponerEnCola(42);
//		c.ponerEnCola(77);
//		c.ponerEnCola(88);
//		c.ponerEnCola(103);
//		c.ponerEnCola(99);
//		int elemento=c.sacarPrimero();
//		System.out.println(c.toString());
		
		//Lanzador l=new Lanzador();
		int NUM_PRODUCTORES=5;
		int NUM_CONSUMIDORES=10;
		GestorColasConcurrentes gcl=new GestorColasConcurrentes(10);
		Productor[] productores=new Productor[NUM_PRODUCTORES];
		Thread[] hilosProductores=new Thread[NUM_PRODUCTORES];
		for(int i=0;i<NUM_PRODUCTORES;i++){
			productores[i]=new Productor(gcl);
			hilosProductores[i]=new Thread(productores[i]);
			hilosProductores[i].start();
		}
		
		Consumidor[] consumidores=new Consumidor[NUM_CONSUMIDORES];
		Thread[] hiloConsumidores=new Thread[NUM_CONSUMIDORES];
		
		for(int i=0;i<NUM_CONSUMIDORES;i++){
			consumidores[i]=new Consumidor(gcl);
			hiloConsumidores[i]=new Thread(consumidores[i]);
			hiloConsumidores[i].start();
		}
		
		for(int i=0;i<NUM_PRODUCTORES;i++){
			try {
				hilosProductores[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0;i<NUM_CONSUMIDORES;i++){
			try {
				hiloConsumidores[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
