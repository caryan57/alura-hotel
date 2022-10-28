package com.alura.tests;

import java.sql.Connection;
import java.sql.SQLException;

import com.alura.factory.ConnectionFactory;

public class PruebaPoolConexiones {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for(int i = 0; i < 20; i++) {
			Connection con = connectionFactory.connect();
			
			System.out.println("Abriendo la conexion " + (i + 1));
		}
	}

}
