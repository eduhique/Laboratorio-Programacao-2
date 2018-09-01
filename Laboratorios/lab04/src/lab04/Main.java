package lab04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 4
 * 
 * Clase principal de um controle de alunos de Programação II. O programa será
 * excutado pelo menos uma vez e Possui a capacidade de cadastrar e consultar
 * alunos; criar grupos e gerencia-lós.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class Main {

	/**
	 * Método principal Main que possui a capacidade de receber comandos do úsuario,
	 * tais como cadastrar aluno, exibir, cria grupos, aloca alunos em grupos,
	 * imprime os alunos de um determinado grupo, registra os alunos que responderam
	 * as perguntas feitas em sala, imprime os alunos que responderam e sair da
	 * agenda. Além disso imprime mensagens úteis e de alerta para o úsuario.
	 * 
	 * @param args
	 *            Agumentos iniciais.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sistema sistema = new Sistema();
		String entrada;
		try {

			do {
				System.out
						.print("(C)adastrar Aluno" + System.lineSeparator() + "(E)xibir Aluno" + System.lineSeparator()
								+ "(N)ovo Grupo" + System.lineSeparator() + "(A)locar Aluno no Grupo e Imprimir Grupos"
								+ System.lineSeparator() + "(R)egistrar Aluno que Respondeu" + System.lineSeparator()
								+ "(I)mprimir Alunos que Respondera" + System.lineSeparator()
								+ "(O)ra, vamos fechar o programa!" + System.lineSeparator() + System.lineSeparator()
								+ "Opção> ");

				entrada = sc.nextLine().trim().toUpperCase();

				switch (entrada) {
				case "C":
					cadastraAluno(sc, sistema);
					break;
				case "E":
					exibeAluno(sc, sistema);
					break;
				case "N":
					criaGrupo(sc, sistema);
					break;
				case "A":
					alocaImprime(sc, sistema);
					break;
				case "R":
					registraResposta(sc, sistema);
					break;
				case "I":
					imprimirRespostas(sistema);
					break;
				case "O":
					break;
				default:
					System.out.println(System.lineSeparator() + "Entrada Inválida!" + System.lineSeparator());
				}
			} while (!(entrada.equals("O")));
		} catch (RuntimeException e) {
			System.out.println(System.lineSeparator() + e.getMessage() + System.lineSeparator() + System.lineSeparator()
					+ "PROGRAMA ENCERRADO!");
		}

	}

	/**
	 * Método que cadastra um Aluno no Sistema. Recebe as entradas do usuário e
	 * chama o método da classe Sistema que cadastra um aluno.
	 * 
	 * @param sc
	 *            Scanner que lê a entrada do úsuario.
	 * @param sistema
	 *            Sistema de Controle responsável por armazenar os dados e controlar
	 *            o fluxo do sistema.
	 */
	private static void cadastraAluno(Scanner sc, Sistema sistema) {
		System.out.print(System.lineSeparator() + "Matrícula: ");
		String matricula = validaMatricula(sc);

		System.out.print("Nome: ");

		String nome = sc.nextLine().trim();

		System.out.print("Curso: ");
		String curso = sc.nextLine().trim();

		if (sistema.cadastaAluno(matricula, nome, curso)) {
			System.out.println(System.lineSeparator() + "CADASTRO REALIZADO!" + System.lineSeparator());
		} else {
			System.out.println(System.lineSeparator() + "MATRÍCULA JÁ CADASTRADA!" + System.lineSeparator());
		}
	}

	/**
	 * Método auxiliar que valida o valor inserido como matrícula pelo usuário. A
	 * matricula tem que ser um valor numerico único de cada Aluno. Recebe um valor
	 * inteiro e converte para String após a validação.
	 * 
	 * @param sc
	 *            Scanner que lê a entrada do úsuario.
	 * @return Retorna a matrícula do aluno que foi devidamente validada.
	 */
	private static String validaMatricula(Scanner sc) {
		int matricula;
		try {
			matricula = sc.nextInt();

		} catch (InputMismatchException e) {
			sc.nextLine();
			throw new InputMismatchException("ENTRADA INVALIDA!");
		}
		sc.nextLine();

		if (matricula < 0) {
			throw new IllegalArgumentException("Insira uma Matrícula Válida!");
		}

		return String.valueOf(matricula);
	}

	/**
	 * Método que exibe um Aluno. Recebe a entrada do usuário e chama o método da
	 * classe Sistema que pesquisa e exibe o Aluno.
	 * 
	 * @param sc
	 *            Scanner que lê a entrada do úsuario.
	 * @param sistema
	 *            Sistema de Controle responsável por armazenar os dados e controlar
	 *            o fluxo do sistema.
	 */
	private static void exibeAluno(Scanner sc, Sistema sistema) {
		System.out.print(System.lineSeparator() + "Matrícula: ");
		String matricula = validaMatricula(sc);

		System.out.println(System.lineSeparator() + sistema.exibeAluno(matricula) + System.lineSeparator());
	}

	/**
	 * Método que recebe as entradas do usuário e chama o método da classe Sistema
	 * que cria um Grupo.
	 * 
	 * @param sc
	 *            Scanner que lê a entrada do úsuario.
	 * @param sistema
	 *            Sistema de Controle responsável por armazenar os dados e controlar
	 *            o fluxo do sistema.
	 */
	private static void criaGrupo(Scanner sc, Sistema sistema) {
		System.out.print(System.lineSeparator() + "Grupo: ");
		String grupo = sc.nextLine().trim();

		if (sistema.cadastaGrupo(grupo)) {
			System.out.println(System.lineSeparator() + "CADASTRO REALIZADO!" + System.lineSeparator());
		} else {
			System.out.println(System.lineSeparator() + "GRUPO JÁ CADASTRADO!" + System.lineSeparator());
		}
	}

	/**
	 * Método Especial que possui duas funções. O usuário deve escolher entre alocar
	 * um aluno em grupo ou imprimir os alunos pertencetes a um grupo. A partir da
	 * escolha será invocada o método adequado na classe Sistema.
	 * 
	 * @param sc
	 *            Scanner que lê a entrada do úsuario.
	 * @param sistema
	 *            Sistema de Controle responsável por armazenar os dados e controlar
	 *            o fluxo do sistema.
	 */
	private static void alocaImprime(Scanner sc, Sistema sistema) {
		System.out.print("(A)locar Aluno no Grupo e (I)mprimir Grupos? ");
		String escolha = sc.nextLine().trim().toUpperCase();

		if (escolha.startsWith("A")) {
			System.out.print(System.lineSeparator() + "Matrícula: ");
			String matricula = validaMatricula(sc);

			System.out.print("Grupo: ");
			String grupo = sc.nextLine().trim();

			System.out.println(System.lineSeparator() + sistema.alocaGrupo(matricula, grupo) + System.lineSeparator());
		}
		if (escolha.startsWith("I")) {
			System.out.print(System.lineSeparator() + "Grupo: ");
			String grupo2 = sc.nextLine().trim();
			System.out.println(System.lineSeparator() + sistema.imprimeGrupo(grupo2) + System.lineSeparator());
		}
	}

	/**
	 * Método recebe a entrada do Usuário e chama o método adequado da Classe
	 * Sistema que Registra resposta do aluno.
	 * 
	 * @param sc
	 *            Scanner que lê a entrada do úsuario.
	 * @param sistema
	 *            Sistema de Controle responsável por armazenar os dados e controlar
	 *            o fluxo do sistema.
	 */
	private static void registraResposta(Scanner sc, Sistema sistema) {
		System.out.print(System.lineSeparator() + "Matrícula: ");
		String matricula = validaMatricula(sc);

		System.out.println(System.lineSeparator() + sistema.registraResposta(matricula) + System.lineSeparator());
	}

	/**
	 * Método recebe a entrada do Usuário e chama o método adequado da Classe
	 * Sistema que imprime os alunos que responderam as perguntas.
	 * 
	 * @param sistema
	 *            Sistema de Controle responsável por armazenar os dados e controlar
	 *            o fluxo do sistema.
	 */
	private static void imprimirRespostas(Sistema sistema) {

		System.out.println(System.lineSeparator() + sistema.imprimeRespostas() + System.lineSeparator());
	}

}
