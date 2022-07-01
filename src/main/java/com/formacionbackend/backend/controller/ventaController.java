package com.formacionbackend.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.formacionbackend.backend.feignClient.VFClient;
import com.formacionbackend.backend.model.Producto;

@RestController
@RequestMapping("/ventas")
public class ventaController {
	@Autowired
    private VFClient ventasFeignClient;

    @GetMapping("")
    public List<Producto> getP() {
        return ventasFeignClient.getP();
    }
}
