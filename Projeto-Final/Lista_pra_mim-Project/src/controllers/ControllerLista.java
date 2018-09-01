package controllers;

import java.text.SimpleDateFormat;
import java.util.*;

import comparators.ComparaDescritor;
import comparators.ComparaPrecoTotal;
import comparators.ComparaTempo;
import entidades.Item;
import entidades.ListaDeCompras;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 *
 * Classe que representa o Controller.
 * Nesta classe e possivel realizar operacoes como: adicionar itens a uma lista de
 * compras, exibir listas, atualizar listas, etc.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ControllerLista {

	/**
	 * Um Mapa que mapeia uma String descritor da lista para uma lista de compras.
	 */
	private Map<String, ListaDeCompras> listasDeCompras;

	/**
	 * Atributo que representa o controller de item, e permite este controller
	 * conhecer os itens cadastrados no sistema.
	 */
	private ControllerItem controllerItem;

	/**
	 * Atributo que representa um comparador de compras.
	 */
	private Comparator<ListaDeCompras> comparador;

	/**
	 * Constroi um controller de lista, e inicializa o Mapa.
	 *
	 * @param controllerItem Controlador de item.
	 */
	public ControllerLista(ControllerItem controllerItem) {
		this.listasDeCompras = new HashMap<>();
		this.controllerItem = controllerItem;
	}

	/**
	 * Cria uma nova lista de compras.
	 *
	 * @param descritorLista O descritor da lista.
	 * @return A representacao textual do descritor da lista criada.
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		if (descritorLista == null) {
			throw new NullPointerException(
					"Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}

		if ("".equals(descritorLista.trim())) {
			throw new IllegalArgumentException(
					"Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}

		if (listasDeCompras.containsKey(descritorLista)) {
			throw new IllegalArgumentException("Erro na criacao de lista de compras: lista ja cadastrada no sistema.");
		}

		this.listasDeCompras.put(descritorLista, new ListaDeCompras(descritorLista));
		return descritorLista;
	}

	/**
	 * Metodo que adiciona um item com sua quantidade, em uma determinada lista.
	 *
	 * @param descritorLista O descritor da lista.
	 * @param quantidade     A quantidade do item.
	 * @param itemId         O item a ser adicionado na lista.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		this.verificaDescritor(descritorLista, "Erro na adicao de item na lista de compras");

		this.listasDeCompras.get(descritorLista).adicionaCompraALista(quantidade,
				this.pegaItem(itemId, "Erro na compra de item: "));
	}

	/**
	 * Metodo que finaliza uma lista de compras.
	 *
	 * @param descritorLista     O descritor da lista.
	 * @param localDaCompra      O local de compra da lista.
	 * @param valorFinalDaCompra O valor final da compra.
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valorFinalDaCompra) {
		this.verificaDescritor(descritorLista, "Erro na finalizacao de lista de compras");

		if (localDaCompra == null) {
			throw new NullPointerException(
					"Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
		}

		if ("".equals(localDaCompra.trim())) {
			throw new IllegalArgumentException(
					"Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
		}

		if (valorFinalDaCompra < 1) {
			throw new IllegalArgumentException(
					"Erro na finalizacao de lista de compras: valor final da lista invalido.");
		}

		listasDeCompras.get(descritorLista).finalizarListaDeCompras(localDaCompra, valorFinalDaCompra);
	}

	/**
	 * Metodo que pesquisa uma item em uma lista.
	 *
	 * @param descritorLista O descritor da lista.
	 * @param itemId         o ID do item.
	 * @return A representacao textual do item pesquisado na lista.
	 */
	public String pesquisaCompraEmLista(String descritorLista, int itemId) {
		if (itemId < 1)
			throw new IllegalArgumentException("Erro na pesquisa de compra: item id invalido.");

		this.verificaDescritor(descritorLista, "Erro na pesquisa de compra");

		return this.listasDeCompras.get(descritorLista)
				.pesquisaCompraEmLista(this.pegaItem(itemId, "Erro na pesquisa de compra: "));
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
	public void atualizaCompraDeLista(String descritorLista, int itemId, int quantidade, String operacao) {
		this.verificaDescritor(descritorLista, "Erro na atualizacao de compra");

		if (!(operacao.equals("adiciona") || (operacao.equals("diminui")))) {
			throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}

		this.listasDeCompras.get(descritorLista).atualizaCompraDeLista(operacao,
				this.pegaItem(itemId, "Erro na exclusao de compra: "), quantidade);

	}

	/**
	 * Metodo que recupera um item de uma lista, a partir de sua posicao.
	 *
	 * @param descritorLista O descritor da lista.
	 * @param posicaoItem    A posicao do Item.
	 * @return A representacao textual de um item.
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		this.verificaDescritor(descritorLista, "Erro na pesquisa de compra");
		return this.listasDeCompras.get(descritorLista).getItemLista(posicaoItem);

	}

	/**
	 * Metodo que deleta uma compra de uma lista a partir do id do item.
	 *
	 * @param descritorLista O descritor da lista.
	 * @param itemId         O ID do item.
	 */
	public void deletaCompraDeLista(String descritorLista, int itemId) {
		this.verificaDescritor(descritorLista, "Erro na exclusao de compra");

		this.listasDeCompras.get(descritorLista)
				.deletaCompraDeLista(this.pegaItem(itemId, "Erro na exclusao de compra: "));
	}

	/**
	 * Metodo que recupera uma lista a partir de sua descricao.
	 *
	 * @param descritorLista O descritor da lista.
	 * @return A representacao Textual de uma lista.
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		this.verificaDescritor(descritorLista, "Erro na pesquisa de compra");

		return this.listasDeCompras.get(descritorLista).getDescritorLista();
	}

	/**
	 * Metodo que retorna uma lista com as listas de compras criadas na data escolhida pelo
	 * usuario. Esta e ordenada lexicograficamente a partir de seus descritores.
	 *
	 * @param data A data da criaçao da lista.
	 * @return As listas de compras criadas na data.
	 */
	private List<ListaDeCompras> getListasDoDia(String data) {
		if (data == null)
			throw new NullPointerException("Erro na pesquisa de compra: data nao pode ser vazia ou nula.");

		if ("".equals(data.trim())) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: data nao pode ser vazia ou nula.");
		}

		if (data.length() < 10 || !(data.charAt(2) == data.charAt(5) && data.charAt(2) == '/')) {
			throw new IllegalArgumentException(
					"Erro na pesquisa de compra: data em formato invalido, tente dd/MM/yyyy");
		}

		List<ListaDeCompras> listasDoDia = new ArrayList<>();

		this.comparador = new ComparaDescritor();

		for (ListaDeCompras listaDeCompra : this.listasDeCompras.values()) {
			if (data.equals(listaDeCompra.getData()))
				listasDoDia.add(listaDeCompra);
		}

		listasDoDia.sort(this.comparador);

		return listasDoDia;
	}

	/**
	 * Metodo que retorna todas as listas de compras cadastradas na data passada como parametro.
	 *
	 * @param data A data da de criacao da lista.
	 * @return A representacao textual contendo a(s) lista(s) com a data passada
	 *         como parametro.
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		StringBuilder saida = new StringBuilder();

		for (ListaDeCompras lista : this.getListasDoDia(data)) {
			saida.append(lista.getDescritorLista()).append(System.lineSeparator());
		}

		return saida.toString().trim();
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
		if (posicaoLista < 0)
			throw new ArrayIndexOutOfBoundsException("Erro na pesquisa de compra: posicao nao pode ser menor que zero");

		return this.getListasDoDia(data).get(posicaoLista).getDescritorLista();

	}

	/**
	 * Metodo que retorna uma lista com todas as listas que possuem o item escolhida pelo
	 * usuario.
	 *
	 * @param id O id do item.
	 * @param comparador Metodo de comparacao escolhido para a necessidade.
	 * @return As listas de compra que possuem o item.
	 */
	private List<ListaDeCompras> getListasPorItem(int id, Comparator<ListaDeCompras> comparador) {
		if (id < 1)
			throw new IllegalArgumentException("Erro na pesquisa de compra: id nao pode ser menor que um");

		List<ListaDeCompras> listasComItem = new ArrayList<>();

		for (ListaDeCompras listaDeCompra : this.listasDeCompras.values()) {
			if (listaDeCompra.hasItem(id))
				listasComItem.add(listaDeCompra);
		}

		if (listasComItem.isEmpty())
			throw new IllegalArgumentException();

		listasComItem.sort(comparador);

		return listasComItem;

	}

	/**
	 * Metodo que retorna as listas que contem um determinado item.
	 *
	 * @param id O id do item.
	 * @return A representacao textual de todas as listas de compras que contem o item.
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		StringBuilder saida = new StringBuilder();

		try {
			for (ListaDeCompras lista : this.getListasPorItem(id, new ComparaDescritor())) {
				saida.append(lista.getDescritorLista()).append(System.lineSeparator());
			}
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
		}

		return saida.toString().trim();
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
		if (posicaoLista < 0)
			throw new ArrayIndexOutOfBoundsException("Erro na pesquisa de compra: posicao nao pode ser menor que zero");

		return this.getListasPorItem(id, new ComparaDescritor()).get(posicaoLista).toString();
	}

	/**
	 * Metodo que recupera um item a partir de seu id.
	 *
	 * @param id  O id do item.
	 * @param msg Parte da mensagem de erro que sera lancada caso alguma excecao
	 *            ocorra.
	 * @return O objeto item.
	 */
	private Item pegaItem(int id, String msg) {
		return this.controllerItem.pegaItem(id, msg);
	}

	/**
	 * Metodo que recupera um item a partir de seu id.
	 *
	 * @param id O id do item.
	 * 
	 * @return O objeto item.
	 */
	private Item pegaItem(int id) {
		return this.controllerItem.pegaItem(id);
	}

	/**
	 * Metodo que verifica a validade e checa a existenciado do descritor de uma
	 * lista repassado pelo usuario
	 *
	 * @param descritorLista O descritor de uma lista.
	 * @param erro           Parte da mensagem de erro que sera lancada caso alguma
	 *                       excecao ocorra.
	 */
	private void verificaDescritor(String descritorLista, String erro) {
		if (descritorLista == null) {
			throw new NullPointerException(erro + ": descritor nao pode ser vazio ou nulo.");
		}

		if ("".equals(descritorLista.trim())) {
			throw new IllegalArgumentException(erro + ": descritor nao pode ser vazio ou nulo.");
		}

		if (!listasDeCompras.containsKey(descritorLista)) {
			throw new IllegalArgumentException(erro + ": lista de compras nao existe.");
		}
	}

	/**
	 * Metodo que gera uma lista automatica do tipo 1, repetindo os itens da lista de
	 * compras mais recentemente criada.
	 * 
	 * @return Retorna a representacao textual do descritor da lista automatica 1
	 *         com a data da criacao.
	 */
	public String geraAutomaticaUltimaLista() {
		String nomeLista = "Lista automatica 1 " + new SimpleDateFormat("dd/MM/yyyy").format(new Date());

		ListaDeCompras ultimaLista = Collections.max(this.listasDeCompras.values(), new ComparaTempo());

		this.listasDeCompras.put(nomeLista, new ListaDeCompras(nomeLista));

		for (int i = 0; i < controllerItem.getId(); i++) {
			if (ultimaLista.hasItem(i)) {
				int quantidade = ultimaLista.getQuantidadeCompra(this.pegaItem(i));
				this.listasDeCompras.get(nomeLista).adicionaCompraALista(quantidade, this.pegaItem(i));
			}
		}
		return nomeLista;
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
		if (descritorItem == null)
			throw new NullPointerException("Erro ao gerar uma lista automatica por item: Descritor de item nao pode ser vazio ou nulo.");
		if ("".equals(descritorItem))
			throw new IllegalArgumentException("Erro ao gerar uma lista automatica por item: Descritor de item nao pode ser vazio ou nulo.");

		ListaDeCompras ultimaLista;
		String nomeLista = "Lista automatica 2 " + new SimpleDateFormat("dd/MM/yyyy").format(new Date());

		try {
			ultimaLista = Collections.max(this
					.getListasPorItem(this.controllerItem.getIdPorDescricao(descritorItem), new ComparaTempo()), new ComparaTempo());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(
					"Erro na geracao de lista automatica por item: nao ha compras cadastradas com o item desejado.");
		}

		listasDeCompras.put(nomeLista, new ListaDeCompras(nomeLista));

		for (int i = 0; i < controllerItem.getId(); i++) {
			if (ultimaLista.hasItem(i)) {
				int quantidade = ultimaLista.getQuantidadeCompra(this.pegaItem(i));
				this.listasDeCompras.get(nomeLista).adicionaCompraALista(quantidade, this.pegaItem(i));
			}
		}
		return nomeLista;
	}

	/**
	 * Metodo que gera uma lista automatica do tipo 3 com os itens que mais aparecem nas
	 * listas criadas anteriormente.
	 * 
	 * @return Retorna a representacao textual do descritor da lista automatica 3
	 *         com a data da criacao.
	 */
	public String geraAutomaticaItensMaisPresentes() {
		String nomeLista = "Lista automatica 3 " + new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		int quantidade = 0;
		int apareceu = 0;

		listasDeCompras.put(nomeLista, new ListaDeCompras(nomeLista));

		for (int i = 0; i < controllerItem.getId(); i++) {
			for (ListaDeCompras list : listasDeCompras.values()) {
				if (list.hasItem(i)) {
					apareceu++;
					quantidade += list.getQuantidadeCompra(this.pegaItem(i));
				}
			}

			if (apareceu >= listasDeCompras.values().size() / 2) {
				int quantidadeNovo = (int) (Math.floor(((double) quantidade) / apareceu));
				listasDeCompras.get(nomeLista).adicionaCompraALista(quantidadeNovo, this.pegaItem(i));
				quantidade = 0;
				apareceu = 0;
			} else {
				quantidade = 0;
				apareceu = 0;
			}
		}

		return nomeLista;
	}

	/**
	 * Metodo que recebe uma lista e cria outra lista com listas de compras geradas
	 * com os estabelecimentos que contem os itens da lista repassada.
	 * 
	 * @param lista Lista base para formar a lista temporaria.
	 * @return Retorna uma lista de estabelecimentos.
	 */
	private ArrayList<ListaDeCompras> listaTemp(ListaDeCompras lista) {
		int contador = 0;
		double valor = 0;
		ArrayList<ListaDeCompras> listasTemp = new ArrayList<>();

		for (String local : lista.getEstabelecimentos()) {
			listasTemp.add(new ListaDeCompras(local));
			for (int i = 0; i < lista.getMaiorId() + 2; i++) {
				if (this.pegaItem(i) != null) {
					if (lista.hasItem(i)) {
						Item item = this.pegaItem(i);
						try {
							valor += (item.getPreco(local) * lista.getQuantidadeCompra(item));
							listasTemp.get(contador).adicionaCompraALista(lista.getQuantidadeCompra(item), item);
						} catch (Exception ignored) {
						}
					}
				}
			}
			listasTemp.get(contador).finalizarListaDeCompras("temp", (int) (valor * 1000));
			contador++;
			valor = 0;
		}
		return listasTemp;
	}

	/**
	 * Metodo que sugere os melhores estabelecimentos para se fazer as compras de
	 * acordo com a lista passada, ordenados de forma crescente, de acordo com o
	 * valor medio das compras.
	 * 
	 * @param descritorLista         O descritor de uma lista.
	 * @param posicaoEstabelecimento Posicao que se encontra o estabelecimento.
	 * @param posicaoLista           Posicao que se quer pesquisar na lista
	 * @return retorna um representacao textual.
	 */
	public String sugereMelhorEstabelecimento(String descritorLista, int posicaoEstabelecimento, int posicaoLista) {
		this.verificaDescritor(descritorLista, "Erro ao sugerir estabelecimento");

		try {
			ArrayList<ListaDeCompras> locaisDeCompra = listaTemp(listasDeCompras.get(descritorLista));
			locaisDeCompra.sort(new ComparaPrecoTotal());
			if (posicaoLista == 0) {
				return String.format("%s: R$ %.2f", locaisDeCompra.get(posicaoEstabelecimento).getDescritorLista(),
						((locaisDeCompra.get(posicaoEstabelecimento).getPrecoTotal()) / 1000.0));
			}

			String resultado = locaisDeCompra.get(posicaoEstabelecimento).getItemLista(posicaoLista - 1);

			if (resultado.equals("")) {
				return "";
			}
			return "- " + resultado;
		} catch (Exception e) {
			throw new IllegalArgumentException("Faltam dados para informar sobre preços em locais de compras.");

		}
	}

	/**
	 * Metodo getter que retorna um Map que mapeia listas de compras a Strings.
	 * 
	 * Este metodo nao utiliza parametros.
	 * 
	 * @return Um Map que mapeia listas de compras a Strings.
	 */
	public Map<String, ListaDeCompras> getListasDeCompras() {
		return this.listasDeCompras;
	}

	/**
	 * Metodo setter que define os valores de um mapa.
	 * 
	 * @param listasDeCompras Um Map que mapeira listas de compras a Strings.
	 * 
	 * Este metodo nao retorna nenhum valor.
	 */
	public void setListasDeCompras(Map<String, ListaDeCompras> listasDeCompras) {
		this.listasDeCompras = listasDeCompras;
	}

}
