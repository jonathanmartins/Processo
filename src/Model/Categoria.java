package Model;

import java.util.List;

import Dao.CategoriaDao;
import Dao.GenericDao;


public class Categoria {
	private int id;
	private String nome;
	private String descricao;
	private GenericDao dao;
	
	public Categoria(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	private void newCategoriaDao(){
		this.dao = new CategoriaDao(this);
	}
	
	public String criarCategoria(){
		this.newCategoriaDao();
		dao.adicionar();
		return null;
	}
	
	public List<Categoria> listCategoria(){
		this.newCategoriaDao();
		return dao.listar();
	}
	
	public void deletarCategoria(){
		this.newCategoriaDao();
		
		dao.deletar();
	}
		
}
