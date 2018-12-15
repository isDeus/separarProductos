package Ordenar;

import java.security.ProtectionDomain;
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

    //codigoCategoria;codigoSub;NombreSub
    public void crearSubCategorias(ArrayList<String> subCategorias, ArrayList<Categoria> categoriasFinales) {
        for (int i = 0; i < subCategorias.size(); i = +3) {
            int codigoCategoria = Integer.parseInt(subCategorias.get(i));
            String nombreSubCategoria = subCategorias.get(i + 1);
            int codigoSubCategoria = Integer.parseInt(subCategorias.get(i + 2));

            Iterator<Categoria> it = categoriasFinales.iterator();
            while (it.hasNext()) {
                Categoria cat = it.next();
                if (cat.getCodigo() == codigoCategoria) {
                    cat.addSubCategoria(new SubCategoria(codigoSubCategoria, nombreSubCategoria, cat));
                }
            }
        }
    }

    public void separarProductos(ArrayList<Producto> Productos, ArrayList<Categoria> categoriasFinales) {
        for (int i = 0; i < Productos.size(); i++) {
            String categoria = "";
            String subCategoria = "";
            String codigo = Integer.toString(Productos.get(i).getCodigo());
            char[] chars = codigo.toCharArray();
            categoria += chars[0];
            categoria += chars[1];
            subCategoria += chars[2];
            subCategoria += chars[3];
            int categoriaFinal = Integer.parseInt(categoria);
            int subCategoriaFinal = Integer.parseInt(subCategoria);
            Iterator<Categoria> it = categoriasFinales.iterator();
            while (it.hasNext()) {
                Categoria cat = it.next();
                if (cat.getCodigo() == categoriaFinal) {
                    cat.addProducto(Productos.get(i), subCategoriaFinal);
                }
            }
        }
    }

    public void añadirNuevoProducto(ArrayList<Categoria> categoriasFinales, String nombreCategoria, String nombreSubCategoria, String nombreProducto, int precio) {
        Iterator<Categoria> it = categoriasFinales.iterator();
        while(it.hasNext()){
            Categoria cat = it.next();
            if(cat.getNombre().equals(nombreCategoria)){
                cat.addNewProducto(nombreSubCategoria,nombreProducto,precio);
            }
        }

    }

    public ArrayList<Producto> getInventarioTotal(ArrayList<Categoria> categoriasFinales) {
        ArrayList<Producto> productoTotal = new ArrayList<>();
        for (int i = 0; i < categoriasFinales.size(); i++) {
            for (int j = 0; i < categoriasFinales.get(i).getSubCategorias().size(); i++) {
                for (int k = 0; k < categoriasFinales.get(i).getSubCategorias().get(j).getProductosDeSubCategoria().size(); k++) {
                    productoTotal.add(categoriasFinales.get(i).getSubCategorias().get(j).getProductosDeSubCategoria().get(k));
                }
            }
        }
        return productoTotal;
    }

    public ArrayList<String> getNombresCategorias(ArrayList<Categoria> categoriasFinales) {
        ArrayList<String> nombreCategoria = new ArrayList<>();
        for (int i = 0; i < categoriasFinales.size(); i++) {
            nombreCategoria.add(categoriasFinales.get(i).getNombre());
        }
        return nombreCategoria;
    }

    public ArrayList<String> getNombreSubcategorias(ArrayList<Categoria> categoriasFinales, String nombreCategoria) {
        ArrayList<String> nombreSubCategoria = new ArrayList<>();
        Iterator<Categoria> it = categoriasFinales.iterator();
        while (it.hasNext()) {
            Categoria cat = it.next();
            if (cat.getNombre().equals(nombreCategoria)) {
                for(int i = 0; i < cat.getSubCategorias().size(); i++){
                    nombreSubCategoria.add(cat.getSubCategorias().get(i).getNombre());
                }
            }
        }
        return nombreSubCategoria;
    }
}
