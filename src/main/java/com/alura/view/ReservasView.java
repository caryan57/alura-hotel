package com.alura.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.alura.controller.ReservasController;
import com.alura.controller.TipoPagoController;
import com.alura.model.Reserva;
import com.alura.model.TipoPago;
import com.alura.view.modals.EmtyFormDialog;
import com.alura.view.modals.ErrorCreate;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;

public class ReservasView extends JFrame {

	private JPanel contentPane;
	private TipoPagoController tipoPagoController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservasView frame = new ReservasView();
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
	public ReservasView() {
		
		TipoPagoController tipoPagoController = new TipoPagoController();
		ReservasController reservasController = new ReservasController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 616);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel ReservasPanel = new JPanel();
		ReservasPanel.setBounds(0, 0, 571, 577);
		ReservasPanel.setBackground(Color.WHITE);
		contentPane.add(ReservasPanel);
		ReservasPanel.setLayout(null);
		
		JLabel ReservasTitle = new JLabel("SISTEMA DE RESERVAS");
		ReservasTitle.setBounds(129, 72, 313, 37);
		ReservasTitle.setForeground(SystemColor.textHighlight);
		ReservasTitle.setHorizontalAlignment(SwingConstants.CENTER);
		ReservasTitle.setFont(new Font("Segoe UI", Font.BOLD, 26));
		ReservasPanel.add(ReservasTitle);
		
		JLabel CheckInTitle = new JLabel("FECHA DE CHECK IN");
		CheckInTitle.setBounds(61, 143, 208, 37);
		CheckInTitle.setForeground(SystemColor.windowBorder);
		CheckInTitle.setFont(new Font("Segoe UI", Font.BOLD, 21));
		ReservasPanel.add(CheckInTitle);
		
		JLabel CheckOutTitle = new JLabel("FECHA DE CHECK OUT");
		CheckOutTitle.setBounds(61, 232, 225, 37);
		CheckOutTitle.setForeground(SystemColor.windowBorder);
		CheckOutTitle.setFont(new Font("Segoe UI", Font.BOLD, 21));
		ReservasPanel.add(CheckOutTitle);
		
		
		JLabel ReservaTotalTitle = new JLabel("PRECIO RESERVA");
		ReservaTotalTitle.setBounds(61, 320, 225, 37);
		ReservaTotalTitle.setForeground(SystemColor.windowBorder);
		ReservaTotalTitle.setFont(new Font("Segoe UI", Font.BOLD, 21));
		ReservasPanel.add(ReservaTotalTitle);
		
		JLabel MoneyIcon = new JLabel("$");
		MoneyIcon.setBounds(62, 368, 31, 22);
		MoneyIcon.setForeground(Color.GRAY);
		MoneyIcon.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		ReservasPanel.add(MoneyIcon);
		
		JSeparator PrecioSeparator = new JSeparator();
		PrecioSeparator.setBounds(61, 397, 297, 22);
		PrecioSeparator.setForeground(SystemColor.textHighlight);
		ReservasPanel.add(PrecioSeparator);
		
		NumberFormat decimalFormat = DecimalFormat.getInstance();
		decimalFormat.setMinimumFractionDigits(2);
		decimalFormat.setMaximumFractionDigits(2);
		JFormattedTextField PrecioInput = new JFormattedTextField(decimalFormat);
		PrecioInput.setBounds(78, 362, 280, 35);
		PrecioInput.setDisabledTextColor(Color.DARK_GRAY);
		PrecioInput.setBackground(Color.WHITE);
		PrecioInput.setEnabled(false);
		PrecioInput.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		PrecioInput.setColumns(10);
		PrecioInput.setBorder(BorderFactory.createEmptyBorder());
		ReservasPanel.add(PrecioInput);
		
		JDateChooser DatePickerCheckIn = new JDateChooser();
		DatePickerCheckIn.setBounds(61, 186, 296, 35);
		DatePickerCheckIn.getCalendarButton().setForeground(Color.WHITE);
		DatePickerCheckIn.setBackground(Color.WHITE);
		DatePickerCheckIn.getCalendarButton().setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\calendario.png"));
		DatePickerCheckIn.getCalendarButton().setBackground(Color.WHITE);
		DatePickerCheckIn.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		DatePickerCheckIn.setDateFormatString("yyyy-MM-dd");
		ReservasPanel.add(DatePickerCheckIn);
		
