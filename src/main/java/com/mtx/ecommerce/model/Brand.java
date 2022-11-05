package com.mtx.ecommerce.model;

import static com.mtx.ecommerce.util.Constants.Tables.BRANDS;
import static com.mtx.ecommerce.util.Constants.Tables.BRAND_ID;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = BRANDS)
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String description;
    @OneToMany
    @JoinColumn(name = BRAND_ID)
    private Set<Product> products;
}
