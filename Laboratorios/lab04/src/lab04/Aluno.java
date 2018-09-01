package lab04;

/**
 * Laboratório de Programação 2 - Lab 4
 *
 * Representação de um Aluno. O Aluno tem uma matrícula, um nome e um curso.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class Aluno {

	/**
	 * Matrícula do aluno.
	 */
	private String matricula;

	/**
	 * Nome do aluno.
	 */
	private String nome;

	/**
	 * Curso do aluno.
	 */
	private String curso;

	/**
	 * Invoca um construtor de Aluno, que recebe uma matricula única, um nome e um
	 * curso.
	 * 
	 * @param matricula
	 *            Matrícula do aluno.
	 * @param nome
	 *            Nome do aluno.
	 * @param curso
	 *            Curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		if (matricula == null) {
			throw new NullPointerException("Insira uma Matrícula Válida!");
		}
		if (matricula.trim().equals("")) {
			throw new IllegalArgumentException("Insira uma Matrícula Válida!");
		}

		if (nome == null) {
			throw new NullPointerException("Insira um Nome Válido!");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Insira um Nome Válido!");
		}

		if (curso == null) {
			throw new NullPointerException("Insira um Curso Válido!");
		}
		if (curso.trim().equals("")) {
			throw new IllegalArgumentException("Insira um Curso Válido!");
		}
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	/**
	 * Método auxiliar que retorna a matricula do objeto Aluno.
	 * 
	 * @return Retorna a Matrícula do objeto Aluno.
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Método que gera um número inteiro único que representa hashCode do objeto a
	 * partir da sua matrícula.
	 *
	 * @return Um número interio único que representa o hashCode do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Método que gera uma String contendo a matrícula, nome (caso haja) e o curso
	 * do aluno. Este método não recebe nenhum parâmetro. Imprime a representação de
	 * um Aluno.
	 * 
	 * @return A representação em String de um Aluno.
	 */
	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}

}
