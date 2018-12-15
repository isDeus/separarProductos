package Ordenar;

import java.util.ArrayList;

public class Categoria {
    int codigo;
    String nombre;
    ArrayList<Producto> productosDeCategoria;

    public Categoria(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void addProducto(Producto producto) {
        this.productosDeCategoria.add(new Producto());
    }

    public int getCodigo() {
        return this.codigo;
    }
}
