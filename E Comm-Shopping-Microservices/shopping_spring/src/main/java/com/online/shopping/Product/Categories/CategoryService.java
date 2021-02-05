package com.online.shopping.Product.Categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDataHandler categoryDataHandler;

    public List<category> getInitialCategories(){
        return categoryDataHandler.getRootCategories();
    }

    public List<category> getSubCategories(int id){
        return categoryDataHandler.getChildCategory(id);
    }

}
