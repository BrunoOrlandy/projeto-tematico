package br.com.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrameLancamentoDePrevisoes extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	public FrameLancamentoDePrevisoes() {
		setTitle("Lançamento de Previsões");

		getContentPane().setLayout(null);
		inicializarComponentes();
		setSize(337, 359);

	}

	public void inicializarComponentes() {

		JPanel panel = new JPanel();
		panel.setBounds(10, 70, 299, 239);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Conta: *");
		lblNewLabel.setBounds(10, 11, 68, 14);
		panel.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 25, 229, 20);
		panel.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Aquisi\u00E7\u00E3o");
		lblNewLabel_1.setBounds(10, 56, 46, 14);
		panel.add(lblNewLabel_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 70, 229, 20);
		panel.add(comboBox_1);

		JLabel lblNewLabel_2 = new JLabel("Data Prevista: *");
		lblNewLabel_2.setBounds(10, 101, 90, 14);
		panel.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(10, 115, 229, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Valor: *");
		lblNewLabel_3.setBounds(10, 146, 78, 14);
		panel.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 161, 102, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(11, 205, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.setBounds(109, 205, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Lan\u00E7amento de Previs\u00F5es");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 11, 299, 48);
		getContentPane().add(lblNewLabel_4);

	}
}
