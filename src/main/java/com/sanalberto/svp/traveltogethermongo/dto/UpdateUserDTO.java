package com.sanalberto.svp.traveltogethermongo.dto;

public class UpdateUserDTO {
    String nombre;
    String alias;
    String correo;
    String tabaco;
    String mascota;

    public UpdateUserDTO() {
    }

    public UpdateUserDTO(String nombre, String alias, String correo, String tabaco, String mascota) {
        this.nombre = nombre;
        this.alias = alias;
        this.correo = correo;
        this.tabaco = tabaco;
        this.mascota = mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void getAlias() {
        return alias;
    }
    public String setAlias(String alias) {
        this.alias = alias;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTabaco() {
        return tabaco;
    }

    public void setTabaco(String tabaco) {
        this.tabaco = tabaco;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }
}
