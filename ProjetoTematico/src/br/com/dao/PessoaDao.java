package br.com.dao;

import br.com.model.Pessoa;

public class PessoaDao extends GenericDao<Pessoa> {

	public void salvar(Pessoa pessoa) {
		save(pessoa);
	}

	public Pessoa buscaLogin(Pessoa pessoa) {
		return findByUser(pessoa.getNome(), pessoa.getSenha());
	}

}
