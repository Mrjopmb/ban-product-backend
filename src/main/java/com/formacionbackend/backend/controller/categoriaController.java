package com.formacionbackend.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbackend.backend.model.Categoria;
import com.formacionbackend.backend.service.categoriaService;

@RestController
public class categoriaController {
	@Autowired
	private categoriaService catService;
	
	@GetMapping("/categorias")
	public List<Categoria> get(){
		return catService.getAll();
	}
	
	@GetMapping("/categorias/{id}")
	public Categoria getAll(@PathVariable Integer id){
		return catService.getOne(id);
	}
	
	@PostMapping("/categorias")
	public Categoria post(@RequestBody Categoria cat) {
		catService.post(cat);
		return cat;
	}
	
	@PatchMapping("/categorias/{id}")
	public boolean patch(@PathVariable Integer id, @RequestBody String json) {
		JSONObject data = new JSONObject(json);
		return catService.patch(data, id);
	}
	
	@DeleteMapping("/categorias/{id}")
	public boolean delete(@PathVariable Integer id) {
		try {
			if(catService.delete(id)){
				
			}
			return true;
		} catch (Exception e)
		{ 
			return false;
		}
	}
	
}
