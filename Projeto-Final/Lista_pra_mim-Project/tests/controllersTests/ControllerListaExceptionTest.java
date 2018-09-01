package controllersTests;

import org.junit.Before;
import org.junit.Test;

import controllers.ControllerItem;
import controllers.ControllerLista;
import facade.Facade;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 *
 * Classe que testa os metodos da classe ControllerLista e esperam excecoes.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ControllerListaExceptionTest {

	// Instanciação de um Objeto Facade.
	private Facade facade;
	// Instanciação de um Objeto ControllerItem.
	private ControllerItem cItem;
	// Instanciação de um Objeto ControllerLista.
	private ControllerLista cLista;

	/**
	 * Metodo que inicializa objetos.
	 * 
	 * Nenhum erro esperado.
	 */
	@Before
	public void inicializa() {
		facade = new Facade();
		cItem = new ControllerItem();
		cLista = new ControllerLista(cItem);
		cLista.adicionaListaDeCompras("Feira Semanal");

		cItem.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79);
		cItem.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, "Mercadinho Bem Barato",
				34.49);
	}

	/**
	 * Metodo que testa o metodo adicionaListaDeCompras com parametros invalidos.
	 *
	 * Esperado NullPointerException
	 */
	@Test(expected = NullPointerException.class)
	public void testAdicionaListaDeComprasInvalido1() {
		cLista.adicionaListaDeCompras(null);
	}

	/**
	 * Metodo que testa o metodo adicionaListaDeCompras com parametros invalidos.
	 *
	 * Esperado IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaListaDeComprasInvalido2() {
		cLista.adicionaListaDeCompras("");
	}

	/**
	 * Metodo que testa o metodo adicionaListaDeCompras com lista ja criada.
	 *
	 * Esperado IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaListaDeComprasInvalido3() {
		cLista.adicionaListaDeCompras("Feira Semanalal");

		cLista.adicionaListaDeCompras("Feira Semanalal");
	}

	/**
	 * Metodo que testa o metodo adicionaCompraALista com parametro descritor nulo.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaInvalido1() {
		cLista.adicionaCompraALista(" ", 1, 1);
	}

	/**
	 * Metodo que testa o metodo adicionaCompraALista com parametro descritor nulo.
	 *
	 * Esperando NullPointerException
	 */
	@Test(expected = NullPointerException.class)
	public void testAdicionaCOmpraAListaInvalido2() {
		cLista.adicionaCompraALista(null, 1, 1);
	}

	/**
	 * Metodo que testa o metodo adicionaCompraALista com descritor de lista
	 * inexistente.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaInvalido3() {
		cLista.adicionaCompraALista("Feira de amanha", 1, 1);
	}

	/**
	 * Metodo que testa o metodo adicionaCompraALista com quantidade invalida.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaInvalido4() {
		cLista.adicionaCompraALista("Feira de Semanal", -1, 1);
	}

	/**
	 * Metodo que testa o metodo adicionaCompraALista com item inexistente.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaInvalido5() {
		cLista.adicionaCompraALista("Feira de Semanal", 1, 42);
	}

	/**
	 * Metodo que testa o metodo FinalizarListaDeCompras com descritor vazio.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasInvalido1() {
		cLista.finalizarListaDeCompras("", "Supermercado Germano", 1);
	}

	/**
	 * Metodo que testa o metodo FinalizarListaDeCompras com descritor nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testFinalizarListaDeComprasInvalido2() {
		cLista.finalizarListaDeCompras(null, "Supermercado Germano", 1);
	}

	/**
	 * Metodo que testa o metodo FinalizarListaDeCompras com local de compra vazio.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasInvalido3() {
		cLista.finalizarListaDeCompras("Feira Semanal", "", 1);
	}

	/**
	 * Metodo que testa o metodo FinalizarListaDeCompras com local de compra nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testFinalizarListaDeComprasInvalido4() {
		cLista.finalizarListaDeCompras("Feira Semanal", null, 1);
	}

	/**
	 * Metodo que testa o metodo FinalizarListaDeCompras com local de compra nulo.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasInvalido5() {
		cLista.finalizarListaDeCompras("Feira Semanal", "Supermercado Germano", 0);
	}

	/**
	 * Metodo que testa o metodo pesquisaCompraEmLista com id de item invalido.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaCompraEmListaInvalido1() {
		cLista.pesquisaCompraEmLista("Feira Semanal", -2);
	}

	/**
	 * Metodo que testa o metodo pesquisaCompraEmLista com descritor de lista vazio.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaCompraEmListaInvalido2() {
		cLista.pesquisaCompraEmLista("", 1);
	}

	/**
	 * Metodo que testa o metodo pesquisaCompraEmLista com descritor de lista nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testPesquisaCompraEmListaInvalido3() {
		cLista.pesquisaCompraEmLista(null, 1);
	}

	/**
	 * Metodo que testa o metodo AtualizaCompraDeLista com descritor vazio.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaInvalido1() {
		cLista.atualizaCompraDeLista("", 1, 1, "aumenta");
	}

	/**
	 * Metodo que testa o metodo AtualizaCompraDeLista com descritor nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testAtualizaCompraDeListaInvalido2() {
		cLista.atualizaCompraDeLista(null, 1, 1, "aumenta");
	}

	/**
	 * Metodo que testa o metodo AtualizaCompraDeLista com operacao invalida.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaInvalido3() {
		cLista.atualizaCompraDeLista("Feira Semanal", 1, 1, "deixa o mesmo");
	}

	/**
	 * Metodo que testa o metodo getItemLista com descritor de lista vazia.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testgetItemListaInvalido1() {
		cLista.getItemLista("", 0);
	}

	/**
	 * Metodo que testa o metodo getItemLista com descritor de lista nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testgetItemListaInvalido2() {
		cLista.getItemLista(null, 0);
	}

	/**
	 * Metodo que testa o metodo getItemLista com posicao de item invalida.
	 *
	 * Esperando ArrayIndexOutOfBoundsException.
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testgetItemListaInvalido3() {
		cLista.getItemLista("Feira Semanal", -1);
	}

	/**
	 * Metodo que testa o metodo deletaCompraDeLista com descritor de lista vazia.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDeletaCompraDeListaInvalido1() {
		cLista.deletaCompraDeLista("", 0);
	}

	/**
	 * Metodo que testa o metodo deletaCompraDeLista com descritor de lista nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testDeletaCompraDeListaInvalido2() {
		cLista.deletaCompraDeLista(null, 0);
	}

	/**
	 * Metodo que testa o metodo deletaCompraDeLista com id nao existente.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDeletaCompraDeListaInvalido3() {
		cLista.deletaCompraDeLista("Feira Semanal", 14);
	}

	/**
	 * Metodo que testa o metodo deletaCompraDeLista com id invalido.
	 *
	 * Esperando ArrayIndexOutOfBoundsException.
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testDeletaCompraDeListaInvalido4() {
		cLista.deletaCompraDeLista("Feira Semanal", -1);
	}

	/**
	 * Metodo que testa o metodo PesquisaListaDeCompras com descritor de lista
	 * vazia.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaListaDeComprasInvalido1() {
		cLista.pesquisaListaDeCompras("");
	}

	/**
	 * Metodo que testa o metodo PesquisaListaDeCompras com descritor de lista nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testPesquisaListaDeComprasInvalido2() {
		cLista.pesquisaListaDeCompras(null);
	}

	/**
	 * Metodo que testa o metodo PesquisaListaDeCompras com descritor de lista nao
	 * existente.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaListaDeComprasInvalido3() {
		cLista.pesquisaListaDeCompras("Feira do Amanha");
	}

	/**
	 * Metodo que testa o metodo PesquisaListasDeComprasPorItem com lista sem
	 * compras.
	 *
	 * Esperando IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaListasDeComprasPorItemInvalido1() {
		cLista.pesquisaListasDeComprasPorItem(1);
	}

	/**
	 * Metodo que testa o metodo PesquisaListasDeComprasPorItem com id invalido.
	 *
	 * Esperando IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaListasDeComprasPorItemInvalido2() {
		cLista.pesquisaListasDeComprasPorItem(0);
	}

	/**
	 * Metodo que testa o metodo PesquisaListasDeComprasPorData com data vazia.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaListasDeComprasPorDataInvalida1() {
		cLista.pesquisaListasDeComprasPorData("");
	}

	/**
	 * Metodo que testa o metodo PesquisaListasDeComprasPorData com data nula.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testPesquisaListasDeComprasPorDataInvalida2() {
		cLista.pesquisaListasDeComprasPorData(null);
	}

	/**
	 * Metodo que testa o metodo PesquisaListasDeComprasPorData com data invalida.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaListasDeComprasPorDataInvalida3() {
		cLista.pesquisaListasDeComprasPorData("11122018");
	}

	/**
	 * Metodo que testa o metodo PesquisaListasDeComprasPorData com data invalida.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaListasDeComprasPorDataInvalida4() {
		cLista.pesquisaListasDeComprasPorData("2018/07/16");
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorData com data vazia.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetItemListaPorDataInvalido1() {
		cLista.getItemListaPorData("", 0);
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorData com data nula.
	 *
	 * Esperando NullPointerException
	 */
	@Test(expected = NullPointerException.class)
	public void testGetItemListaPorDataInvalido2() {
		cLista.getItemListaPorData(null, 0);
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorData com data invalida.
	 *
	 * Esperando IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetItemListaPorDataInvalido3() {
		cLista.getItemListaPorData("18082018", 0);
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorData com data invalida.
	 *
	 * Esperando ArrayIndexOutOfBoundsException
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetItemListaPorDataInvalido4() {
		cLista.getItemListaPorData(facade.dataAtual(), -1);
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorItem com posicao invalida.
	 *
	 * Esperando ArrayIndexOutOfBoundsException.
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetItemListaPorItemInvalido1() {
		cLista.getItemListaPorItem(1, -1);
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorItem com produto nao cadastrado.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetItemListaPorItemInvalido2() {
		cLista.getItemListaPorItem(20, 0);
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorItem com produto nao cadastrado.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetItemListaPorItemInvalido3() {
		cLista.getItemListaPorItem(0, 0);
	}

	/**
	 * Metodo que testa o metodo geraAutamaticaItem com descritor de item nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testGeraAutomaticaItemInvalido1() {
		cLista.geraAutomaticaItem(null);
	}

	/**
	 * Metodo que testa o metodo geraAutomatioItem com descritor de item vazio;
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGeraAutomaticaItemInvalido2() {
		cLista.geraAutomaticaItem("");
	}

	/**
	 * Metodo que testa o metodo sugereMelhorEstabelecimento com descritor de item nulo;
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testSugereMelhorEstabelecimentoInvalido1() {
	    cLista.sugereMelhorEstabelecimento(null, 0, 0);
	}

	/**
	 * Metodo que testa o metodo sugereMelhorEstabelecimento com descritor de item vazio;
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSugereMelhorEstabelecimentoInvalido2() {
	    cLista.sugereMelhorEstabelecimento("", 0, 0);
	}

	/**
	 * Metodo que testa o metodo sugereMelhorEstabelecimento com posicao de estabelecimento invalida;
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSugereMelhorEstabelecimentoInvalido3() {
	    cLista.sugereMelhorEstabelecimento("Lista Feliz", -1, 0);
	}

	/**
	 * Metodo que testa o metodo sugereMelhorEstabelecimento com posicao da lista invalida;
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSugereMelhorEstabelecimentoInvalido4() {
	    cLista.sugereMelhorEstabelecimento("Lista Feliz", 0, -1);
	}
}
