package comparatorsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comparators.ComparaPrecoTotal;
import entidades.ListaDeCompras;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 * 
 * Rotina de testes da classe comparaPrecoTotal.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ComparaPrecoTotalTest {

	/**
	 * listas criadas para testes.
	 */
	private ListaDeCompras lista1, lista2, lista3;

	/**
	 * Comparadores criado para testes.
	 */
	private ComparaPrecoTotal comparador, comparador2;

	/**
	 * Metodo que cria itens para testes.
	 */
	@Before
	public void PreparaCenario() {
		this.comparador = new ComparaPrecoTotal();
		this.lista1 = new ListaDeCompras("lista1");
		lista1.finalizarListaDeCompras("local1", 100);
		this.lista2 = new ListaDeCompras("lista2");
		lista2.finalizarListaDeCompras("local2", 120);
		this.lista3 = new ListaDeCompras("lista3");
		lista3.finalizarListaDeCompras("local3", 80);

	}

	/**
	 * Metodo que testa ComparaPrecoTotal quando o preco Total da primeira lista é menor que o
	 * da segunda lista.
	 */
	@Test
	public void testComparePrimeiro() {
		assertTrue(this.comparador.compare(lista1, lista2) < 0);
	}

	/**
	 * Metodo que testa ComparePrecoTotal quando preco Total da segunda lista é menor que o da
	 * segunda lista.
	 */
	@Test
	public void testCompareSegundo() {
		assertTrue(this.comparador.compare(lista2, lista3) > 0);
	}

	/**
	 * Metodo que testa ComparePrecoTotal quando o preco total das listas tem o mesmo preco.
	 */
	@Test
	public void testCompareIgual() {
		assertTrue(this.comparador.compare(lista2, lista2) == 0);
	}

	/**
	 * Metodo que testa o construtor de um comparador por preco Total.
	 */
	@Test
	public void testConstrutor() {
		assertTrue(comparador2 == null);
		comparador2 = new ComparaPrecoTotal();
		assertFalse(comparador2 == null);
	}

}
