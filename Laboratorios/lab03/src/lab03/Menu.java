package lab03;

import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 3
 * 
 * Clase principal que Representa de um sistema que gerencia uma agenda
 * telefônica. O programa será excutado pelo menos uma vez.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class Menu {

	/**
	 * Método principal Main que possui a capacidade de receber comandos do úsuario,
	 * tais como cadastrar, listar contatos, exibir e sair da agenda. Além disso
	 * imprime mensagens úteis e de alerta para o úsuario.
	 * 
	 * @param args
	 *            Argumentos iniciais.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Agenda agenda = new Agenda();
		String entrada;

		do {
			System.out.print("(C)adastrar Contato" + System.lineSeparator() + "(L)istar Contatos"
					+ System.lineSeparator() + "(E)xibir Contato" + System.lineSeparator() + "(S)air"
					+ System.lineSeparator() + "Opção> ");

			entrada = sc.nextLine().trim().toUpperCase();

			switch (entrada) {
			case "C":
				try {
					cadastra(sc, agenda);
				} catch (RuntimeException e) {
					System.out.println("CADASTRO INVALIDO: " + e.getMessage() + System.lineSeparator());
				}
				break;
			case "L":
				System.out.println(listarAgenda(agenda));
				break;
			case "E":
				try {
					System.out.println(System.lineSeparator() + exibe(sc, agenda) + System.lineSeparator());
				} catch (RuntimeException e) {
					System.out.println(e.getMessage() + System.lineSeparator());
				}
				break;
			case "S":
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA" + System.lineSeparator());
				break;
			}
		} while (!(entrada.equals("S")));

	}

	/**
	 * Método que recebe um agenda e tem lista todos os contatos da agenda.
	 * 
	 * @param agenda
	 *            Agenda de Contatos
	 * @return Retorna uma representação com todos os contatos da agenda.
	 */
	private static String listarAgenda(Agenda agenda) {
		System.out.println("");
		return agenda.toString();
	}

	/**
	 * Método que exibe um contato ao úsuario. receb uma entrada que diz a posição
	 * do contato e uma agenda a ser pesquisada.
	 * 
	 * @param sc
	 *            Scanner que lê a entrada do úsuario.
	 * @param agenda
	 *            Agenda de Contatos.
	 * @return restorna uma representação do contato pesquisado.
	 */
	private static String exibe(Scanner sc, Agenda agenda) {
		System.out.print(System.lineSeparator() + "Contato> ");
		int entrada = sc.nextInt();
		sc.nextLine();
		return agenda.pesquisaPosicao(entrada);
	}

	/**
	 * Método que cadastra um contato na agenda. Recebe a entrada úsuario com os
	 * dados do conatto a ser casdastrado e a agenda onde será cadastrado o contato.
	 * 
	 * @param sc
	 *            Scanner que lê a entrada do úsuario.
	 * @param agenda
	 *            Agenda de Contatos.
	 */
	private static void cadastra(Scanner sc, Agenda agenda) {
		System.out.print(System.lineSeparator() + "Posição: ");
		int posicao = sc.nextInt();
		sc.nextLine();

		System.out.print("Nome: ");
		String nome = sc.nextLine().trim();

		System.out.print("Sobrenome: ");
		String sobrenome = sc.nextLine().trim();

		String[] telefone = inserirTelefone(sc);

		System.out.print(System.lineSeparator() + "Qual seu Nível de Amidade com o contato? " + System.lineSeparator()
				+ System.lineSeparator() + "(1) distante" + System.lineSeparator() + "(2) colega"
				+ System.lineSeparator() + "(3) amigo" + System.lineSeparator() + "(4) amigão" + System.lineSeparator()
				+ "(5) irmão" + System.lineSeparator() + "> ");
		int nivelAmizade = sc.nextInt();
		sc.nextLine();

		if (agenda.cadastaContato(posicao, nome, sobrenome, telefone, nivelAmizade)) {
			System.out.println(System.lineSeparator() + "CADASTRO REALIZADO" + System.lineSeparator());
		}
	}

	/**
	 * Método auxiliar que insere os telefones do contato. Recebe as entradas do
	 * úsuario e retorna um array com no mínimo um telefone e no máximo três.
	 * 
	 * @param sc
	 *            Scanner que lê a entrada do úsuario.
	 * @return Retorna um Array com os telefones do Contato a ser cadastrado.
	 */
	private static String[] inserirTelefone(Scanner sc) {
		String tipo;
		String[] telefone = new String[3];
		String nomeTelefone;

		System.out.print(System.lineSeparator() + "Tipo de Telefone:" + System.lineSeparator() + "(1)Celular"
				+ System.lineSeparator() + "(2)Casa" + System.lineSeparator() + "(3)Trabalho" + System.lineSeparator());

		do {
			if (telefone[2] != null) {
				return telefone;
			}
			tipo = sc.nextLine().trim().toUpperCase();

			switch (tipo) {
			case "1":
				nomeTelefone = "Celular: ";
				System.out.print(System.lineSeparator() + nomeTelefone);
				organizaTelefone(sc, telefone, nomeTelefone);
				if (telefone[2] == null && telefone[0] != null) {
					System.out.print(
							System.lineSeparator() + "Deseja adiconar mais algum Telefone:" + System.lineSeparator()
									+ "(S)im" + System.lineSeparator() + "(N)ão" + System.lineSeparator());
				}
				break;
			case "2":
				nomeTelefone = "Casa: ";
				System.out.print(System.lineSeparator() + nomeTelefone);
				organizaTelefone(sc, telefone, nomeTelefone);
				if (telefone[2] == null && telefone[0] != null) {
					System.out.print(
							System.lineSeparator() + "Deseja adiconar mais algum Telefone:" + System.lineSeparator()
									+ "(S)im" + System.lineSeparator() + "(N)ão" + System.lineSeparator());
				}
				break;
			case "3":
				nomeTelefone = "Trabalho: ";
				System.out.print(System.lineSeparator() + nomeTelefone);
				organizaTelefone(sc, telefone, nomeTelefone);
				if (telefone[2] == null && telefone[0] != null) {
					System.out.print(
							System.lineSeparator() + "Deseja adiconar mais algum Telefone:" + System.lineSeparator()
									+ "(S)im" + System.lineSeparator() + "(N)ão" + System.lineSeparator());
				}
				break;
			case "S":
				System.out.print(System.lineSeparator() + "Tipo de Telefone:" + System.lineSeparator() + "(1)Celular"
						+ System.lineSeparator() + "(2)Casa" + System.lineSeparator() + "(3)Trabalho"
						+ System.lineSeparator());
				break;
			case "N":
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA");
				System.out.print(System.lineSeparator() + "Tipo de Telefone:" + System.lineSeparator() + "(1)Celular"
						+ System.lineSeparator() + "(2)Casa" + System.lineSeparator() + "(3)Trabalho"
						+ System.lineSeparator());

				break;

			}
		} while (!(tipo.equals("N")));
		return telefone;
	}

	/**
	 * Método axuxiliar que insere os telefones cadastrado pelo úsuario de forma
	 * ordenada, para facilitar a interação.
	 * 
	 * @param sc
	 *            Scanner que lê a entrada do úsuario.
	 * @param telefone
	 *            Array de telefones
	 * @param nomeTelefone
	 *            Tipo de telefone, que pode ser do tipo: Celuar, Casa ou Trabalho.
	 */
	private static void organizaTelefone(Scanner sc, String[] telefone, String nomeTelefone) {
		for (int i = 0; i < telefone.length; i++) {
			if (telefone[i] == null) {
				telefone[i] = nomeTelefone + sc.nextLine().trim();
				break;
			}
		}
	}

}
