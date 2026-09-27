package com.curso.front;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RecargaServicio {

    private final Map<Long, Recarga> recargas = new ConcurrentHashMap<>();

    public List<Recarga> listar() {
        return new ArrayList<>(recargas.values());
    }

    public Recarga registrar(Recarga recarga) {
        if (recarga.getFechaRecarga() == null) {
            recarga.setFechaRecarga(LocalDate.now());
        }
        recargas.put(recarga.getIdRecarga(), recarga);
        return recarga;
    }
}
