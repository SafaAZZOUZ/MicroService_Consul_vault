package org.sid.orderservice.services;

import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface InventoryRestClientService {
    @GetMapping(path = "/products/{id}?projection=fullProduct")
    Product productById(@PathVariable Long id);

    @GetMapping(path = "/products?projection=fullProduct")
    PagedModel<Product> productsPage();
}

