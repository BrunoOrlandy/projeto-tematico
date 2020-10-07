package br.com.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;

public class FrameCadastroCliente extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	public FrameCadastroCliente() {

		setTitle("Cadastro de Conta");
		getContentPane().setLayout(null);

		inicializaComponentes();

		this.setSize(450, 366);
		this.getDefaultCloseOperation();
	}

	public void inicializaComponentes() {

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 305);
		getContentPane().add(panel);
		panel.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(21, 28, 160, 20);
		panel.add(comboBox);

		JLabel lblNewLabel = new JLabel("Categoria: *");
		lblNewLabel.setBounds(21, 11, 81, 14);
		panel.add(lblNewLabel);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(212, 28, 192, 20);
		panel.add(comboBox_1);

		JLabel lblNewLabel_1 = new JLabel("Pessoa: *");
		lblNewLabel_1.setBounds(212, 11, 100, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_2.setBounds(21, 59, 100, 14);
		panel.add(lblNewLabel_2);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(21, 75, 160, 85);
		panel.add(textPane);

		JLabel lblNewLabel_3 = new JLabel("Data Pagamento");
		lblNewLabel_3.setBounds(212, 59, 111, 14);
		panel.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(212, 75, 192, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Data Vencimento: * ");
		lblNewLabel_4.setBounds(212, 106, 111, 14);
		panel.add(lblNewLabel_4);

		textField_1 = new JTextField();
		textField_1.setBounds(212, 120, 192, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Valor: *");
		lblNewLabel_5.setBounds(212, 146, 62, 14);
		panel.add(lblNewLabel_5);

		textField_2 = new JTextField();
		textField_2.setBounds(212, 163, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		table = new JTable();
		table.setBounds(21, 194, 383, 74);
		panel.add(table);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(21, 279, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.setBounds(120, 279, 89, 23);
		panel.add(btnNewButton_1);
	}
}
