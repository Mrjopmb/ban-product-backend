package com.formacionbackend.backend.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionbackend.backend.model.Producto;
import com.formacionbackend.backend.repository.productoRepository;

@Service
public class productoService {
	
	@Autowired
	private productoRepository proRepository;
	
	//GET (Consultar Todos)
	public List<Producto> getAll() {
		return proRepository.findAll();
	}
	
	//GET (Consultar Una)
	public Producto getOne(Integer id) {
		return proRepository.findById(id).orElseGet(null);
	}
		
	//POST (Agregar Uno)
	public boolean post(Producto pro) {
		try {
			proRepository.save(pro);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	//PATCH (Actualizar Uno) JSON {"field": "value", "value": "value"}
	public boolean patch(JSONObject data, Integer id) {
		Producto proTMP = new Producto();
		Producto proFinal = new Producto();
		String field = data.optString("field");
		String value = data.optString("value");
		switch(field) {
			case "nombre":
				System.out.println("SIMON");
				proTMP = proRepository.findById(id).orElse(null);
				if(proTMP == null) {
					return false;
				} else {
					proFinal.setPro_iddpro(id);
					proFinal.setPro_nompro(value);
					proFinal.setPro_despro(proTMP.getPro_despro());
					proRepository.save(proFinal);
				}
				return true;
			case "descripcion":
				proTMP = proRepository.findById(id).orElse(null);
				if(proTMP == null) {
					return false;
				} else {
					proFinal.setPro_iddpro(id);
					proFinal.setPro_nompro(proTMP.getPro_nompro());
					proFinal.setPro_despro(value);
					proRepository.save(proFinal);
				}
				return true;
			default:
				return false;
		}
	}
	
	//DELETE (Eliminar Uno)
	public boolean delete(Integer id) {
		try {
			proRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
