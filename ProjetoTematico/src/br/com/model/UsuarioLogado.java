package br.com.model;

public class UsuarioLogado {
	private static UsuarioLogado usuarioLogado_instance = null;

	public String user;

	private UsuarioLogado() {
		user = "";
	}

	public static UsuarioLogado UsuarioLogado() {
		if (usuarioLogado_instance == null) {
			usuarioLogado_instance = new UsuarioLogado();
		}
		return usuarioLogado_instance;
	}
}
