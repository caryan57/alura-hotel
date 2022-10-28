package com.alura.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class MenuUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
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
	public MenuUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBackground(SystemColor.textHighlight);
		MenuPanel.setBounds(0, 0, 362, 577);
		contentPane.add(MenuPanel);
		MenuPanel.setLayout(null);
		
		JLabel Logo150px = new JLabel("");
		Logo150px.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\aH-150px.png"));
		Logo150px.setBounds(107, 29, 150, 187);
		MenuPanel.add(Logo150px);
		
		JSeparator MenuSeparator = new JSeparator();
		MenuSeparator.setBounds(60, 222, 242, 40);
		MenuPanel.add(MenuSeparator);
		
		JLabel ReservasTitle = new JLabel("Registro de Reservas");
		ReservasTitle.setForeground(Color.WHITE);
		ReservasTitle.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		ReservasTitle.setBounds(74, 258, 236, 45);
		MenuPanel.add(ReservasTitle);
		ReservasTitle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel BusquedaTitle = new JLabel("Búsqueda");
		BusquedaTitle.setForeground(Color.WHITE);
		BusquedaTitle.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		BusquedaTitle.setBounds(74, 318, 194, 45);
		MenuPanel.add(BusquedaTitle);
		BusquedaTitle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel ReservasIcon = new JLabel("");
		ReservasIcon.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\icon-reservas.png"));
		ReservasIcon.setBounds(33, 257, 32, 48);
		MenuPanel.add(ReservasIcon);
		ReservasIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel BusquedaIcon = new JLabel("");
		BusquedaIcon.setHorizontalAlignment(SwingConstants.CENTER);
		BusquedaIcon.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\pessoas.png"));
		BusquedaIcon.setBounds(34, 318, 33, 48);
		MenuPanel.add(BusquedaIcon);
		ReservasIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JPanel ReservasPanel = new JPanel();
		ReservasPanel.setBackground(SystemColor.textHighlight);
		ReservasPanel.setBounds(27, 255, 250, 58);
		MenuPanel.add(ReservasPanel);
		ReservasPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservasView = new ReservasView();
				reservasView.setVisible(true);
				dispose();
			}
		});
		
		JPanel BusquedaPanel = new JPanel();
		BusquedaPanel.setBackground(SystemColor.textHighlight);
		BusquedaPanel.setBounds(33, 318, 250, 45);
		MenuPanel.add(BusquedaPanel);
		BusquedaPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Busqueda busqueda = new Busqueda();
				busqueda.setVisible(true);
				dispose();
			}
		});
		
		
		JPanel WelcomePanel = new JPanel();
		WelcomePanel.setBackground(Color.WHITE);
		WelcomePanel.setBounds(361, 1, 696, 576);
		contentPane.add(WelcomePanel);
		WelcomePanel.setLayout(null);
		
		JPanel ClosePanel = new JPanel();
		ClosePanel.setBackground(Color.WHITE);
		ClosePanel.setBounds(638, 14, 42, 42);
		WelcomePanel.add(ClosePanel);
		ClosePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(contentPane,
			            "¿Deseas cerrar la sesión?", "Confirmar Salida: ",
			            JOptionPane.YES_NO_OPTION);
				
				if(result == 0) {
					Login login = new Login();
					login.setVisible(true);
					dispose();
				}
			}
			
		});
		ClosePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel CloseIcon = new JLabel("");
		CloseIcon.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\cerrar-sesion 32-px.png"));
		CloseIcon.setHorizontalAlignment(SwingConstants.CENTER);
		ClosePanel.add(CloseIcon);
		
		JTextArea WelcomeContent = new JTextArea();
		WelcomeContent.setBounds(58, 290, 593, 237);
		WelcomePanel.add(WelcomeContent);
		WelcomeContent.setBackground(Color.WHITE);
		WelcomeContent.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		WelcomeContent.setText("Sistema de reservas de Hotel Alura. Controle y administre \r\nde forma óptima y fácil el flujo de reservas y huéspedes del hotel.\r\nEsta herramienta le permitirá tener un control completo y detallado \r\nde sus reservas y huéspedes, además, tendrá acceso a herramientas \r\nespecializadas para las siguientes tareas administrativas:\r\n\r\n-Registro de Reservas y Huéspedes\r\n-Edición de Reservas y Huéspedes\r\n-Eliminar todo tipo de registros");
		WelcomeContent.setEditable(false);
		
		JLabel WelcomeTitle = new JLabel("Bienvenid@");
		WelcomeTitle.setBounds(58, 232, 204, 50);
		WelcomePanel.add(WelcomeTitle);
		WelcomeTitle.setForeground(Color.DARK_GRAY);
		WelcomeTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
		
		JPanel HeaderPanel = new JPanel();
		HeaderPanel.setBounds(0, 65, 694, 152);
		WelcomePanel.add(HeaderPanel);
		HeaderPanel.setBackground(new Color(104, 186, 230));
		HeaderPanel.setLayout(null);
		
		JLabel HeaderTitle = new JLabel("SISTEMA DE RESERVAS - HOTEL ALURA");
		HeaderTitle.setForeground(Color.WHITE);
		HeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 26));
		HeaderTitle.setBounds(111, 24, 483, 49);
		HeaderPanel.add(HeaderTitle);
		
		JLabel CurrentDate = new JLabel("20/01/2022");
		CurrentDate.setForeground(Color.WHITE);
		CurrentDate.setFont(new Font("Segoe UI", Font.PLAIN, 31));
		CurrentDate.setHorizontalAlignment(SwingConstants.CENTER);
		CurrentDate.setBounds(131, 72, 423, 58);
		HeaderPanel.add(CurrentDate);
		CurrentDate.setText(getDate());
	}
	
	public static String getDate() {
		return DateFormat.getDateInstance().format(new Date());
	}
}
