import java.util.*;
class ColaStrings {
	private ArrayList lista = new ArrayList();
	public synchronized void push(final String p) {
		lista.add(p);
		this.notify(); // hace saber que ha llegado un String
	}
	public synchronized String pop() {
		while (lista.size() == 0) try {
			this.wait(); // espera la llegada de un String
		} catch (final InterruptedException e) { }
		return (String) lista.remove(0);
	}
}