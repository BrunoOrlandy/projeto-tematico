package br.com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class initialView extends JFrame {
	public initialView() {
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static FrameCadastroCategoria frameCadastro = new FrameCadastroCategoria();

	public static void main(String[] args) {

		initialView frame = new initialView();
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Data Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frameCadastro.setVisible(true);
			}
		});
		btnNewButton.setBounds(22, 214, 89, 23);
		panel.add(btnNewButton);

	}

}
