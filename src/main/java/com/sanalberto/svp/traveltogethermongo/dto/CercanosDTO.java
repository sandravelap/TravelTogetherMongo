package com.sanalberto.svp.traveltogethermongo.dto;

import jakarta.ws.rs.QueryParam;

public class CercanosDTO {
    //Mapeamos cada parámetro que pasamos a una variable del DTO

    @QueryParam("lng")
    private Double longitude;
    @QueryParam("lat")
    private Double latitude;
    @QueryParam("radio")
    private double radio;
// Constructores

    public CercanosDTO() {
    }

    public CercanosDTO(Double longitude, Double latitude, int radio) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.radio = radio;
    }
// Getters y setters

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}
