package comparatorsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comparators.ComparaNome;
import entidades.Item;
import entidades.ItemPorQuantidadeFixa;
import entidades.ItemPorQuilo;
import entidades.ItemPorUnidade;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 * 
 * Rotina de testes da classe comparaNome.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ComparaNomeTest {

	/**
	 * Itens criado para testes.
	 */
	private Item item, item2, item3;

	/**
	 * Comparadores criado para testes.
	 */
	private ComparaNome comparador, comparador2;

	/**
	 * Metodo que cria itens para testes.
	 */
	@Before
	public void PreparaCenario() {
		this.comparador = new ComparaNome();
		this.item = new ItemPorQuantidadeFixa("Capsula Dois Coracoes", "alimento industrializado", 3, "capsulas",
				"Mercadinho++", 2.99, 1);
		this.item2 = new ItemPorQuilo("Feijao Hulk", "alimento industrializado", 3.0, "Mercadinho#", 8.99, 1);
		this.item3 = new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, "Mercadinho", 4.99, 1);
	}

	/**
	 * Metodo que testa Compare quando o primeiro item vem primeiro que o segundo
	 * item.
	 */
	@Test
	public void testComparePrimeiro() {
		assertTrue(this.comparador.compare(item, item2) < 0);
	}

	/**
	 * Metodo que testa Compare quando o primeiro item vem depois que o terceiro
	 * item.
	 */
	@Test
	public void testCompareSegundo() {
		assertTrue(this.comparador.compare(item, item3) > 0);
	}

	/**
	 * Metodo que testa Compare quando os itens são iguais.
	 */
	@Test
	public void testCompareIgual() {
		assertTrue(this.comparador.compare(item2, item2) == 0);
	}

	/**
	 * Metodo que testa o construtor de um comparador por Nome.
	 */
	@Test
	public void testConstrutor() {
		assertTrue(comparador2 == null);
		comparador2 = new ComparaNome();
		assertFalse(comparador2 == null);
	}

}
