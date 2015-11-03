import java.lang.Thread;
import java.lang.InterruptedException;


public class Cliente extends Thread{
	Barberia barberia;
	public Cliente(Barberia barberia){
		this.barberia=barberia;
	}
	public void run(){
			while(true){
				barberia.llegarCliente();
				System.out.println("llegó un cliente");
			}
	}
}