package comparatorsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comparators.ComparaTempo;
import entidades.Item;
import entidades.ItemPorQuantidadeFixa;
import entidades.ItemPorQuilo;
import entidades.ItemPorUnidade;
import entidades.ListaDeCompras;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 * 
 * Rotina de testes da classe comparaTempo.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ComparaTempoTest {

	/**
	 * Listas criadas para testes.
	 */
	private ListaDeCompras lista1, lista2, lista3;

	/**
	 * Comparadores criado para testes.
	 */
	private ComparaTempo comparador, comparador2;

	/**
	 * Metodo que cria itens para testes.
	 */
	@Before
	public void PreparaCenario() {
		Item item = new ItemPorQuantidadeFixa("Capsula Dois Coracoes", "alimento industrializado", 3, "capsulas",
				"Mercadinho++", 2.99, 1);
		Item item2 = new ItemPorQuilo("Feijao Hulk", "alimento industrializado", 3.0, "Mercadinho#", 8.99, 1);
		Item item3 = new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, "Mercadinho", 4.99, 1);
		this.comparador = new ComparaTempo();

		this.lista1 = new ListaDeCompras("lista1");
		lista1.adicionaCompraALista(100, item);
		lista1.adicionaCompraALista(100, item2);
		lista1.adicionaCompraALista(100, item3);
		this.lista2 = new ListaDeCompras("lista2");
		lista2.adicionaCompraALista(100, item);
		lista2.adicionaCompraALista(100, item2);
		lista2.adicionaCompraALista(100, item3);
		this.lista3 = new ListaDeCompras("lista3");
		lista3.adicionaCompraALista(100, item);
		lista3.adicionaCompraALista(100, item2);
		lista3.adicionaCompraALista(100, item3);

	}

	/**
	 * Metodo que testa CompareTempo quando a primeira lista foi criada antes da segunda lista.
	 */
	@Test
	public void testComparePrimeiro() {
		assertEquals(-1, this.comparador.compare(lista1, lista2));
	}

	/**
	 * Metodo que testa Compare quando a segunda lista foi criada antes da segunda lista.
	 */
	@Test
	public void testCompareSegundo() {
		assertEquals(-1, this.comparador.compare(lista2, lista3));
	}

	/**
	 * Metodo que testa Compare quando o comparamos a mesma lista.
	 */
	@Test
	public void testCompareIgual() {
		assertEquals(0, this.comparador.compare(lista2, lista2));
	}

	/**
	 * Metodo que testa o construtor de um comparador por tempo.
	 */
	@Test
	public void testConstrutor() {
		assertNull(comparador2);
		comparador2 = new ComparaTempo();
		assertNotNull(comparador2);
	}

}
