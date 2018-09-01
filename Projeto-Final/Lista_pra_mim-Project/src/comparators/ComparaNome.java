package comparators;

import java.io.Serializable;
import java.util.Comparator;

import entidades.Item;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 * 
 * Classe de comparacao de itens a partir dos seus descritores.
 * Implementa o Comparator.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Dantas Santos de Azevedo - 117210382
 */
public class ComparaNome implements Comparator<Item>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3929933189456754487L;

	/**
	 * Compara dois objetos do tipo Item, tomando como base a ordem lexicografica
	 * de suas representacoes textuais.
	 * 
	 * @param i1
	 *            o primeiro item.
	 * @param i2
	 *            o segundo item.
	 * @return um inteiro que indica a posição relativa dos itens.
	 */
	@Override
	public int compare(Item i1, Item i2) {
		return i1.toString().compareTo(i2.toString());
	}

}
