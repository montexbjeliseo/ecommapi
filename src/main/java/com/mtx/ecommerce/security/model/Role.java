package com.mtx.ecommerce.security.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static com.mtx.ecommerce.util.Constants.Tables.ROLES;
import lombok.NoArgsConstructor;

@Entity
@Table(name = ROLES)
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(nullable = false)
    //@NotNull(message = "Name may not be null")
    private String name;

    private String description;
    
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date creationDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastUpdate;

    @ManyToMany(mappedBy = ROLES, fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

}
