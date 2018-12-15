package Ordenar;

import java.util.ArrayList;

public class SubCategoria {
    int codigo;
    String nombre;
    Categoria categoria;
    ArrayList<Producto> productosDeSubCategoria;

    public SubCategoria(int codigo, String nombre, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void addProducto(Producto producto) {
        this.productosDeSubCategoria.add(producto);
    }

    public void addNewProducto(String nombreProducto, int precio) {
        int codigoProducto = formarCodigo();
        this.productosDeSubCategoria.add(new Producto(nombreProducto, precio, 0, codigoProducto));
    }

    private int formarCodigo() {
        String codigoCategoria = Integer.toString(this.categoria.getCodigo());
        String codigoSubCategoria = Integer.toString(this.codigo);
        int codigoProducto = 1;
        for (int i = 0; i < this.productosDeSubCategoria.size(); i++) {
            String codigoFinal = "";
            String codigoTotal = Integer.toString(this.productosDeSubCategoria.get(i).getCodigo());
            char[] chars = codigoTotal.toCharArray();
            codigoFinal += chars[4];
            codigoFinal += chars[5];
            codigoFinal += chars[6];
            int codigoFinalInt = Integer.parseInt(codigoFinal);
            if (codigoFinalInt > codigoProducto) {
                codigoProducto = codigoFinalInt;
            }
        }
        String codigoProductoString = "";
        if (codigoProducto >= 10) {
            codigoProductoString = "0" + Integer.toString(codigoProducto);
        } else if (codigoProducto >= 100) {
            codigoProductoString = Integer.toString(codigoProducto);
        } else {
            codigoProductoString = "0" + "0" + Integer.toString(codigoProducto);
        }
        String codigoFinal = codigoCategoria + codigoSubCategoria + codigoProductoString;
        int codigoFinalInt = Integer.parseInt(codigoFinal);
        return codigoFinalInt;
    }

    public ArrayList<Producto> getProductosDeSubCategoria() {
        return this.productosDeSubCategoria;
    }
}
