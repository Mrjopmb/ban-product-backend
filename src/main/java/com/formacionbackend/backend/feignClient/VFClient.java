package com.formacionbackend.backend.feignClient;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.formacionbackend.backend.model.Producto;

@FeignClient(name = "productos", url = "http://localhost:8080/productos")
public interface VFClient {
    @GetMapping()
    List<Producto> getP();
}

