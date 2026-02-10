package Modelo;

import MODELO.Gama;

public class celulares {
    private int id;
    private int id_marca;
    private String modelo, sistema_operativo;
    private Gama gama;
    private int stock;
    private int precio;

    public celulares(int id, int id_marca, String modelo, String sistema_operativo, Gama gama, int stock, int precio) {
        this.id = id;
        this.id_marca = id_marca;
        this.modelo = modelo;
        this.sistema_operativo = sistema_operativo;
        this.gama = gama;
        this.stock = stock;
        this.precio = precio;
    }

    public celulares() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistema_operativo() {
        return sistema_operativo;
    }

    public void setSistema_operativo(String sistema_operativo) {
        this.sistema_operativo = sistema_operativo;
    }

    public Gama getGama() {
        return gama;
    }

    public void setGama(Gama gama) {
        this.gama = gama;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return"""
        Id:          %s
        Marca:       %s
        Modelo:      %s
        SO:          %s
        Gama:        %s
        Stock:       %s
        Precio:      %s
        """.formatted(id, id_marca,modelo,sistema_operativo,gama,stock,precio);
    }
}
