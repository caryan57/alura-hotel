package com.alura.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Vector;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Reserva {
	private Integer id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private BigDecimal valor;
	private Integer tipoPago;
	private SimpleDateFormat dateFormat;
	private String formatedDateEntrada;
	private String formatedDateSalida;
	private Vector<Huesped> huespedes;
	
	public Reserva(Date fechaEntrada, Date fechaSalida, BigDecimal valor, Integer tipoPago) {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.tipoPago = tipoPago;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaEntrada() {
		formatedDateEntrada = dateFormat.format(fechaEntrada).toString();
		return formatedDateEntrada;
	}
	
	public String getFechaSalida() {
		formatedDateSalida = dateFormat.format(fechaSalida).toString();
		return formatedDateSalida;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public void setValor(int valor) {
		this.valor = new BigDecimal(valor);
	}

	public Integer getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(Integer tipoPago) {
		this.tipoPago = tipoPago;
	}
	
	public void addHuesped(Huesped huesped) {
		if(this.huespedes == null) {
			this.huespedes = new Vector<>();
		}
		
		this.huespedes.add(huesped);
	}
	
	public Vector<Huesped> getHuespedes(){
		return this.huespedes;
	}
}
