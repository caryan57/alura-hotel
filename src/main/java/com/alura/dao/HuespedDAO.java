package com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.alura.model.Huesped;
import com.alura.view.modals.ErrorCreate;

public class HuespedDAO {
	
	private Connection connection;
	
	public HuespedDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Integer insert(Huesped huesped) {
		try {
			var query = "INSERT INTO HUESPEDES(nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva) VALUES(?,?,?,?,?,?)";
			final PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setString(3, huesped.getFechaNacimiento());
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5, huesped.getTelefono());
				statement.setInt(6, huesped.getIdReserva());
				
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				
				try(resultSet){
					if(resultSet.next()) {
						var huespedId = resultSet.getInt(1);
						return huespedId;
					} else {
						return null;
					}
				}
			}
			
		}catch(SQLException e) {
			ErrorCreate errorCreate = new ErrorCreate();
			errorCreate.setLocationRelativeTo(null);
			errorCreate.setVisible(true);
			
			throw new RuntimeException(e);
		}
	}
	
	public boolean update(Huesped huesped) {
		try {
			var query = "UPDATE huespedes SET nombre=?, apellido=?, fechaNacimiento=?, nacionalidad=?, telefono=?, idReserva=? WHERE id=?";
			
			final PreparedStatement statement = connection.prepareStatement(query);
			
			try(statement){
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setString(3, huesped.getFechaNacimiento());
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5, huesped.getTelefono());
				statement.setInt(6, huesped.getIdReserva());
				statement.setInt(7, huesped.getId());
				
				statement.execute();
				return true;
			}
			
		}catch(SQLException e) {
			ErrorCreate errorCreate = new ErrorCreate();
			errorCreate.setLocationRelativeTo(null);
			errorCreate.setVisible(true);
			
			throw new RuntimeException(e);
		}
	}
}
