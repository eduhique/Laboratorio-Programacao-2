package comparatorsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comparators.ComparaDescritor;
import entidades.ListaDeCompras;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 * 
 * Rotina de testes da classe comparaDescritor.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */

public class ComparaDescritorTest {

	/**
	 * Listas de Compras criado para testes.
	 */
	private ListaDeCompras lista1, lista2, lista3;

	/**
	 * Comparadores criado para testes.
	 */
	private ComparaDescritor comparador, comparador2;

	/**
	 * Metodo que cria Lista de Compras para testes.
	 */
	@Before
	public void PreparaCenario() {
		this.comparador = new ComparaDescritor();
		this.lista1 = new ListaDeCompras("aaah");
		this.lista2 = new ListaDeCompras("beeh");
		this.lista3 = new ListaDeCompras("aah");
	}

	/**
	 * Metodo que testa Compare quando a lista1 vem primeiro que a lista2.
	 */
	@Test
	public void testComparePrimeiro() {
		assertTrue(this.comparador.compare(lista1, lista2) < 0);
	}

	/**
	 * Metodo que testa Compare quando a lista2 vem depois que a lista3.
	 */
	@Test
	public void testCompareSegundo() {
		assertTrue(this.comparador.compare(lista2, lista3) > 0);
	}

	/**
	 * Metodo que testa Compare quando as listas são iguais.
	 */
	@Test
	public void testCompareIgual() {
		assertTrue(this.comparador.compare(lista3, lista3) == 0);
	}

	/**
	 * Metodo que testa o construtor de um comparador de Descricoes de listas.
	 */
	@Test
	public void testConstrutor() {
		assertTrue(comparador2 == null);
		comparador2 = new ComparaDescritor();
		assertFalse(comparador2 == null);
	}

}
