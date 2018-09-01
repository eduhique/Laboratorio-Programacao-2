package lab05;

import easyaccept.EasyAccept;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 *
 * Representação de uma Facade. A facade delega os métodos de um Sistema.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class Facade {

	/**
	 * Controlador do Sistema.
	 */
	private Controller controller;

	public static void main(String[] args) {
		args = new String[] { "lab05.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt", "acceptance_test/us5_test.txt",
				"acceptance_test/us6_test.txt", "acceptance_test/us7_test.txt" };
		EasyAccept.main(args);
	}

	/**
	 * Constrói uma Facade, instânciando o Sistema.
	 */
	public Facade() {
		this.controller = new Controller();
	}

	/**
	 * Método que inicializa o Sistema com um valor e taxa superiores a zero.
	 * 
	 * @param caixa
	 *            Caixa do Sistema a ser inicializado. O valor inserido deve ser em
	 *            moedas.
	 * @param taxa
	 *            Taxa do sistema a ser inicializado. A taxa é um double com valor
	 *            menor do que 1 e maior que zero.
	 */
	public void inicializa(int caixa, double taxa) {
		this.controller.inicializa(caixa, taxa);
	}

	/**
	 * Método auxiliar get para o caixa do sistema.
	 * 
	 * @return retorna um inteiro, que carrega a quantia existente no caixa do
	 *         sistema.
	 */
	public int getCaixa() {
		return this.controller.getCaixa();
	}

	/**
	 * Método que cadastra um Cenário. Recebe apenas a descrição do cenário a ser
	 * criado e retorna o número de identificação do mesmo.
	 * 
	 * @param descricao
	 *            Descrição do cenário.
	 * @return Retorna um valor que identifica um cénario
	 */
	public int cadastrarCenario(String descricao) {
		return this.controller.cadastrarCenario(descricao);
	}

	/**
	 * Método que cadastra um Cenário com bônus. Recebe a descrição do cenário a ser
	 * criado e o bonus que sera adicionado ao cenário e retorna o número de
	 * identificação do mesmo.
	 * 
	 * @param descricao
	 *            Descrição do cenário.
	 * @param bonus
	 *            Bônus oferecido aos vecendores.
	 * @return Retorna um valor que identifica um cénario.
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		return this.controller.cadastrarCenarioBonus(descricao, bonus);
	}

	/**
	 * Método que pesquisa e exibe a Representação textual de um cenário. Recebe o
	 * número do cenário e retorna a representação textual do cenário pesquisado com
	 * o formato: "NUMERAÇÃO - DESCRIÇÃO - ESTADO".
	 * 
	 * @param cenario
	 *            Número do cenario a ser pesquisado.
	 * @return Retorna a representação em String do cenário pesquisado.
	 */
	public String exibirCenario(int cenario) {
		return this.controller.exibirCenario(cenario);
	}

	/**
	 * Método que exibe todos os cenários cadastrados no Sistema, numa representação
	 * textual. Não recebe nehum parâmetro.
	 * 
	 * @return Retorna a representação textual de todos o cenários caastrados.
	 */
	public String exibirCenarios() {
		return this.controller.exibirCenarios();
	}

	/**
	 * Método que cadastra uma aposta em um determinado cenário, dada sua numeração,
	 * o nome do apostador, um valor e uma previsão (VAI ACONTECER ou N VAI
	 * ACONTECER).
	 * 
	 * @param cenario
	 *            A numeração do cenário a ser cadastrado a aposta.
	 * @param apostador
	 *            O nome do apostador.
	 * @param valor
	 *            O valor da aposta.
	 * @param previsao
	 *            A previsão da aposta.
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.controller.cadastrarAposta(cenario, apostador, valor, previsao);
	}

	/**
	 * Método que cadastra uma aposta Assegurada por Valor em um determinado
	 * cenário, dada sua numeração, o nome do apostador, um valor e uma previsãouma
	 * previsão (VAI ACONTECER ou N VAI ACONTECER), o valor a ser assegurado e o
	 * custo do seguro.
	 * 
	 * @param cenario
	 *            A numeração do cenário a ser cadastrado a aposta.
	 * @param apostador
	 *            O nome do apostador.previsao
	 * @param valor
	 *            O valor da aposta.
	 * @param previsao
	 *            A previsão da aposta.
	 * @param valorAssegurado
	 *            Valor a Ser assegurado no Cadastro.
	 * @param custo
	 *            Custo do seguro da aposta.
	 * @return Retorna um interiro de identificação da aposta Assegurada.
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao,
			int valorAssegurado, int custo) {
		return this.controller.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, valorAssegurado, custo);
	}

	/**
	 * Método que cadastra uma aposta Assegurada por Taxa em um determinado cenário,
	 * dada sua numeração, o nome do apostador, um valor, uma previsão (VAI
	 * ACONTECER ou N VAI ACONTECER), a taxa Assegurado e o custo do seguro.
	 * 
	 * @param cenario
	 *            A numeração do cenário a ser cadastrado a aposta.
	 * @param apostador
	 *            O nome do apostador.previsao
	 * @param valor
	 *            O valor da aposta.
	 * @param previsao
	 *            A previsão da aposta.
	 * @param taxa
	 *            taxa a Ser assegurada no Cadastro.
	 * @param custo
	 *            Custo do seguro da aposta.
	 * @return Retorna um interiro de identificação da aposta Assegurada.
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa,
			int custo) {
		return this.controller.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa, custo);
	}

	/**
	 * Método que converte uma aposta assegurada por taxa para uma aposta assegurada
	 * por valor.
	 * 
	 * @param cenario
	 *            A numeração do cenário que contém a aposta.
	 * @param apostaAssegurada
	 *            Número que representa a aposta Assegurada.
	 * @param valorAssegurado
	 *            Valor que será assegurado.
	 * @return Retorna um numero correspondente a identificação da aposta.
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valorAssegurado) {
		return this.controller.alterarSeguroValor(cenario, apostaAssegurada, valorAssegurado);
	}

	/**
	 * Método que converte uma aposta assegurada por valor para uma aposta
	 * assegurada por taxa.
	 * 
	 * @param cenario
	 *            A numeração do cenário que contém a aposta.
	 * @param apostaAssegurada
	 *            Número que representa a aposta Assegurada.
	 * @param taxa
	 *            taxa a ser aplicado no seguro.
	 * @return Retorna um numero correspondente a identificação da aposta.
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return this.controller.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
	}

	/**
	 * Método que calcula e retorna o valor total das apostas feitas em um cenário.
	 * 
	 * @param cenario
	 *            Número do cenário a ser somado.
	 * @return Retorna o valor total das apostas.
	 */
	public int valorTotalDeApostas(int cenario) {
		return this.controller.valorTotalDeApostas(cenario);
	}

	/**
	 * Método que retorna o número total de apostas feitas para um cenário indicado.
	 * 
	 * @param cenario
	 *            Número do cenário a ser avaliado.
	 * @return Retorna o número total de apostas feitas para o cenário.
	 */
	public int totalDeApostas(int cenario) {
		return this.controller.totalDeApostas(cenario);
	}

	/**
	 * Método que gera e exibe uma representação textual de todas as apostas feitas
	 * para o cenário indicado, uma a cada linha.
	 * 
	 * @param cenario
	 *            Número do cenário a ser exibido.
	 * @return Retorna uma representação textual de todas apostas feitas para o
	 *         cenário.
	 */
	public String exibeApostas(int cenario) {
		return this.controller.exibeApostas(cenario);
	}

	/**
	 * Método que finaliza as apostas. Recebe o numero do cenário que se deseja
	 * encerrar e um booleano, true, caso o cénario tenha ocorrido ou fasle caso
	 * contrário.
	 * 
	 * @param cenario
	 *            Número do cenario a ser fechado.
	 * @param ocorreu
	 *            Valor booleano que indica se o cenário ocorreu ou não.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.controller.fecharAposta(cenario, ocorreu);
	}

	/**
	 * Método auxiliar que recebe o número de um cénario e retorna o valor total que
	 * será destinado ao caixa, após o cenário ser finalizado.
	 * 
	 * @param cenario
	 *            Número do cenario para pesquisa.
	 * @return Retorna o valor destinado ao caixa.
	 */
	public int getCaixaCenario(int cenario) {
		return this.controller.getCaixaCenario(cenario);
	}

	/**
	 * Método auxiliar que recebe o número de um cénario e retorna o valor total
	 * para rateio entre os vencedores;
	 * 
	 * @param cenario
	 *            Número do cenario para pesquisa.
	 * @return Retorna o valor a ser rateado entre os ganhadores.
	 */
	public int getTotalRateioCenario(int cenario) {
		return this.controller.getTotalRateioCenario(cenario);
	}

	/**
	 * Método que altera a ordem em que os cénarios são exibidos. Recebe como
	 * entrada uma String que especifica o tipo de ordenação, que pode ser
	 * "cadastro", "nome" ou "apostas".
	 * 
	 * @param ordem
	 *            Tipo de Ordem em que os cenários devem ser ordenados.
	 */
	public void alterarOrdem(String ordem) {
		this.controller.alterarOrdem(ordem);
	}

	/**
	 * Método que pesquisa e exibe a Representação textual de um cenário na
	 * ordenação definida anteriormente. Recebe o número do cenário e retorna a
	 * representação textual do cenário odernado pesquisado com o formato:
	 * "NUMERAÇÃO - DESCRIÇÃO - ESTADO".
	 * 
	 * @param cenario
	 *            Número do cenario a ser pesquisado.
	 * @return Retorna a representação em String do cenário pesquisado.
	 */
	public String exibirCenarioOrdenado(int cenario) {
		return this.controller.exibirCenarioOrdenado(cenario);
	}

}
