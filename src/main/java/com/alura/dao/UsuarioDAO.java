package com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alura.model.StatusControl;
import com.alura.view.modals.IncorrectPasswordDialog;
import com.alura.view.modals.UserNotFoundDialog;

public class UsuarioDAO {
	private Connection connection;
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public StatusControl findUser(String nombre, char[] password) {
		try {
			var queryUsername = "SELECT ID, NOMBRE, PASSWORD FROM USUARIOS WHERE NOMBRE=?";
			final PreparedStatement statement = connection.prepareStatement(queryUsername);
			
			try(statement) {
				statement.setString(1, nombre);
				
				final ResultSet resultSet = statement.executeQuery();
				
				try(resultSet) {
					if(resultSet.next()) {	
						String passwordToString = String.valueOf(password);
						
						if(resultSet.getString("PASSWORD").equals(passwordToString)) {
							return new StatusControl(true);
						} else {
							return new StatusControl(false, new IncorrectPasswordDialog());
						}
					} else {
						return new StatusControl(false, new UserNotFoundDialog());
					}
				}
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
