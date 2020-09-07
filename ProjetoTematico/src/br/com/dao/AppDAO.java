package br.com.dao;

import java.util.List;

// Define as operações basicas de cadastro (CRUD), seguindo o design pattern Data Access Object

public interface AppDAO {

	void save(Object obj);

	void remove(Object obj);

	List<Object> listarTodos();

	List<Object> listarPorNome(String nome);

	Object buscarPorId(Integer id);

	void init();

}
