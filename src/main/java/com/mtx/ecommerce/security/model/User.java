package com.mtx.ecommerce.security.model;

import static com.mtx.ecommerce.util.Constants.Tables.ROLE_ID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static com.mtx.ecommerce.util.Constants.Tables.USERS;
import static com.mtx.ecommerce.util.Constants.Tables.USERS_ROLES;
import static com.mtx.ecommerce.util.Constants.Tables.USER_ID;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = USERS)
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String photo;
    @ManyToMany(fetch
            = FetchType.EAGER,
            cascade = CascadeType.PERSIST)

    @JoinTable(name = USERS_ROLES,
            joinColumns = @JoinColumn(name = USER_ID),
            inverseJoinColumns = @JoinColumn(name = ROLE_ID))

    private Set<Role> roles = new HashSet<>();

    
    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return this.email;
    }

}
