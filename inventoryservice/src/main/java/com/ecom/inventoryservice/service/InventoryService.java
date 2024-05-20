package com.ecom.inventoryservice.service;


import com.ecom.inventoryservice.entity.Inventory;
import com.ecom.inventoryservice.repository.InventoryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;


    public List<Inventory> getAllInStockInventory(List<ObjectId> inventoryIds){
        return inventoryRepository.findAllByIdAndAvailability(inventoryIds, "INSTOCK");
    }


}
