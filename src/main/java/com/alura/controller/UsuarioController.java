package com.alura.controller;

import com.alura.dao.UsuarioDAO;
import com.alura.factory.ConnectionFactory;
import com.alura.model.StatusControl;
import com.alura.model.Usuario;

public class UsuarioController {
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioController() {
		usuarioDAO = new UsuarioDAO(new ConnectionFactory().connect());
	}
	
	public StatusControl validarLogin(Usuario usuario) {
		return usuarioDAO.findUser(usuario.getNombre(), usuario.getPassword());
	}
}
