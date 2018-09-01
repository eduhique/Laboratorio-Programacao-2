package lab05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Rotina de testes da classe Aposta Comum.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ApostaComumTest {

	/**
	 * Aposta criada para testes.
	 */
	ApostaComum apostaTest;

	/**
	 * Método que cria um objeto Aposta para testes.
	 */
	@Before
	public void preparaAposta() {
		this.apostaTest = new ApostaComum("Valdisney", 10000, "VAI ACONTECER");
	}

	/**
	 * Método que testa o construtor Aposta que cria um objeto Aposta.
	 */
	@Test
	public void testAposta() {
		new ApostaComum("Seu Zé", 5000, "N VAI ACONTECER");
	}

	/**
	 * Método que testa o construtor Aposta que cria um objeto Aposta diferente
	 * passando outro tipo de previsão.
	 */
	@Test
	public void testAposta2() {
		new ApostaComum("Seu Zé", 5000, "VAI ACONTECER");
	}

	/**
	 * Método que testa o construtor Aposta que cria um objeto Aposta passando um
	 * nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testApostaNomeNull() {
		new ApostaComum(null, 5000, "N VAI ACONTECER");
	}

	/**
	 * Método que testa o construtor Aposta que cria um objeto Aposta passando um
	 * nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaNomeVazio() {
		new ApostaComum(" ", 5000, "N VAI ACONTECER");
	}

	/**
	 * Método que testa o construtor Aposta que cria um objeto Aposta passando um
	 * valor negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaValorNegativo() {
		new ApostaComum("Seu Zé", -23, "N VAI ACONTECER");
	}

	/**
	 * Método que testa o construtor Aposta que cria um objeto Aposta passando um
	 * valor zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaValorZero() {
		new ApostaComum("Seu Zé", 0, "N VAI ACONTECER");
	}

	/**
	 * Método que testa o construtor Aposta que cria um objeto Aposta passando uma
	 * previsão nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testApostaPrevisaoNull() {
		new ApostaComum("Seu Zé", 5000, null);
	}

	/**
	 * Método que testa o construtor Aposta que cria um objeto Aposta passando uma
	 * previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaPrevisaoVazio() {
		new ApostaComum("Seu Zé", 5000, " ");
	}

	/**
	 * Método que testa o construtor Aposta que cria um objeto Aposta passando uma
	 * previsão errada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaPrevisaoErrada() {
		new ApostaComum("Seu Zé", 5000, " ACONTECER");
	}

	/**
	 * Método que testa o construtor Aposta que cria um objeto Aposta passando outra
	 * previsão errada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaPrevisaoErrada2() {
		new ApostaComum("Seu Zé", 5000, " N ACONTECER");
	}

	/**
	 * Método que testa a recuperação do valor da aposta.
	 */
	@Test
	public void testGetValor() {
		assertEquals(10000, this.apostaTest.getValor());
	}

	/**
	 * Método que testa a recuperação da previsão da aposta.
	 */
	@Test
	public void testGetPrevisao() {
		assertEquals("VAI ACONTECER", this.apostaTest.getPrevisao());
	}

	/**
	 * Método que testa a recuperação do valor assegurado. Deve retorna sempre 0.
	 */
	@Test
	public void testGetSeguro() {
		assertEquals(0, this.apostaTest.getSeguro());
	}

	/**
	 * Método que testa o to String de Aposta.
	 */
	@Test
	public void testToString() {
		assertEquals("Valdisney - R$ 100,00 - VAI ACONTECER", this.apostaTest.toString());
	}

}
