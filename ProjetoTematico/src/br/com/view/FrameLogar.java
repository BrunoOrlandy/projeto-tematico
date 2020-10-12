package br.com.view;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import br.com.controller.PessoaController;
import br.com.dao.PessoaDao;
import br.com.model.Pessoa;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrameLogar extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel = new JPanel();
	private JPanel tela = new JPanel();

	private Pessoa pessoa = new Pessoa();

	private JButton btnCadastrar;
	private JButton btnCancelar;

	private JTextField tfLogin;
	private JPasswordField tpSenha;

	private MonneyControlledFrame framePrincipal;
	private MonneyControlledMenuFrame menuFrame = new MonneyControlledMenuFrame(framePrincipal);

	private PessoaController pessoacontroller = new PessoaController();
	private JLabel lblNewLabel;

	public FrameLogar(MonneyControlledFrame framePrincipal) throws ParseException {
		this.framePrincipal = framePrincipal;
		setTitle("Logar ");
		getContentPane().add(tela);

		inicializaComponentes();

		this.setSize(223, 226);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setFocusableWindowState(true);
	}

	private void inicializaComponentes() {
		tela.setLayout(null);

		Panel panel_1 = new Panel();
		panel_1.setBounds(10, 41, 200, 113);
		tela.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Login: *");
		lblNewJgoodiesLabel.setBounds(10, 11, 92, 14);
		panel_1.add(lblNewJgoodiesLabel);

		tpSenha = new JPasswordField();
		tpSenha.setBounds(10, 80, 155, 22);
		panel_1.add(tpSenha);

		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Senha: *");
		lblNewJgoodiesLabel_1.setBounds(10, 59, 92, 14);
		panel_1.add(lblNewJgoodiesLabel_1);

		tfLogin = new JTextField();
		tfLogin.setBounds(10, 25, 155, 22);
		panel_1.add(tfLogin);

		Panel panel_2 = new Panel();
		panel_2.setBounds(10, 160, 200, 27);
		tela.add(panel_2);
		panel_2.setLayout(null);

		btnCadastrar = new JButton("Cancelar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
				dispose();
			}
		});
		btnCadastrar.setBounds(0, 0, 89, 23);
		panel_2.add(btnCadastrar);

		btnCancelar = new JButton("Logar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (pessoacontroller.validarLogin(tfLogin.getText(), tpSenha.getText())) {
					JOptionPane.showMessageDialog(null, "Bem vindo : " + tfLogin.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Login ou senha incorreto");
				}
				resetForm();
				dispose();
				menuFrame.setVisible(true);
				framePrincipal.dispose();

			}
		});

		btnCancelar.setBounds(111, 0, 89, 23);
		panel_2.add(btnCancelar);

		lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 200, 24);
		tela.add(lblNewLabel);

	}

	public void resetForm() {
		this.tfLogin.setText(null);
		this.tpSenha.setText(null);
	}

}
