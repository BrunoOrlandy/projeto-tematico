package br.com.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import br.com.controller.PessoaController;
import br.com.model.Pessoa;

//JInternalFrame 
public class FrameCadastrarPessoa extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel telaCadastro = new JPanel();
	private JPanel panelCampos = new JPanel();

	private JTextField tfNome;
	private JTextField tfSobrenome;
	private JFormattedTextField tfDataNascimento;
	private JRadioButton radioBtnSexoM;
	private JPasswordField tpSenha;
	private JPasswordField tpConfirmarSenha;

	public String sexo = new String();

	private JButton btnCadastrar;
	private JButton btnCancelar;

	private MonneyControlledFrame framePrincipal;
	private MonneyControlledMenuFrame menuFrame = new MonneyControlledMenuFrame(framePrincipal);

	private PessoaController pessoacontroller = new PessoaController();

	public FrameCadastrarPessoa(MonneyControlledFrame framePrincipal) throws ParseException {
		this.framePrincipal = framePrincipal;
		setTitle("Incluir Pessoa");

		getContentPane().add(telaCadastro);

		iniciarlizarComponentes();

	}

	public void iniciarlizarComponentes() throws ParseException {

		JPanel panelCampos_1 = new JPanel();
		panelCampos_1.setBounds(8, 49, 449, 276);
		telaCadastro.add(panelCampos_1);

		tfNome = new JTextField();
		tfNome.setBounds(29, 46, 173, 20);
		tfSobrenome = new JTextField();
		tfSobrenome.setBounds(221, 46, 173, 20);
		// tfDataNascimento = new JTextField();
		tfDataNascimento = new JFormattedTextField();
		tfDataNascimento.setBounds(29, 101, 131, 20);
		radioBtnSexoM = new JRadioButton();
		radioBtnSexoM.setBounds(221, 101, 21, 21);
		tpSenha = new JPasswordField();
		tpSenha.setBounds(29, 169, 365, 20);
		tpConfirmarSenha = new JPasswordField();
		tpConfirmarSenha.setBounds(29, 225, 365, 20);
		panelCampos_1.setLayout(null);

		JLabel lblNome = new JLabel("Nome : *");
		lblNome.setBounds(29, 21, 55, 14);
		panelCampos_1.add(lblNome);
		panelCampos_1.add(tfNome);

		JLabel label_1 = new JLabel("Sobrenome: ");
		label_1.setBounds(221, 21, 80, 14);
		panelCampos_1.add(label_1);
		panelCampos_1.add(tfSobrenome);

		MaskFormatter maskData = new MaskFormatter("##/##/####");
		maskData.install(tfDataNascimento);
		JLabel lblDataNascimento = new JLabel("Data Nascimento : *");
		lblDataNascimento.setBounds(29, 83, 131, 14);
		panelCampos_1.add(lblDataNascimento);
		panelCampos_1.add(tfDataNascimento);

		JLabel lblSexo = new JLabel("Sexo : ");
		lblSexo.setBounds(221, 83, 46, 14);
		panelCampos_1.add(lblSexo);
		panelCampos_1.add(radioBtnSexoM);

		JLabel lblSenha = new JLabel("Senha: *");
		lblSenha.setBounds(29, 144, 55, 14);
		panelCampos_1.add(lblSenha);
		panelCampos_1.add(tpSenha);

		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:  * ");
		lblConfirmarSenha.setBounds(29, 200, 131, 14);
		panelCampos_1.add(lblConfirmarSenha);
		panelCampos_1.add(tpConfirmarSenha);

		final JRadioButton radioBtnSexoF = new JRadioButton();
		radioBtnSexoF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioBtnSexoF.isSelected()) {
					radioBtnSexoM.setSelected(false);
					sexo = "F";
				}
			}
		});
		radioBtnSexoF.setBounds(311, 101, 21, 21);
		panelCampos_1.add(radioBtnSexoF);

		JLabel lblNewLabel = new JLabel("Masculino");
		lblNewLabel.setBounds(246, 105, 76, 14);
		panelCampos_1.add(lblNewLabel);

		JLabel lblFeminino = new JLabel("Feminino");
		lblFeminino.setBounds(332, 104, 55, 14);
		panelCampos_1.add(lblFeminino);

		setSize(482, 416);
		setLocationRelativeTo(null);
		setResizable(true);

		// metodos

		radioBtnSexoM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (radioBtnSexoM.isSelected()) {
					radioBtnSexoF.setSelected(false);
					sexo = "M";
				}
			}
		});

		telaCadastro.setLayout(null);
		panelCampos.setBounds(8, 5, 449, 41);

		telaCadastro.add(panelCampos);
		panelCampos.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cadastro de Pessoa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 444, 41);
		panelCampos.add(lblNewLabel_1);
		JPanel panelBtn_1 = new JPanel();
		panelBtn_1.setBounds(8, 325, 449, 41);
		telaCadastro.add(panelBtn_1);

		btnCadastrar = new JButton("Cancelar");
		btnCadastrar.setBounds(34, 5, 90, 25);
		btnCadastrar.addActionListener(new CancelarCadastro());
		panelBtn_1.setLayout(null);
		panelBtn_1.add(btnCadastrar);

		btnCancelar = new JButton("Salvar");
		btnCancelar.setBounds(134, 5, 90, 25);
		btnCancelar.addActionListener(new Cadastar());
		panelBtn_1.add(btnCancelar);

	}

	private void resetForm() {
		this.tfNome.setText(null);
		this.tfSobrenome.setText(null);
		this.tfDataNascimento.setText(null);
		this.radioBtnSexoM.setText(null);
		this.tpSenha.setText(null);
		this.tpConfirmarSenha.setText(null);

	}

	public void campos() {
		Pessoa pessoa = new Pessoa();

//		try {
//			
//			private Long id;
//			private String nome;
//			private String sobrenome;
//			private LocalDate dataNascimento;
//			private String senha;

//		}
	}

	private class CancelarCadastro implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			resetForm();
			dispose();
		}
	}

	private class Cadastar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			try {
//				String nome = tfNome.getText();
//				String sobrenome = tfSobrenome.getText();
//				String dataNascimento = tfDataNascimento.getText();
//				String senha = tpSenha.getText();
//				String confirmarSenha = tpConfirmarSenha.getText();
//
//				if (validaSenha(senha, confirmarSenha)) {
//
//					pessoacontroller.salvar(nome, sobrenome, senha, dataNascimento, sexo);
//					JOptionPane.showMessageDialog(null, "Cadastro Realizado");
//				}
//			} catch (SQLException sql) {
//				sql.printStackTrace();
//			}
//			resetForm();
			dispose();
			menuFrame.setVisible(true);

		}
	}

	public boolean validaSenha(String senha, String confirmarSenha) {

		if (!senha.isEmpty() || !confirmarSenha.isEmpty()) {
			if (senha.equals(confirmarSenha)) {
				//
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Senhas não correspondem");
				return false;
			}
		}
		JOptionPane.showMessageDialog(null, "Obrigatorio informa senha");
		return false;
	}

}
