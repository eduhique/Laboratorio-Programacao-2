package lab03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 3
 *
 * Rotina de testes da classe Contato.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ContatoTest {

	/**
	 * Contato criado para uso em testes.
	 */
	private Contato contato;

	/**
	 * Contato 2 criado para uso em testes.
	 */
	private Contato contato2;

	/**
	 * Contato 3 criado para uso em testes.
	 */
	private Contato contato3;

	/**
	 * Método que cria três Contatos para testes.
	 */
	@Before
	public void preparaContato() {
		this.contato = new Contato("Carlos", "Filho", new String[] { "Celular: (83) 90000-1111", null, null }, 1);
		this.contato2 = new Contato("Carlos", "Bezerra",
				new String[] { "Celular: (83) 90000-1111", "Casa: (83) 92222-1111", null }, 3);
		this.contato3 = new Contato("Eduardo", "Pontes",
				new String[] { "Celular: (83) 99999-0000", "Casa: (83) 92222-1111", "Trabalho: (83) 93333-1111" }, 5);
	}

	/**
	 * Método que testa o construtor contato usando apenas um número de telefone.
	 */
	@Test
	public void testContato() {
		new Contato("Eduardo", "Pontes", new String[] { "Celular: (83) 99999-0000", null, null }, 5);
	}

	/**
	 * Método que testa o construtor contato usando dois números de telefone.
	 */
	@Test
	public void testContatoDois() {
		new Contato("Eduardo", "Pontes", new String[] { "Celular: (83) 99999-0000", "Casa: (83) 92222-1111", null }, 4);
	}

	/**
	 * Método que testa o construtor contato usando três números de telefone.
	 */
	@Test
	public void testContatoTres() {
		new Contato("Eduardo", "Pontes",
				new String[] { "Celular: (83) 99999-0000", "Casa: (83) 92222-1111", "Trabalho: (83) 93333-1111" }, 1);
	}

	/**
	 * Método que testa o método equals, quando os contatos tem nomes iguais.
	 */
	@Test
	public void testContatosIguais() {
		assertTrue(contato.equals(contato2));
	}

	/**
	 * Método que testa o método equals, quando os contatos tem nomes diferentes.
	 */
	@Test
	public void testContatosDiferentes() {
		assertFalse(contato.equals(contato3));
	}

	/**
	 * Método que testa o método hashCode, quando os hashCodes são gerados a partir
	 * de contatos com nomes iguais.
	 */
	@Test
	public void testHashCodeIgual() {
		assertEquals(contato.hashCode(), contato2.hashCode());
	}

	/**
	 * Método que testa o método hashCode, quando os hashCodes são gerados a partir
	 * de contatos com nomes diferentes.
	 */
	@Test
	public void testHashCodeDiferente() {
		assertNotEquals(contato.hashCode(), contato3.hashCode());
	}

	/**
	 * Método que teste o construtor de Contato com um nome nulo.
	 */
	@Test(expected = RuntimeException.class)
	public void testContatoNomeNull() {
		new Contato(null, "Pontes", new String[] { "(83) 90000-1111", null, null }, 4);
	}

	/**
	 * Método que teste o construtor de Contato com um nome vázio.
	 */
	@Test(expected = RuntimeException.class)
	public void testContatoNomeVazio() {
		new Contato("", "Pontes", new String[] { "(83) 90000-1111", null, null }, 4);
	}

	/**
	 * Método que teste o construtor de Contato com um array de telefones com todas
	 * posições preenchidas com null.
	 */
	@Test(expected = RuntimeException.class)
	public void testContatoTelefoneNull() {
		new Contato("Eduardo", "Pontes", new String[] { null, null, null }, 3);
	}

	/**
	 * Método que teste o construtor de Contato com um array de telefones com todas
	 * posições preenchidas com vazio.
	 */
	@Test(expected = RuntimeException.class)
	public void testContatoTelefoneVazio() {
		new Contato("Eduardo", "Pontes", new String[] { "", "", "" }, 3);
	}

	/**
	 * Método que teste o construtor de Contato Inserindo um nível de Amizade Inválido, 0.
	 */
	@Test(expected = RuntimeException.class)
	public void testContatoNivelAmizade0() {
		new Contato("Eduardo", "Pontes", new String[] { "(83) 90000-1111", null, null }, 0);
	}
	
	/**
	 * Método que teste o construtor de Contato Inserindo um nível de Amizade Inválido acima de 5.
	 */
	@Test(expected = RuntimeException.class)
	public void testContatoNivelAmizadeAcima() {
		new Contato("Eduardo", "Pontes", new String[] { "(83) 90000-1111", null, null }, 6);
		new Contato("Eduardo", "Pontes", new String[] { "(83) 90000-1111", null, null }, 10);
	}
	
	/**
	 * Método que testa o toString com um contato que possui apenas um número de
	 * telefone e retorna a representação em string do contato.
	 */
	@Test
	public void testToStringContato() {
		assertEquals("Carlos Filho - Celular: (83) 90000-1111" + System.lineSeparator() + System.lineSeparator()
				+ "Nível de Amizade: Distante (1)" + System.lineSeparator(), contato.toString());
	}

	/**
	 * Método que testa o toString com um contato que possui dois números de
	 * telefone, e retorna a representação em string do contato.
	 */
	@Test
	public void testToStringContato2() {
		assertEquals(
				"Carlos Bezerra - Celular: (83) 90000-1111" + System.lineSeparator() + System.lineSeparator()
						+ "Nível de Amizade: Amigo (3)" + System.lineSeparator() + System.lineSeparator()
						+ "Outros Números deste Contato:" + System.lineSeparator() + "Casa: (83) 92222-1111",
				contato2.toString());
	}

	/**
	 * Método que testa o toString com um contato que possui três números de
	 * telefone e retorna a representação em string do contato.
	 */
	@Test
	public void testToStringContato3() {
		assertEquals("Eduardo Pontes - Celular: (83) 99999-0000" + System.lineSeparator() + System.lineSeparator()
				+ "Nível de Amizade: Irmão (5)" + System.lineSeparator() + System.lineSeparator()
				+ "Outros Números deste Contato:" + System.lineSeparator() + "Casa: (83) 92222-1111"
				+ System.lineSeparator() + "Trabalho: (83) 93333-1111", contato3.toString());
	}
}
