/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.whatever.pizzeriajdbc_240005;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DAO.ProductoDAO;
import Interfaces.IProductoDAO;
import Objetos.Producto;

/**
 *
 * @author Chris
 */
public class pruebaDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IConexionBD conexionBD = new ConexionBD();
        IProductoDAO productoDAO = new ProductoDAO(conexionBD);

        Producto p1 = new Producto("Pizza de champiñones", "Pizza senccilla con base de tomate y queso, con topping de champiñones.", 120.00f);

        Producto p2 = new Producto("Pizza de extra queso", "Pizza senccilla con base de tomate y queso, con topping de extra queso.", 100.00f);

        Producto p3 = new Producto("Pizza clasica", "Pizza senccilla con base de tomate y queso", 90.00f);

//        productoDAO.agregar(p1);
//        productoDAO.agregar(p2);
//        productoDAO.agregar(p3);

//        productoDAO.eliminar(2);

//        System.out.println(productoDAO.consultar(3));

        System.out.println(productoDAO.cconsultarTodo());
    }

}
