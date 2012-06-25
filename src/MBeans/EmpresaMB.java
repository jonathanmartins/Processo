package MBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import Dao.EmpresaDao;
import Model.Cliente;
import Model.Empresa;

@ManagedBean(name="empresaMB")
public class EmpresaMB{

	private Empresa empresa = new Empresa();
	private DataModel<Empresa> empresas;
	
	
	public EmpresaMB(){
		
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String newEmpresa(){
		this.empresa = new Empresa();
		return "nova empresa";
	}

	public String criaremp() {
    EmpresaDao dao = new EmpresaDao(empresa);
	dao.adicionar();
		
		return "sucesso";
	}
	
	public DataModel<Empresa> getEmpresas() {
		List<Empresa> empresalist = empresa.listEmpresa();
		empresas = new ListDataModel<Empresa>(empresalist);
		
		return empresas;
	}

	public void setEmpresas(DataModel<Empresa> empresas) {
		this.empresas = empresas;
	}

	public String deletarEmpresa(){
		this.empresa.deletarEmpresa();
		return "deletada";
	}
}
