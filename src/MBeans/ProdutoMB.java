package MBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import Model.Categoria;
import Model.Produto;

@ManagedBean
public class ProdutoMB {

	private Produto produto = new Produto();
	private DataModel<Produto> produtos;
	
	public ProdutoMB(){}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public DataModel<Produto> getProdutos() {
		List<Produto> produtolist = produto.listProduto();
		produtos = new ListDataModel<Produto>(produtolist);
		
		return produtos;
	}

	public void setProdutos(DataModel<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public String newProduto(){
		this.produto = new Produto();
		return "novo produto";
	}
	
	public String criarProduto() {
		this.produto.criarProduto();
		return "sucesso";
	}
	
	public String deletarProduto(){
		this.produto.deletarProduto();
		return "deletado";
	}
}
