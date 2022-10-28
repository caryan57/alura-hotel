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

public class IncorrectPasswordDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IncorrectPasswordDialog dialog = new IncorrectPasswordDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IncorrectPasswordDialog() {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel ErrorTitle = new JLabel("Contraseña incorrecta");
		ErrorTitle.setForeground(SystemColor.textHighlight);
		ErrorTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
		ErrorTitle.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorTitle.setBounds(68, 70, 297, 32);
		contentPanel.add(ErrorTitle);
		
		JLabel ErroIcon = new JLabel("");
		ErroIcon.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\cerrar-24px.png"));
		ErroIcon.setBounds(205, 38, 24, 40);
		contentPanel.add(ErroIcon);
	}

}
