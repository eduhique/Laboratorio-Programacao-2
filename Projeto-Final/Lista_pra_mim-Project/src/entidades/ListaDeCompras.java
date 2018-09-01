package entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

import comparators.ComparaCompras;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 *
 * Representa uma lista de compras que tem a capacidade armazenar compras.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ListaDeCompras implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3683351079303281407L;
	// Atributo que representa o horario.
	private Date horario = new Date();
	// Atributo que representa um Set de compras.
	private Set<Compra> compras;
	// Atributo que representa um boolean pra verificar se uma lista esta aberta ou
	// nao.
	private boolean aberto;
	// Atributo que representa o descritor da lista.
	private String descritorLista;
	// Atributo que representa a data de criacao da lista.
	private String data;
	// Atributo que representa a hora de criacao da lista.
	private String hora;
	// Atributo que representa o local de compra de uma lista.
	private String localDaCompra;
	// Atributo que representa o preco total de uma lista.
	private int precoTotal;
	// Atributo que representa o maior id de item que uma lista possui.
	private int maiorIdItem;
	// Atributo que inicializa o comparator de compras.
	private Comparator<Compra> comparaCompras;
	// Atributo que representa os nanosegundos cedidos pela JVM do momento da criacao da lista.
	private long nano;

	/**
	 * Constroi o objeto lista de compras.
	 *
	 * @param descritorLista O descritor da lista.
	 */
	public ListaDeCompras(String descritorLista) {
		if (descritorLista == null)
			throw new NullPointerException(
					"Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		if (descritorLista.trim().isEmpty())
			throw new IllegalArgumentException(
					"Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		this.descritorLista = descritorLista;
		this.data = new SimpleDateFormat("dd/MM/yyyy").format(horario);
		this.hora = new SimpleDateFormat("HH:mm:ss").format(horario);
		this.nano = System.nanoTime();
		this.compras = new HashSet<>();
		this.comparaCompras = new ComparaCompras();
		this.aberto = true;
	}

	/**
	 * Metodo que adiciona uma compra na lista.
	 *
	 * @param quantidade A quantida do item.
	 * @param item       O item a ser adicionado.
	 */
	public void adicionaCompraALista(int quantidade, Item item) {
		if (!aberto)
			throw new IllegalArgumentException("Erro na compra de item: lista ja finalizada.");
		Compra compra = new Compra(quantidade, item);
		compras.add(compra);
		if (item.getId() > maiorIdItem)
			maiorIdItem = item.getId();
	}

	/**
	 * Metodo que finaliza uma lista de compras.
	 *
	 * @param localDaCompra      O local da compra.
	 * @param valorFinalDaCompra O valor final de uma compra.
	 */
	public void finalizarListaDeCompras(String localDaCompra, int valorFinalDaCompra) {
		if (!aberto)
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: lista ja finalizada");
		if (localDaCompra == null)
			throw new NullPointerException(
					"Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
		if (localDaCompra.trim().isEmpty())
			throw new IllegalArgumentException(
					"Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
		if (valorFinalDaCompra <= 0)
			throw new IllegalArgumentException(
					"Erro na finalizacao de lista de compras: valor final da lista invalido.");
		this.localDaCompra = localDaCompra;
		this.precoTotal = valorFinalDaCompra;
		this.aberto = false;
	}

	/**
	 * Metodo que pesquisa uma compra na lista.
	 *
	 * @param item O item a ser pesquisado.
	 * @return em String a representacao textual de uma compra.
	 */
	public String pesquisaCompraEmLista(Item item) {
		for (Compra compra : compras) {
			if (compra.getItem() == item) {
				return compra.toString();
			}
		}
		throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
	}

	/**
	 * Metodo que atualiza a quantidade de um item presente na lista.
	 *
	 * @param item       O item.
	 * @param quantidade A quantidade nova do item.
	 * @param operacao   A operacao de diminuir ou aumentar a quantidade do item.
	 */
	public void atualizaCompraDeLista(String operacao, Item item, int quantidade) {
		if (!aberto)
			throw new IllegalArgumentException("Erro na atualizacao de compra: lista ja finalizada");
		if (!hasItem(item.getId()))
			throw new IllegalArgumentException("Erro na atualizacao de compra: compra nao encontrada na lista.");
		for (Compra compra : compras) {
			if (compra.getItem().equals(item)) {
				compra.atualizaCompra(operacao, quantidade);
				if (compra.getQuantidade() <= 0)
					compras.remove(compra);
				break;
			}
		}
	}

	/**
	 * Metodo que deleta uma compra de uma lista, a partir de um item.
	 *
	 * @param item O item.
	 */
	public void deletaCompraDeLista(Item item) {
		if (!aberto)
			throw new IllegalArgumentException("Erro na exclusao de compra: lista ja finalizada");
		if (item.getId() > maiorIdItem)
			throw new IllegalArgumentException("Erro na exclusao de compra: item nao existe no sistema.");
		if (!hasItem(item.getId()))
			throw new IllegalArgumentException("Erro na exclusao de compra: compra nao encontrada na lista.");
		for (Compra compra : compras) {
			if (compra.getItem() == item) {
				compras.remove(compra);
				break;
			}
		}

	}

	/**
	 * Metodo acessorio que verifica se a lista esta aberta.
	 *
	 * @return O boolean aberto.
	 */
	public boolean getAberto() {
		return this.aberto;
	}

	/**
	 * Metodo que retorna o descritor da lista.
	 *
	 * @return O descritor da lista.
	 */
	public String getDescritorLista() {
		return this.descritorLista;
	}

	/**
	 * Metodo que retorna a data de criacao da lista.
	 *
	 * @return A data de criacao da lista.
	 */
	public String getData() {
		return this.data;
	}

	/**
	 * Metodo que retorna a hora de criacao da lista.
	 *
	 * @return A hora de criacao da lista.
	 */
	public String getHora() {
		return this.hora;
	}

	/**
	 * Metodo que retorna o local de compra da lista.
	 *
	 * @return o local de compra.
	 */
	public String getLocalDeCompra() {
		if (aberto)
			throw new IllegalArgumentException("Erro na consulta de local de compra: lista ainda esta aberta");
		return this.localDaCompra;
	}

	/**
	 * Metodo que retorna o preco total de uma lista.
	 *
	 * @return O preco total.
	 */
	public int getPrecoTotal() {
		if (aberto)
			throw new IllegalArgumentException("Erro na consulta de preco total: lista ainda esta aberta");
		return this.precoTotal;
	}

	/**
	 * Metodo que retorna o maior id presente na lista.
	 *
	 * @return O maior Id presente na lista.
	 */
	public int getMaiorId() {
		return this.maiorIdItem;
	}

	/**
	 * Metodo que recupera a representacao textual de um item na lista de compras.
	 *
	 * @param posicaoItem A posicao do item na lista de compras..
	 * @return A representacao textual de um item na lista de compras.
	 */
	public String getItemLista(int posicaoItem) {
		if (posicaoItem < 0)
			throw new ArrayIndexOutOfBoundsException("Erro no cadastro de preco: id de item invalido.");
		ArrayList<Compra> comprasOrdenadas = new ArrayList<>(this.compras);
		if (comprasOrdenadas.size() <= posicaoItem) {
			return "";
		}
		Collections.sort(comprasOrdenadas, comparaCompras);
		return comprasOrdenadas.get(posicaoItem).toString();

	}

	/**
	 * Metodo que retorna a representacao textual de uma lista de compras.
	 *
	 * @return representacao textual da lista de compras.
	 */
	@Override
	public String toString() {
		return String.format("%s - %s", this.data, this.descritorLista);
	}

	/**
	 * Metodo que verifica se uma lista possui um item.
	 *
	 * @param id O id do item.
	 * @return Booleano que representa a presenca de um item na lista de compras.
	 */
	public boolean hasItem(int id) {
		for (Compra compra : compras) {
			if (compra.getItem().getId() == id)
				return true;
		}
		return false;
	}

	/**
	 * Metodo auxiliar que retorna a quantidade a ser comprada do item
	 * passado pelo sistema.
	 *
	 * @param item Item a ser pega a quantidade.
	 * @return retorna a quantidade do item.
	 */
	public int getQuantidadeCompra(Item item) {
		for (Compra compra : compras) {
			if (compra.getItem() == item) {
				return compra.getQuantidade();
			}
		}
		throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
	}

	/**
	 * Metodo auxiliar que retorna a uma quantidade de nanosegundos criadas pela JVM.
	 *
	 * @return retorna a quantidade de nanosegundos criadas pela JVM.
	 */
	public long getNano(){
		return this.nano;
	}

	/**
	 * Metodo auxiliar que retorna uma lista com os estabelecimentos que contem os
	 * itens da lista de compra.
	 *
	 * @return Retorna uma lista com os estabelecimentos que pode-se fazer a
	 *         compras.
	 */
	public ArrayList<String> getEstabelecimentos() {
		ArrayList<String> locais = new ArrayList<>();
		for (Compra compra : compras) {
			for (String local : compra.getEstabelecimentos())
				if (!locais.contains(local))
					locais.add(local);
		}
		return locais;
	}

}
