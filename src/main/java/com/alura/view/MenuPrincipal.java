package com.alura.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel BgImage = new JLabel("");
		BgImage.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\menu-img.png"));
		BgImage.setBounds(0, 0, 811, 532);
		contentPane.add(BgImage);
		
		JLabel Copyright = new JLabel("Desarrollado por Carlos Olivares © 2022");
		Copyright.setBackground(new Color(0, 128, 255));
		Copyright.setForeground(new Color(255, 255, 255));
		Copyright.setOpaque(true);
		Copyright.setFont(new Font("Segoe UI", Font.BOLD, 16));
		Copyright.setHorizontalAlignment(SwingConstants.CENTER);
		Copyright.setBounds(0, 531, 1056, 46);
		contentPane.add(Copyright);
		
		JLabel Logo150px = new JLabel("");
		Logo150px.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\aH-150px.png"));
		Logo150px.setBounds(863, 73, 150, 171);
		contentPane.add(Logo150px);
		
		JPanel LoginBg = new JPanel();
		LoginBg.setBackground(Color.WHITE);
		LoginBg.setBounds(811, 1, 245, 531);
		contentPane.add(LoginBg);
		LoginBg.setLayout(null);
		
		JPanel ClosePanel = new JPanel();
		ClosePanel.setBackground(Color.WHITE);
		ClosePanel.setBounds(196, 8, 37, 34);
		LoginBg.add(ClosePanel);
		ClosePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(contentPane,
			            "¿Deseas salir de la aplicación?", "Confirmar Salida: ",
			            JOptionPane.YES_NO_OPTION);
				
				if(result == 0) {
					System.exit(0);
				}
			}
			
		});
		ClosePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel CloseIcon = new JLabel("");
		ClosePanel.add(CloseIcon);
		CloseIcon.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\cerrar-24px.png"));
		
		JPanel LoginPanel = new JPanel();
		LoginPanel.setBounds(61, 297, 141, 160);
		LoginBg.add(LoginPanel);
		LoginPanel.setBackground(Color.WHITE);
		LoginPanel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		LoginPanel.setLayout(null);
		LoginPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel LoginLabel = new JLabel("LOGIN");
		LoginLabel.setForeground(SystemColor.textHighlight);
		LoginLabel.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginLabel.setBounds(28, 21, 83, 31);
		LoginPanel.add(LoginLabel);
		
		JLabel LoginIcon = new JLabel("");
		LoginIcon.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\login.png"));
		LoginIcon.setBounds(39, 57, 64, 72);
		LoginPanel.add(LoginIcon);
	}
}
