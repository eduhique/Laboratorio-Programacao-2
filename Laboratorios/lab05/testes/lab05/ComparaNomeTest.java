package lab05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Rotina de testes da classe ComparaNome
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ComparaNomeTest {
	/**
	 * Cenário criado para testes.
	 */
	private Cenario cenario;
	/**
	 * Cenário criado para testes.
	 */
	private Cenario cenario2;
	/**
	 * Cenário criado para testes.
	 */
	private Cenario cenario3;
	/**
	 * Comparador criado para testes.
	 */
	private ComparaNome comparador;
	/**
	 * Comparador criado para testes.
	 */
	private ComparaNome comparador2;

	/**
	 * Método que cria um cenário e cadatra apostas para testes.
	 */
	@Before
	public void PreparaCenario() {
		this.comparador = new ComparaNome();
		this.cenario = new Cenario("Asa Dourada", 1);
		this.cenario2 = new Cenario("Barba Grossa", 2);
		this.cenario3 = new Cenario("Sei la", 2);
	}

	/**
	 * Método que testa Compare quando o primeiro cenario vem primeiro que o segundo
	 * cenario.
	 */
	@Test
	public void testComparePrimeiro() {
		assertTrue(this.comparador.compare(cenario, cenario2) < 0);
	}

	/**
	 * Método que testa Compare quando o segundo cenario vem primeiro que o primeiro
	 * cenario.
	 */
	@Test
	public void testCompareSegundo() {
		assertTrue(this.comparador.compare(cenario3, cenario) > 0);
	}

	/**
	 * Método que testa Compare quando os cenarios são iguais.
	 */
	@Test
	public void testCompareIgual() {
		assertTrue(this.comparador.compare(cenario2, cenario2) == 0);
	}

	/**
	 * Testa o construtor de um comparador por Nome..
	 */
	@Test
	public void testConstrutor() {
		assertTrue(comparador2 == null);
		comparador2 = new ComparaNome();
		assertFalse(comparador2 == null);
	}

}
