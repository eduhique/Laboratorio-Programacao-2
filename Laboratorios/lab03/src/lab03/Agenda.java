package lab03;

import java.util.Arrays;

/**
 * Laboratório de Programação 2 - Lab 3
 *
 * Representação de uma Agenda Telefônica. A agenda pode ter até 100 objetos do
 * tipo Contato, pode fazer interações entre os objetos.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class Agenda {

	/**
	 * Posiçao que o contato ocupa na Agenda
	 */
	private int posicao;

	/**
	 * Array Agenda de Obejetos do tipo Contato.
	 */
	private Contato[] agenda;

	/**
	 * Invoca um Construtor de Agenda. Não recebe nenhum parâmetro e cria uma Agenda
	 * de contatos com 100 espaços.
	 */
	public Agenda() {
		this.agenda = new Contato[100];
	}

	/**
	 * Método que cadastra um contato na agenda. O contato é criado a partir do
	 * nome, Sobrenome (caso haja), um array de telefones com até três contatos,
	 * nivel de Amizade e aloca em uma posição na agenda.
	 * 
	 * @param posicao
	 *            Posição onde será alocado o contato na agenda.
	 * @param nome
	 *            Nome do contato a ser cadastrado.
	 * @param sobrenome
	 *            Sobrenome do contato a ser cadastrado.
	 * @param telefone
	 *            Array com os telefones dos contatos.
	 * @param nivelAmizade
	 *            Nível de afinidade com o contato.
	 * @return Retorna um booleno true caso o contato seja criado.
	 */
	public boolean cadastaContato(int posicao, String nome, String sobrenome, String[] telefone, int nivelAmizade) {
		if (posicao < 1 || posicao > 100) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");
		}
		this.posicao = posicao;
		Contato contato = new Contato(nome, sobrenome, telefone, nivelAmizade);
		this.agenda[this.posicao - 1] = contato;
		return true;
	}

	/**
	 * Metodo que pesquisa o contato pela sua posição na agenda e retorna uma string
	 * de sua representação.
	 * 
	 * @param posicao
	 *            Posição do contato a ser pesquisado
	 * @return Retorna uma representação do contato pesquisado.
	 */
	public String pesquisaPosicao(int posicao) {
		if (posicao < 1 || posicao > 100) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");
		}
		if (this.agenda[posicao - 1] == null) {
			throw new NullPointerException("NÃO EXISTE CONTATO NESSA POSIÇÃO");
		}
		return this.agenda[posicao - 1].toString();
	}

	/**
	 * Método que gera um número inteiro único que representa hashCode do objeto a
	 * partir do Array de contatos.
	 *
	 * @return Um número interio único que representa o hashCode do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(agenda);
		return result;
	}

	/**
	 * Metodo equals, que compara o objeto com outro a partir do Array de contatos.
	 * 
	 * @param obj
	 *            Objeto a ser comparado.
	 * @return um valor booleano que indica se os objetos tem o mesmo nome ou não.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(agenda, other.agenda))
			return false;
		return true;
	}

	/**
	 * Método que gera uma String contendo a posição na agenda, o nome, sobrenome
	 * (caso haja) e os números de telefone do contato. Este método não recebe
	 * nenhum parâmetro e imprime a representação de um contato na agenda.
	 * 
	 * @return A representação em String de um Contato na agenda.
	 */
	@Override
	public String toString() {
		String resultado = "";
		for (int i = 0; i < this.agenda.length; i++) {
			int posicao = i + 1;
			if (this.agenda[i] != null) {
				resultado += posicao + " - " + this.agenda[i].toString() + System.lineSeparator()
						+  "--------------------------------------" + System.lineSeparator();
			}
		}
		return resultado;
	}
}