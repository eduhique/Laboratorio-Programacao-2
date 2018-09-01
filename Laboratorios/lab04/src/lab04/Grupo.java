package lab04;

import java.util.HashSet;

/**
 * Laboratório de Programação 2 - Lab 4
 * 
 * Representação de um Grupo. O grupo tem um nome e armazenas objetos do aluno
 * que fazem parte do grupo.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class Grupo {

	/**
	 * Nome do Grupo.
	 */
	private String nome;

	/**
	 * Composição de elementos do Tipo aluno que fazem parte do grupo.
	 */
	private HashSet<Aluno> alunos;

	/**
	 * Invoca o contrutor de grupo, que recebe apenas um nome do grupo e cria um
	 * conjunto que permite a adição d apenas de objetos do tipo aluno.
	 * 
	 * @param nome
	 *            Nome do Grupo a ser criado.
	 */
	public Grupo(String nome) {
		if (nome == null) {
			throw new NullPointerException("Insira um Nome Válido!");
		}

		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Insira um Nome Válido!");
		}
		this.nome = nome;
		this.alunos = new HashSet<>();
	}

	/**
	 * Método que verifica que um determinado aluno pertence ao grupo. A verificação
	 * é feita a partir da matrícula.
	 * 
	 * @param matricula
	 *            Matrícula do aluno a ser verificado.
	 * @return Retorna um booleno true, caso o Aluno ja perteça ao grupo, ou false,
	 *         caso Não.
	 */
	private boolean verificaAluno(String matricula) {
		if (this.alunos.contains(matricula)) {
			return true;
		}
		return false;
	}

	/**
	 * Método que adiciona um obejeto aluno a um grupo. Recebe o Obejto aluno a ser
	 * adicionado ao grupo.
	 * 
	 * @param aluno
	 *            Obejeto aluno a ser adicionado ao grupo.
	 */
	public void addAluno(Aluno aluno) {
		if (!verificaAluno(aluno.getMatricula())) {
			this.alunos.add(aluno);
		}
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
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Método que gera uma String contendo nome do grupo e os alunos que pertecem ao
	 * grupo. Este método não recebe nenhum parâmetro. Imprime a representação de um
	 * Grupo.
	 * 
	 * @return A representação em String de um Grupo.
	 */
	@Override
	public String toString() {
		String resultado = System.lineSeparator() + "Grupo: " + this.nome + System.lineSeparator()
				+ System.lineSeparator() + "Alunos do grupo " + this.nome + ":" + System.lineSeparator();

		for (Aluno aluno : this.alunos) {
			resultado += "* " + aluno.toString() + System.lineSeparator();
		}
		return resultado;
	}

}
