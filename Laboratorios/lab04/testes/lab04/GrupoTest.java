package lab04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 2
 * 
 * Rotina de testes da classe Grupo.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class GrupoTest {

	/**
	 * Grupo criado para uso em testes.
	 */
	private Grupo grupo;

	/**
	 * Grupo 2 criado para uso em testes.
	 */
	private Grupo grupo2;

	/**
	 * Grupo 3 criado para uso em testes.
	 */
	private Grupo grupo3;

	/**
	 * Método que cria três Grupos para testes.
	 */
	@Before
	public void preparaGrupo() {
		this.grupo = new Grupo("Listas");
		this.grupo2 = new Grupo("Prova");
		this.grupo3 = new Grupo("Listas");
	}

	/**
	 * Método que testa o construtor Grupo que cria um objeto Grupo.
	 */
	@Test
	public void testGrupo() {
		new Grupo("Listas");
	}

	/**
	 * Método que testa o construtor Grupo com um nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGrupoNomeVazio() {
		new Grupo("");
	}

	/**
	 * Método que testa o construtor Grupo com um nome nulo.
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testGrupoNomeNulo() {
		new Grupo(null);
	}

	/**
	 * Método que testa a adição de um aluno em um grupo.
	 */
	@Test
	public void testAddAluno() {
		Aluno aluno = new Aluno("2017360", "Pedro Junior", "Eng. Elétrica");
		Grupo grupo = new Grupo("Listas");
		grupo.addAluno(aluno);
	}

	/**
	 * Método que testa o método equals, quando os grupos tem nomes iguais.
	 */
	@Test
	public void testGruposIguais() {
		grupo.equals(grupo3);
	}

	/**
	 * Método que testa o método equals, quando os grupos tem nomes diferentes.
	 */
	@Test
	public void testGruposDiferentes() {
		assertFalse(grupo.equals(grupo2));
	}

	/**
	 * Método que testa o método hashCode, quando os hashCodes são gerados a partir
	 * de grupos com nomes iguais.
	 */
	@Test
	public void testHashCodeIguais() {
		assertEquals(grupo.hashCode(), grupo3.hashCode());
	}

	/**
	 * Método que testa o método hashCode, quando os hashCodes são gerados a partir
	 * de grupos com nomes diferentes.
	 */
	@Test
	public void testHashCodeDiferentes() {
		assertNotEquals(grupo.hashCode(), grupo2.hashCode());
	}

	/**
	 * Método que testa o toString de um grupo.
	 */
	@Test
	public void testToString() {
		Aluno aluno = new Aluno("2017360", "Pedro Junior", "Eng. Elétrica");
		Aluno aluno1 = new Aluno("2017324", "Eduardo Pontes", "Computação");
		grupo.addAluno(aluno);
		grupo.addAluno(aluno1);

		assertEquals(System.lineSeparator() + "Grupo: Listas" + System.lineSeparator() + System.lineSeparator()
				+ "Alunos do grupo Listas:" + System.lineSeparator() + "* 2017360 - Pedro Junior - Eng. Elétrica"
				+ System.lineSeparator() + "* 2017324 - Eduardo Pontes - Computação" + System.lineSeparator(),
				this.grupo.toString());
	}

	/**
	 * Método que testa o toString de um grupo vazio.
	 */
	@Test
	public void testToStringVazio() {

		assertEquals(System.lineSeparator() + "Grupo: Listas" + System.lineSeparator() + System.lineSeparator()
				+ "Alunos do grupo Listas:" + System.lineSeparator(), this.grupo.toString());
	}
}
