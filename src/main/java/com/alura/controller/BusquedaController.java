package com.alura.controller;

import java.util.Optional;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class BusquedaController {
	public void buscar(String query, DefaultTableModel model, JTable table) {
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);
		
		sorter.setRowFilter(RowFilter.regexFilter(query));
	}
	
	public void limpiar(DefaultTableModel model, JTable table) {
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);
		
		sorter.setRowFilter(RowFilter.regexFilter(""));
	}
}
