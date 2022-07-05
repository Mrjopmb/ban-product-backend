package com.formacionbackend.backend.service;

import com.formacionbackend.backend.model.Categoria;
import com.formacionbackend.backend.model.Producto;
import com.formacionbackend.backend.repository.categoriaRepository;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class categoriaServiceTest {
    @Mock
    private categoriaRepository catRepository;

    @InjectMocks
    private categoriaService catService;

    private Categoria cat;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        cat = new Categoria();
        cat.setCat_iddcat(1);
        cat.setCat_descat("test");
        cat.setCat_nomcat("test");
    }

    @Test
    void getAll() {
    	when(catRepository.findAll()).thenReturn(Arrays.asList(cat));
        assertNotNull(catService.getAll());
    }

    @Test
    void getOne() {
    	when(catRepository.findById(1)).thenReturn(Optional.of(cat));
        assertNotNull(catService.getOne(1));
    }

    @Test
    void post() {
    	when(catRepository.save(cat)).thenReturn(cat);
    	assertEquals(catService.post(cat), true);
    }

    @Test
    void patch() throws JSONException {
    	when(catRepository.save(cat)).thenReturn(cat);
    	when(catRepository.findById(1)).thenReturn(Optional.of(cat));
    	String json = "{\"field\": \"cat_nomcat\", \"value\": \"nombre\"}";
    	JSONObject data = new JSONObject(json);
    	assertEquals(catService.patch(data, 1), true);
    }

    @Test
    void delete() {
    	when(catRepository.findById(3)).thenReturn(Optional.of(cat));
    	catService.delete(3);
    	verify(catRepository, times(1)).deleteById(3);
    	assertEquals(catService.delete(3), true);
    }
}