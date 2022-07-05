package com.formacionbackend.backend.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.formacionbackend.backend.model.Categoria;
import com.formacionbackend.backend.model.Producto;
import com.formacionbackend.backend.repository.productoRepository;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

class productoServiceTest {
    @Mock
    private productoRepository proRepository;

    @InjectMocks
    private productoService proService;

    //private Optional<Producto> pro;
    
    private Producto test;
    
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        test = new Producto();
        test.setPro_despro("test");
        test.setPro_iddpro(1);
        test.setPro_despro("test");
        test.setPro_prepro("100");
    }
    
    @Test
    void getAll() {
    	when(proRepository.findAll()).thenReturn(Arrays.asList(test));
        assertNotNull(proService.getAll());
    }

    @Test
    void getOne() {
    	when(proRepository.findById(1)).thenReturn(Optional.of(test));
        assertNotNull(proService.getOne(1));
    }

    @Test
    void post() {
    	when(proRepository.save(test)).thenReturn(test);
    	assertEquals(proService.post(test), true);
    }

    @Test
    void patch() throws JSONException {
    	when(proRepository.save(test)).thenReturn(test);
    	when(proRepository.findById(1)).thenReturn(Optional.of(test));
    	String json = "{\"field\": \"nombre\", \"value\": \"nombre\"}";
    	JSONObject data = new JSONObject(json);
    	assertEquals(proService.patch(data, 1), true);
    }

    @Test
    void delete() {
    	when(proRepository.findById(3)).thenReturn(Optional.of(test));
    	proService.delete(3);
    	verify(proRepository, times(1)).deleteById(3);
    	assertEquals(proService.delete(3), true);
    }
}