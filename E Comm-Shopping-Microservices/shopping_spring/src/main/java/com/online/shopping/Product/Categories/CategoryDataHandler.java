package com.online.shopping.Product.Categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDataHandler extends JpaRepository<category, Integer> {

    @Query("SELECT c FROM category c WHERE c.ParentCatId = 0 ")
    public List<category> getRootCategories();

    @Query("SELECT c FROM category c WHERE c.ParentCatId = ?1")
    public List<category> getChildCategory(int pid);
}
