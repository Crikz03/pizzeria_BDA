/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Objetos.Producto;
import java.util.List;

/**
 *
 * @author Laboratorios
 */
public interface IProductoDAO {

    public boolean agregar(Producto producto);

    public boolean actualizar(Producto producto);

    public boolean eliminar(int id);

    public Producto consultar(int id);

    public List<Producto> cconsultarTodo();
}
