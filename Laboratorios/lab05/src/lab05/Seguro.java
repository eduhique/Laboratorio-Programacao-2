package lab05;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Representação de um Seguro. Um seguro guarda uma valor a ser assegurado.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public abstract class Seguro {

	/**
	 * Valor a ser armazenado pelo seguro.
	 */
	protected int valor;

	/**
	 * Contrutor de Seguro que recebe um valor a ser assegurado.
	 * 
	 * @param valor
	 *            Valor a ser assegurado.
	 * 
	 */
	public Seguro(int valor) {
		this.valor = valor;
	}

	/**
	 * Retorna o valor assegurado. É abastract, pois cada classe implenta sua forma
	 * de fazer retorno.
	 * 
	 * @return um inteiro que representa o valor assegurado.
	 */
	public abstract int getValorAssegurado();

	/**
	 * Método que gera uma String contendo o tipo de seguro e o valor assegurado.
	 * Este método não recebe nenhum parâmetro. Imprime a representação textual de
	 * um seguro, no modelo “ - ASSEGURADA (TIPO) - VALOR”.
	 * 
	 * @return A representação textualde uma Aposta.
	 */
	@Override
	public abstract String toString();
}
