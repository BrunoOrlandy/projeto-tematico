package br.com.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import br.com.dao.ConnectioMenagerPostgre;

public class MonneyControlledFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel tela = new JPanel();
	private JButton btnCadastrar;
	private JButton btnJaPossuoConta;

	private FrameCadastrarPessoa frameCadastarPessoa;
	private FrameLogar frameLogar;

	private JPanel panel = new JPanel();
	private JPanel panelBtn = new JPanel();

	public MonneyControlledFrame() throws ParseException {
		setTitle("Money Controlled");

		getContentPane().add(tela);

		inicializaComponentes();

		this.setSize(450, 288);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		// inicializaPostgres();

	}

	private void inicializaComponentes() throws ParseException {
		tela.setLayout(null);
		panelBtn.setBounds(115, 161, 209, 80);
		tela.add(panelBtn);
		panelBtn.setLayout(null);

		// botões
		btnCadastrar = new JButton();
		btnCadastrar.setBounds(48, 11, 116, 23);
		panelBtn.add(btnCadastrar);
		btnCadastrar.setText("Cadastrar");

		btnJaPossuoConta = new JButton();
		btnJaPossuoConta.setBounds(48, 45, 116, 24);
		panelBtn.add(btnJaPossuoConta);
		btnJaPossuoConta.setText("Já possuo Conta");

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 414, 139);
		tela.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Bem vindo ao Money Controlled");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewJgoodiesTitle.setBounds(66, 21, 341, 27);
		panel_1.add(lblNewJgoodiesTitle);

		JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance()
				.createTitle("cadastre-se para realizar gest\u00E3o ");
		lblNewJgoodiesTitle_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewJgoodiesTitle_1.setBounds(99, 52, 278, 21);
		panel_1.add(lblNewJgoodiesTitle_1);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("do seu dinheiro.");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewJgoodiesLabel.setBounds(145, 84, 243, 21);
		panel_1.add(lblNewJgoodiesLabel);

		btnJaPossuoConta.addActionListener(new Logar());
		btnCadastrar.addActionListener(new CadastrarUsuarioListener());

		frameCadastarPessoa = new FrameCadastrarPessoa(this);
		frameLogar = new FrameLogar(this);
	}

	private class CadastrarUsuarioListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			frameCadastarPessoa.setVisible(true);
//			if (pessoaImplDAO.findById()) {
//				frameCadastarPessoa.setVisible(true);
//				dispose();
//			}
		}
	}

	private class Logar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frameLogar.setVisible(true);

		}
	}

//	public void inicializaPostgres() {
//		try {
//			ConnectioMenagerPostgre cmp = new ConnectioMenagerPostgre();
//			cmp.abreConexao();
//			cmp.criaDataBase();
//			cmp.close();
//
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(this,
//					"Não foi possível inicializar o Banco de dados: " + e.getMessage()
//							+ "\nVerifique a dependência do driver ou configurações do banco!",
//					"Erro", JOptionPane.ERROR_MESSAGE);
//			System.exit(0);
//		}
//	}
}
