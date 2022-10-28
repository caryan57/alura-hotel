package com.alura.view.modals;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class ErrorDelete extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ErrorDelete dialog = new ErrorDelete();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ErrorDelete() {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("No fue posible eliminar el registro");
			lblNewLabel.setForeground(SystemColor.textHighlight);
			lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(20, 74, 393, 32);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\cerrar-24px.png"));
		lblNewLabel_1.setBounds(205, 45, 24, 29);
		contentPanel.add(lblNewLabel_1);
	}
}
