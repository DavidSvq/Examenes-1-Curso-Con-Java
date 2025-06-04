package examenJavaMarzo;

public class TransporteAereo extends Transporte {

	//Atributo
	private int candidadMotores;
	
	
	//Constructores
	public TransporteAereo() {
		
	}

	public TransporteAereo(String origen, String destino, int cantidadMotores) {
		super(origen, destino);
		this.candidadMotores = cantidadMotores;
	}

	//Getters and Setters
	public int getCandidadMotores() {
		return candidadMotores;
	}

	public void setCandidadMotores(int candidadMotores) {
		this.candidadMotores = candidadMotores;
	}
	
	//Método generar ruta de vuelo
	public String generarRutaVuelo() {
		String mensajeVuelo = " ";
		if(getOrigen().length() == getDestino().length() || getOrigen().charAt(0) == getDestino().charAt(0) || getOrigen().charAt(getOrigen().length() - 1) == getDestino().charAt(getDestino().length() - 1)) {
			mensajeVuelo = "Ruta directa de " + getOrigen() + " a " + getDestino() + ".";
		}
		else {
			mensajeVuelo = "Ruta con escala debido a diferencias en los nombres de " + getOrigen() + " y " + getDestino() + ".";
		}
		return mensajeVuelo;
	}
	
	//Método calcular tiempo viaje
	public double calcularTiempoViaje(double distancia) {
		double tiempoViaje = 0;
		tiempoViaje = distancia / 15;
		if(candidadMotores > 3) {
			tiempoViaje = (distancia / 15) * 0.9;
		}
		return tiempoViaje;
	}

	//Sobreescritura del método toString
	@Override
	public String toString() {
		return super.toString()+ "TransporteAereo [candidadMotores=" + candidadMotores + "]";
	}
	
	
}
