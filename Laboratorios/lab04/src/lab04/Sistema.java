package lab04;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Laboratório de Programação 2 - Lab 4
 * 
 * Representação de um Sistema de controle de dados. Gerencia todo o sistema e
 * possui a capacidade de armazenar os dados úteis inseridos pelo usuário, como
 * por exemplo, os alunos cadastrados, os grupos cadastrados e um histórico dos
 * alunos que responderam as pergunastas.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class Sistema {

	/**
	 * Estrutura de dados que armazena os alunos Cadastrados no sistema. A estrutura
	 * associa a matrícula(chave) ao objeto Aluno.
	 */
	private HashMap<String, Aluno> alunos;

	/**
	 * Estrutura de dados que aramzena os Grupos Cadastrados no sistema. A estrutura
	 * associa o nome(chave) ao objeto Grupo.
	 */
	private HashMap<String, Grupo> grupos;

	/**
	 * ArrayList que guarda os Objetos Alunos que responderam as perguntas feitas em
	 * sala pelo professor.
	 */
	private ArrayList<Aluno> respostas;

	/**
	 * Invoca o Construtor de Sistema. Não recebe nenhum parâmetro e cria uma
	 * Sistema com as estrutura de dados necessárias para armazenar os alunos,
	 * grupos e respostas.
	 */
	public Sistema() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.respostas = new ArrayList<>();
	}

	/**
	 * Método que cadastra um Aluno no Sistema. O contato é criado a partir da
	 * matrícula, nome e Curso.
	 * 
	 * @param matricula
	 *            Identificador numerico único de cada aluno.
	 * @param nome
	 *            Nome do Aluno a ser cadastrado.
	 * @param curso
	 *            Curso do aluno a ser cadastrado.
	 * @return Retorna um booleno true, caso o Aluno seja criado ou false, caso Não.
	 */
	public boolean cadastaAluno(String matricula, String nome, String curso) {
		if (this.alunos.containsKey(matricula)) {
			return false;
		}
		Aluno aluno = new Aluno(matricula, nome, curso);
		this.alunos.put(matricula, aluno);
		return true;
	}

	/**
	 * Método que pesquisa e exibe um aluno. Recebe a matricula do Aluno e retorna o
	 * aluno que conrresponde aquela matrícula.
	 * 
	 * @param matricula
	 *            Identificador numerico único do aluno a ser pesquisado.
	 * @return Retorna a representação do aluno pesquisado.
	 */
	public String exibeAluno(String matricula) {
		String resultado = "";

		if (this.alunos.containsKey(matricula)) {
			resultado = "Aluno: " + this.alunos.get(matricula).toString();
		} else {
			resultado = "Aluno não cadastrado.";
		}
		return resultado;
	}

	/**
	 * Método que cadastra um Grupo no Sistema. O Grupo é criado a partir do nome.
	 * 
	 * @param nome
	 *            Nome do Grupo a ser criado.
	 * @return Retorna um booleno true, caso o Aluno seja criado ou false, caso Não.
	 */
	public boolean cadastaGrupo(String nome) {
		if (grupos.containsKey(nome.toLowerCase())) {
			return false;
		}
		Grupo grupo = new Grupo(nome);
		this.grupos.put(nome.toLowerCase(), grupo);
		return true;
	}

	/**
	 * Método que insere um aluno em grupo existente. Recebe a matrícula do aluno e
	 * o nome do Grupo.
	 * 
	 * @param matricula
	 *            Identificador numerico único do aluno a ser Alocado.
	 * @param grupo
	 *            Nome do Grupo que receberá o aluno.
	 * @return Retorna uma representação que diz que o aluno foi Alocado.
	 */
	public String alocaGrupo(String matricula, String grupo) {
		String resultado;

		if (!grupos.containsKey(grupo.toLowerCase())) {
			return resultado = "Grupo não cadastrado.";
		}
		if (!this.alunos.containsKey(matricula)) {
			return resultado = "Aluno não cadastrado.";
		}

		this.grupos.get(grupo.toLowerCase()).addAluno(this.alunos.get(matricula));
		return resultado = "ALUNO ALOCADO!";
	}

	/**
	 * Método que gera uma String contendo a representação dos Alunos participam do
	 * grupo especificado.
	 * 
	 * @param grupo
	 *            Nome do grupo a ser Impresso.
	 * @return A representação em String dos alunos presente no grupo.
	 */
	public String imprimeGrupo(String grupo) {
		if (!grupos.containsKey(grupo.toLowerCase())) {
			return "Grupo não cadastrado.";
		}
		return this.grupos.get(grupo.toLowerCase()).toString();
	}

	/**
	 * Método que registra os alunos que responderam as perguntas feitas em sala.
	 * 
	 * @param matricula
	 *            Identificador numerico único do aluno que respondeu a pergunta.
	 * @return Retorna uma representação que diz que o aluno foi registrado.
	 */
	public String registraResposta(String matricula) {
		String resultado = "";
		if (!this.alunos.containsKey(matricula)) {
			return resultado = "Aluno não cadastrado.";
		}
		this.respostas.add(this.alunos.get(matricula));
		return resultado = "ALUNO REGISTRADO!";

	}

	/**
	 * Método que gera uma String contendo a representação dos Alunos que
	 * responderam as perguntas feitas em sala.
	 * 
	 * @return A representação em String dos alunos que responderam as perguntas.
	 */
	public String imprimeRespostas() {
		String resultado = "Alunos:" + System.lineSeparator();

		for (int i = 0; i < respostas.size(); i++) {
			resultado += (i + 1) + ". " + respostas.get(i).toString() + System.lineSeparator();
		}
		return resultado;

	}

}
