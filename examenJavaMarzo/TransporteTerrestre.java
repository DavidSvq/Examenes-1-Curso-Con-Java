package examenJavaMarzo;

public class TransporteTerrestre extends Transporte {
	
	//Atributo
	private String matricula;

	//Constructores
	public TransporteTerrestre() {
		super();
	}

	public TransporteTerrestre(String origen, String destino, String matricula) {
		super(origen, destino);
		
		if (introducirMatricula(matricula)) {
			this.matricula = matricula;
		}
	}
	
	//Getters
	public String getMatricula() {
		return matricula;
	}
	
	//Método introducir matrícula
	public boolean introducirMatricula(String matric){
		boolean matVerificada = false;
		if(comprobarMatricula(matric)) {
			this.matricula = matric;
			matVerificada = true;
		}
		else {
			this.matricula = "XXXXYYY";
			matVerificada = false;
		}
		return matVerificada;
	}
	
	//Comprobar matricula
	public static boolean comprobarMatricula(String matric) {
		boolean matCorrecta = false;
		matric = matric.toLowerCase();
		if (matric.length() == 7) {
			if(matric.charAt(0) > '0' && matric.charAt(0) < '9') {
				if(matric.charAt(1) > '0' && matric.charAt(1) < '9') {	
					if(matric.charAt(2) > '0' && matric.charAt(2) < '9') {
						if (matric.charAt(3) > '0' && matric.charAt(3) < '9') {
							if(matric.charAt(4) > 'a' && matric.charAt(4) < 'z') {
								if(matric.charAt(5) > 'a' && matric.charAt(5) < 'z') {
									if(matric.charAt(6) > 'a' && matric.charAt(6) < 'z') {
										matCorrecta = true;
									}
								}
							}
						}
					}
				}
			}
			matCorrecta = true;
		}
		else {
			matCorrecta = false;
		}
		return matCorrecta;
	}
	
	// Método calcular tiempo viaje solo con la distancia
	public double calcularTiempoViaje(double distancia) {
		double tiempoDeViaje = 0;
		int contador7 = 0;
		int contador8 = 0;
		tiempoDeViaje = distancia * 1.34;
		for(int i = 0; i < 4; i++) {
			if(this.matricula.charAt(i) == '7') {
				contador7 ++;
			}
			if(this.matricula.charAt(i) == '8') {
				contador8 ++;
			}
		}		
		if(contador7 == 2 || contador8 == 2) {
			tiempoDeViaje = (distancia * 1.34) * 0.8;
		}
		return tiempoDeViaje;
		
	}
	
	//Método calcular tiempo viaje con distancia y velocidad
	public double calcularTiempoViaje(double distancia, double velocidad) {
		double tiempoDeViaje = 0;
		tiempoDeViaje = distancia * velocidad;
		return tiempoDeViaje;
	}
	
	//Métod calcular tiempo de viaje de 50 km
	public double calcularTiempoViaje() {
		double tiempoDeViaje = 0;
		int contador7 = 0;
		int contador8 = 0;
		tiempoDeViaje = 50 * 1.34;
		for(int i = 0; i < 4; i++) {
			if(this.matricula.charAt(i) == '7') {
				contador7 ++;
			}
			if(this.matricula.charAt(i) == '8') {
				contador8 ++;
			}
		}		
		if(contador7 == 2 || contador8 == 2) {
			tiempoDeViaje = (50 * 1.34) * 0.8;
		}
		return tiempoDeViaje;
	}
	
	//Sobreescritura del método toString
	@Override
	public String toString() {
		return super.toString() + "\nTransporteTerrestre [Matricula: " + matricula +"]";
	}
	
	
	
}
