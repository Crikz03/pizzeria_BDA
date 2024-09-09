/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Objetos.Producto;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IProductoNegocio {
    
    public Producto agregar(Producto producto);

    public void actualizar(Producto producto);

    public void eliminar(int id);

    public Producto consultar(int id);

    public List<Producto> cconsultarTodo();
    
}
