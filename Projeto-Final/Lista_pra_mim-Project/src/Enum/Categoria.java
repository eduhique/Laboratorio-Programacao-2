package Enum;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 *
 * Enum que representa as categorias dos itens de um supermercado. Os item podem
 * ser categorizados como de higiene pessoal, limpeza, alimentos
 * industrializados e alimentos nao industrilaizados.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Dantas Santos de Azevedo - 117210382
 */

public enum Categoria {

	// Declaracao de cada enum com sua descricao.

	HIGIENEPESSOAL("higiene pessoal"), LIMPEZA("limpeza"), ALIMENTOINDUSTRIALIZADO("alimento industrializado"),
	ALIMENTONAOINDUSTRIALIZADO("alimento nao industrializado");

	// Atributo que representa a descricao dos enuns.
	private String descricao;

	/**
	 * Constroi o objeto Categoria.
	 *
	 * @param descricao A descricao de cada enunm.
	 */
	Categoria(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Metodo acessorio que retorna a descricao de um enum.
	 *
	 * @return uma String representadno a descricao do enum.
	 */
	public String getDescricao() {
		return descricao;
	}
}
