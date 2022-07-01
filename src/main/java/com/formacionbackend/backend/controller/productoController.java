package com.formacionbackend.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbackend.backend.model.Producto;
import com.formacionbackend.backend.service.productoService;

import io.swagger.annotations.Api;

@RestController
public class productoController {
	@Autowired
	private productoService proService;
	
	@GetMapping("/productos")
	public List<Producto> getProductos(){
		List<Producto> lista = new ArrayList<Producto>();
		lista = proService.getAll();
		return lista;
	}
	
	@GetMapping("/productos/{id}")
	public Producto cuentasGetWithID(@PathVariable Integer id){
		return proService.getOne(id);
	}
	
	@PostMapping("/productos")
	public Producto postProductos(@RequestBody Producto prod) {
		proService.post(prod);
		return prod;
	}
	
	@PatchMapping("/productos/{id}")
	public boolean patchProductos(@PathVariable Integer id, @RequestBody String json) {
		JSONObject data = new JSONObject(json);
		return proService.patch(data, id);
	}
	
	@DeleteMapping("/productos/{id}")
	public boolean deleteProductos(@PathVariable Integer id) {
		try {
			if(proService.delete(id)){
				return true;
			} else {
				return false;
			}
		} catch (Exception e)
		{ 
			return false;
		}
	}
}
