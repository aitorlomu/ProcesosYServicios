import java.lang.InterruptedException;
public class Barberia{
	int contador;
	public Barberia(int contador){
		this.contador=contador;
	}
	public synchronized void atenderCliente(){
		if(contador==0){
			try{
				wait();
			}catch (InterruptedException e){
				e.printStackTrace();}contador++;
		}else if(contador>=1){
			notify();
		}
	}
	public synchronized void llegarCliente(){
		int copia =contador;
		if(contador==copia){
			try{
				wait();
			}catch (InterruptedException e){
				e.printStackTrace();
			}contador--;
		}
		else if(contador<copia){
			notify();
		}
	}
}