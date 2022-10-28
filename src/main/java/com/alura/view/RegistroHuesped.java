package com.alura.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alura.controller.HuespedController;
import com.alura.view.modals.EmtyFormDialog;
import com.toedter.calendar.JDateChooser;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Dialog;

public class RegistroHuesped extends JFrame {

	private JPanel contentPane;
	private JTextField NombreInput;
	private JTextField ApellidoInput;
	private JTextField TelefonoInput;
	private JTextField ReservaInfo;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHuesped frame = new RegistroHuesped();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public RegistroHuesped(Integer reservaId) {
		
		HuespedController huespedController = new HuespedController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 526, 577);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\Ha-100px.png"));
		lblNewLabel.setBounds(215, 21, 100, 107);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\registro.png"));
		lblNewLabel_1.setBounds(10, 38, 505, 512);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\arrow_1.png"));
		lblNewLabel_4.setBounds(19, 23, 23, 14);
		panel.add(lblNewLabel_4);
		
		JPanel RegistroPane = new JPanel();
		RegistroPane.setBounds(526, 0, 531, 578);
		contentPane.add(RegistroPane);
		RegistroPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("REGISTRO DE HUESPED");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setBounds(121, 38, 288, 36);
		RegistroPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 26));
		
		JLabel NombreLabel = new JLabel("NOMBRE");
		NombreLabel.setForeground(SystemColor.windowBorder);
		NombreLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
		NombreLabel.setBounds(59, 85, 101, 31);
		RegistroPane.add(NombreLabel);
		
		JLabel ApellidoLabel = new JLabel("APELLIDO");
		ApellidoLabel.setForeground(SystemColor.windowBorder);
		ApellidoLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
		ApellidoLabel.setBounds(59, 165, 113, 26);
		RegistroPane.add(ApellidoLabel);
		
		JLabel NacimientoLabel = new JLabel("FECHA DE NACIMIENTO");
		NacimientoLabel.setForeground(SystemColor.windowBorder);
		NacimientoLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
		NacimientoLabel.setBounds(59, 242, 245, 34);
		RegistroPane.add(NacimientoLabel);
		
		JDateChooser DateBirthPicker = new JDateChooser();
		DateBirthPicker.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		DateBirthPicker.getCalendarButton().setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\calendario.png"));
		DateBirthPicker.setBounds(60, 277, 382, 36);
		DateBirthPicker.getCalendarButton().setBackground(Color.WHITE);
		DateBirthPicker.setDateFormatString("yyyy-MM-dd");
		RegistroPane.add(DateBirthPicker);
		
		
		JLabel NacionalidadLabel = new JLabel("NACIONALIDAD");
		NacionalidadLabel.setForeground(SystemColor.windowBorder);
		NacionalidadLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
		NacionalidadLabel.setBounds(59, 322, 170, 33);
		RegistroPane.add(NacionalidadLabel);
		
		JLabel TelefonoLabel = new JLabel("TELEFONO");
		TelefonoLabel.setForeground(SystemColor.windowBorder);
		TelefonoLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
		TelefonoLabel.setBounds(59, 408, 114, 31);
		RegistroPane.add(TelefonoLabel);
		
		JLabel RerservaIdLabel = new JLabel("NO. RESERVA");
		RerservaIdLabel.setForeground(SystemColor.windowBorder);
		RerservaIdLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
		RerservaIdLabel.setBounds(60, 493, 146, 29);
		RegistroPane.add(RerservaIdLabel);
		
		NombreInput = new JTextField();
		NombreInput.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		NombreInput.setBounds(59, 120, 383, 40);
		RegistroPane.add(NombreInput);
		NombreInput.setColumns(10);
		
		ApellidoInput = new JTextField();
		ApellidoInput.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		ApellidoInput.setColumns(10);
		ApellidoInput.setBounds(59, 196, 383, 40);
		RegistroPane.add(ApellidoInput);
		
		JComboBox NacionalidadInput = new JComboBox();
		NacionalidadInput.setModel(new DefaultComboBoxModel(new String[] {"afgana", "alemana", "árabe", "argentina", "australiana", "belga", "boliviana", "brasileña", "camboyana", "canadiense", "chilena", "china", "colombiana", "costarricense", "cubana", "danesa", "ecuatoriana", "egipcia", "salvadoreña", "escocesa", "española", "estadounidense", "etiope", "filipina", "finlandesa", "francesa", "galesa", "griega", "guatemalteca", "haitiana", "holandesa", "hondureña", "indonesa", "inglesa", "iraquí", "iraní", "israelí", "italiana", "japonesa", "jordana", "letona", "malaya", "marroquí", "mexicana", "nicaragüense", "noruega", "neozelandesa", "panameña", "paraguaya", "peruana", "polaca", "portuguesa", "puertoriqueño", "dominicana", "rumano", "sueco", "suiza", "tailandesa", "turca", "ucraniana", "uruguaya", "venezolana", "vietnamieta"}));
		NacionalidadInput.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		NacionalidadInput.setToolTipText("");
		NacionalidadInput.setBounds(59, 357, 382, 40);
		RegistroPane.add(NacionalidadInput);
		
		TelefonoInput = new JTextField();
		TelefonoInput.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		TelefonoInput.setColumns(10);
		TelefonoInput.setBounds(59, 442, 383, 40);
		RegistroPane.add(TelefonoInput);
		
		ReservaInfo = new JTextField();
		ReservaInfo.setBackground(Color.GRAY);
		ReservaInfo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		ReservaInfo.setHorizontalAlignment(SwingConstants.CENTER);
		ReservaInfo.setForeground(Color.WHITE);
		ReservaInfo.setEditable(false);
		ReservaInfo.setText(reservaId.toString());
		ReservaInfo.setBounds(60, 530, 139, 32);
		RegistroPane.add(ReservaInfo);
		ReservaInfo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("GUARDAR");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(NombreInput.getText() != null && ApellidoInput.getText() != null && DateBirthPicker.getDate() != null && TelefonoInput.getText() != null && ReservaInfo.getText() != null) {
					huespedController.crearHuesped(NombreInput.getText(), ApellidoInput.getText(), DateBirthPicker.getDate(), NacionalidadInput.getSelectedItem().toString(), TelefonoInput.getText(), reservaId);
					dispose();
				} else {
					Dialog emptyFormDialog = new EmtyFormDialog();
					emptyFormDialog.setLocationRelativeTo(contentPane);
					emptyFormDialog.setVisible(true);
				}
			}
		});
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(SystemColor.textHighlight);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(311, 502, 131, 45);
		RegistroPane.add(lblNewLabel_3);
	}
}
