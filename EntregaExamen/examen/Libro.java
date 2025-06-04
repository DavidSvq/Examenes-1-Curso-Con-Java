package examen;

import java.util.Objects;

public class Libro implements Comparable<Libro> {

	//Atributos
	private String isbn;
	private String titulo;
	private String autor;
	private int anioPublicacion;
	
	//Constructores
	public Libro() {
		
	}
	
	public Libro(String isbn, String titulo, String autor, int anioPublicacion) {
		super();
		/*if(!isbn.contains("[^0-9]")) {
			throw new LibroNoValidoException("Error, isbn no válido.");
		}*/
		if(isbn.contains("[a-zA-Z)]")) {
			throw new LibroNoValidoException("Error, isbn no válido.");
		}
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
	}

	//Getters and Setters
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	
	//ToString
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", anioPublicacion="
				+ anioPublicacion + "]";
	}
	
	//HashCode
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}
	
	//Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}

	//CompareTo
	@Override
	public int compareTo(Libro l) {
		int resultado = this.autor.compareTo(l.getAutor());
		if(resultado == 0) {
			resultado =  l.getAnioPublicacion() - this.anioPublicacion;
		}
		return resultado;
	}
}
