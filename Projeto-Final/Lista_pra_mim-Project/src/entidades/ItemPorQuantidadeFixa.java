package entidades;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 *
 * Classe que representa um Item comercializado com quantidade fixa. Este tipo
 * de item base possui nome, categoria, unidade de medida, quantidade e precos.
 * Nesta classe e possivel crir um item, adicionar um preco a um item, recuperar
 * o nome do item, recuperar a categoria de um item, etc.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ItemPorQuantidadeFixa extends Item {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6717167202877065938L;

	/**
	 * Unidade de medida do item.
	 */
	private String unidadeDeMedida;

	/**
	 * Quantidade fixa do item.
	 */
	private int qnt;

	/**
	 * Método que cria um item que tem quantidade fixa.
	 *
	 * @param nome
	 *            String que representa o nome do item;
	 * @param categoria
	 *            String que representa a categoria do item;
	 * @param qnt
	 *            Inteiro que representa a quantidade fixa do item;
	 * @param unidadeDeMedida
	 *            String que representa a unidade de medida utilizada pelo item;
	 * @param localDeCompra
	 *            String que representa o local de compra do produto;
	 * @param preco
	 *            Double que representa o valor de compra do produto.
	 * @param id
	 *            Identtficacao unica do item.
	 */
	public ItemPorQuantidadeFixa(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco, int id) {
		super(nome, categoria, localDeCompra, preco, id);

		if (unidadeDeMedida == null)
			throw new NullPointerException("Erro no cadastro de item: unidade de medida nao pode ser vazia ou nula.");
		if (unidadeDeMedida.trim().equals(""))
			throw new IllegalArgumentException(
					"Erro no cadastro de item: unidade de medida nao pode ser vazia ou nula.");

		if (qnt < 0)
			throw new IllegalArgumentException(
					"Erro no cadastro de item: valor de quantidade nao pode ser menor que zero.");

		this.qnt = qnt;
		this.unidadeDeMedida = unidadeDeMedida;
	}

	/**
	 * Metodo que atualiza os dados de um item de acordo com o solicitado pelo
	 * usuario.
	 *
	 * @param atributo
	 *            Uma String que representa o atributo que sera atualizado.
	 * @param novoValor
	 *            Uma String que representa o novo valor para o atributo.
	 */
	@Override
	public void atualizaItem(String atributo, String novoValor) {

		switch (atributo.trim().toLowerCase()) {
		case "nome":
		case "categoria":
			super.atualizaItem(atributo, novoValor);
			break;

		case "quantidade":
			int qnt = Integer.parseInt(novoValor);

			if (qnt < 0)
				throw new IllegalArgumentException(
						"Erro na atualizacao de item: valor de quantidade nao pode ser menor que zero.");
			this.qnt = qnt;
			break;

		case "unidade de medida":
			if (novoValor == null)
				throw new NullPointerException(
						"Erro na atualizacao de item: unidade de medida nao pode ser vazia ou nula.");
			if ("".equals(novoValor.trim()))
				throw new IllegalArgumentException(
						"Erro na atualizacao de item: unidade de medida nao pode ser vazia ou nula.");
			this.unidadeDeMedida = novoValor;
			break;

		default:
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao existe.");
		}
	}

	/**
	 * Metodo que retorna representacao textual de um item.
	 *
	 * @return Uma String contendo nome e categoria de um item.
	 */
	public String toString() {
		return String.format("%s, %d %s, Preco: %s", super.toString(), this.qnt, this.unidadeDeMedida,
				super.getListaPrecos());
	}

	/**
	 * Metodo que retorna uma String contendo a descricao de um item.
	 * 
	 * Este metodo nao utiliza parametros.
	 * 
	 * @return Uma String contendo a descricao de um item e sua quantidade e unidade
	 *         de medida.
	 */
	@Override
	public String getDescricao() {
		return String.format("%s, %d %s", super.toString(), this.qnt, this.unidadeDeMedida);
	}
}
