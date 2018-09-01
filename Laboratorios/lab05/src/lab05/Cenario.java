package lab05;

import java.util.ArrayList;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 *
 * Representação de um Cénario de Acontencimento. Possui uma descrição, um
 * estado(finalizado ou não) e permite o cadastro de apostas (se o cenário vai
 * ocorrer ou não).
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class Cenario {

	/**
	 * Descrição do Cenário.
	 */
	private String descricao;

	/**
	 * Estado do Cenário. Poder classificado como "finalizado" ou "Não finalizado";
	 */
	private String estado;

	/**
	 * Arraylist contendo as apostas feitas para este Cenário.
	 */
	private ArrayList<Aposta> apostas;

	/**
	 * Total arrecado com as apostas perdedoras após a aposta ser finalizada para
	 * ser dividido entre os ganhadores.
	 */
	private int TotalRateioCenario;

	/**
	 * Taxa a ser paga ao cenario
	 */
	private int taxaCenario;

	private int id;

	/**
	 * Invoca um construtor de Cenário, que recebe apenas uma descrição e seta todos
	 * os atributo do cenário. por padrão todos os cenários são criados com o estado
	 * de "Nao finalidado˜.
	 * 
	 * @param descricao
	 *            escrição do Cenário a ser criado.
	 * @param id
	 *            Identificador do cenario
	 */
	public Cenario(String descricao, int id) {
		if (descricao == null) {
			throw new NullPointerException("Descrição não pode ser nula!");
		}
		if (descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		this.descricao = descricao;
		this.estado = "Nao finalizado";
		this.apostas = new ArrayList<>();
		this.TotalRateioCenario = 0;
		this.taxaCenario = 0;
		this.id = id;
	}

	/**
	 * Método auxiliar que retorna o valor total a ser dividido entre os vencedores
	 * após o cenário ser fechado;
	 * 
	 * @return Retorna o valor a ser rateado entre os ganhadores.
	 */
	public int getTotalRateioCenario() {
		String teste = this.estado.split(" ")[0] + " " + this.estado.split(" ")[1];
		if (teste.equals("Nao finalizado")) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		return TotalRateioCenario;
	}

	/**
	 * Método auxiliar que retorna o valor total de um cenário encerrado que será
	 * destinado ao caixa;
	 * 
	 * @return Retorna o valor destinado ao caixa.
	 */
	public int getTaxaCenario() {
		String teste = this.estado.split(" ")[0] + " " + this.estado.split(" ")[1];
		if (teste.equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		return taxaCenario;
	}

	/**
	 * Método auxiliar que retorna a Descrição do Cenário.
	 * 
	 * @return Retorna a Descrição do Cenário.
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Método auxiliar que retorna a identificação do Cenário.
	 * 
	 * @return Retorna a identificação do Cenário.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Método que cadastra uma Aposta. Recebe o nome do apostador, um valor e uma
	 * previsão (VAI ACONTECER ou N VAI ACONTECER).
	 * 
	 * @param apostador
	 *            Nome do Apostador.
	 * @param valor
	 *            Valor a ser apostado.
	 * @param previsao
	 *            Palpite de um resultado.
	 */
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		if (this.estado.split(" ")[0].equals("Finalizado")) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		apostas.add(new ApostaComum(apostador, valor, previsao));
	}

	/**
	 * Método que cadastra uma Aposta Assegurada por taxa. Recebe o nome do
	 * apostador, um valor e uma previsão (VAI ACONTECER ou N VAI ACONTECER), uma
	 * taxa a ser assegurada e o custo do seguro.
	 * 
	 * @param apostador
	 *            O nome do apostador.previsao
	 * @param valor
	 *            O valor da aposta.
	 * @param previsao
	 *            A previsão da aposta.
	 * @param taxa
	 *            taxa a Ser assegurada no Cadastro.
	 * @return Retorna um interiro de identificação da aposta Assegurada.
	 */
	public int cadastrarApostaSeguraTaxa(String apostador, int valor, String previsao, double taxa) {
		if (this.estado.split(" ")[0].equals("Finalizado")) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		ApostaAssegurada aposta = new ApostaAssegurada(apostador, valor, previsao, taxa);
		this.apostas.add(aposta);
		return (Integer) this.apostas.indexOf(aposta) + 1;
	}

	/**
	 * Método que cadastra uma aposta Assegurada por Valor. Recebe o nome do
	 * apostador, um valor e uma previsão (VAI ACONTECER ou N VAI ACONTECER), o
	 * valor a ser assegurado e o custo do seguro.
	 * 
	 * @param apostador
	 *            O nome do apostador.previsao
	 * @param valor
	 *            O valor da aposta.
	 * @param previsao
	 *            A previsão da aposta.
	 * @param valorAssegurado
	 *            Valor a Ser assegurado no Cadastro.
	 * @return Retorna um interiro de identificação da aposta Assegurada.
	 */
	public int cadastrarApostaSeguraValor(String apostador, int valor, String previsao, int valorAssegurado) {
		if (this.estado.split(" ")[0].equals("Finalizado")) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		ApostaAssegurada aposta = new ApostaAssegurada(apostador, valor, previsao, valorAssegurado);
		this.apostas.add(aposta);
		return (Integer) this.apostas.indexOf(aposta) + 1;
	}

	/**
	 * Método que converte uma aposta assegurada por taxa para uma aposta assegurada
	 * por valor.
	 * 
	 * @param apostaAssegurada
	 *            Número que representa a aposta Assegurada.
	 * @param valorAssegurado
	 *            Valor que será assegurado.
	 * @return Retorna um numero correspondente a identificação da aposta.
	 */
	public int alterarSeguroValor(int apostaAssegurada, int valorAssegurado) {
		if (apostaAssegurada < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		if (apostaAssegurada > this.apostas.size()) {
			throw new IndexOutOfBoundsException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		this.apostas.get(apostaAssegurada - 1).alterarSeguroValor(valorAssegurado);
		return apostaAssegurada;
	}

	/**
	 * Método que converte uma aposta assegurada por valor para uma aposta
	 * assegurada por taxa.
	 * 
	 * @param apostaAssegurada
	 *            Número que representa a aposta Assegurada.
	 * @param taxa
	 *            taxa a ser aplicado no seguro.
	 * @return Retorna um numero correspondente a identificação da aposta.
	 */
	public int alterarSeguroTaxa(int apostaAssegurada, double taxa) {
		if (apostaAssegurada < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		if (apostaAssegurada > this.apostas.size()) {
			throw new IndexOutOfBoundsException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		this.apostas.get(apostaAssegurada - 1).alterarSeguroTaxa(taxa);
		return apostaAssegurada;
	}

	/**
	 * Método que que soma e retorna o valor total das apostas feitas no cenário.
	 * 
	 * @return Retorna o valor total das apostas.
	 */
	public int valorTotalDeApostas() {
		int resultado = 0;

		for (int i = 0; i < apostas.size(); i++) {
			resultado += apostas.get(i).getValor();
		}
		return resultado;
	}

	/**
	 * Método que retorna o número total de apostas feitas para no cenário.
	 * 
	 * @return Retorna o número total de apostas feitas.
	 */
	public int totalDeApostas() {
		return apostas.size();
	}

	/**
	 * Método que gera e exibe uma representação textual de todas as apostas feitas
	 * para o cenário indicado, uma a cada linha.
	 * 
	 * @return Retorna uma representação textual de todas apostas feitas para o
	 *         cenário.
	 */
	public String exibeApostas() {
		String resultado = "";

		for (int i = 0; i < apostas.size(); i++) {
			resultado += apostas.get(i).toString() + System.lineSeparator();

		}
		return resultado;
	}

	/**
	 * Método que finaliza as apostas, inserido se o cenario aconteceu ou não e taxa
	 * aplicado pelo sistema as apostas perdedoras. E retorna o valor a ser
	 * adicionado ao caixa do sistema.
	 * 
	 * @param ocorreu
	 *            Valor booleano que indica se o cenário ocorreu ou não.
	 * @param taxa
	 *            Taxa a ser aplicada em cima do valor arrecadado dos perdedores.
	 * @return Valor as ser adicionado ao sistema de acordo com a taxa.
	 */
	public int fecharAposta(boolean ocorreu, double taxa) {
		if (this.estado.split(" ")[0].equals("Finalizado")) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		int resultado = 0;
		String saidaOcorreu = "n ocorreu";
		if (ocorreu) {
			saidaOcorreu = "ocorreu";
		}

		for (int i = 0; i < this.apostas.size(); i++) {
			if (ocorreu && this.apostas.get(i).getPrevisao().equals("N VAI ACONTECER")) {
				resultado += apostas.get(i).getValor();
			}
			if (!ocorreu && this.apostas.get(i).getPrevisao().equals("VAI ACONTECER")) {
				resultado += apostas.get(i).getValor();

			}
		}
		this.estado = "Finalizado (" + saidaOcorreu + ")";
		this.taxaCenario = (int) (resultado * taxa);
		this.TotalRateioCenario = resultado - this.taxaCenario;
		return this.taxaCenario;
	}

	/**
	 * Metodo auxiliar que retorna o valor total assegurado das apostas caso elas
	 * percam em uma das duas previsões possiveis para um cenário. Para isso recebe
	 * a previsão que se deseja calcular o valor total assegurado.
	 * 
	 * @param ocorreu
	 *            Valor booleano que indica se o cenário ocorreu ou não.
	 * @return Retorna o valor total assegurado para a previsão inserida.
	 */
	public int seguroApostaTotal(boolean ocorreu) {
		int resultado = 0;
		for (int i = 0; i < this.apostas.size(); i++) {
			if (ocorreu && this.apostas.get(i).getPrevisao().equals("N VAI ACONTECER")) {
				resultado += this.apostas.get(i).getSeguro();
			}
			if (!ocorreu && this.apostas.get(i).getPrevisao().equals("VAI ACONTECER")) {
				resultado += this.apostas.get(i).getSeguro();

			}
		}

		return resultado;
	}

	/**
	 * Método que gera uma String com uma representação textual do cenário, contendo
	 * a descrição e o estado em que o cenário se encontra.
	 * 
	 * @return A representação textual de um Cenário.
	 */
	@Override
	public String toString() {
		return this.descricao + " - " + this.estado;
	}

}
