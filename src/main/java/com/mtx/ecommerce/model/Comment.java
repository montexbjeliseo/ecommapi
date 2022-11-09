package com.mtx.ecommerce.model;

import com.mtx.ecommerce.security.model.User;
import com.mtx.ecommerce.util.Constants.Tables;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = Tables.COMMENTS)
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = Tables.PRODUCT_ID)
    private Product product;

    @CreationTimestamp
    private Timestamp creationDate;

    @UpdateTimestamp
    private Timestamp updateDate;
}
