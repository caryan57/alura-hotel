package com.alura.model;

public class Usuario {
	private String nombre;
	private char[] password;
	
	public Usuario(String nombre, char[] password) {
		this.nombre = nombre;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}
	
	public char[] getPassword() {
		return password;
	}
	
}
