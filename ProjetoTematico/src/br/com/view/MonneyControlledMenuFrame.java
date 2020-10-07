package br.com.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.text.ParseException;

import javax.swing.JButton;

public class MonneyControlledMenuFrame extends JFrame {

	private MonneyControlledFrame framePrincipal;

	public MonneyControlledMenuFrame(MonneyControlledFrame framePrincipal) throws ParseException {
		
		this.framePrincipal = framePrincipal;
		setTitle("Monney Controlled");

		getContentPane().setLayout(null);

		inicializarComponentes();

		setSize(450, 310);
		setLocationRelativeTo(null);
		setResizable(true);

	}

	public void inicializarComponentes() throws ParseException {

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 251);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Editar Perfil");
		btnNewButton.setBounds(30, 11, 338, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cadastro de Categorias de Contas");
		btnNewButton_1.setBounds(30, 45, 338, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cadastro de Contas");
		btnNewButton_2.setBounds(30, 79, 338, 23);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Transa\u00E7\u00F5es");
		btnNewButton_3.setBounds(30, 112, 338, 23);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Lan\u00E7ar Previs\u00E3o");
		btnNewButton_4.setBounds(30, 146, 338, 23);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Lan\u00E7ar Aquisi\u00E7\u00F5es");
		btnNewButton_5.setBounds(30, 180, 338, 23);
		panel.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Listar Movimenta\u00E7\u00F5es");
		btnNewButton_6.setBounds(30, 214, 338, 23);
		panel.add(btnNewButton_6);
	}

}
