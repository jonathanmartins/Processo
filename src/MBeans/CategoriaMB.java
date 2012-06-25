package MBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import Model.Categoria;

@ManagedBean
public class CategoriaMB {
	private Categoria categoria = new Categoria();
	private DataModel<Categoria> categorias;
	
	public CategoriaMB(){
		
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria cat) {
		this.categoria = cat;
	}
	
	public String newCategoria(){
		this.categoria = new Categoria();
		return "nova categoria";
	}
	
	public String criarCatego() {
		this.categoria.criarCategoria();
		return "sucesso";
	}
	
	
	public DataModel<Categoria> getCategorias() {
		List<Categoria> categorialist = categoria.listCategoria();
		categorias = new ListDataModel<Categoria>(categorialist);
		
		return categorias;
	}

	public void setCategorias(DataModel<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String deletarCategoria(){
		this.categoria.deletarCategoria();
		return "deletado";
	}
		
}
