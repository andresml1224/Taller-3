package com.andresmontoya.domain;

import java.util.ArrayList;
import java.util.List;

public class Mercado {

    private String supermercado;
    private List<Productos> productos;
    public byte CAPACIDAD;

    public Mercado(String supermercado) {
        this.supermercado = supermercado;
        this.productos = new ArrayList<>();
        this.CAPACIDAD = 78;
    }

    public boolean agregar(Productos p) {
        for (Productos producto : productos) {
            if (producto.getCodigo() == p.getCodigo()) {
                return false;
            }
        }
        if (productos.size() >= CAPACIDAD) {
            return false;
        }
        productos.add(p);
        return true;
    }


    public boolean retirar(String nombre) {
        int recorrido = -1; //Se coloca en -1 para evaluar que los productos no se encuentran
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(nombre)) {
                recorrido = i;
                break;
            }
        }
        if (recorrido == -1) {
            return false;
        }
        productos.remove(recorrido);
        productos.get(recorrido).setCantidad(productos.get(recorrido).getCantidad() - 1);
        return true;
    }



    public Productos buscar(String nombre) {
        // Buscamos el producto en el mercado
        int index = -1;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(nombre)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return null;
        }
        return productos.get(index);
    }

    public Productos buscar(int codigo) {
        // Buscamos el producto en el mercado
        int index = -1;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo() == codigo) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return null;
        }
        return productos.get(index);
    }


    public List<Productos> buscarPorTipo(String tipo) {
        List<Productos> productosEncontrados = new ArrayList<>();
        for (Productos producto : productos) {
            if (producto.getTipo().equals(tipo)) {
                productosEncontrados.add(producto);
            }
        }
        return productosEncontrados;
    }


    public int calcularTotal() {
        int total = 0;
        for (Productos producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }

    public String getSupermercado() {
        return supermercado;
    }
}
