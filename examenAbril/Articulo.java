package romeroDavid;

import java.util.ArrayList;

public abstract class Articulo implements Comparable<Articulo> {

	//Atributos
	protected int id;
	protected String titulo;
	protected int precio;
	
	//Constructores
	public Articulo(String titulo, int precio) {
		id = (int) (Math.random() * 100000);
		this.titulo = titulo;
		this.precio = precio;
	}

	//Getters and setter. Id sólo get
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	//Sobreescritura compareTo
	@Override
	public int compareTo(Articulo o) {
		int resultado = this.precio - o.getPrecio();
		if (resultado == 0) {
			resultado = this.titulo.compareToIgnoreCase(o.getTitulo());
		}
		return resultado;
	}
	
	//Método abstracto
	public abstract double calcularNota();
	
	//Método static
	public static void precioMedioPorTipo(ArrayList<Articulo> list) {
		int precioMedioLibros = 0;
		int precioMedioVideoJuegos = 0;
		int sumaLibros = 0;
		int contadorLibros = 0;
		int sumaVideoJuegos = 0;
		int contadorVideoJuegos = 0;
		for (Articulo articulo : list) {
			if(articulo instanceof Libro) {
				sumaLibros += articulo.getPrecio();
				contadorLibros ++;
			}
			else if(articulo instanceof VideoJuego) {
				sumaVideoJuegos += articulo.getPrecio();
				contadorVideoJuegos ++;
				}
		}
		
		precioMedioLibros = sumaLibros/contadorLibros;
		precioMedioVideoJuegos = sumaVideoJuegos/contadorVideoJuegos;
		
		System.out.println("El precio medio de los libros es: " + precioMedioLibros);
		System.out.println("El precio medio de los video juegos es: " + precioMedioVideoJuegos);
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", titulo=" + titulo + ", precio=" + precio + "]";
	}
	
	
}
