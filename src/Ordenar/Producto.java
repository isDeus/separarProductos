package Ordenar;

public class Producto {
    private String nombre;
    private int precio;
    private int stock;
    private int codigo;
    private int stockCritico;

    public Producto(String nombre, int precio, int stock, int codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.codigo = codigo;
        this.stockCritico = 10;

    }

    Producto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sumarPrecio(int precio) {
        this.precio = this.precio + precio;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else if (stock < 0) {
            System.out.println("El stock no puede ser negativo");
        } else {
            System.out.println("El valor ingresado no es válido, porfavor intente denuevo");
        }
    }

    public void sumarStock(int suma) {
        this.stock = this.stock + suma;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio() {
        return this.precio;
    }

    public int getStock() {
        return this.stock;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public int getStockCritico() {
        return this.stockCritico;
    }

    public void setStockCritico(int stockCritico) {
        this.stockCritico = stockCritico;
    }

    //Imprimir
    public String toString() {
        String s = "";
        s += " Nombre = " + this.nombre;
        s += " , Codigo = " + this.codigo;
        s += " , Stock = " + this.stock;
        s += " , Precio = " + this.precio;
        return s;
    }
}
