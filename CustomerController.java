package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CustomerService;

import lombok.RequiredArgsConstructor;
import com.example.demo.entity.Customer;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getCustomers(){
        return  ResponseEntity.ok(customerService.getCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.addCustomer(customer));  
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCustomer(@PathVariable String id){
    customerService.deleteCustomer(id);
    return ResponseEntity.ok("Customer Deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>updateCustomer(@RequestBody Customer customer , @PathVariable String id) {
        return ResponseEntity.ok(customerService.updateCustomer(customer, id));
    }
}
    