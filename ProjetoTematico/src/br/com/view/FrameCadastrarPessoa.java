package br.com.view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//JInternalFrame 
public class FrameCadastrarPessoa extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel telaCadastro = new JPanel();
	private JPanel panelCampos = new JPanel();
	private JPanel panelBtn = new JPanel();

	private JTextField tfNome;
	private JTextField tfSobrenome;
	private JTextField tfDataNascimento;
	private JRadioButton radioBtnSexo;
	private JPasswordField tpSenha;
	private JPasswordField tpConfirmarSenha;

	private JButton btnCadastrar;
	private JButton btnCancelar;

	private MonneyControlledFrame framePrincipal;

	public FrameCadastrarPessoa(MonneyControlledFrame framPrincipal) {
		this.framePrincipal = framPrincipal;
		setTitle("Incluir Pessoa");

		getContentPane().add(telaCadastro);

		iniciarlizarComponentes();

		setSize(500, 450);
		setLocationRelativeTo(null);
		setResizable(true);
		// setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		// setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

	}

	public void iniciarlizarComponentes() {

		telaCadastro.setLayout(new FlowLayout());

		telaCadastro.add(panelCampos);
		panelCampos.add(montarCampos());

//		panelCadstro.setLayout(new BorderLayout());

		telaCadastro.add(panelBtn);
		panelBtn.add(montarBotoes());
		// add(panel);
	}

	private Component montarBotoes() {
		JPanel panelBtn = new JPanel();

		btnCadastrar = new JButton("Cadastar");
		btnCadastrar.addActionListener(new Cadastar());
		panelBtn.add(btnCadastrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new CancelarCadastro());
		panelBtn.add(btnCancelar);
		return panelBtn;
	}

	private Component montarCampos() {

		JPanel panelCampos = new JPanel();

		tfNome = new JTextField();
		tfSobrenome = new JTextField();
		tfDataNascimento = new JTextField();
		radioBtnSexo = new JRadioButton();
		tpSenha = new JPasswordField();
		tpConfirmarSenha = new JPasswordField();

		panelCampos.add(new JLabel("Nome: "));
		panelCampos.add(tfNome);
		panelCampos.add(new JLabel("Sobrenome: "));
		panelCampos.add(tfSobrenome);
		panelCampos.add(new JLabel(":Data Nascimento: "));
		panelCampos.add(tfDataNascimento);
		panelCampos.add(new JLabel("Sexo: "));
		panelCampos.add(radioBtnSexo);
		panelCampos.add(new JLabel("Senha: "));
		panelCampos.add(tpSenha);
		panelCampos.add(new JLabel("Confirmar senha: "));
		panelCampos.add(tpConfirmarSenha);

		return panelCampos;
	}

	private void resetForm() {
		// TODO Auto-generated method stub

	}

	private class CancelarCadastro implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			framePrincipal.setVisible(true);
			dispose();
		}
	}

	private class Cadastar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			framePrincipal.setVisible(true);
//			dispose();
			System.out.println(this.toString());
		}
	}
}
