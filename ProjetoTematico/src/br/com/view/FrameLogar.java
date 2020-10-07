package br.com.view;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
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

public class FrameLogar extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel = new JPanel();
	private JPanel tela = new JPanel();

	private Pessoa pessoa = new Pessoa();

	private JButton btnCadastrar;
	private JButton btnCancelar;

	private JTextField txtNome;
	private JPasswordField tpSenha;

	private MonneyControlledFrame framePrincipal;

	private FrameLogar frameLogar;
	private PessoaController pessoacontroller = new PessoaController();

	public FrameLogar(MonneyControlledFrame framePrincipal) {
		this.framePrincipal = framePrincipal;
		setModal(true);
		setTitle("Logar ");
		getContentPane().add(tela);

		inicializaComponentes();
		this.setSize(223, 184);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	private void inicializaComponentes() {
		tela.setLayout(null);

		Panel panel_1 = new Panel();
		panel_1.setBounds(10, 5, 200, 113);
		tela.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Nome: *");
		lblNewJgoodiesLabel.setBounds(10, 11, 92, 14);
		panel_1.add(lblNewJgoodiesLabel);

		tpSenha = new JPasswordField();
		tpSenha.setBounds(10, 80, 155, 22);
		panel_1.add(tpSenha);

		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Senha: *");
		lblNewJgoodiesLabel_1.setBounds(10, 59, 92, 14);
		panel_1.add(lblNewJgoodiesLabel_1);

		txtNome = new JTextField();
		txtNome.setBounds(10, 25, 155, 22);
		panel_1.add(txtNome);

		Panel panel_2 = new Panel();
		panel_2.setBounds(10, 123, 200, 27);
		tela.add(panel_2);
		panel_2.setLayout(null);

		btnCadastrar = new JButton("Cancelar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
				// frameLogar.setVisible(false);
				dispose();
			}
		});
		btnCadastrar.setBounds(0, 0, 89, 23);
		panel_2.add(btnCadastrar);

		btnCancelar = new JButton("Logar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (pessoacontroller.validarLogin(txtNome.getText(), tpSenha.getText())) {
					JOptionPane.showMessageDialog(null, "Bem vindo :" + txtNome.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Nome ou senha incorreto");
				}
				resetForm();
				dispose();
			}
		});

		btnCancelar.setBounds(111, 0, 89, 23);
		panel_2.add(btnCancelar);

	}

	public void resetForm() {
		this.txtNome.setText(null);
		this.tpSenha.setText(null);
	}

}
