package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConnectioMenagerPostgre {

	// para testar a conexao decomente o main
//	public static void main(String[] args) {
//
//		String driver = "org.postgresql.Driver";
//		String user = "postgres";
//		String senha = "1234";
//		String url = "jdbc:postgresql://localhost:5432/CarteiraJava";
//
//		try {
//			Class.forName(driver);
//			Connection con = null;
//
//			con = (Connection) DriverManager.getConnection(url, user, senha);
//
//			JOptionPane.showMessageDialog(null, "Conexão realizada com Sucesso!");// janela
//
//		} catch (ClassNotFoundException ex) {
//			System.err.print(ex.getMessage());
//		} catch (SQLException e) {
//			System.err.print(e.getMessage());
//		}
//	}
//
	private static final String STR_DRIVER = "org.postgresql.Driver";
	//private static final String DATABASE = "postegres";
	private static final String STR_CON = "jdbc:postgresql://localhost:5432/CarteiraJava";
	private static final String USER = "postgres";
	private static final String PASSWORD = "1234";

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(STR_DRIVER);
			conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
			conn.setAutoCommit(false);

			System.out.println("Aberta a conexão com banco de dados!");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeAll(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				System.err.println("Fechada a conexão com banco de dados!");
			}
		} catch (Exception e) {
			System.err.println("Não foi possivel fechar a conexão com o banco de dados!");
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection conn, Statement stmt) {
		try {
			if (conn != null) {
				closeAll(conn);
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			System.err.println("Não foi possivel fechar o statement!");
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null || stmt != null) {
				closeAll(conn, stmt);
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			System.err.println("Não foi possivel fechar o resultSet!");
			e.printStackTrace();
		}
	}
}
