package lab05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 *
 * Representação de um Controller do Sistema. O controller funciona como o
 * sistema e guarda uma taxa, um caixa e todos os cenários do sistema. Além
 * disso todas as operações referentes à cadastro e manipulação de apostas e
 * cenários também podem ser realizadas pelo Controller.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class Controller {

	/**
	 * Caixa do Sistema.
	 */
	private int caixa;

	/**
	 * Taxa do Sistema
	 */
	private double taxa;

	/**
	 * ArrayList contendo os cenários.
	 */
	private ArrayList<Cenario> cenarios;

	/**
	 * Comparador de Cenários.
	 */
	private Comparator<Cenario> comparador;

	/**
	 * Constrói um Controller, com taxa e caixa especificados na construção, e
	 * inicializa sua lista de cenários.
	 */
	public Controller() {
		this.caixa = 0;
		this.taxa = 0.0;
		this.cenarios = new ArrayList<>();
		this.comparador = new ComparaCadastro();

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
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxa < 0.0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}

		this.caixa = caixa;
		this.taxa = taxa;
		this.cenarios = new ArrayList<>();
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
		Cenario cenario = new Cenario(descricao, cenarios.size());
		this.cenarios.add(cenario);
		return (Integer) this.cenarios.indexOf(cenario) + 1;

	}

	/**
	 * Método que cadastra um Cenário com bônus. Recebe a descrição do cenário a ser
	 * criado e o bonus e retorna o número de identificação do mesmo. O bônus é um
	 * valor que é imediatamente retirado do caixa do sistema e colocado no cenário
	 * quando o mesmo é criado.
	 * 
	 * @param descricao
	 *            Descrição do cenário.
	 * @param bonus
	 *            Bônus oferecido aos vecendores.
	 * @return Retorna um valor que identifica um cénario
	 */
	public int cadastrarCenarioBonus(String descricao, int bonus) {
		CenarioBonus cenario = new CenarioBonus(descricao, bonus, cenarios.size());
		this.caixa -= bonus;
		this.cenarios.add(cenario);
		return (Integer) this.cenarios.indexOf(cenario) + 1;

	}

	/**
	 * Método auxiliar que retorna o valor Contido no caixa.
	 * 
	 * @return Retorna o valor contido no Caixa do Sistema.
	 */
	public int getCaixa() {
		return caixa;
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
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return cenario + " - " + this.cenarios.get(cenario - 1).toString();
	}

	/**
	 * Método que exibe todos os cenários cadastrados no Sistema, numa representação
	 * textual. Não recebe nehum parâmetro.
	 * 
	 * @return Retorna a representação textual de todos o cenários caastrados.
	 */
	public String exibirCenarios() {
		String resultado = "";

		for (int i = 0; i < cenarios.size(); i++) {
			resultado += (i + 1) + " - " + cenarios.get(i).toString() + System.lineSeparator();
		}
		return resultado;
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
		if (ordem == null) {
			throw new NullPointerException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		}
		if (ordem.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");

		}
		switch (ordem.toLowerCase().trim()) {
		case ("cadastro"):
			this.comparador = new ComparaCadastro();
			break;
		case ("nome"):
			this.comparador = new ComparaNome();
			break;
		case ("apostas"):
			this.comparador = new ComparaApostas();
			break;
		default:
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}
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
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro na consulta de cenario ordenado: Cenario nao cadastrado");
		}
		ArrayList<Cenario> cenariosOrdenados = new ArrayList<>(cenarios);
		Collections.sort(cenariosOrdenados, this.comparador);

		return (cenariosOrdenados.get(cenario - 1).getId() + 1) + " - " + cenariosOrdenados.get(cenario - 1).toString();
	}

	/**
	 * Método que cadastra uma Aposta. Recebe o número do cenário, o nome do
	 * apostador, um valor e uma previsão (VAI ACONTECER ou N VAI ACONTECER).
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
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		this.cenarios.get(cenario - 1).cadastrarAposta(apostador, valor, previsao);
	}

	/**
	 * Método que cadastra uma aposta Assegurada por Valor em um determinado
	 * cenário, dada sua numeração, o nome do apostador, um valor e uma previsão
	 * (VAI ACONTECER ou N VAI ACONTECER), o valor a ser assegurado e o custo do
	 * seguro.
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
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException(
					"Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");
		}
		if (custo < 1) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		this.caixa += custo;
		return this.cenarios.get(cenario - 1).cadastrarApostaSeguraValor(apostador, valor, previsao, valorAssegurado);
	}

	/**
	 * Método que cadastra uma Aposta Assegurada por taxa. Recebe o número do
	 * cenário, o nome do apostador, um valor e uma previsão (VAI ACONTECER ou N VAI
	 * ACONTECER), uma taxa a ser assegurada e o custo do seguro.
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
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException(
					"Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
		}
		if (custo < 1) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		}
		this.caixa += custo;
		return this.cenarios.get(cenario - 1).cadastrarApostaSeguraTaxa(apostador, valor, previsao, taxa);
	}

	/**
	 * Método que Altera o tipo do seguro de um aposta assegurada para seguro por
	 * valor.
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
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException(
					"Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");
		}

		return this.cenarios.get(cenario - 1).alterarSeguroValor(apostaAssegurada, valorAssegurado);
	}

	/**
	 * Método que Altera o tipo do seguro de um aposta assegurada para seguro por
	 * taxa.
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
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException(
					"Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).alterarSeguroTaxa(apostaAssegurada, taxa);
	}

	/**
	 * Método que calcula e retorna o valor total das apostas feitas em um cenário
	 * indicado.
	 * 
	 * @param cenario
	 *            Número do cenário a ser somado.
	 * @return Retorna o valor total das apostas.
	 */
	public int valorTotalDeApostas(int cenario) {
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).valorTotalDeApostas();
	}

	/**
	 * Método que retorna o número total de apostas feitas para o cenário indicado.
	 * 
	 * @param cenario
	 *            Número do cenário a ser avaliado.
	 * @return Retorna o número total de apostas feitas.
	 */
	public int totalDeApostas(int cenario) {
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).totalDeApostas();
	}

	/**
	 * Método que gera e retorna uma representação textual de todas as apostas
	 * feitas para o cenário indicado, uma a cada linha.
	 * 
	 * @param cenario
	 *            Número do cenário a ser exibido.
	 * @return Retorna uma representação textual de todas apostas feitas para o
	 *         cenário.
	 */
	public String exibeApostas(int cenario) {
		if (cenario < 1) {
			throw new IllegalArgumentException("Cenário inválido, insira um valor Válido!");
		}
		if (cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException("Cenário não cadastrado!");
		}
		return this.cenarios.get(cenario - 1).exibeApostas();
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
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		this.caixa += this.cenarios.get(cenario - 1).fecharAposta(ocorreu, this.taxa);
		this.caixa -= this.cenarios.get(cenario - 1).seguroApostaTotal(ocorreu);
	}

	/**
	 * Método auxiliar que recebe o número de um cénario e retorna o valor total que
	 * será destinado ao caixa.
	 * 
	 * @param cenario
	 *            Número do cenario para pesquisa.
	 * @return Retorna o valor destinado ao caixa.
	 */
	public int getCaixaCenario(int cenario) {
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).getTaxaCenario();
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
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IndexOutOfBoundsException(
					"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).getTotalRateioCenario();
	}
}
