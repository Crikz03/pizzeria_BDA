/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Interfaces.IProductoDAO;
import Interfaces.IProductoNegocio;
import Objetos.Producto;
import java.util.List;

/**
 *
 * @author Chris
 */
public class ProductoNegocio implements IProductoNegocio {

    IProductoDAO productodao;

    public ProductoNegocio(IProductoDAO productodao) {
        this.productodao = productodao;
    }

    @Override
    public Producto agregar(Producto producto) {
        productodao.agregar(producto);

        return producto;
    }

    @Override
    public void actualizar(Producto producto) {
        productodao.actualizar(producto);

    }

    @Override
    public void eliminar(int id) {
        productodao.eliminar(id);
    }

    @Override
    public Producto consultar(int id) {
        Producto producto = productodao.consultar(id);

        return producto;
    }

    @Override
    public List<Producto> cconsultarTodo() {
        List<Producto> productos = productodao.cconsultarTodo();

        return productos;
    }
}
