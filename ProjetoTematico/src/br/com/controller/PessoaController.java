package br.com.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import br.com.dao.PessoaDao;
import br.com.model.Pessoa;

public class PessoaController {

	private Date formatData(String data) throws ParseException {
		DateFormat format = new SimpleDateFormat("dd/mm");
		return new Date(format.parse(data).getTime());
	}

	public void salvar(String nome, String sobrenome, String senha, String dataNascimento, String sexo)
			throws SQLException {
		Pessoa pessoa = new Pessoa();

		try {

			pessoa.setNome(nome);
			pessoa.setSobrenome(sobrenome);
			pessoa.setSenha(senha);
			pessoa.setSexo(sexo);
			pessoa.setDataNascimento(formatData(dataNascimento));

		} catch (ParseException e) {

			e.printStackTrace();

		}

		new PessoaDao().salvar(pessoa);
		// System.out.println(pessoa.toString());
		JOptionPane.showMessageDialog(null, "Cadastro Realizado");

	}

	public boolean validarLogin(String nome, String senha) {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setSenha(senha);
		PessoaDao pdao = new PessoaDao();

		Pessoa usuario;
		try {
			usuario = pdao.buscaLogin(pessoa);

			if (usuario == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
