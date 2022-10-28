package com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.alura.model.TipoPago;

public class TipoPagoDAO {
	
	private Connection connection;
	
	public TipoPagoDAO(Connection con) {
		this.connection = con;
	}
	
	public List<TipoPago> getAll() {
		TipoPago tipos = new TipoPago(null, null);
		
		try {
			
			final PreparedStatement statement = connection.prepareStatement("SELECT ID, NOMBRE FROM FORMASPAGO");
			
			try(statement){
				final ResultSet resultSet = statement.executeQuery();
				
				try(resultSet){
					
					while(resultSet.next()) {
						Integer id = resultSet.getInt("ID");
						String nombre = resultSet.getString("NOMBRE");
						
						TipoPago tipoPago = new TipoPago(id, nombre);
						tipos.add(tipoPago);
					}
					
					return tipos.getAllTypes();
					
				}
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
