package lab05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Rotina de testes da classe Seguro por taxa.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class SeguroTaxaTest {

	/**
	 * Cria um seguro para testes.
	 */
	SeguroTaxa seguro;

	/**
	 * Método que cria um objeto Seguro por taxa para testes.
	 */
	@Before
	public void preparaSeguro() {
		this.seguro = new SeguroTaxa(0.02, 501);
	}

	/**
	 * Método que testa o construtor de Seguro por taxa.
	 */
	@Test
	public void testSeguroTaxa() {
		new SeguroTaxa(0.5, 10000);
	}

	/**
	 * Método que testa o construtor de Seguro por taxa, quando é passado um valor
	 * negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSeguroTaxaValorNegativo() {
		new SeguroTaxa(0.5, -10000);
	}

	/**
	 * Método que testa o construtor de Seguro por taxa, quando é passado um valor
	 * zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSeguroTaxaValorZero() {
		new SeguroTaxa(0.5, 0);
	}

	/**
	 * Método que testa o construtor de Seguro por taxa, quando é passado uma taxa
	 * negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSeguroTaxaTaxaNegativo() {
		new SeguroTaxa(-0.5, 10000);
	}

	/**
	 * Método que testa o construtor de Seguro por taxa, quando é passado uma taxa
	 * zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSeguroTaxaTAxarZero() {
		new SeguroTaxa(0, 10000);
	}

	/**
	 * Método que testa a recuperação do valor assegurado.
	 */
	@Test
	public void testGetValorAssegurado() {
		assertEquals(10, this.seguro.getValorAssegurado());
	}

	/**
	 * Método que testa o to String de seguro por taxa.
	 */
	@Test
	public void testToString() {
		assertEquals(" - ASSEGURADA (TAXA) - 2%", this.seguro.toString());
	}

}
