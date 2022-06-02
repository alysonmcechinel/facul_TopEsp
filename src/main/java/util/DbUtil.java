package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class DbUtil {

	private static Connection connection = null;

	public static Connection getConnection() {

		try {
			String user = "root";
			String password = "alyson123";//vinicius123
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalhofinal", user, password);

		} catch (Exception ex) {
			System.out.println("Erro" + ex.getMessage());
		}

		if (connection != null) {
			System.out.println("Conectado com sucesso!");
		} else {
			System.out.println("Não foi possivel realizar a conexao!");
		}

		return connection;
	}
}
