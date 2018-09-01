package entidadesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entidades.Item;
import entidades.ItemPorUnidade;

/**
 * 
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 *
 * Classe que testa os metodos da classe ItemPorUnidade.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ItemPorUnidadeTest {

	// este atributo representa o objeto item.
	private Item item;

	/**
	 * Constroi o objeto item para ser usado nos testes.
	 */
	@Before
	public void construtorIdeal() {
		this.item = new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, "Mercadinho", 4.99, 1);
	}

	/**
	 * Constrói um item com nome vazio, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void nomeVazio() {
		this.item = new ItemPorUnidade("", "alimento industrializado", 1, "Mercadinho", 4.99, 1);
	}

	/**
	 * Constrói um item com nome nulo, esperando uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void nomeNulo() {
		this.item = new ItemPorUnidade(null, "alimento industrializado", 1, "Mercadinho", 4.99, 1);
	}

	/**
	 * Constrói um item com categoria vazia, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void categoriaVazia() {
		this.item = new ItemPorUnidade("Batata Roffles", "", 1, "Mercadinho", 4.99, 1);
	}

	/**
	 * Constrói um item com categoria invalida, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void categoriaInvalida() {
		this.item = new ItemPorUnidade("Batata Roffles", "ar", 1, "Mercadinho", 4.99, 1);
	}

	/**
	 * Constrói um item com categoria nula, esperando uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void categoriaNula() {
		this.item = new ItemPorUnidade("Batata Roffles", null, 1, "Mercadinho", 4.99, 1);
	}

	/**
	 * Constrói um item com localDeCompra vazia, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void localDeCompraVazia() {
		this.item = new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, "", 4.99, 1);
	}

	/**
	 * Constrói um item com localDeCompra nula, esperando uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void localDeCompraNula() {
		this.item = new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, null, 4.99, 1);
	}

	/**
	 * Constroi um item com preco invalido, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void precoInvalido() {
		this.item = new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, "Mercadinho", -1.99, 1);
	}

	/**
	 * Testa o método atualizaItem.
	 */
	@Test
	public void atualizaNomeECategoria() {
		this.item.atualizaItem("categoria", "alimento nao industrializado");
		assertEquals("Batata Roffles, alimento nao industrializado, Preco: <Mercadinho, R$ 4,99;>",
				this.item.toString());

		this.item.atualizaItem("nome", "Carne de elefante");

		assertEquals("Carne de elefante, alimento nao industrializado, Preco: <Mercadinho, R$ 4,99;>",
				this.item.toString());
	}

	/**
	 * Testa o método atualizaItem com categoria invalida, esperando a excecao
	 */
	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemCategoriaInvalida() {
		this.item.atualizaItem("categoria", "kg");
	}

	/**
	 * Testa o método atualizaItem com quantidade invalida, esperando a excecao
	 */
	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemQntInvalido() {
		this.item.atualizaItem("unidades", "");
	}

	/**
	 * Testa o método atualizaItem com quantidade menor que zero, esperando a
	 * excecao
	 */
	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemQntMenorQueZero() {
		this.item.atualizaItem("quantidade", "-1");
	}

	/**
	 * Testa o método atualizaItem com atributo invalido, esperando a excecao
	 */
	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemAtributoInvalido() {
		this.item.atualizaItem("kg", "10");
	}

	/**
	 * Testa o metodo de adicionar preco.
	 */
	@Test
	public void adicionaPrecoCorreto() {
		this.item.adicionaPrecoItem("Supermercado Concha", 5.89);
		assertEquals(
				"Batata Roffles, alimento industrializado, Preco: <Supermercado Concha, R$ 5,89;Mercadinho, R$ 4,99;>",
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
		assertEquals("Batata Roffles, alimento industrializado, Preco: <Mercadinho, R$ 4,99;>", this.item.toString());
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
		assertEquals("<Mercadinho, R$ 4,99;>", this.item.getListaPrecos());
	}

	/**
	 * Testa o método getNome.
	 */
	@Test
	public void testGetNome() {
		assertEquals("Batata Roffles", this.item.getNome());
	}

	/**
	 * Testa o método getDescricao.
	 */
	@Test
	public void testGetDescricao() {
		assertEquals("Batata Roffles, alimento industrializado", this.item.getDescricao());
	}

	/**
	 * Testa o método getEstabelecimentos.
	 */
	@Test
	public void testGetEstabelecimentos() {
		item.adicionaPrecoItem("casa", 3.99);
		assertEquals("[casa, Mercadinho]", this.item.getEstabelecimentos().toString());
	}

	/**
	 * Testa o método getPreco.
	 */
	@Test
	public void testGetPreco() {
		item.adicionaPrecoItem("casa", 3.99);
		assertEquals(3.99 + "", this.item.getPreco("casa") + "");
	}
}