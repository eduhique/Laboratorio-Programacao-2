package lab05;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 *
 * Representação de uma Aposta Assegurada que é filha de Aposta. Faz as mesmas
 * ações do pai.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ApostaComum extends Aposta {

	/**
	 * Invoca um construtor de Aposta, que recebe o nome de um apostador, um valor e
	 * uma previsão (VAI ACONTECER ou N VAI ACONTECER).
	 * 
	 * @param apostador
	 *            Nome do Aapostador.
	 * @param valor
	 *            Valor a ser apostado.
	 * @param previsao
	 *            Palpite de um resultado.
	 */
	public ApostaComum(String apostador, int valor, String previsao) {
		super(apostador, valor, previsao);
		if (apostador == null) {
			throw new NullPointerException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (apostador.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (valor < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}

		if (previsao == null) {
			throw new NullPointerException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if (previsao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if (!previsao.trim().equals("VAI ACONTECER") && !previsao.trim().equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}

	}

	/**
	 * Método que retorna o valor assegurado na aposta. Pelo fato de ser uma aposta
	 * não assegurada irá sempre o valor 0.
	 */
	@Override
	public int getSeguro() {
		return 0;
	}

}
