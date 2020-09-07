package br.com.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.dao.AppDAOJDBC;

public class MonneyControlledFrame extends JFrame {

	private static final long serialVersionUID = 1L;

//	private MonneyControlledFrame tela;
	private JPanel tela = new JPanel();
	private JLabel lblMensagemBemVindo = new JLabel(MENSAGEM);
	private JButton btnCadastrar;
	private JButton btnJaPossuoConta;
	private static String MENSAGEM = "Bem-vindo ao Money controlled cadastre-se para realizar a gestão do seu dinheiro";

	private FrameCadastrarPessoa frameCadastarPessoa;
	private JPanel panel = new JPanel();
	private JPanel panelBtn = new JPanel();

	public MonneyControlledFrame() {
		setTitle("Money Controlled");

		getContentPane().add(tela);

		inicializaComponentes();

		// inicializaPostgres();
		pack();
		this.setSize(500, 150);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	private void inicializaComponentes() {
		// menssagem
		tela.setLayout(new FlowLayout());
		tela.add(panel.add(lblMensagemBemVindo));
		tela.add(panelBtn);

		// botões
		btnCadastrar = new JButton();
		panelBtn.add(btnCadastrar);
		btnCadastrar.setText("Cadastrar");

		btnJaPossuoConta = new JButton();
		panelBtn.add(btnJaPossuoConta);
		btnJaPossuoConta.setText("Já possuo Conta");

		btnJaPossuoConta.addActionListener(new Logar());
		btnCadastrar.addActionListener(new CadastrarUsuarioListener());

		frameCadastarPessoa = new FrameCadastrarPessoa(this);

	}

	private void inicializaPostgres() {
		try {
			new AppDAOJDBC().init();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Não foi possível inicializar o Banco de dados: " + e.getMessage()
							+ "\nVerifique a dependência do driver ou configurações do banco!",
					"Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	private class CadastrarUsuarioListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frameCadastarPessoa.setVisible(true);
			dispose();
		}
	}

	private class Logar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//				frameCadastarPessoa.setVisible(true);
//				dispose();
			System.out.println("JA POSSUO CADASTRO");
		}
	}

}
