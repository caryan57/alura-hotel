package com.alura.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Huesped {

	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private String telefono;
	private Integer idReserva;
	private SimpleDateFormat dateFormat;
	
	public Huesped(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer reservaId) {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = reservaId;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getFechaNacimiento() {
		var formatedBirthDate = dateFormat.format(this.fechaNacimiento).toString();
		return formatedBirthDate;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public Integer getIdReserva() {
		return idReserva;
	}
}
