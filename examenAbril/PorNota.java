package romeroDavid;

import java.util.Comparator;

public class PorNota implements Comparator<Articulo> {

	public PorNota() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Articulo o1, Articulo o2) {
		int nota1 = (int)  o1.calcularNota();
		int nota2 = (int)  o2.calcularNota();
		return nota1 - nota2;
	}

}
