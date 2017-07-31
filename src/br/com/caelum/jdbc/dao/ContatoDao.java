package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.exception.DAOException;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {

	private Connection connection;
	
	public ContatoDao() throws ClassNotFoundException {
		connection = new ConnectionFactory().getConnection();
	}
	
	public void altera(Contato contato)
	{
		String sql = "update contatos "
				+ "set nome = ?, email = ?, endereco = ?, dataNascimento = ? "
				+ "where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
				
	}
	
	public void adiciona(Contato contato)
	{
		String sql = "insert into contatos "
				+ "(nome,email,endereco,dataNascimento) "
				+ "values(?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
				
	}
	
	public List<Contato> getLista() {
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		String sql = "select * from contatos";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return contatos;
		
	}
	
	public Contato getById(Long id)
	{
		Contato contato = new Contato();
		
		String sql = "select * from contatos "
				+ "where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return contato;
	}
	
	public void remove(Contato contato)
	{
		
		String sql = "delete from contatos where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}
	
}
