package lab05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Rotina de testes da classe ComparaApostas
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ComparaApostasTest {

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
	private ComparaApostas comparador;
	/**
	 * Comparador criado para testes.
	 */
	private ComparaApostas comparador2;

	/**
	 * Método que cria um cenário e cadatra apostas para testes.
	 */
	@Before
	public void PreparaCenario() {
		this.comparador = new ComparaApostas();
		this.cenario = new Cenario("O professor irá para a aula sobre GRASP com um café!", 1);
		this.cenario2 = new Cenario("A maioria irá tirar mais do que 7 na prova!", 2);
		this.cenario3 = new Cenario("Isso é só um teste, calma.", 3);
		this.cenario.cadastrarAposta("Francisco Cisco", 20000, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Anonimo", 199, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Matheus Gaudencio", 4444, "VAI ACONTECER");
		this.cenario.cadastrarAposta("Francisco Cisco", 20000, "N VAI ACONTECER");
		this.cenario2.cadastrarAposta("Anonimo", 199, "N VAI ACONTECER");
		this.cenario2.cadastrarAposta("Matheus Gaudencio", 4444, "VAI ACONTECER");
		this.cenario3.cadastrarAposta("Francisco Cisco", 20000, "N VAI ACONTECER");
		this.cenario3.cadastrarAposta("Anonimo", 199, "N VAI ACONTECER");
	}

	/**
	 * Método que testa Compare quando o primeiro cenario tem mais apostas que o
	 * segundo.
	 */
	@Test
	public void testComparePrimeiroMaior() {
		assertEquals(-2, this.comparador.compare(cenario, cenario2));
	}

	/**
	 * Método que testa Compare quando o Segundo cenario tem mais apostas que o
	 * Primeiro.
	 */
	@Test
	public void testCompareSegundoMaior() {
		assertEquals(2, this.comparador.compare(cenario3, cenario));
	}

	/**
	 * Método que testa Compare quando os cenarios possuem as mesmas quantidades de
	 * apostas.
	 */
	@Test
	public void testCompareIguais() {
		assertEquals(0, this.comparador.compare(cenario3, cenario2));
	}

	/**
	 * Testa o construtor de um comparador por apostas.
	 */
	@Test
	public void testConstrutor() {
		assertTrue(comparador2 == null);
		comparador2 = new ComparaApostas();
		assertFalse(comparador2 == null);
	}

}
