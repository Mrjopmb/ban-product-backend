package com.formacionbackend.backend.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.formacionbackend.backend.model.Categoria;
import com.formacionbackend.backend.repository.categoriaRepository;


@Service
public class categoriaService {
	@Autowired
	private categoriaRepository catRepository;
	
	//GET (Consultar Todas)
	public ResponseEntity<List<Categoria>> getAll() {
		List<Categoria> list = catRepository.findAll();
		return ResponseEntity.ok(list);
	}
	
	//GET (Consultar Una)
	public Categoria getOne(Integer id) {
		return catRepository.findById(id).orElse(null);
	}
	
	//POST (Agregar Una)
	public boolean post(Categoria cat) {
		try {
			catRepository.save(cat);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	//PATCH (Actualizar Una) JSON {"field": "value", "value": "value"}
	public boolean patch(JSONObject data, Integer id) {
		Categoria catTMP = new Categoria();
		Categoria catFinal = new Categoria();
		String field = data.optString("field");
		String value = data.optString("value");
		switch(field) {
			case "cat_nomcat":
				catTMP = catRepository.findById(id).orElse(null);
				if(catTMP == null) {
					return false;
				} else {
					catFinal.setCat_iddcat(id);
					catFinal.setCat_nomcat(value);
					catFinal.setCat_descat(catTMP.getCat_descat());
					catRepository.save(catFinal);
				}
				return true;
			case "cat_descat":
				catTMP = catRepository.findById(id).orElse(null);
				if(catTMP == null) {
					return false;
				} else {
					catFinal.setCat_iddcat(id);
					catFinal.setCat_nomcat(catTMP.getCat_nomcat());
					catFinal.setCat_descat(value);
					catRepository.save(catFinal);
				}
				return true;
			default:
				return false;
		}
	}
	
	//DELETE (Eliminar Una)
	public boolean delete(Integer id) {
		try {
			catRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
