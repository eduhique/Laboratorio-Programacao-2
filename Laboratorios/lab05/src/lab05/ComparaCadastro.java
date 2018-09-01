package lab05;

import java.util.Comparator;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Classe de comparação de cenário por Número de identificação. Implementa o
 * Comparator.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ComparaCadastro implements Comparator<Cenario> {

	/**
	 * Comparara dois objetos do tipo Cenario, com base na sua ordem de cadastro.
	 * 
	 * @param o1
	 *            o primeiro Cenario.
	 * @param o2
	 *            o segundo Cenario.
	 * @return um inteiro que indica a posição relativa dos cenários.
	 */
	@Override
	public int compare(Cenario o1, Cenario o2) {
		return o1.getId() - o2.getId();
	}

}
