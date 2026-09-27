package com.paygo.riesgo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "analisis")
public class Analisis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idRecarga;

    @Column(nullable = false)
    private Long idTarjeta;

    @Column(nullable = false)
    private Double saldoDisponible;

    @Column(nullable = false)
    private Double montoRecarga;

    @Column(nullable = false)
    private LocalDate fechaRecarga;

    @Column(nullable = false)
    private String situacion;

    public Analisis() {
    }

    public Analisis(Long idRecarga, Long idTarjeta, Double saldoDisponible, Double montoRecarga, LocalDate fechaRecarga, String situacion) {
        this.idRecarga = idRecarga;
        this.idTarjeta = idTarjeta;
        this.saldoDisponible = saldoDisponible;
        this.montoRecarga = montoRecarga;
        this.fechaRecarga = fechaRecarga;
        this.situacion = situacion;
    }

    public Long getId() {
        return id;
    }

    public Long getIdRecarga() {
        return idRecarga;
    }

    public Long getIdTarjeta() {
        return idTarjeta;
    }

    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    public Double getMontoRecarga() {
        return montoRecarga;
    }

    public LocalDate getFechaRecarga() {
        return fechaRecarga;
    }

    public String getSituacion() {
        return situacion;
    }
}
