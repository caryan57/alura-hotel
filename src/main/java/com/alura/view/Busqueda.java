package com.alura.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.alura.controller.BusquedaController;
import com.alura.controller.HuespedController;
import com.alura.controller.ReservasController;
import com.alura.controller.TipoPagoController;
import com.alura.model.Reserva;
import com.alura.model.TipoPago;
import com.alura.view.modals.ErrorCreate;
import com.alura.view.modals.ErrorDelete;
import com.alura.view.modals.SuccessDelete;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloH;
	private JLabel labelAtras;
	private JLabel labelExit;
	private ReservasController reservasController;
	private TipoPagoController tipoPagoController;
	private BusquedaController busquedaController;
	private HuespedController huespedController;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		
		reservasController = new ReservasController();
		tipoPagoController = new TipoPagoController();
		busquedaController = new BusquedaController();
		huespedController = new HuespedController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblNewLabel_4.setBounds(306, 62, 298, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Reservas", new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\reservado.png"), tbReservas, null);
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Huéspedes", new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\pessoas.png"), tbHuespedes, null);
		panel.setBackgroundAt(1, SystemColor.textHighlight);
		modeloH = (DefaultTableModel) tbHuespedes.getModel();
		modeloH.addColumn("Numero de Huesped");
		modeloH.addColumn("Nombre");
		modeloH.addColumn("Apellido");
		modeloH.addColumn("Fecha de Nacimiento");
		modeloH.addColumn("Nacionalidad");
		modeloH.addColumn("Telefono");
		modeloH.addColumn("Numero de Reserva");
		
		//Enviar las reservas y huespedes a la tabla.
		cargarDatos();
		
		//Limpiar filtros de busqueda cuando no haya nada en el campo de texto
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtBuscar.getText().isEmpty()) {
					busquedaController.limpiar(modeloH, tbHuespedes);
					busquedaController.limpiar(modelo, tbReservas);
				}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\eclipse-workspace\\hotel-alura\\src\\img\\aH-150px.png"));
		lblNewLabel_2.setBounds(56, 51, 150, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panel.getSelectedIndex() == 0) {
					busquedaController.buscar(txtBuscar.getText(), modelo, tbReservas);
				} else if (panel.getSelectedIndex() == 1) {
					busquedaController.buscar(txtBuscar.getText(), modeloH, tbHuespedes);
				}
			}
		});
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panel.getSelectedIndex() == 0) {
					
					if(validarSeleccion(tbReservas)) {
						modificarReserva(modelo, tbReservas);
					}
					
				} else if (panel.getSelectedIndex() == 1) {
					
					if(validarSeleccion(tbHuespedes)) {
						modificarHuesped(modeloH, tbHuespedes);
					}
				}
			}
		});
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panel.getSelectedIndex() == 0) {
					if(validarSeleccion(tbReservas)) {
						Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
						.ifPresentOrElse(campo -> {
							Integer id = Integer.parseInt(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
							
							var eliminado = reservasController.eliminarReserva(id);
							
							if(eliminado == 1) {
								limpiarTabla(modelo);
								limpiarTabla(modeloH);
								
								cargarDatos();
								
							} else {
								ErrorDelete errorDelete = new ErrorDelete();
								errorDelete.setContentPane(panel);
								errorDelete.setVisible(true);
							}
							
						}, null);
					}
					
				} else if (panel.getSelectedIndex() == 1) {
					JOptionPane.showMessageDialog(tbHuespedes, "Si desea elminar un huésped debe eliminar la reserva");
				}
				
			}
		});
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
	    }
	    
	    private void cargarDatos() {
	    	var reservas = reservasController.cargarReporte();
	    	
	    	//Obtener los tipos de pago disponibles en la base de datos
	    	var tiposPago = tipoPagoController.obtener();
	    	
	    	reservas.forEach(reserva -> {
	    		
	    		var tipoPago = tiposPago.stream().filter(tipo -> tipo.getId().equals(reserva.getTipoPago())).findAny(); //Encontrar cualquier tipo de pago que exista en las reservas
	    		
	    		//Crear una fila con los datos de la reserva
	    		modelo.addRow(new Object[] {reserva.getId(), reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getValor(), tipoPago.get().getNombre()});
	    		
	    		//Obtener los huéspedes y crear una fila con sus datos
	    		var huespedes = reserva.getHuespedes();
	    		huespedes.forEach(huesped -> {
	    			modeloH.addRow(new Object[] {huesped.getId(), huesped.getNombre(), huesped.getApellido(), huesped.getFechaNacimiento(), huesped.getNacionalidad(), huesped.getTelefono(), huesped.getIdReserva()});
	    		});
	    	});
	    	
	    }
	    
	    private void limpiarTabla(DefaultTableModel model) {
	        model.getDataVector().clear();
	    }
	    
	    private boolean validarSeleccion(JTable table) {
	    	boolean tieneFilaElegida = table.getSelectedRowCount() == 0 || table.getSelectedColumnCount() == 0;
	    	
	    	if (tieneFilaElegida) {
	            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
	            return false;
	        } else {
	        	return true;
	        }
	    }
	    
	    private void modificarReserva(DefaultTableModel model, JTable table) {
	    	var tiposPago = tipoPagoController.obtener();
	    	
			Optional.ofNullable(model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()))
			.ifPresentOrElse(campo -> {
				Integer id = Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString());
				Date fechaEntrada = null;
				Date fechaSalida = null;
				try {
					fechaEntrada = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(table.getSelectedRow(), 1).toString());
					fechaSalida = new SimpleDateFormat("yyy-MM-dd").parse(model.getValueAt(table.getSelectedRow(), 2).toString());
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
				String valor = model.getValueAt(table.getSelectedRow(), 3).toString();
				Integer tipoPago = tiposPago.stream().filter(tipo -> tipo.getNombre().equals(model.getValueAt(table.getSelectedRow(), 4))).findAny().get().getId();
				
				reservasController.editarReserva(fechaEntrada, fechaSalida, valor, tipoPago, id);
				
			}, null);
		}
	    
	    private void modificarHuesped(DefaultTableModel model, JTable table) {
	    	Optional.ofNullable(model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()))
	    	.ifPresentOrElse(campo -> {
	    		Integer id = Integer.parseInt(model.getValueAt(table.getSelectedRow(), 0).toString());
	    		String nombre = model.getValueAt(table.getSelectedRow(), 1).toString();
	    		String apellido = model.getValueAt(table.getSelectedRow(), 2).toString();
	    		Date fechaNacimiento = null;
	    		
	    		try {
	    			fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(table.getSelectedRow(), 3).toString());
	    		}catch(ParseException e) {
	    			e.printStackTrace();
	    		}
	    		
	    		String nacionalidad = model.getValueAt(table.getSelectedRow(), 4).toString();
	    		String telefono = model.getValueAt(table.getSelectedRow(), 5).toString();
	    		Integer reservaId = Integer.parseInt(model.getValueAt(table.getSelectedRow(), 6).toString());
	    		
	    		huespedController.editarHuesped(nombre, apellido, fechaNacimiento, nacionalidad, telefono, reservaId, id);
	    	}, null);
	    }
	    
	    
}