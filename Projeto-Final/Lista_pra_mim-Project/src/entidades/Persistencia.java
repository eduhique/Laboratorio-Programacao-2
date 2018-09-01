package entidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import controllers.ControllerItem;
import controllers.ControllerLista;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 * 
 * Classe que representa a classe de armazenamento dos dados atraves de arquivos.
 * Nesta classe e possivel realizar operacoes como: iniciar sistema e fechar sistema.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class Persistencia {

	// Instanciacao de um Objeto File.
	private File diretorio;
	// Instanciacao de um ControllerItem.
	private ControllerItem cItem;
	// Instanciacao de um ControllerLista.
	private ControllerLista cLista;

	/**
	 * Metodo construtor de uma Persistencia que cria um diretorio para o sistema.
	 * 
	 * @param cItem Um ControllerItem.
	 * @param cLista Um ControllerLista.
	 * 
	 * Este metodo nao retorna nenhum valor.
	 */
	public Persistencia(ControllerItem cItem, ControllerLista cLista) {
		this.cItem = cItem;
		this.cLista = cLista;
		this.diretorio = new File("logs");
		diretorio.mkdir();
	}

	/**
	 * Metodo que inicia o sistema e cria um arquivo para salvar todos os dados do programa.
	 * 
	 * Este metodo nao utiliza parametros.
	 * 
	 * Este metodo nao retorna nenhum valor.
	 * 
	 * @throws IOException Este metodo pode lancar uma excecao do tipo IOException.
	 * @throws ClassNotFoundException Este metodo pode lancar uma excecao do tipo ClassNotFoundException.
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	public void iniciaSistema() throws IOException, ClassNotFoundException {
		FileInputStream ler = null;
		if (diretorio.isDirectory()) {
			try {
				ler = new FileInputStream("logs/system.log");
				ObjectInputStream objeto = new ObjectInputStream(ler);
				cItem.setId(((int) objeto.readObject()));
				cItem.setItens(((Map<Integer, Item>) objeto.readObject()));
				cLista.setListasDeCompras((Map<String, ListaDeCompras>) objeto.readObject());
			} catch (IOException e) {
     				throw new IOException("Sistema iniciado pela primeira vez. Arquivo criado.");
			} finally {
				if (ler != null) {
					try {
						ler.close();
					} catch (IOException e) {
						throw new IOException(e);
					}
				}
			}
		}
	}

	/**
	 * Metodo que salva os dados do sistema e encerra o sistema.
	 * 
	 * Este metodo nao utiliza parametros.
	 * 
	 * Este metodo nao retorna nenhum valor.
	 * 
	 * @throws IOException Este metodo pode lancar uma excecao do tipo IOException.
	 */
	@SuppressWarnings("resource")
	public void fechaSistema() throws IOException {
		FileOutputStream salvar = null;
		if (diretorio.isDirectory()) {
			try {
				salvar = new FileOutputStream("logs/system.log");
				ObjectOutputStream objeto = new ObjectOutputStream(salvar);
				objeto.writeObject(cItem.getId());
				objeto.writeObject(cItem.getItens());
				objeto.writeObject(cLista.getListasDeCompras());
			} catch (IOException e) {
				throw new IllegalArgumentException(e.getMessage());
			} finally {
				if (salvar != null) {
					try {
						salvar.close();
					} catch (IOException e) {
						throw new IOException(e);
					}
				}
			}
		}

	}
}
