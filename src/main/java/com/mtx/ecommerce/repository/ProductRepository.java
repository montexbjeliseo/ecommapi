package com.mtx.ecommerce.repository;

import com.mtx.ecommerce.model.Product;
import com.mtx.ecommerce.util.Constants.CustomQueries;
import com.mtx.ecommerce.util.Constants.Tables;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);

    Optional<Product> findByName(String name);
    
    @Query(CustomQueries.EXISTS_DUPLICATED_NAME_BRAND_PRODUCT)
    boolean existsNameAndBrandDuplicatedProductCustomQuery(@Param(Tables.NAME) String name, @Param(Tables.BRAND_ID) Long brand_id);
    
    @Query(CustomQueries.EXISTS_DUPLICATED_NAME_BRAND_PRODUCT_ID)
    boolean existsNameAndBrandDuplicatedProductIdCustomQuery(@Param(Tables.ID) Long id, @Param(Tables.NAME) String name, @Param(Tables.BRAND_ID) Long brand_id);

}
