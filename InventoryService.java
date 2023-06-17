package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.entity.Inventory;


@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getInventory(){
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryById(String id){
        return inventoryRepository.findById(id);
    }

    public Inventory addInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(String id){
        inventoryRepository.deleteById(id);
    }

    public Optional<Inventory> updateInventory(Inventory inventory, String id) {
        Optional<Inventory> existingInventory = this.getInventoryById(id );
        if(existingInventory.isPresent()) {
            existingInventory.get().setProname(inventory.getProname());
            existingInventory.get().setQuantity(inventory.getQuantity());
            inventoryRepository.save(existingInventory.get());
            return existingInventory;
        }
        return existingInventory;
    }
}
