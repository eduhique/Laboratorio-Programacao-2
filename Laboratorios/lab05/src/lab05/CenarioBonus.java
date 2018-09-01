package lab05;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 *
 * Representação de um Cenário Bônus que é filha de cenario e possui os mesmos
 * atributos do pai e um Bônus que é dado aos vencedores, mas especializa alguns
 * de seus metodos, para viabilizar a aplicaçãodo bônus ao vencedores.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class CenarioBonus extends Cenario {

	/**
	 * Bônus Oferecido aos apostadores como incentivo.
	 */
	private int bonus;

	/**
	 * Invoca um construtor de Cenário Bônus, que cria um cenário com uma descrição
	 * e um bônus para os vecendores.
	 * 
	 * @param descricao
	 *            Descrição do cenário.
	 * @param bonus
	 *            Bônus oferecido aos vecendores.
	 * @param id
	 *            Identificador do cenario.
	 */
	public CenarioBonus(String descricao, int bonus, int id) {
		super(descricao, id);
		if (bonus < 1) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
		this.bonus = bonus;
	}

	/**
	 * Método auxiliar que retorna o valor total a ser dividido entre os vencedores
	 * somado do bônus, após o cenário ser fechado;
	 * 
	 * @return Retorna o valor a ser rateado entre os ganhadores com o bônus do
	 *         cenário.
	 */
	@Override
	public int getTotalRateioCenario() {
		return super.getTotalRateioCenario() + bonus;
	}

	/**
	 * Método que gera uma String com uma representação textual do cenário Bônus,
	 * contendo a descrição, estado em que o cenário se encontra e valor do bônus.
	 * no formato: "NUMERAÇÃO - DESCRIÇÃO - ESTADO - BÔNUS"
	 * 
	 * @return A representação textual de um Cenário.
	 */
	@Override
	public String toString() {
		double novoBonus = ((double) this.bonus) / 100;
		return String.format("%s - R$ %.2f", super.toString(), novoBonus);
	}

}
