package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Cliente;

public class ClienteDao implements GenericDao{
	private Connection connection;
	private Cliente cliente;
	
	public ClienteDao(Cliente cliente){
		this.connection = new ConnectionFactory().getConnection();
		this.cliente = cliente;	
	}
	
	@Override
	public void adicionar(){
		try {
			String sql = "insert into cliente (nome, telefone, endereco, login, senha) values (?,?,?,?,?)";
			
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1,cliente.getNome());
			stmt.setString(2,cliente.getTelefone());
			stmt.setString(3,cliente.getEndereco());
			stmt.setString(4,cliente.getLogin());
			stmt.setString(5,cliente.getSenha());
			
			// executa
			stmt.execute();
			stmt.close();
			
			System.out.println("cliente gravado no BD");
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Cliente> listar() {
		String sql = "select * from cliente";
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			PreparedStatement s = connection.prepareStatement(sql);
			
			ResultSet res = s.executeQuery();
			
			while (res.next()) {
				Cliente cliente =  new Cliente();
				
				cliente.setNome(res.getString("nome"));
				cliente.setLogin(res.getString("login"));
				cliente.setTelefone(res.getString("telefone"));
				cliente.setEndereco(res.getString("endereco"));
				
				clientes.add(cliente);
				
			}
			
			res.close();
			s.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return clientes;
	}

	@Override
	public void deletar() {
		String sql = "delete from cliente where login = ?";
		
		try {
			PreparedStatement s = connection.prepareStatement(sql);
			s.setString(1, cliente.getLogin());
			
			s.execute();
			s.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
