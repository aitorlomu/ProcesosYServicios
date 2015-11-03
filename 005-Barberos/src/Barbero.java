import java.lang.Thread;
import java.lang.InterruptedException;
public class Barbero extends Thread{
	Barberia barberia;
	public Barbero(Barberia barberia){
		this.barberia=barberia;
	}
	public void run(){
		while(true){
			barberia.atenderCliente();
			try{sleep(5000);
			}catch (InterruptedException e){
				e.printStackTrace();}
			System.out.println("atendio a un cliente");
		}
	}
}