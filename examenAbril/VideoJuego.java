package romeroDavid;

public class VideoJuego extends Articulo {
	
	//Atributo
	private String plataforma;

	//Constrcutores
	public VideoJuego(String titulo, int precio, String plataforma) {
		super(titulo, precio);
		if(titulo.equals(null)|| this.precio < 0) {
			throw new ArticuloNoValidoException();
		}
		this.plataforma = plataforma;
	}

	public VideoJuego(String titulo, int precio) {
		super(titulo, 40);
		if(titulo.equals(null)|| this.precio < 0) {
			throw new ArticuloNoValidoException();
		}
		this.plataforma = "Sonny";
		
	}
	
	//Getters and setters
	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	//Si el titulo tiene más de 10 caracteres suma 1, si es pc o ps5 suma 2, si cuesta menos de 30 euros suma 2, menos 1 si cuesta mas de 50 euros,
	// si es contiene números suma 1.
	@Override
	public double calcularNota() {
		
		double nota = 0;
		if(titulo.length() > 10) {
			nota ++;
		}
		if (plataforma.equalsIgnoreCase("Pc") || plataforma.equalsIgnoreCase("Ps5")) {
			nota += 2;
		}
		if(precio < 30) {
			nota += 2;
		}
		else if(precio > 50) {
			nota --;
		}
		if (titulo.contains("1") ||(titulo.contains("2") || titulo.contains("3") || titulo.contains("4") || titulo.contains("5"))) {
			nota ++;
		}
		else if(titulo.contains("6") || titulo.contains("7") || titulo.contains("8") || titulo.contains("9")) {
			nota+= 2;
		}
	
		return nota;
	}
	
	public double calcularNota(boolean hacerTrampas) {
		double nota = calcularNota();
		double notaNueva = 0;
		if(!hacerTrampas) {
			notaNueva = nota;
		}
		else {
			notaNueva = nota + (nota/3);
			if(notaNueva > 10) {
				notaNueva = 10;
			}
			
		}
		return notaNueva;
	}

	@Override
	public String toString() {
		return "VideoJuego [plataforma=" + plataforma + ", getTitulo()=" + getTitulo() + ", getPrecio()=" + getPrecio()
				+ ", getId()=" + getId() + "]";
	}
	
	

}
