package com.mtx.ecommerce.repository;

import com.mtx.ecommerce.model.Brand;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    boolean existsByName(String name);
    Optional<Brand> findByName(String name);
}
