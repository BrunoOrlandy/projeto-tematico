package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/*
 * classe subistituida pela abstração do Hibernate
 */
public class ConnectioMenagerPostgre {

	private static final String STR_DRIVER = "org.postgresql.Driver";
	private static final String DATABASE = "CarteiraJava";// Teste
	private static final String STR_CON = "jdbc:postgresql://localhost:5432/" + DATABASE;
	private static final String USER = "postgres";
	private static final String PASSWORD = "1234";

	private Connection conn;

	public Connection testaConexao() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(STR_DRIVER);
			conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
			conn.setAutoCommit(false);

			if (conn != null) {
				JOptionPane.showMessageDialog(null, "Conexão com banco de dados aberta com Sucesso!", "Conexão",
						JOptionPane.INFORMATION_MESSAGE);
			}

			return conn;

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Conexão falhou!", "Conexão", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

// metodo para abrir a conexao
	public Connection abreConexao() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(STR_DRIVER);
			conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
			conn.setAutoCommit(false);

			return conn;

		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao abrir a conexao");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Problema ao conectar-se ao banco");
			e.printStackTrace();
		}
		return conn;
	}

	// metedo para testar a conexao com o banco e criar as tabelas
	public void criaDataBase() {
		Connection conn = null;
		try {
			Class.forName(STR_DRIVER);
			conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
			conn.setAutoCommit(false);

			if (conn != null) {
				rodaScript(conn);
				JOptionPane.showMessageDialog(null, "Tabelas Criadas com sucesso!", "Conexão",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	public void rodaScript(Connection conn) throws SQLException {
		PreparedStatement stmt = null;

		try {

			String script = new String();

			script = " CREATE TABLE IF NOT EXISTS  Pessoa (" + "  id INT NOT NULL, " + "  nome \"char\"[] NOT NULL, "
					+ "  sobrenome \"char\"[], " + "  PRIMARY KEY (id) " + "); " + " " + " "
					+ "CREATE TABLE IF NOT EXISTS  CategoriaConta " + "( " + "    id INT NOT NULL, "
					+ "    nome VARCHAR(30), " + "    PRIMARY KEY (id) " + "); " + " " + " "
					+ "CREATE TABLE IF NOT EXISTS  Conta " + "( " + "    id INT NOT NULL, "
					+ "    idPessoa INT NOT NULL, " + "    dataCadastro date, " + "    dataPagamento date, "
					+ "    valorConta numeric, " + "    idContaCategoria INT, " + "    PRIMARY KEY (id), "
					+ "   	CONSTRAINT fk_conta FOREIGN KEY(idContaCategoria) REFERENCES CategoriaConta(id) " + " "
					+ "); " + " " + "CREATE TABLE IF NOT EXISTS  Aquisicao " + "( " + "    id INT NOT NULL, "
					+ "	idPessoa INT NOT NULL, " + "    aquisicao VARCHAR(30) NULL, " + "    valor numeric, "
					+ "	qunatidadeParcelas INT, " + "    formaPagamento VARCHAR(1), " + "    dataAquisicao date, "
					+ "    PRIMARY KEY (id), "
					+ "   	CONSTRAINT fk_pessoa FOREIGN KEY(idPessoa) REFERENCES Pessoa(id) " + "); " + " "
					+ "CREATE TABLE IF NOT EXISTS  Previsao " + "( " + "    idConta INT NOT NULL, "
					+ "	idAquisicao INT NOT NULL, " + "    dataPrevisao date , " + "    valorPrevisao numeric, "
					+ "    PRIMARY KEY (idConta), "
					+ "   	CONSTRAINT fk_conta FOREIGN KEY(idConta) REFERENCES Conta(id), "
					+ "   	CONSTRAINT fk_aquisicao FOREIGN KEY(idAquisicao) REFERENCES Aquisicao(id) " + "); " + " "
					+ "CREATE TABLE IF NOT EXISTS  Transacao " + "( " + "    idConta INT NOT NULL, "
					+ "	idPessoa INT NOT NULL, " + "    valorTransacao numeric, " + "    dataPagamento date , "
					+ "    PRIMARY KEY (idConta), "
					+ "   	CONSTRAINT fk_conta FOREIGN KEY(idConta) REFERENCES Conta(id), "
					+ "   	CONSTRAINT fk_pessoa FOREIGN KEY(idPessoa) REFERENCES Pessoa(id) " + ");";

			stmt = conn.prepareStatement(script);
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, stmt);
		}

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

}
