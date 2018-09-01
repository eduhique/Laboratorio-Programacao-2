package lab05;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Representação de um Seguro por Taxa que é filha de Seguro. Um seguro por taxa
 * guarda uma taxa a ser assegurada além de herdar os atributos do pai e tambem
 * especializa seus metodos.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class SeguroTaxa extends Seguro {

	/**
	 * taxa Assegurada.
	 */
	private double taxa;

	/**
	 * Contrutor de Seguro por taxa, a partir da taxa a ser aplicada e do valor da
	 * aposta.
	 * 
	 * @param taxa
	 *            Taxa a ser aplicada no Seguro
	 * @param valor
	 *            Valor da aposta.
	 */
	public SeguroTaxa(double taxa, int valor) {
		super(valor);
		if (valor < 1) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: valor nao pode ser menor ou igual a zero");
		}
		if (taxa <= 0.0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: taxa nao pode ser menor ou igual a zero");
		}
		this.taxa = taxa;
	}

	/**
	 * Retorna o valor assegurado.
	 * 
	 * @return um inteiro que representa o valor do seguro
	 */
	@Override
	public int getValorAssegurado() {
		return (int) (this.valor * this.taxa);
	}

	/**
	 * Método que gera uma String contendo o tipo de seguro e a taxa assegurada.
	 * Este método não recebe nenhum parâmetro. Imprime a representação textual de
	 * um seguro por taxa, no modelo “ - ASSEGURADA (TAXA) - TAXA”.
	 * 
	 * @return A representação textualde uma Aposta.
	 */
	@Override
	public String toString() {
		int novoValor = (int) (this.taxa * 100);
		return String.format(" - ASSEGURADA (TAXA) - %d%%", novoValor);
	}
}
