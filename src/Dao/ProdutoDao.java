package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Produto;

public class ProdutoDao implements GenericDao{
	private Connection connection;
	private Produto produto;
	
	public ProdutoDao(Produto produto){
		super();
		this.connection = new ConnectionFactory().getConnection();
		this.produto = produto;
	}
	
	@Override
	public void adicionar() {
		String sql = "insert into produto (nome,descricao,idcatego) values (?,?,?)";
		
		try {
			PreparedStatement s = connection.prepareStatement(sql);
			
			s.setString(1, produto.getNome());
			s.setString(2, produto.getDescricao());
			s.setInt(3, produto.getIdcategoria());
			
			s.execute();
			s.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Produto> listar() {
		String sql = "select * from produto";

		List<Produto> produtos = new ArrayList<Produto>();

		try{
			PreparedStatement s = connection.prepareStatement(sql);

			ResultSet res = s.executeQuery();

			while(res.next()){
				Produto produto = new Produto();

				produto.setId_produto(res.getInt("idproduto"));
				produto.setNome(res.getString("nome"));
				produto.setDescricao(res.getString("descricao"));
				produto.setIdcategoria(res.getInt("idcatego"));

				produtos.add(produto);
			}

			res.close();
			s.close();
		}catch (Exception e) {

		}

		return produtos;
	}
	@Override
	public void deletar() {
		String sql = "delete from produto where idproduto = " +produto.getId_produto();

		try{
			PreparedStatement s = connection.prepareStatement(sql);
			s.execute(sql);
			s.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
