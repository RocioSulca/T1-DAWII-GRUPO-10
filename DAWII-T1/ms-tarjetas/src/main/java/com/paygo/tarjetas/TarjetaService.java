package com.paygo.tarjetas;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TarjetaService {

    private final Map<Long, Tarjeta> tarjetas = new ConcurrentHashMap<>();

    public TarjetaService() {
        tarjetas.put(1L, new Tarjeta(1L, "Ana Sulca", 1500.0, 1200.0));
        tarjetas.put(2L, new Tarjeta(2L, "Luis Sulca", 2000.0, 2000.0));
        tarjetas.put(3L, new Tarjeta(3L, "Maria Sulca", 1000.0, 700.0));
    }

    public List<Tarjeta> listar() {
        return new ArrayList<>(tarjetas.values());
    }

    public Tarjeta buscarPorId(Long id) {
        return tarjetas.get(id);
    }

    public Tarjeta registrar(Tarjeta tarjeta) {
        if (tarjeta.getSaldoDisponible() == null) {
            tarjeta.setSaldoDisponible(tarjeta.getSaldoAsignado());
        }
        tarjetas.put(tarjeta.getIdTarjeta(), tarjeta);
        return tarjeta;
    }
}
