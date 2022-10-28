package com.alura.view.modals;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alura.view.MenuUsuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class SuccessCreate extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SuccessCreate dialog = new SuccessCreate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SuccessCreate() {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Reserva creada con exito");
			lblNewLabel.setForeground(SystemColor.textHighlight);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
			lblNewLabel.setBounds(41, 83, 353, 29);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\tick-78.png"));
			lblNewLabel_1.setBounds(187, 21, 59, 57);
			contentPanel.add(lblNewLabel_1);
		}
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario menuUsuario = new MenuUsuario();
				menuUsuario.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(172, 123, 89, 23);
		contentPanel.add(btnNewButton);
	}
}
