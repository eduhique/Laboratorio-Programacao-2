package lab05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Rotina de testes da classe Cenario Bônus.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class CenarioBonusTest {

	/**
	 * Cenário Bônus criado para testes.
	 */
	CenarioBonus cenario;

	/**
	 * Método que cria um cenário Bônus para testes.
	 */
	@Before
	public void PreparaCenario() {
		this.cenario = new CenarioBonus("O professor irá para a aula sobre GRASP com um café!", 10000, 1);
	}

	/**
	 * Método que testa o construtor Cenario Bônus que cria um objeto Cenario Bônus.
	 */
	@Test
	public void testCenarioBonus() {
		new CenarioBonus("A maioria irá tirar mais do que 7 na prova!", 1000, 1);
	}

	/**
	 * Método que testa o construtor Cenario Bônus que cria um objeto Cenario Bônus
	 * passando um valor negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusNegativo() {
		new CenarioBonus("A maioria irá tirar mais do que 7 na prova!", -1000, 1);
	}

	/**
	 * Método que testa o construtor Cenario Bônus que cria um objeto Cenario Bônus
	 * passando um valor zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusZero() {
		new CenarioBonus("A maioria irá tirar mais do que 7 na prova!", 0, 1);
	}

	/**
	 * Método auxiliar criado para simplificar e evitar a ultilização de métodos
	 * repitidos.
	 */
	private void cadastraApostas() {
		this.cenario.cadastrarAposta("Francisco Cisco", 20000, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Anonimo", 199, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Matheus Gaudencio", 10000, "VAI ACONTECER");

	}

	/**
	 * Método que testa a recuperação do total para rateio quando o um cenário Bônus
	 * foi finalizado.
	 */
	@Test
	public void testGetTotalRateioCenario() {
		cadastraApostas();
		this.cenario.fecharAposta(true, 0.1);
		assertEquals(28180, this.cenario.getTotalRateioCenario());
	}

	/**
	 * Método que testa o to String do objeto Cenário Bônus.
	 */
	@Test
	public void testToString() {
		assertEquals("O professor irá para a aula sobre GRASP com um café! - Nao finalizado - R$ 100,00",
				this.cenario.toString());
	}

}
