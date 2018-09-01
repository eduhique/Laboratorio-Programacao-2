package comparators;

import java.util.Comparator;

import entidades.ListaDeCompras;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 *
 * Classe de comparacao de listas a partir dos seus precos totais.
 * Implementa o Comparator.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Dantas Santos de Azevedo - 117210382
 */
public class ComparaPrecoTotal implements Comparator<ListaDeCompras> {

	/**
	 * Comparara dois objetos do tipo ListaDeCompras, tomando como base o menor preço
	 * da soma dos itens presentes na lista.
	 *
	 * @param o1 a primeira lista.
	 * @param o2 a segunda lista.
	 * @return um inteiro que indica a posição relativa das listas de acordo com o
	 *         preco.
	 */
	@Override
	public int compare(ListaDeCompras o1, ListaDeCompras o2) {
		return  o1.getPrecoTotal() - o2.getPrecoTotal();
	}

}
