package com.paygo.tarjetas;

import java.util.Objects;

public class Tarjeta {

    private Long idTarjeta;
    private String nomTitular;
    private Double saldoAsignado;
    private Double saldoDisponible;

    public Tarjeta() {
    }

    public Tarjeta(Long idTarjeta, String nomTitular, Double saldoAsignado, Double saldoDisponible) {
        this.idTarjeta = idTarjeta;
        this.nomTitular = nomTitular;
        this.saldoAsignado = saldoAsignado;
        this.saldoDisponible = saldoDisponible;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarjeta tarjeta = (Tarjeta) o;
        return Objects.equals(idTarjeta, tarjeta.idTarjeta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTarjeta);
    }
}
