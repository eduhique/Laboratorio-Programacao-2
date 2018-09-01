package comparators;

import java.io.Serializable;
import java.util.Comparator;

import entidades.ListaDeCompras;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 *
 * Classe de comparacao de listas a partir do momento de seua criacao.
 * Implementa o Comparator.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Dantas Santos de Azevedo - 117210382
 */
public class ComparaTempo implements Comparator<ListaDeCompras>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2952868760453122481L;

	/**
	 * Comparara dois objetos do tipo lista, tomando como base o momento em que
	 * foi criado no sistema.
	 *
	 * @param l1 a primeira lista.
	 * @param l2 a segunda lista.
	 * @return um inteiro que indica a posição relativa dos itens de acordo com o
	 *         momento de criacao.
	 */
	@Override
	public int compare(ListaDeCompras l1, ListaDeCompras l2) {
		return Long.compare(l1.getNano(), l2.getNano());
	}


}
