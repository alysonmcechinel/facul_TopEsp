package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Acessorio;
import util.DbUtil;

public class AcessorioDAO {
	
	private Connection connection;
	
	public AcessorioDAO() {
		connection = DbUtil.getConnection();
	}
	
	public void addAcessorio(Acessorio acessorio) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into acessorios(nome,marca,cor,preco) values (?, ?, ?, ?)");

			preparedStatement.setString(1, acessorio.getNome());
			preparedStatement.setString(2, acessorio.getMarca());
			preparedStatement.setString(3, acessorio.getCor());
			preparedStatement.setString(4, acessorio.getPreco());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteAcessorio(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from acessorios where id=?");

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAcessorio(Acessorio acessorio) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update acessorios set nome=?, marca=?, cor=?, preco=? where id=?");
			
			preparedStatement.setString(1, acessorio.getNome());
			preparedStatement.setString(2, acessorio.getMarca());
			preparedStatement.setString(3, acessorio.getCor());
			preparedStatement.setString(4, acessorio.getPreco());
			preparedStatement.setInt(5, acessorio.getId());
		
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Acessorio> getAllAcessorio() {
		List<Acessorio> listaDeAcessorio = new ArrayList<Acessorio>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from acessorios");
			while (rs.next()) {
				Acessorio acessorio = new Acessorio();
				acessorio.setId(rs.getInt("id"));
				acessorio.setNome(rs.getString("nome"));
				acessorio.setMarca(rs.getString("marca"));
				acessorio.setCor(rs.getString("cor"));
				acessorio.setPreco(rs.getString("preco"));
			
				listaDeAcessorio.add(acessorio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeAcessorio;
	}
	
	public Acessorio getAcessorioById(int id) {
		Acessorio acessorio = new Acessorio();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from acessorios where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				acessorio.setId(rs.getInt("id"));
				acessorio.setNome(rs.getString("nome"));
				acessorio.setMarca(rs.getString("marca"));
				acessorio.setCor(rs.getString("cor"));
				acessorio.setPreco(rs.getString("preco"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return acessorio;
	}

}
