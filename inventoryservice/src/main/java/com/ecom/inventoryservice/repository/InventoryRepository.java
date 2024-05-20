package com.ecom.inventoryservice.repository;

import com.ecom.inventoryservice.entity.Inventory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository  extends MongoRepository<Inventory, ObjectId> {

    List<Inventory> findAllByIdAndAvailability(List<ObjectId> inventoryId, String avalability);
}
