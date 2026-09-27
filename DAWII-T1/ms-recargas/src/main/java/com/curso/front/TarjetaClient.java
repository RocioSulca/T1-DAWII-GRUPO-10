package com.curso.front;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-tarjetas", url = "http://localhost:8301")
public interface TarjetaClient {

    @GetMapping("/tarjetas/{id}")
    TarjetaResponse getTarjeta(@PathVariable Long id);
}
