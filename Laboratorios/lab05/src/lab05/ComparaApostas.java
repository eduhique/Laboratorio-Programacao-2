package lab05;

import java.util.Comparator;

/**
 * Laboratório de Programação 2 - Lab 5 parte 3
 * 
 * Classe de comparação de cenários pelo número de apostas cadastradas.
 * Implementa Comparator.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ComparaApostas implements Comparator<Cenario> {

	/**
	 * Comparara dois objetos do tipo Cenario, de acordo com suas quantidades de
	 * apostas.
	 * 
	 * @param o1
	 *            o primeiro Cenario.
	 * @param o2
	 *            o segundo Cenario.
	 * @return um inteiro que indica a posição relativa dos cenários.
	 */
	@Override
	public int compare(Cenario o1, Cenario o2) {
		return o2.totalDeApostas() - o1.totalDeApostas();
	}

}
