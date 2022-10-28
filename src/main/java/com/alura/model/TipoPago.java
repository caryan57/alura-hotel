package com.alura.model;

import java.util.ArrayList;
import java.util.List;

public class TipoPago {
	private Integer id;
	private String nombre;
	private List<TipoPago> tiposDePago;
	
	public TipoPago(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Integer getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void add(TipoPago tipoPago){
		if(tiposDePago == null) {
			this.tiposDePago = new ArrayList<>();
		}
		
		this.tiposDePago.add(tipoPago);
	}
	
	public List<TipoPago> getAllTypes(){
		return this.tiposDePago;
	}
}
