package lab05;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Representação de um Seguro por Valor que é filha de Seguro. Um seguro por
 * valor herdar os atributos do pai e especializa seus métodos.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class SeguroValor extends Seguro {

	/**
	 * Contrutor de um Seguro por valor que recebe um valor a ser assegurado.
	 * 
	 * @param valorAssegurado
	 *            Valor a ser assegurado.
	 */
	public SeguroValor(int valorAssegurado) {
		super(valorAssegurado);
		if (valor < 1) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: valor nao pode ser menor ou igual a zero");
		}
	}

	/**
	 * Retorna o valor assegurado
	 * 
	 * @return um inteiro que representa o valor do seguro
	 */
	@Override
	public int getValorAssegurado() {
		return this.valor;
	}

	/**
	 * Método que gera uma String contendo o tipo de seguro e o valor assegurado.
	 * Este método não recebe nenhum parâmetro. Imprime a representação textual de
	 * um seguro, no modelo “ - ASSEGURADA (VALOR) - VALOR”.
	 * 
	 * @return A representação textualde uma Aposta.
	 */
	@Override
	public String toString() {
		double novoValor = (1.0 * this.valor) / 100;
		return String.format(" - ASSEGURADA (VALOR) - R$ %.2f", novoValor);
	}

}
