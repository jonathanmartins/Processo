package MBeans;




import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import Model.Cliente;

@ManagedBean(name="clienteMB")
public class ClienteMB{

	private Cliente cliente = new Cliente();
	private DataModel<Cliente> clientes;
	
	public ClienteMB(){
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cli) {
		this.cliente = cli;
	}
	
	public String newCliente(){
		this.cliente = new Cliente();
		return "novo cliente";
	}

	public String criarc() {
		this.cliente.criarCliente();
		return "sucesso";
	}
	
	
	public DataModel<Cliente> getClientes() {
		List<Cliente> clientelist = cliente.listCliente();
		clientes = new ListDataModel<Cliente>(clientelist);
		
		return clientes;
	}

	public void setClientes(DataModel<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String deletarCliente(){
		this.cliente.deletarCliente();
		return "deletado";
	}
}
