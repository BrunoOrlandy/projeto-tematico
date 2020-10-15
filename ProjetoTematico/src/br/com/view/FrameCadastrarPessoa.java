package br.com.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

import br.com.app.utils.TeclasPermitidas;
import br.com.controller.PessoaController;
import br.com.model.Pessoa;
import br.com.model.UsuarioLogado;

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
	private JTextField tfLogin;
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

		if (UsuarioLogado.UsuarioLogado() == null) {
			iniciarlizarComponentes();
		} else {
			Pessoa pessoa = new Pessoa();
			pessoa = carregarUsuarioLogado(UsuarioLogado.UsuarioLogado().user);
			iniciarlizarComponentes();
			preencheCamposComUsuarioLogado(pessoa);
		}

	}

	public void iniciarlizarComponentes() throws ParseException {

		JPanel panelCampos_1 = new JPanel();
		panelCampos_1.setBounds(8, 56, 449, 269);
		telaCadastro.add(panelCampos_1);

		tfNome = new JTextField();
		tfNome.setBounds(29, 46, 173, 20);
		tfSobrenome = new JTextField();
		tfSobrenome.setBounds(221, 46, 173, 20);
		tfDataNascimento = new JFormattedTextField();
		tfDataNascimento.setBounds(29, 101, 131, 20);
		radioBtnSexoM = new JRadioButton();
		radioBtnSexoM.setBounds(221, 101, 21, 21);
		tpSenha = new JPasswordField();
		tpSenha.setBounds(29, 188, 365, 20);
		tpConfirmarSenha = new JPasswordField();
		tpConfirmarSenha.setBounds(29, 232, 365, 20);
		tfLogin = new JTextField();
		tfLogin.setBounds(29, 146, 131, 20);

		panelCampos_1.setLayout(null);

		JLabel lblNome = new JLabel("Nome : *");
		lblNome.setBounds(29, 31, 55, 14);
		panelCampos_1.add(lblNome);
		tfNome.setDocument(new TeclasPermitidas());
		panelCampos_1.add(tfNome);

		JLabel label_1 = new JLabel("Sobrenome: ");
		label_1.setBounds(221, 31, 80, 14);
		panelCampos_1.add(label_1);
		tfSobrenome.setDocument(new TeclasPermitidas());
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

		JLabel lblNewLabel_2 = new JLabel("Login : * ");
		lblNewLabel_2.setBounds(29, 132, 93, 14);
		panelCampos_1.add(lblNewLabel_2);
		panelCampos_1.add(tfLogin);
		tfLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha: *");
		lblSenha.setBounds(29, 174, 55, 14);
		panelCampos_1.add(lblSenha);
		panelCampos_1.add(tpSenha);

		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:  * ");
		lblConfirmarSenha.setBounds(29, 219, 131, 14);
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

		radioBtnSexoM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (radioBtnSexoM.isSelected()) {
					radioBtnSexoF.setSelected(false);
					sexo = "M";
				}
			}
		});

		telaCadastro.setLayout(null);
		panelCampos.setBounds(8, 11, 449, 35);

		telaCadastro.add(panelCampos);
		panelCampos.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cadastro de Pessoa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 11, 444, 30);
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
		this.tfLogin.setText(null);
		this.tpSenha.setText(null);
		this.tpConfirmarSenha.setText(null);

	}

	private class CancelarCadastro implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			resetForm();
			dispose();
		}
	}

	private class Cadastar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Pessoa pessoa = new Pessoa();

				pessoa.setNome(tfNome.getText());
				pessoa.setSobrenome(tfSobrenome.getText());
				pessoa.setDataNascimento(formatData(tfDataNascimento.getText()));
				pessoa.setLogin(tfLogin.getText());
				pessoa.setSenha(tpSenha.getText());
				pessoa.setSexo(sexo);

				String confirmarSenha = tpConfirmarSenha.getText();

				if (camposObrigatorios(pessoa) && validaSenha(tpSenha.getText(), confirmarSenha)) {

					pessoacontroller.salvar(pessoa);
					JOptionPane.showMessageDialog(null, "Cadastro Realizado");
					dispose();
					menuFrame.setVisible(true);
					framePrincipal.dispose();

				}
			} catch (SQLException sql) {
				sql.printStackTrace();

			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			resetForm();

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

	private boolean camposObrigatorios(Pessoa pessoa) {

		if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
			tfNome.requestFocus();
			JOptionPane.showMessageDialog(null, "Campo Nome obrigatorio");
			return false;
		}
		if (pessoa.getDataNascimento() == null) {
			tfDataNascimento.requestFocus();
			JOptionPane.showMessageDialog(null, "Campo data nascimento obrigatorio");
			return false;
		}
		if (pessoa.getSenha().isEmpty()) {
			tpSenha.requestFocus();
			JOptionPane.showMessageDialog(null, "Campo data nascimento obrigatorio");
			return false;
		}

		if (tpConfirmarSenha.getText().isEmpty()) {
			tpConfirmarSenha.requestFocus();
			JOptionPane.showMessageDialog(null, "Campo confirmar senha obrigatorio");
			return false;
		}

		return true;
	}

	private Date formatData(String data) throws ParseException {
		if (data.isEmpty() || data == null) {
			DateFormat format = new SimpleDateFormat("dd/mm");
			return new Date(format.parse(data).getTime());
		}
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();

	}

	private boolean validarDiaMesAno(String data) {

		String dia = data.substring(0, 2);
		String mes = data.substring(3, 5);
		String ano = data.substring(6, 10);
		int diaToInteger = (Integer.valueOf(dia));
		int mesToInteger = (Integer.valueOf(mes));
		int anoToInteger = (Integer.valueOf(ano));

		if (diaToInteger < 32) {
			JOptionPane.showMessageDialog(null, "Dia Invalido");
			return false;
		}
		if (mesToInteger < 12) {
			JOptionPane.showMessageDialog(null, "Mês Invalido");
			return false;
		}
		if (anoToInteger < 1900 || anoToInteger > 2020) {
			JOptionPane.showMessageDialog(null, "Ano Invalido");
			return false;
		}
		return true;
	}

	public Pessoa carregarUsuarioLogado(String string) {
		return pessoacontroller.buscarUsuario(string);

	}

	private void preencheCamposComUsuarioLogado(Pessoa pessoa) {
		tfNome.setText(pessoa.getNome());
		tfSobrenome.setText(pessoa.getSobrenome());
		tfDataNascimento.setText(pessoa.getDataNascimento().toString());
		if (pessoa.getSexo() != null) {
			if (pessoa.getSexo() == "M") {
				radioBtnSexoM.setSelected(true);
			} else {
				radioBtnSexoM.setSelected(true);
			}
		}
		tpSenha = new JPasswordField();
		tpSenha.setBounds(29, 188, 365, 20);
		tpConfirmarSenha = new JPasswordField();
		tpConfirmarSenha.setBounds(29, 232, 365, 20);
		tfLogin = new JTextField();
		tfLogin.setBounds(29, 146, 131, 20);
	}

}
