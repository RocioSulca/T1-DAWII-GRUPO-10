package com.curso.front;

import java.time.LocalDate;

public class Recarga {

    private Long idRecarga;
    private Long idTarjeta;
    private Double saldoDisponible;
    private Double montoRecarga;
    private LocalDate fechaRecarga;

    public Recarga() {
    }

    public Recarga(Long idRecarga, Long idTarjeta, Double saldoDisponible, Double montoRecarga, LocalDate fechaRecarga) {
        this.idRecarga = idRecarga;
        this.idTarjeta = idTarjeta;
        this.saldoDisponible = saldoDisponible;
        this.montoRecarga = montoRecarga;
        this.fechaRecarga = fechaRecarga;
    }

    public Long getIdRecarga() {
        return idRecarga;
    }

    public void setIdRecarga(Long idRecarga) {
        this.idRecarga = idRecarga;
    }

    public Long getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(Double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public Double getMontoRecarga() {
        return montoRecarga;
    }

    public void setMontoRecarga(Double montoRecarga) {
        this.montoRecarga = montoRecarga;
    }

    public LocalDate getFechaRecarga() {
        return fechaRecarga;
    }

    public void setFechaRecarga(LocalDate fechaRecarga) {
        this.fechaRecarga = fechaRecarga;
    }
}
