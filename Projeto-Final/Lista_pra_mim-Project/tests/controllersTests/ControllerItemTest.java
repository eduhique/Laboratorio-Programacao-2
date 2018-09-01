package controllersTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controllers.ControllerItem;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 *
 * Classe que testa os metodos da classe ControllerItem.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ControllerItemTest {

	// Instanciacao de objetos do tipo Controller.
	private ControllerItem controller, outroController;

	/**
	 * Metodo que inicializa o Controller.
	 * 
	 * Nenhum erro esperado.
	 */
	@Before
	public void inicializa() {
		this.controller = new ControllerItem();
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", "Supermercado Excepcional",
				2.19);
	}

	/**
	 * Metodo que testa o metodo construtor de um Controller.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testController() {
		assertTrue(outroController == null);
		outroController = new ControllerItem();
		assertTrue(outroController != null);
	}

	/**
	 * Metodo que testa o metodo adicionaItemPorQtd.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAdicionaItemPorQtdValido() {
		this.controller.adicionaItemPorQtd("Agua Sanitaria Dragon", "limpeza", 1, "l", "Supermercado Excepcional",
				2.19);
	}

	/**
	 * Metodo que testa o metodo adicionaItemPorQuilo.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAdicionaItemPorQuiloValido() {
		this.controller.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0,
				"Mercadinho Bem Barato", 34.49);

	}

	/**
	 * Metodo que testa o metodo adicionaItemPorUnidade.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAdicionaItemPorUnidadeValido() {
		this.controller.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato",
				3.79);
	}

	/**
	 * Metodo que testa o metodo exibeItem.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testExibeItemValido() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>",
				controller.exibeItem(1));
	}

	/**
	 * Metodo que testa o metodo atualizaItem.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAtualizaItemValido() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>",
				controller.exibeItem(1));
		controller.atualizaItem(1, "nome", "Agua Sanitaria Viserion");
		assertEquals("1. Agua Sanitaria Viserion, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>",
				controller.exibeItem(1));

	}

	/**
	 * Metodo que testa o metodo adicionaPrecoItem.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAdicionaPrecoItemValido() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>",
				controller.exibeItem(1));
		controller.adicionaPrecoItem(1, "Supermercado UauMart", 3.69);
		assertEquals(
				"1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado UauMart, R$ 3,69;Supermercado Excepcional, R$ 2,19;>",
				controller.exibeItem(1));
	}

	/**
	 * Metodo auxiliar que prepara o controller para testar os metodos do caso dois
	 * que fazer ordenancao de exibicao.
	 */
	private void preparaTests() {
		this.controller.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0,
				"Mercadinho Bem Barato", 34.49);
		this.controller.adicionaItemPorQtd("Queijo ralado Lebron", "alimento industrializado", 50, "grama",
				"Supermercado UauMart", 1.59);
		this.controller.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato",
				3.79);
		this.controller.adicionaItemPorUnidade("Creme dental colgate", "higiene pessoal", 3, "Mercadinho Bem Barato",
				4.69);
		this.controller.adicionaItemPorUnidade("Esponja de Aco Assolange", "limpeza", 1, "Supermercado BuyMore", 3.50);
		this.controller.adicionaItemPorQuilo("Limao", "alimento nao industrializado", 1.0, "Supermercado Excepcional",
				4.19);

	}

	/**
	 * Metodo que testa o metodo getItem.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemValido() {
		preparaTests();
		assertEquals("4. Creme dental Oral-C, higiene pessoal, Preco: <Mercadinho Bem Barato, R$ 3,79;>",
				this.controller.getItem(1));
	}

	/**
	 * Metodo que testa o metodo getItem.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemValido2() {
		preparaTests();
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>",
				this.controller.getItem(0));
	}

	/**
	 * Metodo que testa o metodo getItem.
	 * 
	 * Esperado retorno vazio.
	 */
	@Test
	public void testGetItemAcima() {
		preparaTests();
		assertEquals("", this.controller.getItem(7));
	}

	/**
	 * Metodo que testa o metodo getItemPorCategoria.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemPorCategoriaValido() {
		preparaTests();
		assertEquals(
				"2. Peito de peru Saara, alimento industrializado, Preco por quilo: <Mercadinho Bem Barato, R$ 34,49;>",
				this.controller.getItemPorCategoria("alimento industrializado", 0));
	}

	/**
	 * Metodo que testa o metodo getItemPorCategoria.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemPorCategoriaValido2() {
		preparaTests();
		assertEquals("6. Esponja de Aco Assolange, limpeza, Preco: <Supermercado BuyMore, R$ 3,50;>",
				this.controller.getItemPorCategoria("limpeza", 1));
	}

	/**
	 * Metodo que testa o metodo getItemPorCategoria.
	 * 
	 * retorno vazio.
	 */
	@Test
	public void testGetItemPorCategoriaValidoVazio() {
		preparaTests();
		assertEquals("", this.controller.getItemPorCategoria("limpeza", 3));
	}

	/**
	 * Metodo que testa o metodo getItemPorMenorPreco.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemPorMenorPrecoValido() {
		preparaTests();
		assertEquals(
				"3. Queijo ralado Lebron, alimento industrializado, 50 grama, Preco: <Supermercado UauMart, R$ 1,59;>",
				this.controller.getItemPorMenorPreco(0));
	}

	/**
	 * Metodo que testa o metodo getItemPorMenorPreco.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemPorMenorPrecoValido2() {
		preparaTests();
		assertEquals("4. Creme dental Oral-C, higiene pessoal, Preco: <Mercadinho Bem Barato, R$ 3,79;>",
				this.controller.getItemPorMenorPreco(3));
	}

	/**
	 * Metodo que testa o metodo getItemPorMenorPreco.
	 * 
	 * Esperado retorno vazio.
	 */
	@Test
	public void testGetItemPorMenorPrecoValidoVazio() {
		preparaTests();
		assertEquals("", this.controller.getItemPorMenorPreco(10));
	}

	/**
	 * Metodo que testa o metodo getItemPorPesquisa.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemPorPesquisaValido() {
		preparaTests();
		assertEquals("4. Creme dental Oral-C, higiene pessoal, Preco: <Mercadinho Bem Barato, R$ 3,79;>",
				this.controller.getItemPorPesquisa("dental", 0));
	}

	/**
	 * Metodo que testa o metodo getItemPorPesquisa.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemPorPesquisaValido2() {
		preparaTests();
		assertEquals("5. Creme dental colgate, higiene pessoal, Preco: <Mercadinho Bem Barato, R$ 4,69;>",
				this.controller.getItemPorPesquisa("dental", 1));
	}

	/**
	 * Metodo que testa o metodo getItemPorPesquisa.
	 * 
	 * Esperado retorno vazio.
	 */
	@Test
	public void testGetItemPorPesquisaValidoVazio() {
		preparaTests();
		assertEquals("", this.controller.getItemPorPesquisa("dental", 3));
	}

	/**
	 * Metodo que testa o metodo pegaItem.
	 * 
	 * deve retornar um item.
	 */
	@Test
	public void testePegaItemValido() {
		assertEquals("Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>",
				this.controller.pegaItem(1, "Nao vai dar erro").toString());
	}

}