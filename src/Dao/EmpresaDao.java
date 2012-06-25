package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Cliente;
import Model.Empresa;

public class EmpresaDao implements GenericDao{
	private Connection connection;
	private Empresa empresa;
	
	public EmpresaDao(Empresa empresa){
		this.connection = new ConnectionFactory().getConnection();
		this.empresa = empresa;
	}
	
	@Override
	public void adicionar(){
		try {
			String sql = "insert into empresa (nome, cnpj, endereco, telefone, ramo, login, senha) values (?,?,?,?,?,?,?)";
			
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, empresa.getNome());
			stmt.setString(2, empresa.getCnpj());
			stmt.setString(3, empresa.getEndereco());
			stmt.setString(4, empresa.getTelefone());
			stmt.setString(5, empresa.getRamo());
			stmt.setString(6, empresa.getLogin());
			stmt.setString(7, empresa.getSenha());
			
			// executa
			stmt.execute();
			stmt.close();
						
			System.out.println("empresa gravada no BD");
						

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

	@Override
	public List<Empresa> listar() {
		String sql = "select * from empresa";

		List<Empresa> empresas = new ArrayList<Empresa>();

		try {
			PreparedStatement s = connection.prepareStatement(sql);

			ResultSet res = s.executeQuery();

			while (res.next()) {
				Empresa empresa =  new Empresa();

				empresa.setNome(res.getString("nome"));
				empresa.setCnpj(res.getString("cnpj"));
				empresa.setEndereco(res.getString("endereco"));
				empresa.setTelefone(res.getString("telefone"));
				empresa.setRamo(res.getString("ramo"));

				empresas.add(empresa);

			}

			res.close();
			s.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return empresas;
	}

	@Override
	public void deletar() {
		String sql = "delete from empresa where cnpj = ?";

		try {
			PreparedStatement s = connection.prepareStatement(sql);
			s.setString(1, empresa.getCnpj());

			s.execute();
			s.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
