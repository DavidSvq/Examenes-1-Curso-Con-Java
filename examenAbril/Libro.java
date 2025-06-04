package romeroDavid;

import java.util.ArrayList;
import java.util.Collections;

public class Libro extends Articulo {
	//Atributos
	private String isbn;
	
	//Cosntructor
	public Libro(String titulo, int precio, String isbn) {
		super(titulo, precio);
		if(isbn.length() != 13) {
			throw new ArticuloNoValidoException("Error, ISBN incorrecto.");
		}
		this.isbn = isbn;
	}

	//Getters and setters
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public double calcularNota() {
		double nota = 0;
		int contador = 10;
		int contadorAux = 0;
		double suma = 0;
		double puntuacionBaja = 10;
		double puntuacionAlta = -1;
		ArrayList<Double> notas = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			notas.add(Math.random() * 10);
		}
		for (Double double1 : notas) {
			System.out.println(double1);
			if(double1 < puntuacionBaja) {
				puntuacionBaja = double1;
			}
			if(double1 > puntuacionAlta) {
				puntuacionAlta = double1;
			}
			
		}
		Collections.sort(notas);
		notas.remove(0);
		notas.remove(9);
		for (Double double1 : notas) {
			suma += double1;
			if(double1 < 5) {
				contadorAux ++;
			}
		}
		nota = suma/8;
		if(contadorAux > 3) {
			nota --;
		}
		nota = Math.round(nota);
		
		return nota;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", getTitulo()=" + getTitulo() + ", getPrecio()=" + getPrecio() + ", getId()="
				+ getId() + "]";
	}
	
}
