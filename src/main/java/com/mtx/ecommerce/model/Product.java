package com.mtx.ecommerce.model;

import static com.mtx.ecommerce.util.Constants.Tables.BRAND_ID;
import static com.mtx.ecommerce.util.Constants.Tables.CATEGORY_ID;
import static com.mtx.ecommerce.util.Constants.Tables.PRODUCTS;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = PRODUCTS)
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String image;
    @ManyToOne
    @JoinColumn(name = BRAND_ID)
    private Brand brand;
    private String description;
    @ManyToOne
    @JoinColumn(name = CATEGORY_ID)
    private Category category;
    private float price;
    @OneToMany
    private Set<Comment> comments;
}
