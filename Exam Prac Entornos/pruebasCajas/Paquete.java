package pruebasCajas;

public class Paquete {
	/*ATRIBUTOS*/
	private double costeEnvio=0;
	
	private int altura = -1;
	private int anchura = -1;
	private int grosor = -1;
	private double volumen = -1;
	private boolean fragil= false;
	
	/*CONSTRUCTORES*/
	public Paquete(int altura, int anchura, int grosor){
		this.altura=altura;
		this.anchura=anchura;
		this.grosor=grosor;
	}
	
	public Paquete(){
	}
	
	/*GET AND SET*/
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getAnchura() {
		return anchura;
	}
	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}
	public int getGrosor() {
		return grosor;
	}
	public void setGrosor(int grosor) {
		this.grosor = grosor;
	}
	public boolean isFragil() {
		return fragil;
	}
	public void setFragil(boolean fragil) {
		this.fragil = fragil;
	}
	public double getVolumen() {
		return volumen;
	}

	public double getCosteEnvio() {
		return costeEnvio;
	}
	public void setCosteEnvio(double costeEnvio) {
		this.costeEnvio = costeEnvio;
	}
	
	
	/*Otros métodos*/
	private int calcularVolumen() {
		int volumen = this.altura*this.anchura*this.grosor;
		this.volumen=volumen;
		return volumen;
	}
	
	public double calcularCoste() {
		double costeEnvio=0;
		double volumen= calcularVolumen();
		
		System.out.println(volumen+"Volumen");
		
		if(volumen>0) {
			costeEnvio=volumen*0.05;
			if(this.fragil==true) {
				costeEnvio=costeEnvio+10;
			}
		}else {
			System.out.println("Volumen no valido.");
		}
		this.setCosteEnvio(costeEnvio);
		
		return costeEnvio;
	}
	
	public double calcularCoste(String descuento) {
		int volumen;
		volumen=calcularVolumen();
		
		if(volumen>0) {
			if(descuento.equalsIgnoreCase("DES10")) {
				this.volumen=volumen*0.9;
			}else if(descuento.equalsIgnoreCase("DES25")) {
				this.volumen=volumen*0.75;
			}
		}
		
		setCosteEnvio(this.volumen*0.05);

		return this.costeEnvio;
	}
	
	public String enviar() {
		String mensaje="Error de envio";
		if(costeEnvio>1) {
			mensaje="Envio correcto";	
		}
		
		return mensaje;
	}

}

