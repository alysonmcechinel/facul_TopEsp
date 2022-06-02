package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import util.DbUtil;

public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {
		connection = DbUtil.getConnection();
	}

	public void addCliente(Cliente cliente) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into clientes(nome,email,cidade,telefone) values (?, ?, ?, ? )");

			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getCidade());
			preparedStatement.setInt(4, cliente.getTelefone());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteCliente(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from clientes where id=?");

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCliente(Cliente cliente) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update clientes set nome=?, email=?, cidade=?, telefone=? where id=?");

			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getCidade());
			preparedStatement.setInt(4, cliente.getTelefone());
			preparedStatement.setInt(5, cliente.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> getAllClientes() {
		List<Cliente> listaDeCliente = new ArrayList<Cliente>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from clientes");
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setTelefone(rs.getInt("telefone"));
				listaDeCliente.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeCliente;
	}

	public Cliente getClienteById(int id) {
		Cliente cliente = new Cliente();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from clientes where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setTelefone(rs.getInt("telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}
}
