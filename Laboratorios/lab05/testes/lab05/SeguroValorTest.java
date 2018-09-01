package lab05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Rotina de testes da classe Seguro por valor.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class SeguroValorTest {

	/**
	 * Cria um seguro para testes.
	 */
	SeguroValor seguro;

	/**
	 * Método que cria um objeto Seguro por valor para testes.
	 */
	@Before
	public void preparaSeguro() {
		this.seguro = new SeguroValor(1000);
	}

	/**
	 * Método que testa o construtor de Seguro por valor.
	 */
	@Test
	public void testSeguroValor() {
		new SeguroValor(10000);
	}

	/**
	 * Método que testa o construtor de Seguro por valor, quando é passado um valor
	 * negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSeguroValorValorNegativo() {
		new SeguroValor(-10000);
	}

	/**
	 * Método que testa o construtor de Seguro por valor, quando é passado um valor
	 * zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSeguroValorValorZero() {
		new SeguroValor(0);
	}

	/**
	 * Método que testa a recuperação do valor assegurado.
	 */
	@Test
	public void testGetValorAssegurado() {
		assertEquals(1000, this.seguro.getValorAssegurado());
	}

	/**
	 * Método que testa o to String de seguro por valor.
	 */
	@Test
	public void testToString() {
		assertEquals(" - ASSEGURADA (VALOR) - R$ 10,00", this.seguro.toString());
	}

}
