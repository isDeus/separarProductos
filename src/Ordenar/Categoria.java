package Ordenar;

import java.util.ArrayList;
import java.util.Iterator;

public class Categoria {
    int codigo;
    String nombre;
    ArrayList<SubCategoria> subCategorias;

    public Categoria(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void addProducto(Producto producto, int codigoSubCategoria) {
        Iterator<SubCategoria> it = this.subCategorias.iterator();
        while (it.hasNext()) {
            SubCategoria sub = it.next();
            if (sub.getCodigo() == codigoSubCategoria) {
                sub.addProducto(producto);
            }
        }
    }

    public void addNewProducto(String nombreSubCategoria, String nombreProducto, int precio) {
        Iterator<SubCategoria> it = this.subCategorias.iterator();
        while (it.hasNext()) {
            SubCategoria sub = it.next();
            if (sub.getNombre().equals(nombreSubCategoria)) {
                sub.addNewProducto(nombreProducto,precio);
            }
        }
    }

    public void addSubCategoria(SubCategoria subCategoria) {
        this.subCategorias.add(subCategoria);
    }


    public int getCodigo() {
        return this.codigo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public ArrayList<SubCategoria> getSubCategorias(){
        return this.subCategorias;
    }
}
