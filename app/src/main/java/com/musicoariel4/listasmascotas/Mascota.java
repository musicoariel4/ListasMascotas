package com.musicoariel4.listasmascotas;

public class Mascota {

    private int foto;
    private String  nombre;
    private String contador;

    public Mascota(int foto, String nombre, String contador) {
        this.foto = foto;
        this.nombre = nombre;
        this.contador = contador;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContador() {
        return contador;
    }

    public void setContador(String contador) {
        this.contador = contador;
    }
}
