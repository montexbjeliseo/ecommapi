package com.mtx.ecommerce.model;

import static com.mtx.ecommerce.util.Constants.Tables.CATEGORIES;
import static com.mtx.ecommerce.util.Constants.Tables.CATEGORY_ID;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = CATEGORIES)
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = CATEGORY_ID)
    private Set<Product> products;
}
