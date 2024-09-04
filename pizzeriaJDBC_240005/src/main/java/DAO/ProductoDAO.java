/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.IConexionBD;
import Interfaces.IProductoDAO;
import Objetos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laboratorios
 */
public class ProductoDAO implements IProductoDAO {

    private IConexionBD conexion;

    public ProductoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Producto producto) {
        try {
            Connection bd = conexion.crearConexion();
            String insertar = "INSERT INTO productos (nombre,precio,descripcion) VALUES (?,?,?)";

            PreparedStatement i = bd.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS);

            i.setString(1, producto.getNombre());
            i.setFloat(2, producto.getPrecio());
            i.setString(3, producto.getDescripcion());

            i.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(Producto producto) {
        String sentencia = "UPDATE productos SET nombre = ?, precio = ?, descripcion = ? WHERE id = ?";
        try (Connection bd = conexion.crearConexion(); PreparedStatement i = bd.prepareStatement(sentencia)) {
            i.setString(1, producto.getNombre());
            i.setFloat(2, producto.getPrecio());
            i.setString(3, producto.getDescripcion());

            i.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean eliminar(int id) {
        String sentencia = "DELETE FROM productos WHERE id = ?;";

        try (Connection bd = conexion.crearConexion(); PreparedStatement i = bd.prepareStatement(sentencia)) {

            i.setInt(1, id);

            int encontrado = i.executeUpdate();

            if (encontrado == 0) {
                System.out.println("No se encontro el producto con id: " + id);
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Producto consultar(int id) {
        String query = "SELECT * FROM productos WHERE id < ?";
        try {
            Connection bd = conexion.crearConexion();
            PreparedStatement busqueda = bd.prepareStatement(query);

            busqueda.setInt(1, id);

            ResultSet resultado = busqueda.executeQuery();

            if (resultado.next()) {
                Producto p = new Producto();
                p.setId(resultado.getInt("id"));
                p.setNombre(resultado.getString("nombre"));
                p.setDescripcion(resultado.getString("descripcion"));
                p.setPrecio(resultado.getFloat("precio"));

                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Producto> cconsultarTodo() {
        List<Producto> productos = new ArrayList<>();
        String busqueda = "SELECT * FROM productos";

        try (Connection bd = conexion.crearConexion(); PreparedStatement i = bd.prepareStatement(busqueda)) {
            try (ResultSet rs = i.executeQuery()) {
                while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setId(rs.getInt("id"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setPrecio(rs.getFloat("precio"));
                    producto.setDescripcion(rs.getString("descripcion"));

                    productos.add(producto);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productos;
    }

}
