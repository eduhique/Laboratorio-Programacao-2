package lab03;

/**
 * Laboratório de Programação 2 - Lab 3
 *
 * Representação de um Contato. O Contato pode ter um nome, sobrenome, e até
 * três telefones.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class Contato {

	/**
	 * Nome do Contato.
	 */
	private String nome;

	/**
	 * Sobrenome do Contato. A insersão de um sobrenome é opicional.
	 */
	private String sobrenome;

	/**
	 * Array que aramazena os números de telefone do contato. Pode conter até tres
	 * números.
	 */
	private String[] telefone;

	/**
	 * Inteiro que representa o nível de amizade, do contato com o usuário.
	 */
	private int nivelAmizade;

	/**
	 * Invoca um construtor de contato. que recebe um nome, sobrenome (opcional), um
	 * array contendo até três números de telefones e o nível de amizade com o
	 * contato.
	 * 
	 * @param nome
	 *            Nome do contato.
	 * @param sobrenome
	 *            Sobrenome do contato (opcional).
	 * @param telefone
	 *            Os numeros de telefone do contato.
	 * @param nivelAmizade
	 *            Nível de afinidade com o contato.
	 */
	public Contato(String nome, String sobrenome, String[] telefone, int nivelAmizade) {
		if (nome == null) {
			throw new NullPointerException("Insira um Nome Válido!");
		}

		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Insira um Nome Válido!");
		}

		if (telefone[0] == null && telefone[1] == null && telefone[2] == null) {
			throw new NullPointerException("Insira um Telefone Válido!");
		}

		if (telefone[0].trim().equals("") && telefone[1].trim().equals("") && telefone[2].trim().equals("")) {
			throw new IllegalArgumentException("Insira um Telefone Válido!");
		}
		if (nivelAmizade < 1 || nivelAmizade > 5) {
			throw new IndexOutOfBoundsException("Insira um Nome Válido!");
		}
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.nivelAmizade = nivelAmizade;

	}

	/**
	 * Método auxiliar que pega o inteiro que representa o nível de amizade com o
	 * contato e gera um representação para saida. Ex: "Amigo(3)".
	 * 
	 * @return Uma representação do nível de amizade com o usuário.
	 */
	private String getNivelAmizade() {
		if (this.nivelAmizade == 2) {
			return "Colega (" + this.nivelAmizade + ")";
		}
		if (this.nivelAmizade == 3) {
			return "Amigo (" + this.nivelAmizade + ")";
		}
		if (this.nivelAmizade == 4) {
			return "Amigão (" + this.nivelAmizade + ")";
		}
		if (this.nivelAmizade == 5) {
			return "Irmão (" + this.nivelAmizade + ")";
		}
		return "Distante (" + this.nivelAmizade + ")";
	}

	/**
	 * Método que gera um número inteiro único que representa hashCode do objeto a
	 * partir de seu nome.
	 *
	 * @return Um número interio único que representa o hashCode do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Metodo equals, que compara o objeto com outro a partir de seu nome.
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
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Método que gera uma String contendo nome, sobrenome (caso haja) e os números
	 * de telefone do contato. Este método não recebe nenhum parâmetro. Imprime a
	 * representação de um contato.
	 * 
	 * @return A representação em String de um Contato.
	 */
	@Override
	public String toString() {
		String resultado = "";
		resultado = this.nome + " " + this.sobrenome + " - " + this.telefone[0] + System.lineSeparator()
				+ System.lineSeparator() + "Nível de Amizade: " + getNivelAmizade() + System.lineSeparator();
		if (this.telefone[1] != null) {
			resultado += System.lineSeparator() + "Outros Números deste Contato:";
		}
		for (int i = 1; i < this.telefone.length; i++) {
			if (this.telefone[i] != null) {
				resultado += System.lineSeparator() + this.telefone[i];
			}
		}
		return resultado;
	}
}