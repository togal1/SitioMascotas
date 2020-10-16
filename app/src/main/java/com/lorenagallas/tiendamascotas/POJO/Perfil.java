package com.lorenagallas.tiendamascotas.POJO;

public class Perfil {
    private int fotoPerfil;
    private int like;

    public Perfil(int fotoPerfil, int like) {
        this.fotoPerfil = fotoPerfil;
        this.like = like;
    }

    public int getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(int fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}

