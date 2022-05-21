package org.sid.ecom.web;

import org.sid.ecom.dtos.ProductDTO;
import org.sid.ecom.entities.Product;
import org.sid.ecom.repositories.ProductRepository;
import org.sid.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductRestController {

    /*@Autowired
    private ProductRepository productRepository;*/


    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<ProductDTO> productList(){
        return productService.listProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable(name = "id") String id){
        return productService.getProduct(id);
    };

    @PostMapping("/products")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
       return productService.save(productDTO);
    };

    @PutMapping("/products/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO,@PathVariable String id){
        productDTO.setId(id);
        return productService.save(productDTO);
    };

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id){
         productService.deleteProduct(id);
    };
}
