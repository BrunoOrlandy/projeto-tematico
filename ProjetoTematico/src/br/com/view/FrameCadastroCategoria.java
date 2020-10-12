package br.com.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrameCadastroCategoria extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;

	private initialView framePrincipal = new initialView();

	public FrameCadastroCategoria() {

		this.setSize(450, 341);

		inicializaComponentes();
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastro de Categorias");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 11, 414, 30);
		getContentPane().add(lblNewLabel_2);
	}

	public void inicializaComponentes() {

		JPanel panel = new JPanel();
		JTable table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setSize(394, 90);
		table.setLocation(10, 104);
		table.setToolTipText("Tabela");

		panel.setBounds(10, 52, 414, 239);
		getContentPane().add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 48, 187, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Categoria: * ");
		lblNewLabel.setBounds(10, 34, 107, 14);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(10, 205, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.setBounds(109, 205, 89, 23);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Categorias");
		lblNewLabel_1.setBounds(10, 79, 89, 14);
		panel.add(lblNewLabel_1);

		Object[] colunas = new Object[] { "id", "Nome", "Teste" };
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(colunas);

		table.setVisible(true);

		panel.add(table);

	}
}
