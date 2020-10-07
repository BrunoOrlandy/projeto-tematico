package br.com.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class FrameRegistroDeMovimentacoes extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table = new JTable();
	JPanel panel = new JPanel();

	public FrameRegistroDeMovimentacoes() {
		setTitle("Registro de Movimentações");
		inicializarComponentes();
		getContentPane().setLayout(null);

		setSize(700, 282);
	}

	public void inicializarComponentes() {

		panel.setBounds(10, 21, 663, 213);
		getContentPane().add(panel);
		panel.setLayout(null);

		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Pessoa", "Tipo Movimenta\u00E7\u00E3o", "Data", "Tipo Conta", "Valor" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(113);
		table.setBounds(10, 11, 643, 159);
		panel.add(table);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(10, 181, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Editar Registro");
		btnNewButton_1.setBounds(126, 183, 116, 23);
		panel.add(btnNewButton_1);

	}
}
