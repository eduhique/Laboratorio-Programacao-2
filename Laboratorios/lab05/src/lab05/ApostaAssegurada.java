package lab05;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 *
 * Representação de uma Aposta Assegurada que é filha de Aposta. Uma Aposta tem
 * um apostador, um valor e uma previsão e um seguro associado a essa aposta.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ApostaAssegurada extends Aposta {

	private Seguro seguro;

	/**
	 * Invoca o Construtor de aposta assegurada por valor, que recebe o nome de um
	 * apostador, um valor e uma previsão (VAI ACONTECER ou N VAI ACONTECER) e o
	 * valor a ser assegurado.
	 * 
	 * @param apostador
	 *            O nome do apostador.previsao
	 * @param valor
	 *            O valor da aposta.
	 * @param previsao
	 *            A previsão da aposta.
	 * @param valorAssegurado
	 *            Valor a Ser assegurado no Cadastro.
	 * 
	 */
	public ApostaAssegurada(String apostador, int valor, String previsao, int valorAssegurado) {
		super(apostador, valor, previsao);
		validaAposta("Erro no cadastro de aposta assegurada por valor: ", apostador, valor, previsao);
		this.seguro = new SeguroValor(valorAssegurado);
	}

	/**
	 * Invoca o Construtor de aposta assegurada por taxa, que recebe o nome de um
	 * apostador, um valor e uma previsão (VAI ACONTECER ou N VAI ACONTECER) e a
	 * taxa a ser assegurada.
	 * 
	 * @param apostador
	 *            O nome do apostador.previsao
	 * @param valor
	 *            O valor da aposta.
	 * @param previsao
	 *            A previsão da aposta.
	 * @param taxa
	 *            taxa a Ser assegurada no Cadastro.
	 */
	public ApostaAssegurada(String apostador, int valor, String previsao, double taxa) {
		super(apostador, valor, previsao);
		validaAposta("Erro no cadastro de aposta assegurada por taxa: ", apostador, valor, previsao);
		this.seguro = new SeguroTaxa(taxa, valor);
	}

	/**
	 * Método privado que valida os parâmetros dos construtores da classe Aposta
	 * assegurada.
	 * 
	 * @param msg
	 *            Mensagem que especifica se o erro é de uma aposta assegurada por
	 *            taxa ou por valor.
	 * @param apostador
	 *            O nome do apostador.previsao
	 * @param valor
	 *            O valor da aposta.
	 * @param previsao
	 *            A previsão da aposta.
	 */
	private void validaAposta(String msg, String apostador, int valor, String previsao) {
		if (apostador == null) {
			throw new NullPointerException(msg + "Apostador nao pode ser vazio ou nulo");
		}
		if (apostador.trim().equals("")) {
			throw new IllegalArgumentException(msg + "Apostador nao pode ser vazio ou nulo");
		}
		if (valor < 1) {
			throw new IllegalArgumentException(msg + "Valor nao pode ser menor ou igual a zero");
		}

		if (previsao == null) {
			throw new NullPointerException(msg + "Previsao nao pode ser vazia ou nula");
		}
		if (previsao.trim().equals("")) {
			throw new IllegalArgumentException(msg + "Previsao nao pode ser vazia ou nula");
		}
		if (!previsao.trim().equals("VAI ACONTECER") && !previsao.trim().equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException(msg + "Previsao invalida");
		}
	}

	/**
	 * Método auxiliar que retorna um boleano que diz se uma aposta é assegurda
	 * (true) ou não (false).
	 * 
	 * @return Retorna um booleano que diz se uma aposta é assegurada.
	 */
	public int getSeguro() {
		return this.seguro.getValorAssegurado();
	}

	/**
	 * Método que converte uma aposta assegurada por taxa para uma aposta assegurada
	 * por valor.
	 * 
	 * @param valorAssegurado
	 *            Valor a ser assegurado.
	 */
	@Override
	public void alterarSeguroValor(int valorAssegurado) {
		this.seguro = new SeguroValor(valorAssegurado);
	}

	/**
	 * Método que converte uma aposta assegurada por valor para uma aposta
	 * assegurada por taxa.
	 * 
	 * @param taxa
	 *            Taxa a ser aplicada no seguro.
	 */
	@Override
	public void alterarSeguroTaxa(double taxa) {
		this.seguro = new SeguroTaxa(taxa, this.valor);
	}

	/**
	 * Método que gera uma String contendo o nome do apostador, o valor da aposta em
	 * reais e a previsão da aposta e o seguro que essa aposta Possui. Este método
	 * não recebe nenhum parâmetro. Imprime a representação textual de uma aposta
	 * assegurada, no modelo "NOME - VALOR - PREVISÃO - ASSEGURADA (TIPO) - VALOR".
	 * 
	 * @return A representação textual de uma Aposta.
	 */
	@Override
	public String toString() {
		return super.toString() + seguro.toString();
	}

}