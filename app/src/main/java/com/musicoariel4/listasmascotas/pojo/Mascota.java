package com.musicoariel4.listasmascotas.pojo;

public class Mascota {
    private String id;
    private String  nombreCompleto;
    private String urlFoto;
    private  int likes = 0;

    public Mascota(String urlFoto, String nombreCompleto,int likes ) {
        this.nombreCompleto = nombreCompleto;
        this.urlFoto=urlFoto;
        this.likes = likes;
    }

    public Mascota() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
