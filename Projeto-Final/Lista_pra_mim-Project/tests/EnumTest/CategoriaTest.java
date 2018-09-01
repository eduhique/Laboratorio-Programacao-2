package EnumTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Enum.Categoria;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 *
 * Rotina de testes do Enum Categoria.
 *
 * @author Rafael Dantas Santos de Azevedo - 117210382
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Dantas Santos de Azevedo - 117210382
 */

public class CategoriaTest {

	private Categoria higiene = Categoria.HIGIENEPESSOAL;
	private Categoria limpeza = Categoria.LIMPEZA;
	private Categoria industrialisados = Categoria.ALIMENTOINDUSTRIALIZADO;
	private Categoria naoInsdustrializados = Categoria.ALIMENTONAOINDUSTRIALIZADO;

	/**
	 * Testa a recuperaco do valor da constante HIGIENEPESSOAL.
	 */
	@Test
	public void testGetDescricao() {
		assertEquals("higiene pessoal", higiene.getDescricao());
	}

	/**
	 * Testa a recuperaco do valor da constante LIMPEZA.
	 */
	@Test
	public void testGetDescricao2() {
		assertEquals("limpeza", limpeza.getDescricao());
	}

	/**
	 * Testa a recuperacao do valor da constante ALIMENTOINDUSTRIALIZADO.
	 */
	@Test
	public void testGetDescricao3() {
		assertEquals("alimento industrializado", industrialisados.getDescricao());
	}

	/**
	 * Testa a recuperaco do valor da constante ALIMENTOSNAOINDUSTRIALIZADOS.
	 */
	@Test
	public void testGetDescricao4() {
		assertEquals("alimento nao industrializado", naoInsdustrializados.getDescricao());
	}

}
