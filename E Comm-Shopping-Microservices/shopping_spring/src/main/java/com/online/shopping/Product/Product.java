package com.online.shopping.Product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.online.shopping.AttributeConverter.JsonToMapConverter.ImageStringConverter;
import static com.online.shopping.AttributeConverter.JsonToMapConverter.productSpecificationStringConverter;


@Entity(name = "products")
@Table(name = "products")
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
public class Product {

    @Id
    @Column(name = "prod_id")
    @GeneratedValue
    private int prod_id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "product_category")
    private int product_category;

    @Column(name = "retail_price")
    private int retail_price;

    @Column(name = "discounted_price")
    private int discounted_price;


    @Type(type = "json")
    @Column(name = "image",columnDefinition = "json")
    @JsonIgnore
    private String image;

    @JsonProperty("image")
    public List<Object> ImageString() {
        return ImageStringConverter(image);
    }

    @Column(name = "is_FK_Advantage_product")
    private String is_FK_Advantage_product;

    @Column(name = "description")
    private String description;

    @Column(name = "product_rating")
    private String product_rating;

    @Column(name = "brand")
    private  String brand;

    @Type(type = "json")
    @Column(name = "product_specifications",columnDefinition = "json")
    @JsonIgnore
    private String product_specifications;

    @JsonProperty("product_specifications")
    public Map<String, Object> productSpecification() {
        return productSpecificationStringConverter(product_specifications);
    }

    public Product() {}

    public Product(int prod_id, String product_name, int product_category, int retail_price, int discounted_price,
                   String image, String is_FK_Advantage_product, String description, String product_rating, String brand,
                   String product_specifications)
    {
        this.prod_id = prod_id;
        this.product_name = product_name;
        this.product_category = product_category;
        this.retail_price = retail_price;
        this.discounted_price = discounted_price;
        this.image = image;
        this.is_FK_Advantage_product = is_FK_Advantage_product;
        this.description = description;
        this.product_rating = product_rating;
        this.brand = brand;
        this.product_specifications = product_specifications;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_category() {
        return product_category;
    }

    public void setProduct_category(int product_category) {
        this.product_category = product_category;
    }

    public int getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(int retail_price) {
        this.retail_price = retail_price;
    }

    public int getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(int discounted_price) {
        this.discounted_price = discounted_price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIs_FK_Advantage_product() {
        return is_FK_Advantage_product;
    }

    public void setIs_FK_Advantage_product(String is_FK_Advantage_product) {
        this.is_FK_Advantage_product = is_FK_Advantage_product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct_rating() {
        return product_rating;
    }

    public void setProduct_rating(String product_rating) {
        this.product_rating = product_rating;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProduct_specifications() {
        return product_specifications;
    }

    public void setProduct_specifications(String product_specifications) {
        this.product_specifications = product_specifications;
    }
}
