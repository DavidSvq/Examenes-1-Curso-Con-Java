package romeroDavid;

import java.util.Comparator;

public class TipoYTitulo implements Comparator<Articulo> {

	public TipoYTitulo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Articulo o1, Articulo o2) {
		int resultado = o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
		if(resultado == 0) {
			resultado = o1.getTitulo().compareTo(o2.getTitulo());
		}
		return resultado;
	}

}
