package br.com.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.dao.PessoaDao;
import br.com.model.Pessoa;
import br.com.model.UsuarioLogado;

public class PessoaController {

	public void salvar(Pessoa pessoa) throws SQLException {

		new PessoaDao().salvar(pessoa);

		JOptionPane.showMessageDialog(null, "Cadastro Realizado");

	}

	public boolean validarLogin(String login, String senha) {

		Pessoa pessoa = new Pessoa();
		pessoa.setLogin(login);
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

	public Pessoa buscarUsuario(String usuarioLogado) {
		Pessoa pessoa = new Pessoa();
		PessoaDao pessoaDao = new PessoaDao();

		pessoa = (Pessoa) pessoaDao.findByName(usuarioLogado);
		return pessoa;

	}

}
