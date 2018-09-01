package lab02;

import java.util.Arrays;

/**
 * Laboratório de Programação 2 - Lab 2
 *
 * Representação da disciplina de um aluno matriculado na UFCG. Permite o
 * controle de horas de estudo; cadastrar uma nota, calcular a media e verificar
 * se foi aprovado.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class Disciplina {

	/**
	 * Nome da Disciplina. No formato texto (String) XXXX. ex: "Cálculo II"
	 */
	public String nomeDisciplina;

	/**
	 * Horas de estudo. No Formato XX, onde representa a quantidade de horas de
	 * estudo para a disciplina cadastrada.
	 */
	public int horas = 0;

	/**
	 * Pesos das notas cadastradas. No formato Array, onde a posição especifica para
	 * qual nota aquele peso será atribuido. ex: {6,4}, o peso 6 esta na primeira
	 * posição e sera atribuido a nota 1 e 4 a na nota 2.
	 */
	public int[] pesos;

	/**
	 * Notas do aluno na Disciplina. No formato Array, onde a posição diz o numero
	 * da nota. ex: {9.0, 10.0} , onde 9.0 e 10.0 representam, respectivamente, as
	 * notas 1 e nota 2.
	 */
	private double[] notas;

	/**
	 * Média do Aluno na disciplina. No formato XX, onde repsenta um valor entre 0.0
	 * e 10.0.
	 */
	private double media = 0;

	/**
	 * Soma dos pesos. representa a soma dos pesos atribuido as notas. No formato
	 * "00", onde esse valor vai ser ultilizado para calcular a media.
	 */
	private int somaPesos;

	/**
	 * Soma todas as nota da Diciplina.Representa a soma das nota . No formato "00",
	 * onde esse valor vai ser ultilizado para calcular a media.
	 */
	private double somaNotas;

	/**
	 * Constrói uma Disciplina a partir de seu nome. Caso não seja passado a
	 * quantidade de notas e os pesos, será atribuido a quantidade de notas padrao
	 * (quatro notas) e ser calculado a media aritmética.
	 * 
	 * @param nomeDisciplina
	 *            o nome da disciplina.
	 */
	public Disciplina(String nomeDisciplina) {
		this(nomeDisciplina, 4);
	}

	/**
	 * Constrói uma Disciplina a partir de seu nome e a quantidade de notas que
	 * serão adicionadas. Todas a notas terão o mesmo peso, ou seja, peso 1.
	 * 
	 * @param nomeDisciplina
	 *            o nome da disciplina.
	 * @param qtdNotas
	 *            a quantidades de notas.
	 */
	public Disciplina(String nomeDisciplina, int qtdNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[qtdNotas];
		this.somaPesos = qtdNotas;
		this.pesos = new int[qtdNotas];
		for (int i = 0; i < pesos.length; i++) {
			this.pesos[i] = 1;
		}
	}

	/**
	 * Constrói uma Disciplina a partir de seu nome, quantidade de notas e um array
	 * de pesos das respectivas notas.
	 * 
	 * @param nomeDisciplina
	 *            nome da disciplina.
	 * @param qtdNotas
	 *            quantidade de notas.
	 * @param pesos
	 *            os pesos da notas, no formato array "new int[] {a,b, ..., y, z}"
	 */
	public Disciplina(String nomeDisciplina, int qtdNotas, int[] pesos) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[qtdNotas];
		this.pesos = pesos;
		for (int i = 0; i < pesos.length; i++) {
			this.somaPesos += pesos[i];
		}

	}

	/**
	 * Método sem retorno que cadastra as horas de estudos para a disciplina.
	 * 
	 * @param horas
	 *            as horas de estudo para a disciplina.
	 */
	public void cadastraHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * Método que cadastra as notas do aluno na disciplina.
	 * 
	 * @param nota
	 *            numero da nota a ser cadastrada.
	 * @param valorNota
	 *            valor da nota a ser cadastrada.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}

	/**
	 * Método que calcula media da disciplina e retorna se o aluno foi aprovado ou
	 * não.
	 * 
	 * @return um boleano que diz se o aluno foi aprovado ou não.
	 */
	public boolean aprovado() {
		this.somaNotas = 0;
		for (int i = 0; i < notas.length; i++) {
			this.somaNotas += notas[i] * pesos[i];
		}
		this.media = this.somaNotas / this.somaPesos;
		if (media >= 7) {
			return true;
		}
		return false;

	}

	/**
	 * Método que retorna uma String que representa a disciplina. A representação
	 * segue no formato "NomeDaDiciplina HorasDeEstudo Media [Notas]
	 * 
	 * @return a representação da String Disciplina
	 */
	public String toString() {
		String stringDisciplina = this.nomeDisciplina + " " + this.horas + " " + this.media + Arrays.toString(notas);
		return stringDisciplina;
	}
}
