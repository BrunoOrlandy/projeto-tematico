package br.com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

public class AppDAOJDBC implements AppDAO {

	private final static String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS ";

	public void save(Object obj) {
		// TODO Auto-generated method stub

	}

	public void remove(Object obj) {
		// TODO Auto-generated method stub

	}

	public List<Object> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> listarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void init() {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ConnectioMenagerPostgre.getConnection();
			stmt = conn.createStatement();
			//nt r = stmt.executeUpdate(CREATE_TABLE);

			JOptionPane.showMessageDialog(null, "Conexão realizada com Sucesso!");// janela

//			if (r > 0) {
//				JOptionPane.showMessageDialog(null, "Tabelas criadas com sucesso!");// janela
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectioMenagerPostgre.closeAll(conn, stmt);
		}

	}

}
