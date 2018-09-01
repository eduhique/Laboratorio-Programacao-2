package lab05;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Rotina de testes da classe ComparaCadastro
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ComparaCadastroTest {

	/**
	 * Cenário criado para testes.
	 */
	private Cenario cenario;
	/**
	 * Cenário criado para testes.
	 */
	private Cenario cenario2;
	/**
	 * Comparador criado para testes.
	 */
	private ComparaCadastro comparador;

	/**
	 * Método que testa Compare quando o cenario 1 foi cadstrado primeiro do cenario
	 * 2.
	 */
	@Test
	public void testComparePrimeiroMaior() {
		this.comparador = new ComparaCadastro();
		this.cenario = new Cenario("O professor irá para a aula sobre GRASP com um café!", 1);
		this.cenario2 = new Cenario("A maioria irá tirar mais do que 7 na prova!", 2);
		assertEquals(-1, this.comparador.compare(cenario, cenario2));
	}

	/**
	 * Método que testa Compare quando o Segundo cenario foi cadastrado antes do
	 * Primeiro cenaria.
	 */
	@Test
	public void testCompareSegundoMaior() {
		this.comparador = new ComparaCadastro();
		this.cenario2 = new Cenario("O professor irá para a aula sobre GRASP com um café!", 1);
		this.cenario = new Cenario("A maioria irá tirar mais do que 7 na prova!", 2);
		assertEquals(1, this.comparador.compare(cenario, cenario2));
	}

	/**
	 * Testa o construtor de um comparador por apostas.
	 */
	@Test
	public void testConstrutor() {
		assertTrue(comparador == null);
		comparador = new ComparaCadastro();
		assertFalse(comparador == null);
	}

}
