package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Categoria;

public class CategoriaDao implements GenericDao{
	private Connection connection;
	private Categoria categoria;
	public CategoriaDao(Categoria categoria) {
		super();
		this.connection = new ConnectionFactory().getConnection();
		this.categoria = categoria;
	}
	
	@Override
	public void adicionar(){
		String sql = "insert into categoria (nome,descricao) values (?,?)";
		
		try {
			PreparedStatement s = connection.prepareStatement(sql);
			
			s.setString(1, categoria.getNome());
			s.setString(2, categoria.getDescricao());
			
			s.execute();
			s.close();
			
			System.out.println("Categoria Adicionada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Categoria> listar(){
		String sql = "select * from categoria";
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		try{
			PreparedStatement s = connection.prepareStatement(sql);
			
			ResultSet res = s.executeQuery();
			
			while(res.next()){
				Categoria categoria = new Categoria();
				
				categoria.setId(res.getInt("idcategoria"));
				categoria.setNome(res.getString("nome"));
				categoria.setDescricao(res.getString("descricao"));
				
				categorias.add(categoria);
			}
			
			res.close();
			s.close();
		}catch (Exception e) {
			
		}
		
		return categorias;
	}
	
	@Override
	public void deletar() {
		String sql = "delete from categoria where idcategoria = " +categoria.getId();

		try{
			PreparedStatement s = connection.prepareStatement(sql);
			s.execute(sql);
			s.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
