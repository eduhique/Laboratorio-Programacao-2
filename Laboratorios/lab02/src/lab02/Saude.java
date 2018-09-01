package lab02;

/**
 * Laboratório de Programação 2 - Lab 2
 * 
 * Representação do estado de saúde de um aluno da UFCG. Permite saber o estado
 * de saúde do aluno a partir de informações sobre sua saude mental e física.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class Saude {

	/**
	 * Saúde mental. No formato texto (String) XXXX. ex: "boa".
	 */
	private String saudeMental;

	/**
	 * Saúde física. No formato texto (String) XXXX. ex: "fraca".
	 */
	private String saudeFisica;

	/**
	 * Constrói uma estado de saude. Não recebe, nem retorna nada.
	 */
	public Saude() {

	}

	/**
	 * Método sem retorno que define a saude mental do aluno.
	 * 
	 * @param valor
	 *            String breve que diz o estado mental do aluno.
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
	}

	/**
	 * Método sem retorno que define a saude física do aluno.
	 * 
	 * @param valor
	 *            String breve que diz o estado física do aluno.
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
	}

	/**
	 * Método que retorna uma String dizendo o estado geral de saúde do aluno.
	 * Recebe os valores de estado mental e estado físico.
	 * 
	 * @return o estado geral de saúde do aluno.
	 */
	public String getStatusGeral() {
		if (saudeFisica == "fraca" && saudeMental == "fraca") {
			return "fraca";
		} else if ((saudeFisica == "fraca" && saudeMental == "boa")
				|| (saudeFisica == "boa" && saudeMental == "fraca")) {
			return "ok";
		}
		return "boa";
	}
}
