package com.online.shopping.Product.Categories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class category {

    @Id
    @Column(name = "categoryid")
    private int CategoryId;

    @Column(name = "categoryname")
    private String CategoryName;

    @Column(name = "parentcatid")
    private int ParentCatId;

    category(){}

    public category(int categoryId, String categoryName, int parentCatId) {
        CategoryId = categoryId;
        CategoryName = categoryName;
        ParentCatId = parentCatId;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public int getParentCatId() {
        return ParentCatId;
    }

    public void setParentCatId(int parentCatId) {
        ParentCatId = parentCatId;
    }
}
