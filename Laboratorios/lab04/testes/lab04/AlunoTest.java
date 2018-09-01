package lab04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 2
 * 
 * Rotina de testes da classe Aluno.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class AlunoTest {

	/**
	 * Aluno criado para uso em testes.
	 */
	private Aluno aluno;

	/**
	 * ALuno 2 criado para uso em testes.
	 */
	private Aluno aluno2;

	/**
	 * Aluno 3 criado para uso em testes.
	 */
	private Aluno aluno3;

	/**
	 * Método que cria três Alunos para testes.
	 */
	@Before
	public void preparaAluno() {
		this.aluno = new Aluno("2017360", "Pedro Junior", "Eng. Elétrica");
		this.aluno2 = new Aluno("2017334", "Carlos Fernandes", "Computação");
		this.aluno3 = new Aluno("2017360", "Eduardo Pontes", "Computação");
	}

	/**
	 * Método que testa o construtor Aluno que cria um objeto aluno.
	 */
	@Test
	public void testAluno() {
		new Aluno("2017360", "Pedro junior", "Eng. Elétrica");
	}

	/**
	 * Método que teste o construtor de Aluno com uma matrícula Nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testAlunoMatriculaNulo() {
		new Aluno(null, "Pedro junior", "Eng. Elétrica");
	}

	/**
	 * Método que teste o construtor de Aluno com uma matrícula vázio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlunoMatriculaVazio() {
		new Aluno("", "Pedro junior", "Eng. Elétrica");
	}

	/**
	 * Método que teste o construtor de Aluno com um nome Nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testAlunoNomeNulo() {
		new Aluno("2017360", null, "Eng. Elétrica");
	}

	/**
	 * Método que teste o construtor de Aluno com um nome vázio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlunoNomeVazio() {
		new Aluno("2017360", "", "Eng. Elétrica");
	}

	/**
	 * Método que teste o construtor de Aluno com um Curso nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testAlunoCursoNulo() {
		new Aluno("2017360", "Pedro Junior", null);
	}

	/**
	 * Método que teste o construtor de Aluno com um curso vázio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlunoCursoVazio() {
		new Aluno("2017360", "Pedro Junior", "");
	}

	/**
	 * Método que testa o método equals, quando os Alunos tem a mesma matrícula.
	 */
	@Test
	public void testAlunosIguais() {
		aluno.equals(aluno3);
	}

	/**
	 * Método que testa o método equals, quando os Alunos tem as matrículas
	 * diferentes.
	 */
	@Test
	public void testAlunosDiferentes() {
		assertFalse(aluno.equals(aluno2));
	}

	/**
	 * Método que testa o método hashCode, quando os hashCodes são gerados a partir
	 * de Alunos que tem a mesma matrícula.
	 */
	@Test
	public void testHashCodeIguais() {
		assertEquals(aluno.hashCode(), aluno3.hashCode());
	}

	/**
	 * Método que testa o método hashCode, quando os hashCodes são gerados a partir
	 * de Alunos com matrículas diferentes.
	 */
	@Test
	public void testHashCodeDiferentes() {
		assertNotEquals(aluno.hashCode(), aluno2.hashCode());
	}

	/**
	 * Método que testa o toString de um aluno.
	 */
	@Test
	public void testToString() {
		assertEquals("2017360 - Pedro Junior - Eng. Elétrica", this.aluno.toString());
	}

}
