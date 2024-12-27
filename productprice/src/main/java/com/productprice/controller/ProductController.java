package com.productprice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.productprice.entity.Product;
import com.productprice.repository.ProductRepository;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v3/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getAll")
	public List<Product> getAllProductList( Product product) {
		return productRepository.findAll();
	}
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@GetMapping("/{id}/product")
	public ResponseEntity<Object> getOrderWithPrice(@PathVariable long id){
		
		return productRepository.findById(id)
				.map(product ->{
					String productURL ="http://localhost:8282/api/v3/order" + product.getOrderId();
					Object orderObject = restTemplate.getForObject(productURL, Object.class);
				return ResponseEntity.ok(orderObject);
					}).orElse(ResponseEntity.notFound().build());
		}
	
	
}
