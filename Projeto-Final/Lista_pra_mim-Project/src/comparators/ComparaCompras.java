package comparators;

import java.io.Serializable;
import java.util.Comparator;

import entidades.Compra;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 * 
 * Classe de comparacao de compras por nome e categoria.
 * Implementa o Comparator.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Dantas Santos de Azevedo - 117210382
 */
public class ComparaCompras implements Comparator<Compra>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8424546379406513872L;

	/**
	 * Metodo que compara a descricao das compras, e depois a categoria do item.
	 */
	@Override
	public int compare(Compra c1, Compra c2) {
		if (c1.getItemCategoria().equals(c2.getItemCategoria())) {
			return c1.getItemDescricao().compareTo(c2.getItemDescricao());

		}
		return c1.getItemCategoria().compareTo(c2.getItemCategoria());
	}

}
