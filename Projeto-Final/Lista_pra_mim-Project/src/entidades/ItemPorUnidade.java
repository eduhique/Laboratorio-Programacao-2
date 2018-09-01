package entidades;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 *
 * Classe que representa um Item comercializado por unidade. Este tipo de item
 * base possui nome, categoria, quantidade e precos. Nesta classe e possivel
 * crir um item, adicionar um preco a um item, recuperar o nome do item,
 * recuperar a categoria de um item, etc.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ItemPorUnidade extends Item {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1439042583672669777L;
	/**
	 * Quantidade de itens por compra.
	 */
	private int qnt;

	/**
	 * Método que cria um item comercializado por quilo.
	 *
	 * @param nome
	 *            String que representa o nome do item;
	 * @param categoria
	 *            String que representa a categoria do item;
	 * @param qnt
	 *            Inteiro que representa a quantidade de itens por compra;
	 * @param localDeCompra
	 *            String que representa o local de compra do produto;
	 * @param preco
	 *            Double que representa o valor de compra do produto.
	 * @param id
	 *            Identtficacao unica do item.
	 */
	public ItemPorUnidade(String nome, String categoria, int qnt, String localDeCompra, double preco, int id) {
		super(nome, categoria, localDeCompra, preco, id);

		if (qnt < 0)
			throw new IllegalArgumentException(
					"Erro no cadastro de item: valor de unidade nao pode ser menor que zero.");

		this.qnt = qnt;
	}

	/**
	 * Metodo que atualiza os dados de um item de acordo com a necessidade do usuario.
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

		case "unidade":
			int qnt = Integer.parseInt(novoValor);

			if (qnt < 0)
				throw new IllegalArgumentException(
						"Erro na atualizacao de item: valor de unidade nao pode ser menor que zero.");
			this.qnt = qnt;
			break;

		default:
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao existe.");
		}
	}

	/**
	 * Metodo que retorna representacao textual de um item.
	 *
	 * @return Uma String contendo nome, categoria, locais de compras e precos de um item.
	 */
	public String toString() {
		return String.format("%s, Preco: %s", super.toString(), super.getListaPrecos());
	}

	/**
	 * Metodo que retorna uma String contendo a descricao de um item.
	 * 
	 * Este metodo nao utiliza parametros.
	 * 
	 * @return Uma String contendo a descricao de um item.
	 */
	@Override
	public String getDescricao() {
		return String.format("%s", super.toString());
	}
}
