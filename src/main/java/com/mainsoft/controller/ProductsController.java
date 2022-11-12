package com.mainsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainsoft.model.Products;
import com.mainsoft.service.ProductsService;
import com.mainsoft.utils.Response;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin
public class ProductsController {

	@Autowired
	ProductsService service;
	
	
    /**
     * Metodo para consultar los productos
     *
     * @param request
     * @return
     */
    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar Productos", notes = "Servicio para consultar los productos")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Consulta realizada con exito")})
    public ResponseEntity<Response> findAll() {
    	Response<List<Products>> response = new Response<List<Products>>();
    	
    	List<Products> listProducts = service.getAllProducts();
    	if(!listProducts.isEmpty()) {
			response.setData(listProducts);
			response.setMessage("Consulta realizada con éxito.");
    	} else {
			response.setData(null);
			response.setMessage("Solicitud no válida");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    	}
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    	
    }
    
    @GetMapping
    private ResponseEntity<Response> test(){
    	Response<List<Products>> response = new Response<List<Products>>();
    	response.setData(null);
    	response.setMessage("Consulta realizada con éxito.");
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