		JDateChooser DatePickerCheckOut = new JDateChooser();
		DatePickerCheckOut.setBounds(61, 274, 296, 35);
		DatePickerCheckOut.getCalendarButton().setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\calendario.png"));
		DatePickerCheckOut.getCalendarButton().setForeground(Color.WHITE);
		DatePickerCheckOut.getCalendarButton().setBackground(Color.WHITE);
		DatePickerCheckOut.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		DatePickerCheckOut.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				//Activa el evento, después del usuario seleccionar las fechas se debe calcular el valor de la reserva
				var precio = calcularPrecio(400, DatePickerCheckIn.getDate(), DatePickerCheckOut.getDate());
				
				if(precio > 0) {
					PrecioInput.setValue(precio);
				}
				
			}
		});
		DatePickerCheckOut.setDateFormatString("yyyy-MM-dd");
		DatePickerCheckOut.setBackground(Color.WHITE);
		ReservasPanel.add(DatePickerCheckOut);
		
		JLabel PagoTitle = new JLabel("FORMA DE PAGO");
		PagoTitle.setBounds(61, 417, 225, 37);
		PagoTitle.setForeground(SystemColor.windowBorder);
		PagoTitle.setFont(new Font("Segoe UI", Font.BOLD, 21));
		ReservasPanel.add(PagoTitle);
		
		JComboBox TipoPagoBox = new JComboBox();
		TipoPagoBox.setBounds(63, 465, 295, 37);
		TipoPagoBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		tipoPagoController.obtenerCombos(TipoPagoBox);
		ReservasPanel.add(TipoPagoBox);
		
		JLabel NextBtn = new JLabel("SIGUIENTE");
		NextBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(DatePickerCheckIn.getDate() != null && DatePickerCheckOut.getDate() != null) {
					var reserva = reservasController.crearReserva(DatePickerCheckIn.getDate(), DatePickerCheckOut.getDate(), PrecioInput.getText(), TipoPagoBox.getSelectedIndex());
					
					if(reserva != null) {
						reservasController.mostrarRegistroHuesped(reserva);
						dispose();
					}
					
				} else {
					Dialog emptyFormDialog = new EmtyFormDialog();
					emptyFormDialog.setLocationRelativeTo(contentPane);
					emptyFormDialog.setVisible(true);
				}
			}
		});
		NextBtn.setBounds(398, 511, 148, 35);
		NextBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		NextBtn.setOpaque(true);
		NextBtn.setForeground(Color.WHITE);
		NextBtn.setBackground(SystemColor.textHighlight);
		NextBtn.setHorizontalAlignment(SwingConstants.CENTER);
		NextBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		ReservasPanel.add(NextBtn);
		
		JLabel PrevIcon = new JLabel("");
		PrevIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PrevIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario menuUsuario = new MenuUsuario();
				menuUsuario.setVisible(true);
				dispose();
			}
		});
		PrevIcon.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\arrow_1.png"));
		PrevIcon.setBounds(33, 34, 31, 22);
		ReservasPanel.add(PrevIcon);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\reservas-img-3.png"));
		lblNewLabel.setBounds(570, 190, 486, 325);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\Ha-100px.png"));
		lblNewLabel_2.setBounds(772, 64, 100, 115);
		contentPane.add(lblNewLabel_2);
		
	}
	
	private static Long calcularDias(Date fechaEntrada, Date fechaSalida) {
		
		LocalDate formatEntrada = LocalDate.ofInstant(fechaEntrada.toInstant(), ZoneId.systemDefault());
		LocalDate formatSalida = LocalDate.ofInstant(fechaSalida.toInstant(), ZoneId.systemDefault());
		
		Long calcularDias = ChronoUnit.DAYS.between(formatEntrada, formatSalida);
		
		return calcularDias;
	}
	
	private static Integer calcularPrecio(Integer precio, Date fechaEntrada, Date fechaSalida) {
		
		if(fechaEntrada == null || fechaSalida == null) {
			return 0;
		} else {
			Long dias = calcularDias(fechaEntrada, fechaSalida);
			return (int) (precio * dias);
		}
	}
}
