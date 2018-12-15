package Ordenar;

import java.util.ArrayList;
import java.util.Iterator;

public class CrearSeparacion {
    public ArrayList<Categoria> crearCategorias(ArrayList<String> categorias) {
        ArrayList<Categoria> categoriasFinales = new ArrayList<>();
        for (int i = 0; i < categorias.size(); i = +2) {
            int codigoCategoria = Integer.parseInt(categorias.get(i));
            String nombreCategoria = categorias.get(i + 1);
            categoriasFinales.add(new Categoria(codigoCategoria, nombreCategoria));
        }
        return categoriasFinales;
    }

    public ArrayList<SubCategoria> crearSubCategorias(ArrayList<String> subCategorias) {
        ArrayList<SubCategoria> subCategoriasFinales = new ArrayList<>();
        for (int i = 0; i < subCategorias.size(); i = +2) {
            int codigoCategoria = Integer.parseInt(subCategorias.get(i));
            String nombreCategoria = subCategorias.get(i + 1);
            subCategoriasFinales.add(new SubCategoria(codigoCategoria, nombreCategoria));
        }
        return subCategoriasFinales;
    }

    public void separarProductoCategoria(ArrayList<Producto> Productos, ArrayList<Categoria> categoriasFinales) {
        for (int i = 0; i < Productos.size(); i++) {
            String categoria = "";
            String codigoProvisional = Integer.toString(Productos.get(i).getCodigo());
            char[] chars = codigoProvisional.toCharArray();
            categoria += chars[0];
            categoria += chars[1];
            int categoriaFinal = Integer.parseInt(categoria);
            Iterator<Categoria> it = categoriasFinales.iterator();
            while (it.hasNext()) {
                Categoria cat = it.next();
                if (cat.getCodigo() == categoriaFinal) {
                    cat.addProducto(Productos.get(i));
                }
            }
        }
    }

    public void separarProductosSubCategoria(ArrayList<Producto> Productos, ArrayList<SubCategoria> subCategoriasFinales) {
        for (int i = 0; i < Productos.size(); i++) {
            String categoria = "";
            String codigoProvisional = Integer.toString(Productos.get(i).getCodigo());
            char[] chars = codigoProvisional.toCharArray();
            categoria += chars[0];
            categoria += chars[1];
            int categoriaFinal = Integer.parseInt(categoria);
            Iterator<SubCategoria> it = subCategoriasFinales.iterator();
            while (it.hasNext()) {
                SubCategoria sub = it.next();
                if (sub.getCodigo() == categoriaFinal) {
                    sub.addProducto(Productos.get(i));
                }
            }
        }
    }
}
