package com.curso.front;

public class TarjetaResponse {
    private Long idTarjeta;
    private String nomTitular;
    private Double saldoAsignado;
    private Double saldoDisponible;

    public Long getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getNomTitular() {
        return nomTitular;
    }

    public void setNomTitular(String nomTitular) {
        this.nomTitular = nomTitular;
    }

    public Double getSaldoAsignado() {
        return saldoAsignado;
    }

    public void setSaldoAsignado(Double saldoAsignado) {
        this.saldoAsignado = saldoAsignado;
    }

    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(Double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
}
