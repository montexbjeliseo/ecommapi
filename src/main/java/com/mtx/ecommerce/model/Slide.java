package com.mtx.ecommerce.model;

import com.mtx.ecommerce.util.Constants.Patterns;
import com.mtx.ecommerce.util.Constants.Tables;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Tables.SLIDES)
@Getter
@Setter
@NoArgsConstructor
public class Slide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alt;

    private String image;

    private String link;
}
