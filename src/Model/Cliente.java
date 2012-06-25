package Model;

import java.util.List;

import Dao.ClienteDao;
import Dao.GenericDao;


public class Cliente{
	
	
	
	private int id;
	private String nome;
	private String login;
	private String senha;
	private String endereco;
	private String telefone;
	private GenericDao dao;
	
	
	public Cliente(){}
	
	
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	private void newClienteDao(){
		this.dao = new ClienteDao(this);
	}
	
	public String criarCliente(){
		this.newClienteDao();
		dao.adicionar();
		return null;
	}
	
	public List<Cliente> listCliente(){
		this.newClienteDao();
		return dao.listar();
	}
	
	public void deletarCliente(){
		this.newClienteDao();
		
		dao.deletar();
	}
}
