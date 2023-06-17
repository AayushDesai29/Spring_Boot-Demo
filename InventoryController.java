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

import com.example.demo.entity.Inventory;
import com.example.demo.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor

public class InventoryController {
  private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<?> getInventory(){
        return  ResponseEntity.ok(inventoryService.getInventory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInventoryById(@PathVariable String id) {
        return ResponseEntity.ok(inventoryService.getInventoryById(id));
    }

    @PostMapping
    public ResponseEntity<?> addInventory(@RequestBody Inventory inventory){
        return ResponseEntity.ok(inventoryService.addInventory(inventory));  
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCustomer(@PathVariable String id){
    inventoryService.deleteInventory(id);
    return ResponseEntity.ok("Inventory Deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>updateCustomer(@RequestBody Inventory inventory, @PathVariable String id) {
        return ResponseEntity.ok(inventoryService.updateInventory(inventory, id));
    }
}
    
