package com.alura.view.modals;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;

public class EmtyFormDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EmtyFormDialog dialog = new EmtyFormDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EmtyFormDialog() {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Proporcione todos los valores");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(44, 73, 343, 25);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\cerrar-24px.png"));
		lblNewLabel_1.setBounds(205, 45, 24, 25);
		contentPanel.add(lblNewLabel_1);
	}
}
