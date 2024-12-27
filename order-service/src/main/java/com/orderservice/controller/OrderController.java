package com.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderservice.entity.Order;
import com.orderservice.repository.OrderRepository;

@RestController
@RequestMapping("api/v2/order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id){
		return orderRepo.findById(id)
			    .map(order -> ResponseEntity.ok().body(order))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/createorder")
	public Order createOrder(@RequestBody Order order) {
		return orderRepo.save(order);
	}
	
	
	//Fetch the user information from ID
	
	  @GetMapping("/{id}/user") 
	  public ResponseEntity<Object> getOrderWithUser(@PathVariable long id){
		  return orderRepo.findById(id)
			  .map(order ->{ 
				  String userServiceURL ="http://localhost:8181/api/v1/user/" +order.getUserId(); 
				  Object user = restTemplate.getForObject(userServiceURL, Object.class); 
				  return ResponseEntity.ok(user);
	  }).orElse(ResponseEntity.notFound().build()); }
	 
}
