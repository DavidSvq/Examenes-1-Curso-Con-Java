package pruebasCajas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PaqueteTest {

	@Test
	void testCalcularCoste() {
		Paquete p = new Paquete();
		p.setAltura(3);
		p.setAnchura(3);
		p.setGrosor(3);
		p.setFragil(true);
		assertEquals(11.35, p.calcularCoste());
		p.setFragil(false);
		assertEquals(1.35, p.calcularCoste());
		p.setAltura(0);
		p.setAnchura(0);
		p.setGrosor(0);
		assertEquals(0, p.calcularCoste());
	}

	@Test
	void testCalcularCosteString() {
		Paquete p = new Paquete();
		p.setAltura(3);
		p.setAnchura(3);
		p.setGrosor(3);
		String descuento = "DES10";
		assertEquals(1.125, p.calcularCoste(descuento));
		descuento = "DES25";
		assertEquals(1.35, p.calcularCoste(descuento));
		descuento = "a";
		assertEquals(1.5, p.calcularCoste(descuento));
		p.setAltura(0);
		p.setAnchura(0);
		p.setGrosor(0);
		descuento = "DES25";
		assertEquals(0, p.calcularCoste(descuento));
	}

	@Test
	void testEnviar() {
		Paquete p = new Paquete();
		p.setCosteEnvio(2);
		assertEquals("Envio correcto", p.enviar());
		p.setCosteEnvio(0);
		assertEquals("Error de envio", p.enviar());
	}

}
