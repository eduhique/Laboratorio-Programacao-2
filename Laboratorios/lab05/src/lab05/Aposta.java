package lab05;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 *
 * Representação de uma Aposta. Uma Aposta tem um apostador, um valor e uma
 * previsão.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public abstract class Aposta {

	/**
	 * Nome do Apostador.
	 */
	private String apostador;

	/**
	 * Valor Apostado.
	 */
	protected int valor;

	/**
	 * Palpite de um resultado.
	 */
	private String previsao;

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
	public Aposta(String apostador, int valor, String previsao) {
		this.apostador = apostador.trim();
		this.valor = valor;
		this.previsao = previsao.trim();
	}

	/**
	 * Método auxiliar que retorna o valor da aposta.
	 * 
	 * @return Retorna o valor da aposta.
	 */
	public int getValor() {
		return this.valor;
	}

	/**
	 * Método auxiliar que retorna a previsão da aposta.
	 * 
	 * @return Retorna a previsão.
	 */
	public String getPrevisao() {
		return this.previsao;
	}

	/**
	 * Método que converte uma aposta assegurada por valor para uma aposta
	 * assegurada por taxa. cada classe irá implementar sua forma de fazer essa
	 * alteração, caso seja nescesário.
	 * 
	 * @param taxa
	 *            Taxa a ser aplicada no seguro.
	 */
	public void alterarSeguroTaxa(double taxa) {
	}

	/**
	 * Método que converte uma aposta assegurada por taxa para uma aposta assegurada
	 * por valor. cada classe irá implementar sua forma de fazer essa alteração,
	 * caso seja nescesário.
	 * 
	 * @param valorAssegurado
	 *            Valor a ser assegurado.
	 */
	public void alterarSeguroValor(int valorAssegurado) {
	}

	/**
	 * Método que retorna o valor assegurado. cada classe implentar a sua forma de
	 * fazer esse retorno.
	 * 
	 * @return retorna o valor assegurado pela aposta.
	 */
	public abstract int getSeguro();

	/**
	 * Método que gera uma String contendo o nome do apostador, o valor da aposta em
	 * reais e a previsão da aposta. Este método não recebe nenhum parâmetro.
	 * Imprime a representação textual de uma aposta, no modelo "APOSTADOR - VALOR -
	 * PREVISÃO".
	 * 
	 * @return A representação textualde uma Aposta.
	 */
	public String toString() {
		double novoValor = ((double) this.valor) / 100;
		return String.format("%s - R$ %.2f - %s", this.apostador, novoValor, this.previsao);
	}

}