package com.andresmontoya.app;

import com.andresmontoya.domain.Mercado;
import com.andresmontoya.domain.Productos;
import com.andresmontoya.domain.TipoProductos;

import java.util.List;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        Mercado mercado = new Mercado("Supermercado La esquina");

        Productos producto1 = new Productos(1, "Carne de Res", 5, 8000, TipoProductos.CARNE);
        Productos producto2 = new Productos(2, "Lechuga", 3, 900, TipoProductos.VERDURA);
        Productos producto3 = new Productos(3, "Yogurt Alpina", 7, 1500, TipoProductos.LACTEO);
        Productos producto4 = new Productos(4, "Detergente Bonaropa", 3, 4500, TipoProductos.ASEO);
        Productos producto5 = new Productos(5, "Combo pan Normal", 8, 8500, TipoProductos.PAN);
        Productos producto6 = new Productos(6, "Acetaminofen", 9, 2000, TipoProductos.FARMACIA);
        Productos producto7 = new Productos(7, "Paquete manzanas", 5, 2300, TipoProductos.FRUTA);
        Productos producto8 = new Productos(8, "Camiseta One Piece", 20, 70000, TipoProductos.ROPA);
        Productos producto9 = new Productos(9, "Gorras ADIDAS", 2, 25000, TipoProductos.ROPA);
        mercado.agregar(producto1);
        mercado.agregar(producto2);
        mercado.agregar(producto3);
        mercado.agregar(producto4);
        mercado.agregar(producto5);
        mercado.agregar(producto6);
        mercado.agregar(producto7);
        mercado.agregar(producto8);
        mercado.agregar(producto9);

        int opcion;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bienvenido al " + mercado.getSupermercado());
            System.out.println("------------------------------------------");
            System.out.println("Ingrese que desea hacer");
            System.out.println("1. Buscar producto por nombre");
            System.out.println("2. Buscar producto por código");
            System.out.println("3. Buscar productos por tipo");
            System.out.println("4. Calcular total del inventario");
            System.out.println("5. Salir");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    Productos productoEncontradoNombre = mercado.buscar(nombre);

                    if (productoEncontradoNombre != null) {
                        System.out.println("El producto se encontró");
                        System.out.println("Nombre: " + productoEncontradoNombre.getNombre());
                        System.out.println("Código: " + productoEncontradoNombre.getCodigo());
                        System.out.println("Precio: " + productoEncontradoNombre.getPrecio());
                        System.out.println("Cantidad: " + productoEncontradoNombre.getCantidad());
                        System.out.println("Tipo: " + productoEncontradoNombre.getTipo());
                    } else {
                        System.out.println("El producto no se encontró");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el código del producto: ");
                    int codigo = scanner.nextInt();
                    Productos productoEncontradoCodigo = mercado.buscar(codigo);

                    if (productoEncontradoCodigo != null) {
                        System.out.println("El producto se encontró");
                        System.out.println("Nombre: " + productoEncontradoCodigo.getNombre());
                        System.out.println("Código: " + productoEncontradoCodigo.getCodigo());
                        System.out.println("Precio: " + productoEncontradoCodigo.getPrecio());
                        System.out.println("Cantidad: " + productoEncontradoCodigo.getCantidad());
                        System.out.println("Tipo: " + productoEncontradoCodigo.getTipo());
                    } else {
                        System.out.println("El producto no se encontró");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el tipo de producto: ");
                    String tipo = scanner.nextLine();
                    List<Productos> productosEncontrados = mercado.buscarPorTipo(tipo);

                    if (!productosEncontrados.isEmpty()) {
                        System.out.println("Se encontraron productos");
                        for (Productos producto : productosEncontrados) {
                            System.out.println("Nombre: " + producto.getNombre());
                            System.out.println("Código: " + producto.getCodigo());
                            System.out.println("Precio: " + producto.getPrecio());
                            System.out.println("Cantidad: " + producto.getCantidad());
                            System.out.println("Tipo: " + producto.getTipo());
                        }
                    } else {
                        System.out.println("No se encontraron productos");
                    }
                    break;
                case 4:
                    int total = mercado.calcularTotal();
                    System.out.println("El total del inventario es: " + total);
                    break;
                case 5:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 5);
    }
}
