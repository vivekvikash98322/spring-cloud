package com.ecom.inventoryservice.entity;

import com.ecom.inventoryservice.config.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("Inventory")
@Data
public class Inventory {

    @MongoId(value = FieldType.OBJECT_ID)
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;

    private String name;

    private String sku;

    @Field("selling_price")
    private String sellingPrice;

    @Field("original_price")
    private String orignalPrice;

    private String currency;

    private String availability;

    private String color;

    private String category;
}
