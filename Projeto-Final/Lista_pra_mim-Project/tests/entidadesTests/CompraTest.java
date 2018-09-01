package entidadesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Enum.Categoria;
import entidades.Compra;
import entidades.Item;
import entidades.ItemPorQuantidadeFixa;
import entidades.ItemPorQuilo;
import entidades.ItemPorUnidade;

/**
 * 
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 *
 * Classe que testa os metodos da classe Compra.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class CompraTest {

	// Instanciacao de um objeto compra.
	private Compra compra, outraCompra;
	// Instanciacao de itens.
	private Item itemPQF, itemPQ, itemPU;
	/**
	 * Metodo que inicializa itens.
	 * 
	 * Nenhum erro esperado.
	 */
	@Before
	public void inicializa() {
		itemPQF = new ItemPorQuantidadeFixa("Agua Sanitaria Drogon", "limpeza", 1, "l", "Supermercado Excepcional",
				2.19, 1);
		itemPQ = new ItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, "Mercadinho Bem Barato",
				34.49, 2);
		itemPU = new ItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79, 3);
	}

	/**
	 * Metodo que testa o construtor de uma compra valida.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testCompraValido1() {
		assertTrue(compra == null);
		compra = new Compra(1, itemPQF);
		assertTrue(compra != null);
	}

	/**
	 * Metodo que testa o construtor de uma compra valida.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testCompraValido2() {
		assertTrue(compra == null);
		compra = new Compra(10, itemPQ);
		assertTrue(compra != null);
	}

	/**
	 * Metodo que testa o construtor de uma compra valida.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testCompraValido3() {
		assertTrue(compra == null);
		compra = new Compra(100, itemPU);
		assertTrue(compra != null);
	}

	/**
	 * Metodo que testa o construtor de uma compra invalida.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCompraInvalido1() {
		compra = new Compra(0, itemPU);
	}

	/**
	 * Metodo que testa o construtor de uma compra invalida.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCompraInvalido2() {
		compra = new Compra(-1, itemPU);
	}

	/**
	 * Metodo que testa o metodo atualizaCompra com parametros validos.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAtualizaCompraValido1() {
		compra = new Compra(1, itemPQF);
		assertTrue(compra.getQuantidade() == 1);
		compra.atualizaCompra("adiciona", 1);
		assertTrue(compra.getQuantidade() == 2);
	}

	/**
	 * Metodo que testa o metodo atualizaCompra com parametros validos.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAtualizaCompraValido2() {
		compra = new Compra(2, itemPQF);
		assertTrue(compra.getQuantidade() == 2);
		compra.atualizaCompra("diminui", 1);
		assertTrue(compra.getQuantidade() == 1);
	}

	/**
	 * Metodo que testa o metodo atualizaCompra com parametros validos.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraInvalido1() {
		compra = new Compra(2, itemPQF);
		compra.atualizaCompra("multiplica", 1);
	}

	/**
	 * Metodo que testa o metodo atualizaCompra com parametros validos.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraInvalido2() {
		compra = new Compra(2, itemPQF);
		compra.atualizaCompra("adiciona", 0);
	}

	/**
	 * Metodo que testa o metodo atualizaCompra com parametros validos.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraInvalido3() {
		compra = new Compra(2, itemPQF);
		compra.atualizaCompra("adiciona", -1);
	}

	/**
	 * Metodo que retorna a quantidade de itens de uma compra.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetQuantidade() {
		compra = new Compra(1, itemPU);
		assertTrue(compra.getQuantidade() == 1);
	}

	/**
	 * Metodo que retorna um item de uma compra.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItem() {
		compra = new Compra(1, itemPU);
		assertTrue(compra.getItem() == itemPU);
	}

	/**
	 * Metodo que retorna a categoria de um item de uma compra.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemCategoria() {
		compra = new Compra(1, itemPQF);
		assertEquals(Categoria.LIMPEZA, compra.getItemCategoria());
	}

	/**
	 * Metodo que retorna a descricao de um item de uma compra.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemDescricao1() {
		compra = new Compra(1, itemPQF);
		assertEquals("Agua Sanitaria Drogon, limpeza, 1 l", compra.getItemDescricao());
	}

	/**
	 * Metodo que retorna a descricao de um item de uma compra.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemDescricao2() {
		compra = new Compra(1, itemPQ);
		assertEquals("Peito de peru Saara, alimento industrializado", compra.getItemDescricao());
	}

	/**
	 * Metodo que retorna a descricao de um item de uma compra.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemDescricao3() {
		compra = new Compra(1, itemPU);
		assertEquals("Creme dental Oral-C, higiene pessoal", compra.getItemDescricao());
	}

	/**
	 * Metodo que testa o metodo equals de uma compra.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testEqualsObject1() {
		compra = new Compra(1, itemPQF);
		outraCompra = new Compra(1, itemPQF);

		assertEquals(compra.toString(), outraCompra.toString());
	}

	/**
	 * Metodo que testa o metodo equals de uma compra.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testEqualsObject2() {
		compra = new Compra(1, itemPQF);
		outraCompra = new Compra(1, itemPU);

		assertTrue(!compra.toString().equals(outraCompra.toString()));
	}

	/**
	 * Metodo que testa o metodo toString de uma compra.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testToString1() {
		compra = new Compra(1, itemPQ);
		assertEquals("1 Peito de peru Saara, alimento industrializado", compra.toString());
	}

	/**
	 * Metodo que testa o metodo toString de uma compra.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testToString2() {
		compra = new Compra(1, itemPQF);
		assertEquals("1 Agua Sanitaria Drogon, limpeza, 1 l", compra.toString());
	}

	/**
	 * Metodo que testa o metodo toString de uma compra.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testToString3() {
		compra = new Compra(1, itemPU);
		assertEquals("1 Creme dental Oral-C, higiene pessoal", compra.toString());
	}

	/**
	 * Testa o método getEstabelecimentos.
	 */
	@Test
	public void testGetEstabelecimentos() {
		itemPU.adicionaPrecoItem("Feira - Prata", 10);
		compra = new Compra(1, itemPU);
		assertEquals("[Mercadinho Bem Barato, Feira - Prata]", this.compra.getEstabelecimentos().toString());
	}

}
