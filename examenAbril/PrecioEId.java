package romeroDavid;

import java.util.Comparator;

public class PrecioEId implements Comparator<Articulo> {

	public PrecioEId() {
	}

	@Override
	public int compare(Articulo o1, Articulo o2) {
		int resultado = o1.getPrecio() - o2.getPrecio();
		if(resultado == 0) {
			resultado = o2.getId() - o1.getId();
		}
		return resultado;
	}

}
