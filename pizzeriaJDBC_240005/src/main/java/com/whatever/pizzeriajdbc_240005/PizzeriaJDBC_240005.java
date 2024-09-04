/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.whatever.pizzeriajdbc_240005;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Laboratorios
 */
public class PizzeriaJDBC_240005 {

    public static void main(String[] args) {
        String cadenaConex = "jdbc:mysql://localhost:3306/pizzeria";
        String usuario = "root";
        String pass = "itson";

        String i = "INSERT INTO productos (nombre,precio,descripcion) VALUES (?,?,?)";
        String query = "SELECT * FROM productos WHERE precio < ?";

        try {
            Connection c = DriverManager.getConnection(cadenaConex, usuario, pass);

//            PreparedStatement insert = c.prepareStatement(i, Statement.RETURN_GENERATED_KEYS);
//
//            insert.setString(1, "Pizza de Champiñones");
//            insert.setFloat(2, 100.0f);
//            insert.setString(3, "Pizza senccilla con base de tomate y queso, con topping de champiñones.");
//
//            insert.execute();
            PreparedStatement busqueda = c.prepareStatement(query);

            busqueda.setFloat(1, 100);

            ResultSet resultados = busqueda.executeQuery();

            if (resultados.next()) {
                String nombre = resultados.getString("nombre");
                float precio = resultados.getFloat("precio");
                String descripcion = resultados.getString("descripcion");
                
                System.out.println(nombre+" $" +precio+descripcion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
