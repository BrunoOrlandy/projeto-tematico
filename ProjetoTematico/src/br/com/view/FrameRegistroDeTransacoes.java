package br.com.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class FrameRegistroDeTransacoes extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table = new JTable();
	private JPanel panel = new JPanel();

	public FrameRegistroDeTransacoes() {
		setTitle("Registro de Transações");

		getContentPane().setLayout(null);

		iniciarlizarComponentes();
		this.setSize(600, 300);

	}

	public void iniciarlizarComponentes() {

		panel.setBounds(10, 11, 562, 241);
		getContentPane().add(panel);
		panel.setLayout(null);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, }, new String[] { "Editar", "Nome", "Data", "Valor", "Conta" }));
		table.setBounds(10, 11, 542, 192);
		panel.add(table);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBounds(10, 217, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Editar Registro");
		btnNewButton_1.setBounds(109, 217, 119, 23);
		panel.add(btnNewButton_1);
	}

}
