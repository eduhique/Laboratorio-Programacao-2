package lab04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 4
 * 
 * Rotina de testes da classe Sistema.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class SistemaTest {

	/**
	 * Sistema criado para testes.
	 */
	private Sistema sistema;

	/**
	 * Método que prepara o sistema para Aluguns testes e cria uma grupo para
	 * testes.
	 */
	@Before
	public void preparaSistema() {
		this.sistema = new Sistema();
		this.sistema.cadastaGrupo("Prova");
	}

	/**
	 * Método que testa a criação de um objeto Sistema.
	 */
	@Test
	public void testSistema() {
		new Sistema();
	}

	/**
	 * Método que testa o cadastro de um aluno no Sistema.
	 */
	@Test
	public void testCadastaAluno() {
		assertTrue(this.sistema.cadastaAluno("250", "Gabryel Gomes", "Eng. Mecanica"));
	}

	/**
	 * Método que testa o cadastro de um aluno duas vezes. O teste do segundo
	 * cadastro deve retornar false.
	 */
	@Test
	public void testCadastaAlunoDuasVezes() {
		assertTrue(this.sistema.cadastaAluno("250", "Gabryel Gomes", "Eng. Mecanica"));
		assertFalse(this.sistema.cadastaAluno("250", "Gabryel Gomes", "Eng. Mecanica"));
	}

	/**
	 * Método que testa a exibição de um aluno do Sistema.
	 */
	@Test
	public void testExibeAluno() {
		this.sistema.cadastaAluno("250", "Gabryel Gomes", "Eng. Mecanica");
		assertEquals("Aluno: 250 - Gabryel Gomes - Eng. Mecanica", sistema.exibeAluno("250"));
	}

	/**
	 * Método que testa a exibição de um aluno não cadastrado. Deve retornar a
	 * mensagem "Aluno não cadastrado.".
	 */
	@Test
	public void testExibeNaoCadastrado() {
		assertEquals("Aluno não cadastrado.", sistema.exibeAluno("250"));
	}

	/**
	 * Método que testa o cadastro de um grupo.
	 */
	@Test
	public void testCadastaGrupo() {
		assertTrue(this.sistema.cadastaGrupo("Listas"));
	}

	/**
	 * Método que testa o cadastro de um Grupo duas vezes. O teste do segundo
	 * cadastro deve retornar false.
	 */
	@Test
	public void testCadastaGrupoDuasVezes() {
		assertTrue(this.sistema.cadastaGrupo("Listas"));
		assertFalse(this.sistema.cadastaGrupo("lISTAS"));
	}

	/**
	 * Método que testa a alocação de um aluno em grupo.
	 */
	@Test
	public void testAlocaGrupo() {
		this.sistema.cadastaAluno("250", "Gabryel Gomes", "Eng. Mecanica");
		String teste = this.sistema.alocaGrupo("250", "Prova");
		assertEquals("ALUNO ALOCADO!", teste);
	}

	/**
	 * Método que testa a alocação de um aluno em grupo não cadastrado. Deve
	 * retornar a mensagem "Grupo não cadastrado.".
	 */
	@Test
	public void testAlocaGrupoNaoCadastrado() {
		this.sistema.cadastaAluno("250", "Gabryel Gomes", "Eng. Mecanica");
		String teste = this.sistema.alocaGrupo("250", "Provas");
		assertEquals("Grupo não cadastrado.", teste);
	}

	/**
	 * Método que testa a alocação de um aluno não cadastrado em grupo. Deve
	 * retornar a mensagem "Aluno não cadastrado.".
	 */
	@Test
	public void testAlocaAlunoNaoCadastrado() {
		String teste = this.sistema.alocaGrupo("250", "Prova");
		assertEquals("Aluno não cadastrado.", teste);
	}

	/**
	 * Método que testa a impressão de um grupo.
	 */
	@Test
	public void testImprimeGrupo() {
		this.sistema.cadastaAluno("250", "Gabryel Gomes", "Eng. Mecanica");
		this.sistema.alocaGrupo("250", "Prova");
		assertEquals(System.lineSeparator() + "Grupo: Prova" + System.lineSeparator() + System.lineSeparator()
				+ "Alunos do grupo Prova:" + System.lineSeparator() + "* 250 - Gabryel Gomes - Eng. Mecanica"
				+ System.lineSeparator(), this.sistema.imprimeGrupo("Prova"));
	}

	/**
	 * Método que testa a impressão de um grupo não cadastrado. Deve retornar a
	 * mensagem "Grupo não cadastrado."
	 */
	@Test
	public void testImprimeGrupoNaoCadastrado() {
		assertEquals("Grupo não cadastrado.", this.sistema.imprimeGrupo("ProvaS"));
	}

	/**
	 * Método que testa o registro de respostas de um aluno.
	 */
	@Test
	public void testRegistraResposta() {
		this.sistema.cadastaAluno("250", "Gabryel Gomes", "Eng. Mecanica");
		String teste = this.sistema.registraResposta("250");
		assertEquals("ALUNO REGISTRADO!", teste);
	}

	/**
	 * Método que testa o registro de respostas de um aluno não cadastrado. Deve
	 * retornar a mensagem "Aluno não cadastrado.".
	 */
	@Test
	public void testRegistraRespostaAlunoNaoCadstrado() {
		String teste = this.sistema.registraResposta("255");
		assertEquals("Aluno não cadastrado.", teste);
	}

	/**
	 * Método que testa a impressão dos alunos que responderam.
	 */
	@Test
	public void testImprimeRespostas() {
		this.sistema.cadastaAluno("250", "Gabryel Gomes", "Eng. Mecanica");
		this.sistema.registraResposta("250");
		this.sistema.registraResposta("250");
		this.sistema.registraResposta("250");
		assertEquals(
				"Alunos:" + System.lineSeparator() + "1. 250 - Gabryel Gomes - Eng. Mecanica" + System.lineSeparator()
						+ "2. 250 - Gabryel Gomes - Eng. Mecanica" + System.lineSeparator()
						+ "3. 250 - Gabryel Gomes - Eng. Mecanica" + System.lineSeparator(),
				this.sistema.imprimeRespostas());
	}

}
