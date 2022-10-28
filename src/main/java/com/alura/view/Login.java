package com.alura.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alura.controller.UsuarioController;
import com.alura.model.StatusControl;
import com.alura.model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSeparator;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField PasswordInput;
	
	private UsuarioController usuarioController = new UsuarioController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Logo40px = new JLabel("");
		Logo40px.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\aH-40px.png"));
		Logo40px.setBounds(100, 44, 40, 45);
		contentPane.add(Logo40px);
		
		JLabel LoginTitle = new JLabel("INICIAR SESIÓN");
		LoginTitle.setForeground(SystemColor.textHighlight);
		LoginTitle.setFont(new Font("Segoe UI", Font.BOLD, 26));
		LoginTitle.setBounds(100, 112, 202, 54);
		contentPane.add(LoginTitle);
		
		JLabel UserNameTitle = new JLabel("USUARIO");
		UserNameTitle.setForeground(SystemColor.windowBorder);
		UserNameTitle.setFont(new Font("Segoe UI", Font.BOLD, 21));
		UserNameTitle.setBounds(100, 210, 101, 41);
		contentPane.add(UserNameTitle);
		
		JSeparator UserNameSeparator = new JSeparator();
		UserNameSeparator.setForeground(SystemColor.textHighlight);
		UserNameSeparator.setBounds(100, 295, 400, 51);
		contentPane.add(UserNameSeparator);
		
		JTextPane UserNameInput = new JTextPane();
		UserNameInput.setForeground(SystemColor.controlShadow);
		UserNameInput.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		UserNameInput.setBounds(100, 256, 398, 38);
		contentPane.add(UserNameInput);
		
		JPanel LoginPane = new JPanel();
		LoginPane.setBackground(Color.WHITE);
		LoginPane.setBounds(0, 0, 676, 577);
		contentPane.add(LoginPane);
		LoginPane.setLayout(null);
		
		JLabel PasswordTitle = new JLabel("CONTRASEÑA");
		PasswordTitle.setBounds(100, 314, 151, 29);
		PasswordTitle.setForeground(SystemColor.windowBorder);
		PasswordTitle.setFont(new Font("Segoe UI", Font.BOLD, 21));
		LoginPane.add(PasswordTitle);
		
		JSeparator PasswordSeparator = new JSeparator();
		PasswordSeparator.setForeground(SystemColor.textHighlight);
		PasswordSeparator.setBounds(100, 384, 400, 51);
		LoginPane.add(PasswordSeparator);
		
		PasswordInput = new JPasswordField();
		PasswordInput.setForeground(SystemColor.windowBorder);
		PasswordInput.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		PasswordInput.setBounds(100, 343, 398, 41);
		LoginPane.add(PasswordInput);
		PasswordInput.setBorder(null);
		
		JLabel LoginBtn = new JLabel("ENTRAR");
		LoginBtn.setBackground(SystemColor.textHighlight);
		LoginBtn.setForeground(Color.WHITE);
		LoginBtn.setOpaque(true);
		LoginBtn.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		LoginBtn.setHorizontalAlignment(SwingConstants.CENTER);
		LoginBtn.setBounds(100, 427, 152, 49);
		LoginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		LoginPane.add(LoginBtn);
		
		JPanel LoginBtnPanel = new JPanel();
		LoginBtnPanel.setBackground(Color.WHITE);
		LoginBtnPanel.setBounds(96, 422, 160, 59);
		LoginPane.add(LoginBtnPanel);
		LoginBtnPanel.addMouseListener(new MouseAdapter () {
			@Override
			public void mouseClicked(MouseEvent e) {
				var username = UserNameInput.getText();
				var password = PasswordInput.getPassword();
				
				Usuario usuario = new Usuario(username, password);
				StatusControl validacion = usuarioController.validarLogin(usuario);
				
				if(validacion.getStatus()) {
					MenuUsuario menuUsuario = new MenuUsuario();
					menuUsuario.setVisible(true);
					dispose();
				} else {
					Dialog errorDialog = validacion.getDialog();
					errorDialog.setLocationRelativeTo(contentPane); //Centrar el cuadro de diálogo
					errorDialog.setVisible(true);
				}
			}
		});
		
		JLabel HotelIcon = new JLabel("");
		HotelIcon.setHorizontalAlignment(SwingConstants.CENTER);
		HotelIcon.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\img-hotel-login-.png"));
		HotelIcon.setBounds(724, 58, 289, 495);
		contentPane.add(HotelIcon);
		
		JPanel HotelPanel = new JPanel();
		HotelPanel.setBackground(SystemColor.textHighlight);
		HotelPanel.setBounds(676, 0, 380, 577);
		contentPane.add(HotelPanel);
		HotelPanel.setLayout(null);
		
		JPanel ClosePanel = new JPanel();
		ClosePanel.setBackground(SystemColor.textHighlight);
		ClosePanel.setBounds(328, 11, 42, 34);
		HotelPanel.add(ClosePanel);
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
		CloseIcon.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\cerrar-24px.png"));
		ClosePanel.add(CloseIcon);
	}
}
