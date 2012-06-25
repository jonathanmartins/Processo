package Model;

import java.util.List;

import Dao.EmpresaDao;
import Dao.GenericDao;

public class Empresa{
	

	private int id;
	private String nome;
	private String cnpj;
	private String endereco;
	private String telefone;
	private String ramo;
	private String login;
	private String senha;
	private GenericDao dao;
	
	public Empresa(){}
	
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	public String getRamo() {
		return ramo;
	}
	public void setRamo(String ramo) {
		this.ramo = ramo;
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
	
	private void newEmpresaDao(){
		this.dao = new EmpresaDao(this);
	}
	
	public String criarEmpresa(){
		this.newEmpresaDao();
		dao.adicionar();
		return null;
	}
	
	public List<Empresa> listEmpresa(){
		this.newEmpresaDao();
		return dao.listar();
	}
	
	public void deletarEmpresa(){
		this.newEmpresaDao();
		
		dao.deletar();
	}

}
