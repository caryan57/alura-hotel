package com.alura.view.modals;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class ErrorCreate extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ErrorCreate dialog = new ErrorCreate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ErrorCreate() {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Hubo un error al crear el registro");
			lblNewLabel.setForeground(SystemColor.textHighlight);
			lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
			lblNewLabel.setBounds(22, 69, 389, 37);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\cerrar-24px.png"));
			lblNewLabel_1.setBounds(205, 37, 24, 29);
			contentPanel.add(lblNewLabel_1);
		}
	}

}
