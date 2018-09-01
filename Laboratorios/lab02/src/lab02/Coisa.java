package lab02;

/**
 * Laboratório de Programação 2 - Lab 2
 * 
 * C.O.I.S.A = Controle Institucional da Situação Acadêmica Representação de um
 * sistema que controla ações basicas de um estudante da UFCG, como suas
 * Diciplinas, contas nos laborátorios contas em cantinas e saude.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */
public class Coisa {

	/**
	 * Metodo principal Main que controla ações basicas de controle em laboratórios;
	 * controle de horas de estudo e notas de uma Disciplina, bem como o resultado
	 * final; controla sua conta na Cantina e por fim sua saude fisica e mental.
	 * 
	 * @param args
	 *            Arguemntos iniciais
	 */
	public static void main(String[] args) {

		/**
		 * Gerencia conta de laboratório
		 */
		ContaLaboratorio contaLCC2 = new ContaLaboratorio("LCC2");

		contaLCC2.consomeEspaco(1999);

		System.out.println(contaLCC2.atingiuCota());

		contaLCC2.consomeEspaco(2);

		System.out.println(contaLCC2.atingiuCota());

		contaLCC2.liberaEspaco(1);

		System.out.println(contaLCC2.atingiuCota());

		contaLCC2.liberaEspaco(1);

		System.out.println(contaLCC2.atingiuCota());

		System.out.println(contaLCC2.toString());

		/**
		 * Gerencia a Disciplina
		 */
		Disciplina prog2 = new Disciplina("PROGRAMACAO 2");

		prog2.cadastraHoras(4);

		prog2.cadastraNota(1, 5.0);

		prog2.cadastraNota(2, 6.0);

		prog2.cadastraNota(3, 7.0);

		System.out.println(prog2.aprovado());

		prog2.cadastraNota(4, 10.0);

		System.out.println(prog2.aprovado());

		System.out.println(prog2.toString());

		/**
		 * Genrencia conta na Cantina
		 */
		ContaCantina mulherDoBolo = new ContaCantina("Mulher do Bolo");

		mulherDoBolo.cadastraLanche(2, 500);

		mulherDoBolo.cadastraLanche(1, 500);

		mulherDoBolo.pagaConta(200);

		System.out.println(mulherDoBolo.toString());

		/**
		 * Gerencia saúde do aluno
		 */
		Saude saude = new Saude();

		System.out.println(saude.getStatusGeral());

		saude.defineSaudeMental("boa");

		saude.defineSaudeFisica("boa");

		System.out.println(saude.getStatusGeral());

		saude.defineSaudeMental("fraca");

		saude.defineSaudeFisica("fraca");

		System.out.println(saude.getStatusGeral());

		saude.defineSaudeMental("boa");

		saude.defineSaudeFisica("fraca");

		System.out.println(saude.getStatusGeral());
	}
}
