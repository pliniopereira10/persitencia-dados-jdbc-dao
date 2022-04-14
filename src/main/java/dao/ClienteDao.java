package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClienteDao {

	private Connection conexao;
	private String sql;
	
	// Construtor responsável pela conexão
	public ClienteDao() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String databaseUrl = "jdbc:sqlserver://localhost:1433;databaseName=TesteClienteDao;"
					+ "trustServerCertificate=true";
			String usuario = "sa";
			String senha = "Abc123456";
			this.conexao = DriverManager.getConnection(databaseUrl, usuario, senha);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		}
		
	}	//	fim do construtor ClienteDao	
	
	// Método responsável por buscar os dados
	public List<Cliente> listar() {
		sql = "SELECT * FROM Cliente ORDER BY id";
		List<Cliente> retorno = new ArrayList<>();
		
		try(PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setTelefone(resultSet.getString("telefone"));
				retorno.add(cliente);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return retorno;
		
	}	//	fim do método listar
	
	// Método responsável pela inserção de dados
	public boolean inserir (Cliente cliente) {
		sql = "INSERT INTO Cliente (nome, cpf, telefone) VALUES (?, ?, ?)";
		
		try(PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getTelefone());
			preparedStatement.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
		
	}	//	fim do método inserir
	
	// Método responsável pela atualização de dados
	public boolean alterar(Cliente cliente) {
		sql = "UPDATE Cliente SET nome=?, cpf=?, telefone=? WHERE id=?";
		
		try(PreparedStatement  preparedStatement = conexao.prepareStatement(sql)) {
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getTelefone());
			preparedStatement.setInt(4, cliente.getId());
			preparedStatement.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
		
	}	//	fim do metodo alterar
	
	// Método responsável pela remoção de dados
	public boolean remover(Integer id) {
		sql = "DELETE FROM Cliente WHERE id=?";
		
		try(PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
		
	}	//	fim do método remover

	
}
