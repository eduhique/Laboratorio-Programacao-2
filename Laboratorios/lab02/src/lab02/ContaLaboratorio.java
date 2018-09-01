package lab02;

/**
 * Laboratório de Programação 2 - Lab 2
 * 
 * Representação da conta de laborátorio de um aluno da UFCG. Permite cadastrar
 * um laborátorio; criar e gerenciar uma cota de armazenamento, consumindo e
 * liberando espaço.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ContaLaboratorio {

	/**
	 * Nome do laboratório. No formato texto (String) XXXX. ex: "LCC 3"
	 */
	public String nomeLaboratorio;

	/**
	 * Cota de uso no laboratório. Número inteiro que representa a quantidade de
	 * espaço de armazebamento máxima, em megabytes, que o aluno pode usar.
	 */
	public int cotaDeUso;

	/**
	 * Cota atualmente usada pelo aluno.Numro de inteiro que representa a quantidade
	 * de espaço de armazenamento ultilizada, em megabytes.
	 */
	private int cotaUsadaTotal = 0;

	/**
	 * Constrói uma conta em um laboratório. recebe uma String com o nome do
	 * laboratório. para esse construtor sera atribuido a cota padrão de 2000 mb.
	 * 
	 * @param nomeLaboratorio,
	 *            nome do laboratório.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this(nomeLaboratorio, 2000);
	}

	/**
	 * Constrói um conta em um laboratório. Recebe uma String com o nome do
	 * laboratório onde será criado a conta e um int correspondendo a cota, em
	 * megabytes.
	 * 
	 * @param nomeLaboratorio,
	 *            nome do laboratório.
	 * @param cota,
	 *            cota, em magabytes, atribuido a conta.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cotaDeUso = cota;
	}

	/**
	 * Método sem retorno que contabiliza a a cota usada na conta do laboratório.
	 * Recebe um inteiro que representa o número de megabytes a ser ocupado na cota.
	 * 
	 * @param mbytes,
	 *            número de megabytes usados da cota.
	 */
	public void consomeEspaco(int mbytes) {
		this.cotaUsadaTotal += mbytes;
	}

	/**
	 * Método sem retorno que libera espaço de armazenamento na cota da conta do
	 * laboratório. Recebe um inteiro que representa o número de megabytes a ser
	 * liberado na cota.
	 * 
	 * @param mbytes
	 *            número de megabytes liberados da cota.
	 */
	public void liberaEspaco(int mbytes) {
		this.cotaUsadaTotal -= mbytes;
	}

	/**
	 * Método que retorna um boleano que diz se o aluno atingiu a cota. Este método
	 * não recebe nenhum parâmetro.
	 * 
	 * @return um boleano true, se o aluno atingiu a cota, ou false, se ainda não
	 *         atingiu.
	 */
	public boolean atingiuCota() {
		if (this.cotaDeUso > this.cotaUsadaTotal)
			return false;
		return true;

	}

	/**
	 * Método que retorna uma String que representa a conta no laboratório. A
	 * representação segue no formato "NomeDoLaboratório cotaUsada CotaDeUso.
	 * 
	 * @return a representação da String ContaLaboratório.
	 */
	public String toString() {
		String estado = this.nomeLaboratorio + " " + this.cotaUsadaTotal + "/" + this.cotaDeUso;
		return estado;
	}
}
