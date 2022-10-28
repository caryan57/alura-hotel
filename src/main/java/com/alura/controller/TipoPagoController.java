package com.alura.controller;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.alura.dao.TipoPagoDAO;
import com.alura.factory.ConnectionFactory;
import com.alura.model.TipoPago;

public class TipoPagoController {
	
	private TipoPagoDAO tipoPagoDAO;
	
	public TipoPagoController() {
		tipoPagoDAO = new TipoPagoDAO(new ConnectionFactory().connect());
	}
	
	public List<TipoPago> obtener() {
		return tipoPagoDAO.getAll();
	}
	
	public void obtenerCombos(JComboBox combo) {
		DefaultComboBoxModel model = new DefaultComboBoxModel<>();
		combo.setModel(model);
		
		var tipos = this.obtener();
		
		tipos.forEach(tipo -> {
			model.addElement(tipo.getNombre());
		});
		
	}
}
