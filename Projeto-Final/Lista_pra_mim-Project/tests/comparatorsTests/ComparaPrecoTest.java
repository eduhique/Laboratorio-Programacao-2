package comparatorsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comparators.ComparaPreco;
import entidades.Item;
import entidades.ItemPorQuantidadeFixa;
import entidades.ItemPorQuilo;
import entidades.ItemPorUnidade;

/**
 * Laboratóoio de Programacao 2 - Lista pra mim© Project
 * 
 * Rotina de testes da classe comparaPreco.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ComparaPrecoTest {

	/**
	 * Itenscriado para testes.
	 */
	private Item item, item2, item3;
	/**
	 * Comparadores criado para testes.
	 */
	private ComparaPreco comparador, comparador2;

	/**
	 * Metodo que cria itens para testes.
	 */
	@Before
	public void PreparaCenario() {
		this.comparador = new ComparaPreco();
		this.item = new ItemPorQuantidadeFixa("Capsula Dois Coracoes", "alimento industrializado", 3, "capsulas",
				"Mercadinho++", 2.99, 1);
		this.item2 = new ItemPorQuilo("Feijao Hulk", "alimento industrializado", 3.0, "Mercadinho#", 8.99, 1);
		this.item3 = new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, "Mercadinho", 4.99, 1);
	}

	/**
	 * Metodo que testa ComparaPreco quando o preco do primeiro é menor que o do segundo
	 * item.
	 */
	@Test
	public void testComparePrimeiro() {
		assertTrue(this.comparador.compare(item, item2) < 0);
	}

	/**
	 * Metodo que testa ComparaPreco quando o preco segundo é maior que do terceiro item.
	 */
	@Test
	public void testCompareSegundo() {
		assertTrue(this.comparador.compare(item2, item3) > 0);
	}

	/**
	 * Metodo que testa ComparaPreco quando os itens tem o mesmo preco.
	 */
	@Test
	public void testCompareIgual() {
		assertTrue(this.comparador.compare(item2, item2) == 0);
	}

	/**
	 * Metodo que testa o construtor de um comparador por preco.
	 */
	@Test
	public void testConstrutor() {
		assertTrue(comparador2 == null);
		comparador2 = new ComparaPreco();
		assertFalse(comparador2 == null);
	}

}
