package entidadesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entidades.Item;
import entidades.ItemPorQuilo;

/**
 * 
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 *
 * Classe que testa os metodos da classe ItemPorQuilo.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ItemPorQuiloTest {

	// este atributo representa o objeto item.
	private Item item;

	/**
	 * Constrói o objeto item para ser usado nos testes.
	 */
	@Before
	public void construtorIdeal() {
		this.item = new ItemPorQuilo("Feijao Hulk", "alimento industrializado", 3.0, "Mercadinho#", 8.99, 1);
	}

	/**
	 * Constrói um item com nome vazio, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void nomeVazio() {
		this.item = new ItemPorQuilo("", "alimento industrializado", 2.0, "Mercadinho#", 2.99, 1);
	}

	/**
	 * Constrói um item com nome nulo, esperando uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void nomeNulo() {
		this.item = new ItemPorQuilo(null, "alimento industrializado", 2.0, "Mercadinho#", 2.99, 1);
	}

	/**
	 * Constrói um item com categoria vazia, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void categoriaVazia() {
		this.item = new ItemPorQuilo("Feijao Hulk", "", 2.0, "Mercadinho#", 2.99, 1);
	}

	/**
	 * Constrói um item com categoria invalida, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void categoriaInvalida() {
		this.item = new ItemPorQuilo("Agua", "liquido", 2.0, "Mercadinho#", 1.0, 1);
	}

	/**
	 * Constrói um item com categoria nula, esperando uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void categoriaNula() {
		this.item = new ItemPorQuilo("Agua", null, 2.0, "Mercadinho#", 1.0, 1);
	}

	/**
	 * Constrói um item com localDeCompra vazia, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void localDeCompraVazia() {
		this.item = new ItemPorQuilo("Agua", "limpeza", 2.0, "", 1.0, 1);
	}

	/**
	 * Constrói um item com localDeCompra nula, esperando uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void localDeCompraNula() {
		this.item = new ItemPorQuilo("Agua", "limpeza", 2.0, null, 1.0, 1);
	}

	/**
	 * Constroi um item com preco invalido, esperando uma esxcecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void precoInvalido() {
		this.item = new ItemPorQuilo("Agua", "limpeza", 2.0, "Mercadinho#", -3.5, 1);
	}

	/**
	 * Testa o método atualizaItem.
	 */
	@Test
	public void atualizaNomeECategoria() {
		this.item.atualizaItem("kg", "4");
		assertEquals("Feijao Hulk, alimento industrializado, Preco por quilo: <Mercadinho#, R$ 8,99;>",
				this.item.toString());

		this.item.atualizaItem("nome", "Carne de elefante");

		assertEquals("Carne de elefante, alimento industrializado, Preco por quilo: <Mercadinho#, R$ 8,99;>",
				this.item.toString());
	}

	/**
	 * Testa o método atualizaItem com categoria invalida, esperando a excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemCategoriaInvalida() {
		this.item.atualizaItem("categoria", "unidades");
	}

	/**
	 * Testa o metodo atualizaItem com kg invalido, eseprando uma excecao.
	 */

	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemKgInvalido() {
		this.item.atualizaItem("kg", "");
	}

	/**
	 * Testa o metodo atualizaItem com kg menor que zero, eseprando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemKgMenorQueZero() {
		this.item.atualizaItem("kg", "-1");
	}

	/**
	 * Testa o metodo atualizaItem com atributo invalido, eseprando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemAtributoInvalido() {
		this.item.atualizaItem("unidades", "10");
	}

	/**
	 * Testa o metodo de adicionar preco.
	 */
	@Test
	public void adicionaPrecoCorreto() {
		this.item.adicionaPrecoItem("Supermercado Concha", 5.89);
		assertEquals(
				"Feijao Hulk, alimento industrializado, Preco por quilo: <Supermercado Concha, R$ 5,89;Mercadinho#, R$ 8,99;>",
				this.item.toString());
	}

	/**
	 * Testa o metodo de adicionar preco com mercado vazio, esperando a excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void adicionaPrecoMercadoVazio() {
		this.item.adicionaPrecoItem("", 8.99);
	}

	/**
	 * Testa o metodo de adicionar preco com mercado nulo, esperando a excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void adicionaPrecoMercadoNulo() {
		this.item.adicionaPrecoItem(null, 8.99);
	}

	/**
	 * Testa o metodo de adicionar preco com preco invalido, esperando a excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void adicionaPrecoInvalido() {
		this.item.adicionaPrecoItem("Supermercado Bonus", -1.99);
	}

	/**
	 * Testa o método toString.
	 */
	@Test
	public void testeToString() {
		assertEquals("Feijao Hulk, alimento industrializado, Preco por quilo: <Mercadinho#, R$ 8,99;>",
				this.item.toString());
	}

	/**
	 * Testa o metodo getCategoria.
	 */
	@Test
	public void testGetCategoria() {
		assertEquals("alimento industrializado", this.item.getCategoria().getDescricao());
	}

	/**
	 * Testa o método getId.
	 */
	@Test
	public void testGetId() {
		assertEquals(1, this.item.getId());
	}

	/**
	 * Testa o método getListaPreco.
	 */
	@Test
	public void testGetListaPrecos() {
		assertEquals("<Mercadinho#, R$ 8,99;>", this.item.getListaPrecos());
	}

	/**
	 * Testa o método getNome.
	 */
	@Test
	public void testGetNome() {
		assertEquals("Feijao Hulk", this.item.getNome());
	}

	/**
	 * Testa o método getDescricao.
	 */
	@Test
	public void testGetDescricao() {
		assertEquals("Feijao Hulk, alimento industrializado", this.item.getDescricao());
	}

	/**
	 * Testa o método getEstabelecimentos.
	 */
	@Test
	public void testGetEstabelecimentos() {
		assertEquals("[Mercadinho#]", this.item.getEstabelecimentos().toString());
	}

	/**
	 * Testa o método getPreco.
	 */
	@Test
	public void testGetPreco() {
		assertEquals(8.99 + "", this.item.getPreco("Mercadinho#") + "");
		;
	}
}