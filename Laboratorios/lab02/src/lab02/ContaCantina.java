package lab02;

/**
 * Laboratório de Programação 2 - Lab 2
 * 
 * Representação da conta da cantina de um aluno da UFCG. Permite cadastrar uma
 * cantina onde criará uma conta; adincionar itens consumidos e seu valor, além
 * de ser possível pagar a conta.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ContaCantina {

	/**
	 * Nome da cantina. No formato texto (String) XXXX. ex: "Cantina do Franburgão".
	 */
	public String nomeCantina;

	/**
	 * Quantidade de itens comprados. Número inteiro que representa a quantidade
	 * itens consumidos.
	 */
	private int quantidade;

	/**
	 * valor a ser pago pelo intens consumidos. Número inteiro que representa o
	 * valor, ,em centavos, dos produtos consumidos.
	 */
	private int valor;

	/**
	 * Valor total da conta. Número inteiro que representa o valor total da conta,
	 * em centavos.
	 */
	private int total = 0;

	/**
	 * Valor total de itens consumidos. Número inteiro que representa o valor total
	 * de itens consumidos.
	 */
	private int quantidadeTotal;

	/**
	 * Constrói uma conta em uma cantina. Recebe uma String com o nome da cantina.
	 * 
	 * @param nomeDaCantina
	 *            nome da cantina.
	 */
	public ContaCantina(String nomeDaCantina) {
		this.nomeCantina = nomeDaCantina;
	}

	/**
	 * Método sem retorno que cadastra lanches. Recebe como a quantidades de itens e
	 * o valor unitário a ser paga. Calcula o to
	 * 
	 * @param qtdItens
	 *            quantidade de itens a serem adicionados na conta.
	 * @param valorCentavos
	 *            valor unitário dos produtos consumidos.
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.quantidade = qtdItens;
		this.quantidadeTotal += qtdItens;
		this.valor = valorCentavos;
		this.total += this.quantidade * this.valor;
	}

	/**
	 * Método sem retorno recebe um valor a ser creditado na conta. Recebe um
	 * inteiro representa o valor a ser creditado na conta, em centavos.
	 * 
	 * @param valorCentavos
	 *            valor a ser creditado na conta.
	 */
	public void pagaConta(int valorCentavos) {
		this.total -= valorCentavos;
	}

	/**
	 * método que retorna uma String que representa a conta na cantina. A
	 * representação segue no formato "NomeDoCantina QuantidadeDeItens DebitoAtual.
	 * 
	 * @return a representação de uma String ContaCantina.
	 */
	public String toString() {
		String saidaString = this.nomeCantina + " " + this.quantidadeTotal + " " + this.total;
		return saidaString;
	}
}
