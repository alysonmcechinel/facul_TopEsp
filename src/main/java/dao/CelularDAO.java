package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Celular;
import util.DbUtil;

public class CelularDAO {
	
	private Connection connection;
	
	public CelularDAO() {
		connection = DbUtil.getConnection();
	}
	
	public void addCelular(Celular celular) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into celular(nome,marca,cor,tela,memoria,preco) values (?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, celular.getNome());
			preparedStatement.setString(2, celular.getMarca());
			preparedStatement.setString(3, celular.getCor());
			preparedStatement.setString(4, celular.getTela());
			preparedStatement.setString(5, celular.getMemoria());
			preparedStatement.setString(6, celular.getPreco());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteCelular(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from celular where id=?");

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCelular(Celular celular) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update celular set nome=?, marca=?, cor=?, tela=?, memoria=?, preco=? where id=?");
			
			preparedStatement.setString(1, celular.getNome());
			preparedStatement.setString(2, celular.getMarca());
			preparedStatement.setString(3, celular.getCor());
			preparedStatement.setString(4, celular.getTela());
			preparedStatement.setString(5, celular.getMemoria());
			preparedStatement.setString(6, celular.getPreco());
			preparedStatement.setInt(7, celular.getId());
		
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Celular> getAllCelular() {
		List<Celular> listaDeCelular = new ArrayList<Celular>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from celular");
			while (rs.next()) {
				Celular celular = new Celular();
				celular.setId(rs.getInt("id"));
				celular.setNome(rs.getString("nome"));
				celular.setMarca(rs.getString("marca"));
				celular.setCor(rs.getString("cor"));
				celular.setTela(rs.getString("tela"));
				celular.setMemoria(rs.getString("memoria"));
				celular.setPreco(rs.getString("preco"));
				listaDeCelular.add(celular);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeCelular;
	}
	
	public Celular getCelularById(int id) {
		Celular celular = new Celular();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from celular where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				celular.setId(rs.getInt("id"));
				celular.setNome(rs.getString("nome"));
				celular.setMarca(rs.getString("marca"));
				celular.setCor(rs.getString("cor"));
				celular.setTela(rs.getString("tela"));
				celular.setMemoria(rs.getString("memoria"));
				celular.setPreco(rs.getString("preco"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return celular;
	}

}
