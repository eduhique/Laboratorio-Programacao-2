package lab05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Rotina de testes da classe Controller.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ControllerTest {

	/**
	 * Controller Criado para testes.
	 */
	Controller controller;

	/**
	 * Método que cria e inicializa um controller para testes.
	 */
	@Before
	public void PreparaController() {
		this.controller = new Controller();
		this.controller.inicializa(10000, 0.1);
	}

	// Testes de Construtor

	/**
	 * Método que testa o construtor Controller que cria um objeto Controller.
	 */
	@Test
	public void testController() {
		new Controller();
	}

	// Testes de Inicialização.

	/**
	 * Método que testa a Inicialização do Sistema em situação normal de uso.
	 */
	@Test
	public void testInicializa() {
		this.controller.inicializa(10000, 0.1);
	}

	/**
	 * Método que testa a Inicialização do Sistema com um valor de caixa negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInicializaCaixaNegativo() {
		this.controller.inicializa(-500, 0.1);
	}

	/**
	 * Método que testa a Inicialização do Sistema com uma taxa negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInicializaTaxaNegativa() {
		this.controller.inicializa(10000, -0.1);
	}

	// Testes para Cadastrar Cénario e Get caixa

	/**
	 * Método que testa o cadastro de um cenário.
	 */
	@Test
	public void testCadastrarCenario() {
		assertEquals(1, this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!"));
	}

	/**
	 * Método que testa o cadastro de um cenário com Bônus.
	 */
	@Test
	public void testCadastrarCenarioBonus() {
		assertEquals(1,
				this.controller.cadastrarCenarioBonus("O professor irá para a aula sobre GRASP com um café!", 1000));
	}

	/**
	 * Método que testa a recuperação do valor contido no caixa do sistema.
	 */
	@Test
	public void testGetCaixa() {
		assertEquals(10000, this.controller.getCaixa());
	}

	// teste de Exibição de um Cenario

	/**
	 * Método que testa a exibição de um cenário.
	 */
	@Test
	public void testExibirCenario() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		assertEquals("1 - O professor irá para a aula sobre GRASP com um café! - Nao finalizado",
				this.controller.exibirCenario(1));
	}

	/**
	 * Método que testa a exibição de um cenário, quando é passado um número de
	 * cenário negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioEntradaNegativa() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.exibirCenario(-1);
	}

	/**
	 * Método que testa a exibição de um cenário, quando é passado um número de
	 * cenário zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioEntradaZero() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.exibirCenario(0);
	}

	/**
	 * Método que testa a exibição de um cenário quando, é passado um número de
	 * cenário maior que o número de cenários cadastrados.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testExibirCenarioEntradaInvalida() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.exibirCenario(2);
	}

	// teste de Exibição de todos os Cenários

	/**
	 * Método que testa a exibição de todos os Cenários.
	 */
	@Test
	public void testExibirCenarios() {
		this.controller.cadastrarCenario("A maioria irá tirar mais do que 7 na prova!");
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		assertEquals("1 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado" + System.lineSeparator()
				+ "2 - O professor irá para a aula sobre GRASP com um café! - Nao finalizado" + System.lineSeparator(),
				controller.exibirCenarios());
	}

	// testes de Cadastro de apostas

	/**
	 * Método que testa o cadastro de apostas.
	 */
	@Test
	public void testCadastrarAposta() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarAposta(1, "Valdisney", 10000, "VAI ACONTECER");
	}

	/**
	 * Método que testa o cadastro de apostas, quando é passado um número de cenário
	 * negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostaEntradaNegativa() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarAposta(-1, "Valdisney", 10000, "VAI ACONTECER");
	}

	/**
	 * Método que testa o cadastro de apostas, quando é passado um número de cenário
	 * zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostaEntradaZero() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarAposta(0, "Valdisney", 10000, "VAI ACONTECER");
	}

	/**
	 * Método que testa o cadastro de apostas, quando é passado um número de cenário
	 * maior que o número de cenários cadastrados.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCadastrarApostaEntradaInvalida() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarAposta(2, "Valdisney", 10000, "VAI ACONTECER");
	}

	/**
	 * Método que testa o cadastro de aposta assegurada por valor.
	 */
	@Test
	public void testCadastrarApostaSeguraValor() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraValor(1, "Valdisney", 10000, "VAI ACONTECER", 10000, 5000);
	}

	/**
	 * Método que testa o cadastro de aposta assegurada por valor, quando é passado
	 * um número de cenário negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostaSeguraValorEntradaNegativa() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraValor(-1, "Valdisney", 10000, "VAI ACONTECER", 10000, 5000);
	}

	/**
	 * Método que testa o cadastro de aposta assegurada por valor, quando é passado
	 * um número de cenário zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostaSeguraValorEntradaZero() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraValor(0, "Valdisney", 10000, "VAI ACONTECER", 10000, 5000);
	}

	/**
	 * Método que testa o cadastro de aposta assegurada por valor, quando é passado
	 * um número de cenário maior que o número de cenários cadastrados.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCadastrarApostaSeguraValorEntradaInvalida() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraValor(2, "Valdisney", 10000, "VAI ACONTECER", 10000, 5000);
	}

	/**
	 * Método que testa o cadastro de aposta assegurada por taxa.
	 */
	@Test
	public void testCadastrarApostaSeguraTaxa() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraTaxa(1, "Valdisney", 10000, "VAI ACONTECER", 0.02, 5000);
	}

	/**
	 * Método que testa o cadastro de aposta assegurada por taxa, quando é passado
	 * um número de cenário negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostaSeguraTaxaEntradaNegativa() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraTaxa(-1, "Valdisney", 10000, "VAI ACONTECER", 0.02, 5000);
	}

	/**
	 * Método que testa o cadastro de aposta assegurada por taxa, quando é passado
	 * um número de cenário zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostaSeguraTaxaEntradaZero() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraTaxa(0, "Valdisney", 10000, "VAI ACONTECER", 0.02, 5000);
	}

	/**
	 * Método que testa o cadastro de aposta assegurada por taxa, quando é passado
	 * um número de cenário maior que o número de cenários cadastrados.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCadastrarApostaSeguraTaxaEntradaInvalida() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraTaxa(2, "Valdisney", 10000, "VAI ACONTECER", 0.02, 5000);
	}

	// Métodos de alteração de apostas asseguradas.

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para Valor.
	 */
	@Test
	public void testAlteraSeguroValor() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraTaxa(1, "Valdisney", 10000, "VAI ACONTECER", 0.02, 5000);
		assertEquals(1, this.controller.alterarSeguroValor(1, 1, 10000));
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para Valor,
	 * quando é passado um número de cenário negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraSeguroValorEntradaNegativa() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraTaxa(1, "Valdisney", 10000, "VAI ACONTECER", 0.02, 5000);
		this.controller.alterarSeguroValor(-1, 1, 10000);
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para Valor,
	 * quando é passado um número de cenário zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraSeguroValorEntradaZero() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraTaxa(1, "Valdisney", 10000, "VAI ACONTECER", 0.02, 5000);
		this.controller.alterarSeguroValor(0, 1, 10000);
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para Valor,
	 * quando é passado um número de cenário maior que o número de cenários
	 * cadastrados.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAlteraSeguroValorEntradaInvalida() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraTaxa(1, "Valdisney", 10000, "VAI ACONTECER", 0.02, 5000);
		this.controller.alterarSeguroValor(2, 1, 10000);
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para seguro
	 * por taxa.
	 */
	@Test
	public void testAlteraSeguroTaxa() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraValor(1, "Valdisney", 10000, "VAI ACONTECER", 10000, 5000);
		assertEquals(1, this.controller.alterarSeguroTaxa(1, 1, 0.2));
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para seguro
	 * por taxa, quando é passado um número de cenário negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraSeguroTaxaEntradaNegativa() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraValor(1, "Valdisney", 10000, "VAI ACONTECER", 10000, 5000);
		this.controller.alterarSeguroTaxa(-1, 1, 0.02);
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para seguro
	 * por taxa, quando é passado um número de cenário zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraSeguroTaxaEntradaZero() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraValor(1, "Valdisney", 10000, "VAI ACONTECER", 10000, 5000);
		this.controller.alterarSeguroTaxa(0, 1, 0.02);
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para seguro
	 * por taxa, quando é passado um número de cenário maior que o número de
	 * cenários cadastrados.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAlteraSeguroTaxaEntradaInvalida() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarApostaSeguraValor(1, "Valdisney", 10000, "VAI ACONTECER", 10000, 5000);
		this.controller.alterarSeguroTaxa(2, 1, 0.02);
	}

	// Método auxiliar.
	/**
	 * Método auxiliar criado para simplificar e evitar a ultilização de métodos
	 * repitidos.
	 */
	private void CadastraCenarioAposta() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarAposta(1, "Francisco Cisco", 20000, "N VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Anonimo", 199, "N VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Matheus Gaudencio", 10000, "VAI ACONTECER");
	}

	// testes do valor total de apostas.

	/**
	 * Método que testa a recuperação do valor total de apostas para um cénario.
	 */
	@Test
	public void testValorTotalDeApostas() {
		CadastraCenarioAposta();
		assertEquals(30199, this.controller.valorTotalDeApostas(1));
	}

	/**
	 * Método que testa a recuperação do valor total de apostas para um cénario,
	 * quando é passado um número de cenário negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasEntradaNegativa() {
		CadastraCenarioAposta();
		this.controller.valorTotalDeApostas(-1);
	}

	/**
	 * Método que testa a recuperação do valor total de apostas para um cénario,
	 * quando é passado um número de cenário zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasEntradaZero() {
		CadastraCenarioAposta();
		this.controller.valorTotalDeApostas(0);
	}

	/**
	 * Método que testa a recuperação do valor total de apostas para um cénario,
	 * quando é passado um número de cenário maior que o número de cenários
	 * cadastrados.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testValorTotalDeApostasEntradaInvalida() {
		CadastraCenarioAposta();
		this.controller.valorTotalDeApostas(2);
	}

	// testes do total de apostas

	/**
	 * Método que testa a recuperação do número total de apostas feitas em um
	 * cénario.
	 */
	@Test
	public void testTotalDeApostas() {
		CadastraCenarioAposta();
		assertEquals(3, this.controller.totalDeApostas(1));
	}

	/**
	 * Método que testa a recuperação do número total de apostas feitas em um
	 * cénario, quando é passado um número de cenário negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasEntradaNegativa() {
		CadastraCenarioAposta();
		this.controller.totalDeApostas(-1);
	}

	/**
	 * Método que testa a recuperação do número total de apostas feitas em um
	 * cénario, quando é passado um número de cenário Zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasEntradaZero() {
		CadastraCenarioAposta();
		this.controller.totalDeApostas(0);
	}

	/**
	 * Método que testa a recuperação do número total de apostas feitas em um
	 * cénario, quando é passado um número de cenário maior que o número de cenários
	 * cadastrados.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testTotalDeApostasEntradaInvalida() {
		CadastraCenarioAposta();
		this.controller.totalDeApostas(2);
	}

	// testes de exibição de apostas

	/**
	 * Método que testa a exibição das apostas feitas para um cénario.
	 */
	@Test
	public void testExibeApostas() {
		CadastraCenarioAposta();
		assertEquals(
				"Francisco Cisco - R$ 200,00 - N VAI ACONTECER" + System.lineSeparator()
						+ "Anonimo - R$ 1,99 - N VAI ACONTECER" + System.lineSeparator()
						+ "Matheus Gaudencio - R$ 100,00 - VAI ACONTECER" + System.lineSeparator(),
				this.controller.exibeApostas(1));

	}

	/**
	 * Método que testa a exibição das apostas feitas para um cénario, quando é
	 * passado um número de cenário negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasEntradaNegativa() {
		CadastraCenarioAposta();
		this.controller.exibeApostas(-1);
	}

	/**
	 * Método que testa a exibição das apostas feitas para um cénario, quando é
	 * passado um número de cenário zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasEntradaZero() {
		CadastraCenarioAposta();
		this.controller.exibeApostas(0);
	}

	/**
	 * Método que testa a exibição das apostas feitas para um cénario, quando é
	 * passado um número de cenário maior que o número de cenários cadastrados.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testExibeApostasEntradaInvalida() {
		CadastraCenarioAposta();
		this.controller.exibeApostas(2);
	}

	// testes de fechar apostas

	/**
	 * Método que testa o fechamento de apostas.
	 */
	@Test
	public void testFecharAposta() {
		CadastraCenarioAposta();
		this.controller.fecharAposta(1, true);
	}

	/**
	 * Método que testa o fechamento de apostas, quando é passado um número de
	 * cenário negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFecharApostaEntradaNegativa() {
		CadastraCenarioAposta();
		this.controller.fecharAposta(-1, true);
	}

	/**
	 * Método que testa o fechamento de apostas, quando é passado um número de
	 * cenário zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFecharApostaEntradaZero() {
		CadastraCenarioAposta();
		this.controller.fecharAposta(0, true);
	}

	/**
	 * Método que testa o fechamento de apostas, quando é passado um número de
	 * cenário maior que o número de cenários cadastrados.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testFecharApostaEntradaInvalida() {
		CadastraCenarioAposta();
		this.controller.fecharAposta(2, true);
	}

	// testes para o getCaixaCenario

	/**
	 * Método que testa a recuperação do caixa de um cénario.
	 */
	@Test
	public void testGetCaixaCenario() {
		CadastraCenarioAposta();
		this.controller.fecharAposta(1, true);
		assertEquals(2019, this.controller.getCaixaCenario(1));
	}

	/**
	 * Método que testa a recuperação do caixa de um cénario, quando é passado um
	 * número de cenário negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioEntradaNegativa() {
		CadastraCenarioAposta();
		this.controller.fecharAposta(1, true);
		this.controller.getCaixaCenario(-1);
	}

	/**
	 * Método que testa a recuperação do caixa de um cénario, quando é passado um
	 * número de cenário zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioEntradaZero() {
		CadastraCenarioAposta();
		this.controller.fecharAposta(1, true);
		this.controller.getCaixaCenario(0);
	}

	/**
	 * Método que testa a recuperação do caixa de um cénario, quando é passado um
	 * número de cenário maior que o número de cenários cadastrados.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetCaixaCenarioEantradaInvalida() {
		CadastraCenarioAposta();
		this.controller.fecharAposta(1, true);
		this.controller.getCaixaCenario(2);
	}

	// testes do getRateioCenario

	/**
	 * Método que testa a recuperação do rateio de um cénario.
	 */
	@Test
	public void testGetTotalRateioCenario() {
		CadastraCenarioAposta();
		this.controller.fecharAposta(1, true);
		assertEquals(18180, this.controller.getTotalRateioCenario(1));

	}

	/**
	 * Método que testa a recuperação do rateio de um cénario, quando é passado um
	 * número de cenário negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetTotalRateioCenarioEntradaNegativa() {
		CadastraCenarioAposta();
		this.controller.fecharAposta(1, true);
		this.controller.getCaixaCenario(-1);
	}

	/**
	 * Método que testa a recuperação do rateio de um cénario, quando é passado um
	 * número de cenário zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetTotalRateioCenarioEntradaZero() {
		CadastraCenarioAposta();
		this.controller.fecharAposta(1, true);
		this.controller.getCaixaCenario(0);
	}

	/**
	 * Método que testa a recuperação do rateio de um cénario, quando é passado um
	 * número de cenário maior que o número de cenários cadastrados.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetTotalRateioCenarioEntradaInvalida() {
		CadastraCenarioAposta();
		this.controller.fecharAposta(1, true);
		this.controller.getCaixaCenario(2);
	}

	/**
	 * Método que testa a alteração de ordem, quando é inserido uma entrada nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testAlteraOrdemNull() {
		this.controller.alterarOrdem(null);
	}

	/**
	 * Método que testa a alteração de ordem, quando é inserido uma entrada vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraOrdemVazio() {
		this.controller.alterarOrdem(" ");
	}

	/**
	 * Método que testa a alteração de ordem, quando é inserido uma entrada
	 * Invalida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraOrdemEntradaInvalida() {
		this.controller.alterarOrdem("Normal");
	}

	/**
	 * Método que testa a exibição de um cenário Ordenado por Cadastro.
	 */
	@Test
	public void testExibirCenarioOrdenadoCadastro() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarCenario("A maioria irá tirar mais do que 7 na prova!");
		this.controller.cadastrarCenario("Isso é só um teste, calma.");
		this.controller.alterarOrdem("cadastro");
		assertEquals("1 - O professor irá para a aula sobre GRASP com um café! - Nao finalizado",
				this.controller.exibirCenarioOrdenado(1));
	}

	/**
	 * Método que testa a exibição de um cenário Ordenado por Cadastro.
	 */
	@Test
	public void testExibirCenarioOrdenadoCadastro2() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarCenario("A maioria irá tirar mais do que 7 na prova!");
		this.controller.cadastrarCenario("Isso é só um teste, calma.");
		this.controller.alterarOrdem("cadastro");
		assertEquals("2 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado",
				this.controller.exibirCenarioOrdenado(2));
	}

	/**
	 * Método que testa a exibição de um cenário Ordenado por nome.
	 */
	@Test
	public void testExibirCenarioOrdenadoNome() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarCenario("A maioria irá tirar mais do que 7 na prova!");
		this.controller.cadastrarCenario("Isso é só um teste, calma.");
		this.controller.alterarOrdem("Nome");
		assertEquals("2 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado",
				this.controller.exibirCenarioOrdenado(1));
	}

	/**
	 * Método que testa a exibição de um cenário Ordenado por nome.
	 */
	@Test
	public void testExibirCenarioOrdenadoNome2() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarCenario("A maioria irá tirar mais do que 7 na prova!");
		this.controller.cadastrarCenario("Isso é só um teste, calma.");
		this.controller.alterarOrdem("Nome");
		assertEquals("3 - Isso é só um teste, calma. - Nao finalizado", this.controller.exibirCenarioOrdenado(2));
	}

	/**
	 * Método auxiliar criado para simplificar e evitar a ultilização de métodos
	 * repitidos.
	 */
	private void PreparaApostasOrdem() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarCenario("A maioria irá tirar mais do que 7 na prova!");
		this.controller.cadastrarCenario("Isso é só um teste, calma.");
		this.controller.cadastrarAposta(3, "Francisco Cisco", 20000, "N VAI ACONTECER");
		this.controller.cadastrarAposta(3, "Anonimo", 199, "N VAI ACONTECER");
		this.controller.cadastrarAposta(3, "Matheus Gaudencio", 4444, "VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Anonimo", 242, "N VAI ACONTECER");
		this.controller.cadastrarAposta(1, "Matheus Gaudencio", 1000000, "VAI ACONTECER");
	}

	/**
	 * Método que testa a exibição de um cenário Ordenado por numero de apostas.
	 */
	@Test
	public void testExibirCenarioOrdenadoApostas() {
		PreparaApostasOrdem();
		this.controller.alterarOrdem("apostas");
		assertEquals("3 - Isso é só um teste, calma. - Nao finalizado", this.controller.exibirCenarioOrdenado(1));
	}

	/**
	 * Método que testa a exibição de um cenário Ordenado por numero de apostas.
	 */
	@Test
	public void testExibirCenarioOrdenadoApostas2() {
		PreparaApostasOrdem();
		this.controller.alterarOrdem("apostas");
		assertEquals("1 - O professor irá para a aula sobre GRASP com um café! - Nao finalizado",
				this.controller.exibirCenarioOrdenado(2));
	}

	/**
	 * Método que testa a exibição de um cenário Ordenado, quando é passado um
	 * número de cenário negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioOrdenadoEntradaNegativa() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarCenario("A maioria irá tirar mais do que 7 na prova!");
		this.controller.cadastrarCenario("Isso é só um teste, calma.");
		this.controller.alterarOrdem("cadatro");
		this.controller.exibirCenarioOrdenado(-1);
	}

	/**
	 * Método que testa a exibição de um cenário Ordenado, quando é passado um
	 * número de cenário zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioOrdenadoEntradaZero() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarCenario("A maioria irá tirar mais do que 7 na prova!");
		this.controller.cadastrarCenario("Isso é só um teste, calma.");
		this.controller.alterarOrdem("nome");
		this.controller.exibirCenarioOrdenado(0);
	}

	/**
	 * Método que testa a exibição de um cenário Ordenado quando, é passado um
	 * número de cenário maior que o número de cenários cadastrados.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testExibirCenarioOrdenadoEntradaInvalida() {
		this.controller.cadastrarCenario("O professor irá para a aula sobre GRASP com um café!");
		this.controller.cadastrarCenario("A maioria irá tirar mais do que 7 na prova!");
		this.controller.cadastrarCenario("Isso é só um teste, calma.");
		this.controller.alterarOrdem("apostas");
		this.controller.exibirCenarioOrdenado(4);
	}

}
