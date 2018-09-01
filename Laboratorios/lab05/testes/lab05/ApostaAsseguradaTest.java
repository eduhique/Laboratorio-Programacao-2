package lab05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Rotina de testes da classe Aposta Assegurada.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ApostaAsseguradaTest {

	/**
	 * Aposta criada para testes.
	 */
	ApostaAssegurada apostaTest;

	/**
	 * Aposta criada para testes.
	 */
	ApostaAssegurada apostaTest2;

	/**
	 * Método que cria um objeto Aposta para testes.
	 */
	@Before
	public void preparaAposta() {
		this.apostaTest = new ApostaAssegurada("Valdisney", 10000, "VAI ACONTECER", 10000);
		this.apostaTest2 = new ApostaAssegurada("Valdisney", 20000, "N VAI ACONTECER", 0.2);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por valor.
	 */
	@Test
	public void testApostaAsseguradaValor() {
		new ApostaAssegurada("Seu Zé", 5000, "N VAI ACONTECER", 10000);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por taxa.
	 */
	@Test
	public void testApostaAsseguradaTaxa() {
		new ApostaAssegurada("Seu Zé", 5000, "N VAI ACONTECER", 0.02);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por valor, passando um nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testApostaAsseguradaValorNomeNull() {
		new ApostaAssegurada(null, 5000, "N VAI ACONTECER", 10000);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por taxa, passando um nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testApostaAsseguradaTaxaNomeNull() {
		new ApostaAssegurada(null, 5000, "N VAI ACONTECER", 0.02);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por valor, passando um nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaValorNomeVazio() {
		new ApostaAssegurada(" ", 5000, "N VAI ACONTECER", 10000);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por taxa, passando um nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaNomeVazio() {
		new ApostaAssegurada(" ", 5000, "N VAI ACONTECER", 0.02);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por valor, passando um valor negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguraValorValorNegativo() {
		new ApostaAssegurada("Seu Zé", -23, "N VAI ACONTECER", 1000);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por taxa, passando um valor negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaAsseguradaTaxaValorNegativo() {
		new ApostaAssegurada("Seu Zé", -23, "N VAI ACONTECER", 0.2);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por valor, passando um valor zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void ApostaAsseguradaValorValorZero() {
		new ApostaAssegurada("Seu Zé", 0, "N VAI ACONTECER", 1000);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por taxa, passando um valor zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void ApostaAsseguradaTaxaValorZero() {
		new ApostaAssegurada("Seu Zé", 0, "N VAI ACONTECER", 0.2);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por valor, passando uma previsão nula.
	 */
	@Test(expected = NullPointerException.class)
	public void ApostaAsseguradaValorPrevisaoNull() {
		new ApostaAssegurada("Seu Zé", 1000, null, 10000);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por taxa, passando uma previsão nula.
	 */
	@Test(expected = NullPointerException.class)
	public void ApostaAsseguradaTaxaPrevisaoNull() {
		new ApostaAssegurada("Seu Zé", 1000, null, 0.2);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por valor, passando uma previsão vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void ApostaAsseguradaValorPrevisaoVazio() {
		new ApostaAssegurada("Seu Zé", 1000, " ", 10000);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por taxa, passando uma previsão vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void ApostaAsseguradaTaxaPrevisaoVazio() {
		new ApostaAssegurada("Seu Zé", 1000, " ", 0.2);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por valor, passando uma previsão invalida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void ApostaAsseguradaValorPrevisaoErrada() {
		new ApostaAssegurada("Seu Zé", 1000, " ACONTECER", 10000);
	}

	/**
	 * Método que testa o construtor Aposta Assegurada, quando essa aposta é
	 * assegurada por taxa, passando uma previsão invalida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void ApostaAsseguradaTaxaPrevisaoErrada2() {
		new ApostaAssegurada("Seu Zé", 1000, "N ACONTECER", 0.2);
	}

	/**
	 * Método que testa a recuperação do valor da aposta assegurada por valor.
	 */
	@Test
	public void testGetValorValor() {
		assertEquals(10000, this.apostaTest.getValor());
	}

	/**
	 * Método que testa a recuperação do valor da aposta assegurada por taxa.
	 */
	@Test
	public void testGetValorTaxa() {
		assertEquals(20000, this.apostaTest2.getValor());
	}

	/**
	 * Método que testa a recuperação da previsão da aposta assegurada por valor.
	 */
	@Test
	public void testGetPrevisaoValor() {
		assertEquals("VAI ACONTECER", this.apostaTest.getPrevisao());
	}

	/**
	 * Método que testa a recuperação da previsão da aposta assegurada por taxa.
	 */
	@Test
	public void testGetPrevisaoTaxa() {
		assertEquals("N VAI ACONTECER", this.apostaTest2.getPrevisao());
	}

	/**
	 * Método que testa a recuperação do valor assegurado, numa aposta assegurada
	 * por valor.
	 */
	@Test
	public void testGetSeguroValor() {
		assertEquals(10000, this.apostaTest.getSeguro());
	}

	/**
	 * Método que testa a recuperação do valor assegurado, numa aposta assegurada
	 * por taxa.
	 */
	@Test
	public void testGetSeguroTaxa() {
		assertEquals(4000, this.apostaTest2.getSeguro());
	}

	/**
	 * Método que testa o to String de Aposta assegura, quando ela é assegurada por
	 * valor.
	 */
	@Test
	public void testToString() {
		assertEquals("Valdisney - R$ 100,00 - VAI ACONTECER - ASSEGURADA (VALOR) - R$ 100,00", this.apostaTest.toString());
	}

}
