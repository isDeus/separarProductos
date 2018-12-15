package Ordenar;

import java.util.ArrayList;

public class SubCategoria {
    int codigo;
    String nombre;
    ArrayList<Producto> productosDeSubCategoria;

    public SubCategoria(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void addProducto(Producto producto) {
        this.productosDeSubCategoria.add(new Producto());
    }
}
