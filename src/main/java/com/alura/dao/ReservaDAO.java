package com.alura.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import com.alura.model.Huesped;
import com.alura.model.Reserva;
import com.alura.view.modals.ErrorCreate;

public class ReservaDAO {

	private Connection connection;
	
	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Integer insert(Reserva reserva) {
		try {
			var query = "INSERT INTO RESERVAS(fechaEntrada, fechaSalida, valor, idFormaPago) VALUES(?,?,?,?)";
			final PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			try(statement) {
				statement.setString(1, reserva.getFechaEntrada());
				statement.setString(2, reserva.getFechaSalida());
				statement.setBigDecimal(3, reserva.getValor());
				statement.setInt(4, reserva.getTipoPago());
				
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				
				try(resultSet) {
					if(resultSet.next()) {
						var reservaId = resultSet.getInt(1); //Obtener id de la reserva si la operación fue exitosa
						return reservaId; //Retornar el id de la reserva creada
					} else {
						return null;
					}
				}
			}
			
		} catch(SQLException e) {
			ErrorCreate errorCreate = new ErrorCreate();
			errorCreate.setLocationRelativeTo(null);
			errorCreate.setVisible(true);
			
			throw new RuntimeException(e);
		}
	}
	
	public boolean update(Reserva reserva) {
		try {
			var query = "UPDATE reservas SET fechaEntrada=?, fechaSalida=?, valor=?, idFormaPago=? WHERE id=?";
			
			final PreparedStatement statement = connection.prepareStatement(query);
			
			try(statement) {
				statement.setString(1, reserva.getFechaEntrada());
				statement.setString(2, reserva.getFechaSalida());
				statement.setBigDecimal(3, reserva.getValor());
				statement.setInt(4, reserva.getTipoPago());
				statement.setInt(5, reserva.getId());
				
				statement.execute();
				return true;
			}
			
		} catch(SQLException e) {
			ErrorCreate errorCreate = new ErrorCreate();
			errorCreate.setLocationRelativeTo(null);
			errorCreate.setVisible(true);
			
			throw new RuntimeException(e);
		}
	}
	
	public Vector<Reserva> listarConHuespedes(){
		Vector<Reserva> result = new Vector<>();
		
		try {
			var query = "SELECT R.id, R.fechaEntrada, R.fechaSalida, R.valor, R.idFormaPago, H.id, H.nombre, H.apellido, H.fechaNacimiento, H.nacionalidad, H.telefono, H.idReserva FROM RESERVAS R INNER JOIN HUESPEDES H ON R.id = H.idReserva";
			final PreparedStatement statment = connection.prepareStatement(query);
			
			try(statment){
				final ResultSet resultSet = statment.executeQuery();
				
				try(resultSet){
					while(resultSet.next()) {
						//Crear un objeto de tipo reserva con los datos de la consulta
						Integer reservaId = resultSet.getInt("R.id");
						Date fechaEntrada = resultSet.getDate("R.fechaEntrada");
						Date fechaSalida = resultSet.getDate("R.fechaSalida");
						BigDecimal valor = resultSet.getBigDecimal("R.valor");
						Integer idFormaPago = resultSet.getInt("R.idFormaPago");
						
						Reserva reserva = new Reserva(fechaEntrada, fechaSalida, valor, idFormaPago);
						reserva.setId(reservaId);
						
						//Crear un huesped para agregarlo a su reserva
						Huesped huesped = new Huesped(resultSet.getString("H.nombre"), resultSet.getString("H.apellido"), resultSet.getDate("H.fechaNacimiento"), resultSet.getString("H.nacionalidad"), resultSet.getString("H.telefono"), resultSet.getInt("H.idReserva"));
						huesped.setId(resultSet.getInt("H.id"));
						reserva.addHuesped(huesped);
						
						//Agregar la reserva con su huesped a los resultados
						result.add(reserva);						
					}
				}
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}

	public Integer delete(Integer id) {
		try{
			
			var query = "DELETE FROM reservas WHERE id=?";
			
			final PreparedStatement statement = connection.prepareStatement(query);
			
			try(statement){
				statement.setInt(1, id);
				statement.execute();
				
				return statement.getUpdateCount();
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
