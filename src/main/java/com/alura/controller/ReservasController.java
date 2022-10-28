package com.alura.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import com.alura.dao.ReservaDAO;
import com.alura.factory.ConnectionFactory;
import com.alura.model.Reserva;
import com.alura.view.RegistroHuesped;
import com.alura.view.modals.EditSuccess;
import com.alura.view.modals.SuccessCreate;

public class ReservasController {
	
	private ReservaDAO reservaDAO;
	
	public ReservasController() {
		reservaDAO = new ReservaDAO(new ConnectionFactory().connect());
	}
	
	public Reserva crearReserva(Date fechaEntrada, Date fechaSalida, String valor, Integer tipoPago) {
		var formatedValor =  new BigDecimal(valor.replaceAll(",","")); //Eliminar comas y convertir a un BigDecimal
		var idTipoPago = tipoPago + 1; //Sumar más uno para que corresponda un id de la tabla TipoPago
		
		Reserva reserva = new Reserva(fechaEntrada, fechaSalida, formatedValor, idTipoPago);
		var reservaID = reservaDAO.insert(reserva); //Ejecutar query en la base de datos y recibimos el id de la reserva si fue exitoso, en caso contrario, devuelve un null.
		
		if(reservaID != null) {
			reserva.setId(reservaID); //Aginar el id generado por la base de datos en el objeto
			return reserva; //Devolver el objeto a la vista
		} else {
			return null; //Si no se creó la reserva, se devuelve en null
		}
	}
	
	public void editarReserva(Date fechaEntrada, Date fechaSalida, String valor, Integer tipoPago, Integer idReserva) {
		var formatedValor =  new BigDecimal(valor.replaceAll(",",""));
		
		Reserva reserva = new Reserva(fechaEntrada, fechaSalida, formatedValor, tipoPago);
		reserva.setId(idReserva);
		
		boolean update = reservaDAO.update(reserva);
		
		if(update) {
			EditSuccess editSuccess = new EditSuccess();
			editSuccess.setLocationRelativeTo(null);
			editSuccess.setVisible(true);
		}
	}
	
	public void mostrarRegistroHuesped(Reserva reserva) {
		//Abrir venta para el registro de huesped
		RegistroHuesped registroHuesped = new RegistroHuesped(reserva.getId());
		registroHuesped.setVisible(true);
	}
	
	public Vector<Reserva> cargarReporte() {
		var reservas = reservaDAO.listarConHuespedes();
		if(reservas != null) {
			return reservas;
		} else {
			System.out.println("No fue posible obtener las reservas");
			return null;
		}
	}
	
	public Integer eliminarReserva(Integer id) {
		var reservaEliminada = reservaDAO.delete(id);
		
		if(reservaEliminada == 1) {
			return reservaEliminada;
		} else {
			return 0;
		}
	}
}
