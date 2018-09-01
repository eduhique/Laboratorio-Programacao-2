package facade;

import easyaccept.EasyAccept;
import entidades.Persistencia;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import controllers.ControllerItem;
import controllers.ControllerLista;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 * 
 * Representacao de uma Facade. Esta que delega os metodos para seus devidos destinos.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class Facade {

	// Atributo que representa um Objeto ControllerItem.
	private ControllerItem controllerItem;
	// Atributo que representa um Objeto ControllerLista.
	private ControllerLista controllerLista;
	// Atributo que representa um Objeto Persistência.
	private Persistencia persistencia;

	public static void main(String[] args) {
		args = new String[] { "facade.Facade", "acceptance_tests/use_case1.txt",
				"acceptance_tests/use_case1_exception.txt", "acceptance_tests/use_case2.txt",
				"acceptance_tests/use_case2_exception.txt", "acceptance_tests/use_case3.txt",
				"acceptance_tests/use_case3_exception.txt", "acceptance_tests/use_case4.txt",
				"acceptance_tests/use_case4_exception.txt", "acceptance_tests/use_case5.txt",
				"acceptance_tests/use_case6.txt", "acceptance_tests/use_case6_exception.txt",
				"acceptance_tests/use_case7.txt" };

		EasyAccept.main(args);
	}

	/**
	 * Constroi o objeto Facade, inicializa os objetos ControllerItem, ControllerLista e Persistencia.
	 */
	public Facade() {
		this.controllerItem = new ControllerItem();
		this.controllerLista = new ControllerLista(controllerItem);
		this.persistencia = new Persistencia(controllerItem, controllerLista);
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorQuantidade a uma lista que contem
	 * todos os itens cadastrados.
	 *
	 * @param nome            Uma String que representa o nome do produto.
	 * @param categoria       Uma String que representa a categoria do item.
	 * @param qnt             Um inteiro que representa a quantidade de produtos que
	 *                        se encontram na embalagem de um item.
	 * @param unidadeDeMedida Uma String que representa a unidade de medida do
	 *                        produto (gramas, litros, etc.).
	 * @param localDeCompra   Uma String que representa onde o item foi comprado.
	 * @param preco           Um double que representa o valor do item.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		return this.controllerItem.adicionaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorQuilo a uma lista que contem todos
	 * os itens.
	 *
	 * @param nome          Uma String que representa o nome do produto.
	 * @param categoria     Uma String que representa a categoria do item.
	 * @param kg            Um double que representa o peso do item.
	 * @param localDeCompra Uma String que representa onde o item foi comprado.
	 * @param preco         Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return this.controllerItem.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorUnidade a uma lista que contem
	 * todos os itens.
	 *
	 * @param nome          Uma String que representa o nome do produto.
	 * @param categoria     Uma String que representa a categoria do item.
	 * @param qnt           Um inteiro que representa a quantidade de produtos que
	 *                      se encontram na embalagem do item.
	 * @param localDeCompra Uma String que representa onde o item foi comprado.
	 * @param preco         Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int qnt, String localDeCompra, double preco) {
		return this.controllerItem.adicionaItemPorUnidade(nome, categoria, qnt, localDeCompra, preco);
	}

	/**
	 * Metodo que retorna uma String contendo a exibicao de um item.
	 *
	 * @param id Um inteiro que representa o identificador de um item.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String exibeItem(int id) {
		return this.controllerItem.exibeItem(id);
	}

	/**
	 * Metodo que atualiza o atributo de um item passando um novo valor para o
	 * atributo.
	 *
	 * @param id        Um inteiro que representa o identificador unico de um item.
	 * @param atributo  Uma String que representa o atributo a ser modificado.
	 * @param novoValor Uma String que representa o novo valor para o item.
	 *
	 *                  Este metodo nao retorna nenhum valor.
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		this.controllerItem.atualizaItem(id, atributo, novoValor);
	}

	/**
	 * Metodo que adiciona um preco a um item.
	 *
	 * @param id            Um inteiro que representa o identificador de um item.
	 * @param localDeCompra Uma String que representa o local de compra do item.
	 * @param preco         Um double que representa o valor do preco que será
	 *                      adicionado.
	 *
	 *                      Este método não retorna nenhum valor.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		this.controllerItem.adicionaPrecoItem(id, localDeCompra, preco);
	}

	/**
	 * Metodo que remove um item a partir de seu id.
	 *
	 * @param id Um inteiro que representa o identificador de um item.
	 *
	 *           Este metodo nao retorna nenhum valor.
	 */
	public void deletaItem(int id) {
		this.controllerItem.deletaItem(id);
	}

	/**
	 * Metodo que ordena os itens por ordem alfabetica, e retorna um item na posicao
	 * em que foi ordenado.
	 *
	 * @param posicao A posicao em que o item esta posicionado ordenadamente.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItem(int posicao) {
		return this.controllerItem.getItem(posicao);
	}

	/**
	 * Metodo que ordena os itens pela categoria e retorna a exibicao de um item
	 * a partir da sua posicao na lista ordenada de itens.
	 *
	 * @param posicao   A posicao em que o item esta posicionado ordenadamente.
	 * @param categoria catergoria que sera realizada a pesquisa.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return this.controllerItem.getItemPorCategoria(categoria, posicao);
	}

	/**
	 * Metodo que ordena os itens por preco, e retorna a exibicao de um item
	 * a partir da sua posicao na lista ordenada de itens.
	 *
	 * @param posicao A posicao em que o item esta posicionado ordenadamente.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorMenorPreco(int posicao) {
		return this.controllerItem.getItemPorMenorPreco(posicao);
	}

	/**
	 * Metodo que ordena os itens relacionados a uma dada string de pesquisa e a
	 * listagem deve ocorrer em ordem alfabética considerando, a representação em
	 * string do item, e retorna um item na posicao em que foi ordenado.
	 *
	 * @param posicao       A posicao em que o item esta posicionado ordenadamente.
	 * @param strPesquisada parametro de pesquisa.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return this.controllerItem.getItemPorPesquisa(strPesquisada, posicao);
	}

	/**
	 * Cria uma nova lista de compras.
	 *
	 * @param descritorLista O descritor da lista.
	 * @return A representacao textual do descritor da lista criada.
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		return this.controllerLista.adicionaListaDeCompras(descritorLista);
	}

	/**
	 * Metodo que adiciona um item com sua quantidade, em uma determinada lista.
	 *
	 * @param descritorLista O descritor da lista.
	 * @param quantidade     A quantidade do item.
	 * @param itemId         O item a ser adicionado na lista.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		this.controllerLista.adicionaCompraALista(descritorLista, quantidade, itemId);
	}

	/**
	 * Metodo que finaliza uma lista de compras.
	 *
	 * @param descritorLista     O descritor da lista.
	 * @param localDaCompra      O local de compra da lista.
	 * @param valorFinalDaCompra O valor final da compra.
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valorFinalDaCompra) {
		this.controllerLista.finalizarListaDeCompras(descritorLista, localDaCompra, valorFinalDaCompra);
	}

	/**
	 * Metodo que recupera uma lista a partir de sua descricao.
	 *
	 * @param descritorLista O descritor da lista.
	 * @return A representacao Textual de uma lista.
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		return this.controllerLista.pesquisaListaDeCompras(descritorLista);

	}

	/**
	 * Metodo que pesquisa uma item em uma lista.
	 *
	 * @param descritorLista O descritor da lista.
	 * @param itemId         o ID do item.
	 * @return A representacao textual do item pesquisado na lista.
	 */
	public String pesquisaCompraEmLista(String descritorLista, int itemId) {
		return this.controllerLista.pesquisaCompraEmLista(descritorLista, itemId);
	}

	/**
	 * Metodo que atualiza a quantidade de um item, em uma determinada lista.
	 *
	 * @param descritorLista O descritor da lista.
	 * @param itemId         O ID do item.
	 * @param quantidade     A quantidade nova do item.
	 * @param operacao       A operacao de diminuir ou aumentar a quantidade do
	 *                       item.
	 */
	public void atualizaCompraDeLista(String descritorLista, int itemId, String operacao, int quantidade) {
		this.controllerLista.atualizaCompraDeLista(descritorLista, itemId, quantidade, operacao);
	}

	/**
	 * Metodo que recupera um item de uma lista, a partir de sua posicao.
	 *
	 * @param descritorLista O descritor da lista.
	 * @param posicaoItem    A posicao do Item.
	 * @return A representacao textual de um item.
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		return this.controllerLista.getItemLista(descritorLista, posicaoItem);
	}

	/**
	 * Metodo que deleta uma compra de uma lista a partir do id do item.
	 *
	 * @param descritorLista O descritor da lista.
	 * @param itemId         O ID do item.
	 */
	public void deletaCompraDeLista(String descritorLista, int itemId) {
		this.controllerLista.deletaCompraDeLista(descritorLista, itemId);
	}

	/**
	 * Metodo que recupera uma lista de compras a partir de sua data de cadastro, e sua
	 * posicao na lista de listas criadas no mesmo dia.
	 *
	 * @param data         A data da de criacao da lista.
	 * @param posicaoLista A posicao da lista.
	 * @return A representacao textual da lista de compras escolhida.
	 */
	public String getItemListaPorData(String data, int posicaoLista) {
		return this.controllerLista.getItemListaPorData(data, posicaoLista);
	}

	/**
	 * Metodo que recupera uma lista de compras a partir do id do item escolhido, e sua
	 * posicao na lista de listas que possuem o mesmo item.
	 *
	 * @param id           O id do item.
	 * @param posicaoLista A posicao da lista.
	 * @return A representacao textual da lista de compras escolhida pelo usuario.
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		return this.controllerLista.getItemListaPorItem(id, posicaoLista);
	}

	/**
	 * Metodo que retorna todas as listas de compras cadastradas na data passada como parametro.
	 *
	 * @param data A data da de criacao da lista.
	 * @return A representacao textual contendo a(s) lista(s) com a data passada
	 *         como parametro.
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		return this.controllerLista.pesquisaListasDeComprasPorData(data);
	}

	/**
	 * Metodo que retorna as listas que contem um determinado item.
	 *
	 * @param id O id do item.
	 * @return A representacao textual de todas as listas de compras que contem o item.
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		return this.controllerLista.pesquisaListasDeComprasPorItem(id);
	}

	/**
	 * Metodo que retorna a data atual do sistema.
	 * 
	 * @return em String a representacao da data atual.
	 */
	public String dataAtual() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}


	/**
	 * Metodo que gera uma lista automatica do tipo 1, repetindo os itens da lista de
	 * compras mais recentemente criada.
	 *
	 * @return Retorna a representacao textual do descritor da lista automatica 1
	 *         com a data da criacao.
	 */
	public String geraAutomaticaUltimaLista() {
		return this.controllerLista.geraAutomaticaUltimaLista();
	}

	/**
	 * Metodo que gera uma lista automatica do tipo 2. Essa lista e criada repetindo os
	 * itens da ultima lista que contem o item passado pelo usuario.
	 *
	 * @param descritorItem Nome do item que quer que esteja na lista automatica.
	 * @return Retorna a representacao textual do descritor da lista automatica 2
	 *         com a data da criacao.
	 */
	public String geraAutomaticaItem(String descritorItem) {
		return this.controllerLista.geraAutomaticaItem(descritorItem);
	}

	/**
	 * Metodo que gera uma lista automatica do tipo 3 com os itens que mais aparecem nas
	 * listas geradas, anteriormente.
	 * 
	 * @return Retorna a representacao textual do descritor da lista automatica 3
	 *         com a data da criacao.
	 */
	public String geraAutomaticaItensMaisPresentes() {
		return this.controllerLista.geraAutomaticaItensMaisPresentes();
	}

	/**
	 * Metodo que sugere os melhores estabelecimentos para se fazer as compras de
	 * acordo com a lista passada, ordenados de forma crescente, de acordo com o
	 * valor medio das compras.
	 * 
	 * @param descritorLista         O descritor de uma lista.
	 * @param posicaoEstabelecimento Posicao que se encontra o estabelecimento.
	 * @param posicaoLista           Posicao que se quer pesquisar da lista
	 * @return retorna um representacao textual.
	 */
	public String sugereMelhorEstabelecimento(String descritorLista, int posicaoEstabelecimento, int posicaoLista) {
		return this.controllerLista.sugereMelhorEstabelecimento(descritorLista, posicaoEstabelecimento, posicaoLista);

	}

	/**
	 * Metodo que invoca o metodo iniciaSistema da classe Persistencia.
	 * 
	 * Este metodo nao utiliza parametros.
	 * 
	 * Este metodo nao retorna nenhum valor.
	 * 
	 * @throws IOException            Este metodo pode lancar uma excecao.
	 * @throws ClassNotFoundException Este metodo pode lancar uma excecao.
	 */
	public void iniciaSistema() throws ClassNotFoundException, IOException {
		this.persistencia.iniciaSistema();
	}

	/**
	 * Metodo que invoca o metodo fechaSistema da classe Persistencia.
	 * 
	 * Este metodo nao utiliza parametros.
	 * 
	 * Este metodo nao retorna nenhum valor.
	 * 
	 * @throws IOException Este metodo pode lancar uma excecao.
	 */
	public void fechaSistema() throws IOException {
		this.persistencia.fechaSistema();
	}
}
