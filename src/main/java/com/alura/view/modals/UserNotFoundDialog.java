package com.alura.view.modals;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class UserNotFoundDialog extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserNotFoundDialog dialog = new UserNotFoundDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserNotFoundDialog() {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(null);
		{
			JLabel ErrorTitle = new JLabel("Usuario no encontrado");
			ErrorTitle.setForeground(SystemColor.textHighlight);
			ErrorTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
			ErrorTitle.setHorizontalAlignment(SwingConstants.CENTER);
			ErrorTitle.setBounds(68, 70, 297, 33);
			getContentPane().add(ErrorTitle);
		}
		{
			JLabel ErrorIcon = new JLabel("");
			ErrorIcon.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\cerrar-24px.png"));
			ErrorIcon.setBounds(205, 38, 24, 39);
			getContentPane().add(ErrorIcon);
		}
	}

}
