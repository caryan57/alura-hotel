package com.alura.controller;

import java.util.Date;
import java.util.Vector;

import com.alura.dao.HuespedDAO;
import com.alura.factory.ConnectionFactory;
import com.alura.model.Huesped;
import com.alura.model.Reserva;
import com.alura.view.MenuUsuario;
import com.alura.view.modals.EditSuccess;
import com.alura.view.modals.SuccessCreate;

public class HuespedController {
	
	private HuespedDAO huespedDAO;
	
	public HuespedController() {
		huespedDAO = new HuespedDAO(new ConnectionFactory().connect());
	}

	public void crearHuesped(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer reservaId) {
		Huesped huesped = new Huesped(nombre, apellido, fechaNacimiento, nacionalidad, telefono, reservaId);
		var huespedId = huespedDAO.insert(huesped);
		
		if(huespedId != null) {
			SuccessCreate successCreate = new SuccessCreate();
			successCreate.setLocationRelativeTo(null);
			successCreate.setVisible(true);
		}
	}
	
	public void editarHuesped(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer reservaId, Integer id) {
		Huesped huesped = new Huesped(nombre, apellido, fechaNacimiento, nacionalidad, telefono, reservaId);
		huesped.setId(id);
		
		boolean update = huespedDAO.update(huesped);
		
		if(update) {
			EditSuccess editSuccess = new EditSuccess();
			editSuccess.setLocationRelativeTo(null);
			editSuccess.setVisible(true);
		}
	}
}
