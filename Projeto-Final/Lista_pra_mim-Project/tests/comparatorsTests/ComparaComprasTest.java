package comparatorsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comparators.ComparaCompras;
import entidades.Compra;
import entidades.ItemPorQuantidadeFixa;
import entidades.ItemPorQuilo;
import entidades.ItemPorUnidade;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 * 
 * Rotina de testes da classe comparaCompras.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */

public class ComparaComprasTest {

	/**
	 * Compras criados para testes.
	 */
	private Compra compra1, compra2, compra3;

	/**
	 * Comparadores criado para testes.
	 */
	private ComparaCompras comparador, comparador2;

	/**
	 * Metodo que cria itens para testes.
	 */
	@Before
	public void PreparaCenario() {
		this.comparador = new ComparaCompras();
		this.compra1 = new Compra(2, new ItemPorQuantidadeFixa("Capsula Dois Coracoes", "alimento industrializado", 3,
				"capsulas", "Mercadinho++", 2.99, 1));
		this.compra2 = new Compra(2,
				new ItemPorQuilo("Feijao Hulk", "alimento industrializado", 3.0, "Mercadinho#", 8.99, 1));
		this.compra3 = new Compra(2,
				new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, "Mercadinho", 4.99, 1));
	}

	/**
	 * Metodo que testa Compare quando compra1 vem primeiro que a compra2.
	 */
	@Test
	public void testComparePrimeiro() {
		assertTrue(this.comparador.compare(compra1, compra2) < 0);
	}

	/**
	 * Metodo que testa Compare quando compra2 vem primeiro que a compra3.
	 */
	@Test
	public void testCompareSegundo() {
		assertTrue(this.comparador.compare(compra2, compra3) > 0);
	}

	/**
	 * Metodo que testa Compare quando as compras são iguais.
	 */
	@Test
	public void testCompareIgual() {
		assertTrue(this.comparador.compare(compra2, compra2) == 0);
	}

	/**
	 * Metodo que testa o construtor de um comparador de compras.
	 */
	@Test
	public void testConstrutor() {
		assertTrue(comparador2 == null);
		comparador2 = new ComparaCompras();
		assertFalse(comparador2 == null);
	}

}
