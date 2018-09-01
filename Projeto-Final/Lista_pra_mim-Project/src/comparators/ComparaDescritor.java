package comparators;

import entidades.ListaDeCompras;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 * 
 * Classe de comparacao de descritores de listas de compras.
 * Implementa o Comparator.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Dantas Santos de Azevedo - 117210382
 */
public class ComparaDescritor implements Comparator<ListaDeCompras>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1032921725889053313L;

	/**
	 * Comparara dois objetos do tipo ListaDeCompras, tomando como base seus descritores.
	 *
	 * @param listaDeCompras1 a primeira lista de compras.
	 * @param listaDeCompras2 a segunda lista de compras.
	 * @return um inteiro que indica a posição relativa dos itens de acordo com o
	 *         preco.
	 */
	@Override
	public int compare(ListaDeCompras listaDeCompras1, ListaDeCompras listaDeCompras2) {
		return listaDeCompras1.getDescritorLista().toLowerCase()
				.compareTo(listaDeCompras2.getDescritorLista().toLowerCase());
	}
}
