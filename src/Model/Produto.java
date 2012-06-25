package Model;

import java.util.List;

import Dao.GenericDao;
import Dao.ProdutoDao;

public class Produto {
	
	private int id_produto;
	private String nome;
	private String descricao;
	private int idcategoria;
	private GenericDao dao;
	
	public Produto(){}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	
	private void newProdutoDao(){
		this.dao = new ProdutoDao(this);
	}
	
	public String criarProduto(){
		this.newProdutoDao();
		dao.adicionar();
		return null;
	}
	
	public List<Produto> listProduto(){
		this.newProdutoDao();
		return dao.listar();
	}
	
	public void deletarProduto(){
		this.newProdutoDao();
		
		dao.deletar();
	}

}
