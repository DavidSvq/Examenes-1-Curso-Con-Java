package examen;

@SuppressWarnings("serial")
public class LibroNoValidoException extends IllegalArgumentException {

	public LibroNoValidoException(String mensaje) {
		super(mensaje);
	}
	
}
