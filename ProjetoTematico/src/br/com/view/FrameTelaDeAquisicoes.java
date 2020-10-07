package br.com.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FrameTelaDeAquisicoes extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	JPanel panel = new JPanel();

	public FrameTelaDeAquisicoes() {
		setTitle("Aquisições");
		getContentPane().setLayout(null);

		inicializarComponentes();
		setSize(256, 303);

	}

	public void inicializarComponentes() {

		panel.setBounds(10, 11, 227, 239);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome: *");
		lblNewLabel.setBounds(10, 11, 59, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(10, 25, 198, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Data Aquisi\u00E7\u00E3o: *");
		lblNewLabel_1.setBounds(10, 56, 109, 14);
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 70, 198, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Forma de Pagamento: *");
		lblNewLabel_2.setBounds(10, 101, 134, 14);
		panel.add(lblNewLabel_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 115, 198, 20);
		panel.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("Valor: *");
		lblNewLabel_3.setBounds(10, 146, 59, 14);
		panel.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setBounds(10, 159, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("N\u00BA Parcelas: *");
		lblNewLabel_4.setBounds(121, 146, 87, 14);
		panel.add(lblNewLabel_4);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(116, 159, 92, 20);
		panel.add(comboBox_1);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setToolTipText("Cancelar");
		btnNewButton.setBounds(10, 205, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.setToolTipText("Salvar");
		btnNewButton_1.setBounds(119, 205, 89, 23);
		panel.add(btnNewButton_1);

	}
}
