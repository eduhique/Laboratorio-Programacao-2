package entidadesTests;

import org.junit.Before;
import org.junit.Test;

import entidades.Item;
import entidades.ItemPorQuantidadeFixa;

import static org.junit.Assert.*;

/**
 * 
 * Laboratório de Programação 2 - Lista pra mim© Project
 *
 * Classe que testa os metodos da classe ItemPorQuantidadeFixa.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ItemPorQuantidadeFixaTest {

	// este atributo representa o objeto item.
	private Item item;

	/***
	 * Constroi o objeto item para ser usado nos testes.
	 */
	@Before
	public void construtorIdeal() {
		this.item = new ItemPorQuantidadeFixa("Capsula Dois Coracoes", "alimento industrializado", 3, "capsulas",
				"Mercadinho++", 2.99, 1);
	}

	/**
	 * Constroi um item com nome vazio, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void nomeVazio() {
		this.item = new ItemPorQuantidadeFixa("", "alimento industrializado", 3, "capsulas", "Mercadinho++", 2.99, 1);
	}

	/**
	 * Constroi um item com nome nulo, esperando uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void nomeNulo() {
		this.item = new ItemPorQuantidadeFixa(null, "alimento industrializado", 3, "capsulas", "Mercadinho++", 2.99, 1);
	}

	/**
	 * Constroi um item com categoria vazia, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void categoriaVazia() {
		this.item = new ItemPorQuantidadeFixa("Queijo ralado Python", "", 3, "capsulas", "Mercadinho++", 2.99, 1);
	}

	/**
	 * Constroi um item com categoria invalida, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void categoriaInvalida() {
		this.item = new ItemPorQuantidadeFixa("Queijo ralado Python", "suco", 3, "capsulas", "Mercadinho++", 2.99, 1);
	}

	/**
	 * Constroi um item com categoria nula, esperando uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void categoriaNula() {
		this.item = new ItemPorQuantidadeFixa("Queijo ralado Python", null, 3, "capsulas", "Mercadinho++", 2.99, 1);
	}

	/**
	 * Constroi um item com localDeCompra vazia, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void localDeCompraVazia() {
		this.item = new ItemPorQuantidadeFixa("Queijo ralado Python", "alimento industrializado", 3, "capsulas", "",
				2.99, 1);
	}

	/**
	 * Constroi um item com localDeCompra nula, esperando uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void localDeCompraNula() {
		this.item = new ItemPorQuantidadeFixa("Queijo ralado Python", "alimento industrializado", 3, "capsulas", null,
				2.99, 1);
	}

	/**
	 * Constroi um item com quantidade invalida, esperando a excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void quantidadeInvalida() {
		this.item = new ItemPorQuantidadeFixa("Esponja de Aco da Solange", "limpeza", -1, "capsulas", "Mercadinho++",
				2.99, 1);
	}

	/**
	 * Constroi um item com preco invalido, esperando uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void precoInvalido() {
		this.item = new ItemPorQuantidadeFixa("Esponja de Aco da Solange", "limpeza", -1, "capsulas", "Mercadinho++",
				2.99, 1);
	}

	/**
	 * Testa o metodo atualizaItem.
	 */
	@Test
	public void atualizaNomeQuantidadeCategoria() {
		this.item.atualizaItem("quantidade", "20");
		assertEquals("Capsula Dois Coracoes, alimento industrializado, 20 capsulas, Preco: <Mercadinho++, R$ 2,99;>",
				this.item.toString());

		this.item.atualizaItem("categoria", "alimento nao industrializado");
		assertEquals(
				"Capsula Dois Coracoes, alimento nao industrializado, 20 capsulas, Preco: <Mercadinho++, R$ 2,99;>",
				this.item.toString());

		this.item.atualizaItem("nome", "Capsula Dois Pulmoes");

		assertEquals("Capsula Dois Pulmoes, alimento nao industrializado, 20 capsulas, Preco: <Mercadinho++, R$ 2,99;>",
				this.item.toString());
	}

	/**
	 * Testa o metodo atualizaItem com categoria invalida, esperando a excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemCategoriaInvalida() {
		this.item.atualizaItem("categoria", "kg");
	}

	/**
	 * Testa o metodo atualizaItem com quantidade invalida, esperando a excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemQuantidadeInvalido() {
		this.item.atualizaItem("quantidade", "kg");
	}

	/**
	 * Testa o metodo atualizaItem com quantidade menor que zero, esperando a
	 * excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemQuantidadeMenorQueZero() {
		this.item.atualizaItem("quantidade", "-1");
	}

	/**
	 * Testa o atualiza unidade de medida.
	 */
	@Test
	public void atualizaItemUnidadeDeMedida() {
		this.item.atualizaItem("unidade de medida", "kg");
		assertEquals("Capsula Dois Coracoes, alimento industrializado, 3 kg, Preco: <Mercadinho++, R$ 2,99;>",
				this.item.toString());
	}

	/**
	 * Testa o atualiza item com unidade de medida vazia, esperando a excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void atualizaItemUnidadeDeMedidaVazio() {
		this.item.atualizaItem("unidade de medida", "");
	}

	/**
	 * Testa o atualiza item com unidade de medida nula, esperando a excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void atualizaItemUnidadeDeMedidaNula() {
		this.item.atualizaItem("unidade de medida", null);
	}

	/**
	 * Testa o metodo de adicionar preco.
	 */
	@Test
	public void adicionaPrecoCorreto() {
		this.item.adicionaPrecoItem("Supermercado Concha", 5.89);
		assertEquals(
				"Capsula Dois Coracoes, alimento industrializado, 3 capsulas, Preco: <Supermercado Concha, R$ 5,89;Mercadinho++, R$ 2,99;>",
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
	 * Testa o metodo toString.
	 */
	@Test
	public void testeToString() {
		assertEquals("Capsula Dois Coracoes, alimento industrializado, 3 capsulas, Preco: <Mercadinho++, R$ 2,99;>",
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
	 * Testa o metodo getId.
	 */
	@Test
	public void testGetId() {
		assertEquals(1, this.item.getId());
	}

	/**
	 * Testa o metodo getListaPreco.
	 */
	@Test
	public void testGetListaPrecos() {
		assertEquals("<Mercadinho++, R$ 2,99;>", this.item.getListaPrecos());
	}

	/**
	 * Testa o metodo getNome.
	 */
	@Test
	public void testGetNome() {
		assertEquals("Capsula Dois Coracoes", this.item.getNome());
	}

	/**
	 * Testa o metodo getDescricao.
	 */
	@Test
	public void testGetDescricao() {
		assertEquals("Capsula Dois Coracoes, alimento industrializado, 3 capsulas", this.item.getDescricao());
	}

	/**
	 * Testa o metodo getEstabelecimentos.
	 */
	@Test
	public void testGetEstabelecimentos() {
		item.adicionaPrecoItem("casa", 3.99);
		assertEquals("[casa, Mercadinho++]", this.item.getEstabelecimentos().toString());
	}

	/**
	 * Testa o metodo getPreco.
	 */
	@Test
	public void testGetPreco() {
		item.adicionaPrecoItem("casa", 3.99);
		assertEquals(2.99 + "", this.item.getPreco("Mercadinho++") + "");
	}
}