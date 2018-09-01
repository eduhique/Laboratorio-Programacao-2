package lab03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 3
 *
 * Rotina de testes da classe Agenda.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class AgendaTest {

	/**
	 * Agenda criada para uso em testes.
	 */
	Agenda agenda;

	/**
	 * Agenda 2 criada para uso em testes.
	 */
	Agenda agenda2;

	/**
	 * Método que cadastra alguns contatos para testes.
	 */
	@Before
	public void testCadastaContatoPrepro() {
		agenda = new Agenda();
		agenda2 = new Agenda();
		agenda.cadastaContato(1, "Carlos", "Filho", new String[] { "Celular: (83) 90000-1111", null, null }, 2);
		agenda.cadastaContato(2, "Carlos", "Bezerra",
				new String[] { "Celular: (83) 90000-1111", "Casa: (83) 92222-1111", null }, 1);
		agenda.cadastaContato(20, "Eduardo", "Pontes",
				new String[] { "Celular: (83) 99999-0000", "Casa: (83) 92222-1111", "Trabalho: (83) 93333-1111" }, 3);
	}

	/**
	 * Método que testa o cadastro de um contato na agenda.
	 */
	@Test
	public void testCadastaContato() {
		agenda.cadastaContato(1, "Eduardo", "Pontes", new String[] { "Celular: (83) 90000-1111", null, null }, 5);
	}

	/**
	 * Método que testa o cadastro de um telefone em posição que já esta ocupada. O
	 * teste tem que ser bem sucedido.
	 */
	@Test
	public void testCadastaContatoDuasVezes() {
		agenda.cadastaContato(1, "Eduardo", "Pontes", new String[] { "Celular: (83) 90000-1111", null, null }, 3);
		agenda.cadastaContato(1, "Pedro", "Junior",
				new String[] { "Celular: (83) 98888-8888", "Trabalho: (83) 93333-1111", null }, 5);
	}

	/**
	 * Método que testa o cadastro de um contato na última posição da agenda.
	 */
	@Test
	public void testCadastaContatoLimite100() {
		agenda.cadastaContato(100, "Maria", "Gabriela", new String[] { "Celular: +1 (595) 5555-1234", null, null }, 4);
	}

	/**
	 * Método que testa o cadastro de um contato na primeira posição da agenda.
	 */
	@Test
	public void testCadastaContatoLimite1() {
		agenda.cadastaContato(1, "Maria", "Gabriela", new String[] { "Celular: +1 (595) 5555-1234", null, null }, 2);
	}

	/**
	 * Método que testa a pesquisa de um contato na agenda.
	 */
	@Test
	public void pesquisatPosicao() {
		String teste = agenda.pesquisaPosicao(1);
		assertEquals(teste, "Carlos Filho - Celular: (83) 90000-1111" + System.lineSeparator() + System.lineSeparator()
				+ "Nível de Amizade: Colega (2)" + System.lineSeparator());
	}

	/**
	 * Método que testa a pesquisa de um contato na agenda.
	 */
	@Test
	public void pesquisatPosicao2() {
		String teste = agenda.pesquisaPosicao(20);
		assertEquals(teste,
				"Eduardo Pontes - Celular: (83) 99999-0000" + System.lineSeparator() + System.lineSeparator()
						+ "Nível de Amizade: Amigo (3)" + System.lineSeparator() + System.lineSeparator()
						+ "Outros Números deste Contato:" + System.lineSeparator() + "Casa: (83) 92222-1111"
						+ System.lineSeparator() + "Trabalho: (83) 93333-1111");
	}

	/**
	 * Método que testa o cadastro de um contato em uma posição inválida acima do do
	 * limite.
	 */
	@Test(expected = RuntimeException.class)
	public void testCadastaContatoAcimaLimite() {
		agenda.cadastaContato(101, "Pedro", "Junior", new String[] { "Celular: (83) 98888-8888", null, null }, 1);
	}

	/**
	 * Método que testa o cadastro de um contato em uma posição inválida 0.
	 */
	@Test(expected = RuntimeException.class)
	public void testCadastaContatoNo0() {
		agenda.cadastaContato(0, "Pedro", "Junior", new String[] { "Celular: (83) 98888-8888", null, null }, 5);
	}

	/**
	 * Método que pesquisa um contato numa posição onde não há contato.
	 */
	@Test(expected = RuntimeException.class)
	public void pesquisatPosicaoNaoexiste() {
		agenda.pesquisaPosicao(3);
	}

	/**
	 * Método que pesquisa um contato em uma posição inválida acima do valor máximo,
	 * 100.
	 */
	@Test(expected = RuntimeException.class)
	public void pesquisatPosicaoAcima() {
		agenda.pesquisaPosicao(101);
	}

	/**
	 * Método que pesquisa um contato uma posição inválida 0.
	 */
	@Test(expected = RuntimeException.class)
	public void pesquisatPosicaoAbaixo() {
		agenda.pesquisaPosicao(0);
	}

	/**
	 * Método que testa o método equals, quando as agendas são iguais.
	 */
	@Test
	public void testAgendasIguais() {
		agenda2.cadastaContato(1, "Carlos", "Filho", new String[] { "Celular: (83) 90000-1111", null, null }, 2);
		agenda2.cadastaContato(2, "Carlos", "Bezerra",
				new String[] { "Celular: (83) 90000-1111", "Casa: (83) 92222-1111", null }, 1);
		agenda2.cadastaContato(20, "Eduardo", "Pontes",
				new String[] { "Celular: (83) 99999-0000", "Casa: (83) 92222-1111", "Trabalho: (83) 93333-1111" }, 3);
		assertTrue(agenda.equals(agenda2));
	}

	/**
	 * Método que testa o método equals, quando as agendas são diferentes.
	 */
	@Test
	public void testAgendasDiferentes() {
		agenda2.cadastaContato(1, "Carlos", "Filho", new String[] { "Celular: (83) 90000-1111", null, null }, 2);
		assertFalse(agenda.equals(agenda2));
	}

	/**
	 * Método que testa o método hashCode, quando hashCodes das agendas são iguais.
	 */
	@Test
	public void testHashCodeIgual() {
		agenda2.cadastaContato(1, "Carlos", "Filho", new String[] { "Celular: (83) 90000-1111", null, null }, 2);
		agenda2.cadastaContato(2, "Carlos", "Bezerra",
				new String[] { "Celular: (83) 90000-1111", "Casa: (83) 92222-1111", null }, 1);
		agenda2.cadastaContato(20, "Eduardo", "Pontes",
				new String[] { "Celular: (83) 99999-0000", "Casa: (83) 92222-1111", "Trabalho: (83) 93333-1111" }, 3);
		assertEquals(agenda.hashCode(), agenda2.hashCode());
	}

	/**
	 * Método que testa o método hashCode, quando os hashCodes das agendas são
	 * diferentes.
	 */
	@Test
	public void testHashCodeDiferente() {
		agenda2.cadastaContato(1, "Carlos", "Filho", new String[] { "Celular: (83) 90000-1111", null, null }, 2);
		agenda2.cadastaContato(20, "Eduardo", "Pontes",
				new String[] { "Celular: (83) 99999-0000", "Casa: (83) 92222-1111", "Trabalho: (83) 93333-1111" }, 1);
		assertNotEquals(agenda.hashCode(), agenda2.hashCode());
	}

	/**
	 * Método que testa o toString da agenda.
	 */
	@Test
	public void testToString() {
		String testeToString = "1 - Carlos Filho - Celular: (83) 90000-1111" + System.lineSeparator()
				+ System.lineSeparator() + "Nível de Amizade: Colega (2)" + System.lineSeparator()
				+ System.lineSeparator() + "--------------------------------------" + System.lineSeparator()
				+ "2 - Carlos Bezerra - Celular: (83) 90000-1111" + System.lineSeparator() + System.lineSeparator()
				+ "Nível de Amizade: Distante (1)" + System.lineSeparator() + System.lineSeparator()
				+ "Outros Números deste Contato:" + System.lineSeparator() + "Casa: (83) 92222-1111"
				+ System.lineSeparator() + "--------------------------------------" + System.lineSeparator()
				+ "20 - Eduardo Pontes - Celular: (83) 99999-0000" + System.lineSeparator() + System.lineSeparator()
				+ "Nível de Amizade: Amigo (3)" + System.lineSeparator() + System.lineSeparator()
				+ "Outros Números deste Contato:" + System.lineSeparator() + "Casa: (83) 92222-1111"
				+ System.lineSeparator() + "Trabalho: (83) 93333-1111" + System.lineSeparator()
				+ "--------------------------------------" + System.lineSeparator();
		assertEquals(testeToString, agenda.toString());
	}
}