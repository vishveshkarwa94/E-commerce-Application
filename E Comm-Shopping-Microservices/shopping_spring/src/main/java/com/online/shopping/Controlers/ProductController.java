package com.online.shopping.Controlers;
import com.online.shopping.Product.Categories.CategoryService;
import com.online.shopping.Product.Categories.category;
import com.online.shopping.Product.Product;
import com.online.shopping.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/search-product-name/{name}/{page}/{offset}")
    public List<Product> searchName(@PathVariable String name,@PathVariable int page,@PathVariable int offset){
        return productService.searchByName(name,page,offset);
    }

    @GetMapping("/search-product-category/{category}/{page}/{offset}")
    public List<Product> searchCategory(@PathVariable int category,@PathVariable int page,@PathVariable int offset){
        return productService.searchByCategory(category,page,offset);
    }

    @GetMapping("/get-root-categories")
    public List<category> getRootCategories(){
        return categoryService.getInitialCategories();
    }

    @GetMapping("/get-sub-categories/{id}")
    public List<category> getSubCategory(@PathVariable int id){
        return categoryService.getSubCategories(id);
    }


}
