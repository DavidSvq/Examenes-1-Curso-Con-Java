package examenJavaMarzo;

public class Transporte {
	//Atributos
	private String origen;
	private String destino;
	
	//Constructores
	public Transporte() {
		origen = " ";
		destino = " ";
	}

	public Transporte(String origen, String destino) {
		this.origen = origen;
		this.destino = destino;
	}
	
	//Getters
	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}
	
	//Método introducir viaje
	public boolean introducirViaje(String ori, String dest) {
		boolean viaje = false;
		if (ori.equalsIgnoreCase(dest)) {
			viaje = false;
		}
		else {
			this.origen = ori;
			this.destino = dest;
			viaje = true;
		}
		return viaje;
	}
	
	//Método calcular tiempo de viaje
	public double calcularTiempoViaje() {
		return 0;
	}
	
	//Sobreescritura del método toString
	@Override
	public String toString() {
		return "Transporte [Origen: " + origen + "\t Destino: " + destino + "]";
	}
	
	
	
}
