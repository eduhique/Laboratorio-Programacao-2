package lab05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Rotina de testes da classe Cenario.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class CenarioTest {

	/**
	 * Cenário criado para testes.
	 */
	Cenario cenario;

	/**
	 * Método que cria um cenário para testes.
	 */
	@Before
	public void PreparaCenario() {
		this.cenario = new Cenario("O professor irá para a aula sobre GRASP com um café!", 1);
	}

	/**
	 * Método que testa o construtor Cenario que cria um objeto Cenario.
	 */
	@Test
	public void testCenario() {
		new Cenario("A maioria irá tirar mais do que 7 na prova!", 1);
	}

	/**
	 * Método que testa o construtor Cenario que cria um objeto Cenario passando uma
	 * descrição nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCenarioDescricaoNull() {
		new Cenario(null, 1);
	}

	/**
	 * Método que testa o construtor Cenario que cria um objeto Cenario passando uma
	 * descrição vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioDescricaoVazio() {
		new Cenario(" ", 1);
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
	 * Método que testa a recuperação do total para rateio quando o um cenário foi
	 * finalizado.
	 */
	@Test
	public void testGetTotalRateioCenario() {
		cadastraApostas();
		this.cenario.fecharAposta(true, 0.1);
		assertEquals(18180, this.cenario.getTotalRateioCenario());
	}

	/**
	 * Método que testa a recuperação do total para rateio quando o um cenário não
	 * foi finalizado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetTotalRateioCenarioNaoFinalizado() {
		cadastraApostas();
		this.cenario.getTotalRateioCenario();
	}

	/**
	 * Método que testa a recuperação do taxa de um cenário foi finalizado.
	 */
	@Test
	public void testGetTaxaCenario() {
		cadastraApostas();
		this.cenario.fecharAposta(true, 0.1);
		assertEquals(2019, this.cenario.getTaxaCenario());
	}

	/**
	 * Método que testa a recuperação do taxa de um cenário não foi finalizado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetTaxaCenarioNaoFinalizado() {
		cadastraApostas();
		this.cenario.getTaxaCenario();
	}

	/**
	 * Método que testa a recuperação da descrição do cenário.
	 */
	@Test
	public void testGetDescicao() {
		assertEquals("O professor irá para a aula sobre GRASP com um café!", this.cenario.getDescricao());
	}

	/**
	 * Método que testa a recuperação do taxa de um cenário não foi finalizado.
	 */
	@Test
	public void testGetId() {
		assertEquals(1, this.cenario.getId());
	}

	// Cadastrar

	/**
	 * Método que testa o cadastro de apostas.
	 */
	@Test
	public void testCadastrarAposta() {
		this.cenario.cadastrarAposta("Valdisney", 10000, "N VAI ACONTECER");
	}

	/**
	 * Método que testa o cadastro de duas apostas iguais.
	 */
	@Test
	public void testCadastrarApostaIguais() {
		this.cenario.cadastrarAposta("Valdisney", 10000, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Valdisney", 10000, "N VAI ACONTECER");
	}

	/**
	 * Método que testa o cadastro de duas apostas com previões diferentes.
	 */
	@Test
	public void testCadastrarApostaDiferentes() {
		this.cenario.cadastrarAposta("Valdisney", 10000, "N VAI ACONTECER");
		this.cenario.cadastrarAposta("Valdisney", 10000, "VAI ACONTECER");
	}

	/**
	 * Método que testa o cadastro de apostas em cenário finalizado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostaFinalizado() {
		this.cenario.fecharAposta(true, 0.01);
		this.cenario.cadastrarAposta("Valdisney", 10000, "N VAI ACONTECER");
	}

	/**
	 * Método que testa o cadastro de uma aposta Assegurada por valor.
	 */
	@Test
	public void testCadastrarApostaAsseguradaValor() {
		this.cenario.cadastrarApostaSeguraValor("Valdisney", 10000, "N VAI ACONTECER", 10000);
	}

	/**
	 * Método que testa o cadastro de duas apostas Assegurada por valor iguais.
	 */
	@Test
	public void testCadastrarApostaAsseguradaValorIguais() {
		this.cenario.cadastrarApostaSeguraValor("Valdisney", 10000, "N VAI ACONTECER", 10000);
		this.cenario.cadastrarApostaSeguraValor("Valdisney", 10000, "N VAI ACONTECER", 10000);

	}

	/**
	 * Método que testa o cadastro de duas apostas Asseguradas por valor com
	 * previões diferentes.
	 */
	@Test
	public void testCadastrarApostaAsseguradaValorDiferentes() {
		this.cenario.cadastrarApostaSeguraValor("Valdisney", 10000, "N VAI ACONTECER", 10000);
		this.cenario.cadastrarApostaSeguraValor("Valdisney", 10000, "VAI ACONTECER", 10000);
	}

	/**
	 * Método que testa o cadastro de uma aposta Assegurada por valor em cenário
	 * finalizado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaValorFinalizado() {
		this.cenario.fecharAposta(true, 0.01);
		this.cenario.cadastrarApostaSeguraValor("Valdisney", 10000, "N VAI ACONTECER", 10000);
	}

	/**
	 * Método que testa o cadastro de uma aposta Assegurada por Taxa.
	 */
	@Test
	public void testCadastrarApostaAsseguradaTaxa() {
		this.cenario.cadastrarApostaSeguraTaxa("Valdisney", 10000, "N VAI ACONTECER", 0.02);
	}

	/**
	 * Método que testa o cadastro de duas apostas Assegurada por Taxa iguais.
	 */
	@Test
	public void testCadastrarApostaAsseguradaTaxaIguais() {
		this.cenario.cadastrarApostaSeguraTaxa("Valdisney", 10000, "N VAI ACONTECER", 0.02);
		this.cenario.cadastrarApostaSeguraTaxa("Valdisney", 10000, "N VAI ACONTECER", 0.02);

	}

	/**
	 * Método que testa o cadastro de duas apostas Asseguradas por Taxa com previões
	 * diferentes.
	 */
	@Test
	public void testCadastrarApostaAsseguradaTaxaDiferentes() {
		this.cenario.cadastrarApostaSeguraTaxa("Valdisney", 10000, "N VAI ACONTECER", 0.02);
		this.cenario.cadastrarApostaSeguraTaxa("Valdisney", 10000, "VAI ACONTECER", 0.02);
	}

	/**
	 * Método que testa o cadastro de uma aposta Assegurada por Taxa em cenário
	 * finalizado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaTaxaFinalizado() {
		this.cenario.fecharAposta(true, 0.01);
		this.cenario.cadastrarApostaSeguraTaxa("Valdisney", 10000, "N VAI ACONTECER", 0.02);
	}

	// Métodos de alteração de apostas asseguradas.

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para Valor.
	 */
	@Test
	public void testAlteraSeguroValor() {
		this.cenario.cadastrarApostaSeguraTaxa("Valdisney", 10000, "VAI ACONTECER", 0.02);
		assertEquals(1, this.cenario.alterarSeguroValor(1, 10000));
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para Valor,
	 * quando é passado um número de uma aposta assegurada negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraSeguroValorEntradaNegativa() {
		this.cenario.cadastrarApostaSeguraTaxa("Valdisney", 10000, "VAI ACONTECER", 0.02);
		this.cenario.alterarSeguroValor(-1, 10000);
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para Valor,
	 * quando é passado um número de uma aposta assegurada zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraSeguroValorEntradaZero() {
		this.cenario.cadastrarApostaSeguraTaxa("Valdisney", 10000, "VAI ACONTECER", 0.02);
		this.cenario.alterarSeguroValor(0, 10000);
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para Valor,
	 * quando é passado um número de uma aposta assegurada maior que o número de
	 * apostas asseguradas cadastradas.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAlteraSeguroValorEntradaInvalida() {
		this.cenario.cadastrarApostaSeguraTaxa("Valdisney", 10000, "VAI ACONTECER", 0.02);
		this.cenario.alterarSeguroValor(2, 10000);
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para seguro
	 * por taxa.
	 */
	@Test
	public void testAlteraSeguroTaxa() {
		this.cenario.cadastrarApostaSeguraValor("Valdisney1", 10000, "VAI ACONTECER", 10000);
		assertEquals(1, this.cenario.alterarSeguroTaxa(1, 0.2));
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para seguro
	 * por taxa, quando é passado um número de uma aposta assegurada negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraSeguroTaxaEntradaNegativa() {
		this.cenario.cadastrarApostaSeguraValor("Valdisney", 10000, "VAI ACONTECER", 10000);
		this.cenario.alterarSeguroTaxa(-1, 0.02);
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para seguro
	 * por taxa, quando é passado um número de uma aposta assegurada zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraSeguroTaxaEntradaZero() {
		this.cenario.cadastrarApostaSeguraValor("Valdisney", 10000, "VAI ACONTECER", 10000);
		this.cenario.alterarSeguroTaxa(0, 0.02);
	}

	/**
	 * Método que testa a alteração do seguro de uma aposta assegurada para seguro
	 * por taxa, quando é passado um número de uma aposta assegurada maior que o
	 * número de apostas asseguradas cadastradas.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAlteraSeguroTaxaEntradaInvalida() {
		this.cenario.cadastrarApostaSeguraValor("Valdisney", 10000, "VAI ACONTECER", 10000);
		this.cenario.alterarSeguroTaxa(2, 0.02);
	}

	/**
	 * Método que testa a recuperação do valor toral de apostas feitas para um
	 * cénario.
	 */
	@Test
	public void testValorTotalDeApostas() {
		cadastraApostas();
		assertEquals(30199, this.cenario.valorTotalDeApostas());
	}

	/**
	 * Método que testa a recuperação do valor toral de apostas feitas quando um
	 * cénario não tem apostas.
	 */
	@Test
	public void testValorTotalDeApostasSemApostas() {
		assertEquals(0, this.cenario.valorTotalDeApostas());
	}

	/**
	 * Método que testas a quantidade de apostas feitas para um cenário.
	 */
	@Test
	public void testTotalDeApostas() {
		cadastraApostas();
		assertEquals(3, this.cenario.totalDeApostas());
	}

	/**
	 * Método que testas a quantidade de apostas feitas para um cenário, sem
	 * apostas.
	 */
	@Test
	public void testTotalDeApostasSemApostas() {
		assertEquals(0, this.cenario.totalDeApostas());
	}

	/**
	 * Método que testa a exibição das apostas feitas para o cenário.
	 */
	@Test
	public void testExibeApostas() {
		cadastraApostas();
		this.cenario.cadastrarApostaSeguraTaxa("Valdisney", 10000, "VAI ACONTECER", 0.02);
		this.cenario.cadastrarApostaSeguraValor("Valdisney1", 10000, "VAI ACONTECER", 10000);
		assertEquals("Francisco Cisco - R$ 200,00 - N VAI ACONTECER" + System.lineSeparator()
				+ "Anonimo - R$ 1,99 - N VAI ACONTECER" + System.lineSeparator()
				+ "Matheus Gaudencio - R$ 100,00 - VAI ACONTECER" + System.lineSeparator()
				+ "Valdisney - R$ 100,00 - VAI ACONTECER - ASSEGURADA (TAXA) - 2%" + System.lineSeparator()
				+ "Valdisney1 - R$ 100,00 - VAI ACONTECER - ASSEGURADA (VALOR) - R$ 100,00" + System.lineSeparator(),
				this.cenario.exibeApostas());
	}

	/**
	 * Método que testa a exibição das apostas feitas para o cenário, quando não há
	 * apostas.
	 */
	@Test
	public void testExibeApostasVazio() {
		assertEquals("", this.cenario.exibeApostas());
	}

	/**
	 * Método que testa o fechamento de apostas de um cenário.
	 */
	@Test
	public void testFecharAposta() {
		cadastraApostas();
		assertEquals(201, this.cenario.fecharAposta(true, 0.01));
	}

	/**
	 * Método que testa o fechamento de apostas de um cenário que ja foi finalizado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFecharApostaFinalizado() {
		cadastraApostas();
		this.cenario.fecharAposta(true, 0.01);
		this.cenario.fecharAposta(true, 0.01);

	}

	/**
	 * Método que testa qual o valor total assegurado, caso o cenario feche.
	 */
	@Test
	public void testSeguroAposta() {
		this.cenario.cadastrarApostaSeguraTaxa("Valdisney", 10000, "VAI ACONTECER", 0.2);
		this.cenario.cadastrarApostaSeguraValor("Valdisney1", 10000, "VAI ACONTECER", 10000);
		this.cenario.cadastrarApostaSeguraValor("Valdisney1", 10000, "N VAI ACONTECER", 10000);
		assertEquals(12000, this.cenario.seguroApostaTotal(false));
	}

	/**
	 * Método que testa o to String do objeto Cenário.
	 */
	@Test
	public void testToString() {
		assertEquals("O professor irá para a aula sobre GRASP com um café! - Nao finalizado", this.cenario.toString());
	}

}
