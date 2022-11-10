package com.mtx.ecommerce.util;

import com.mtx.ecommerce.model.Brand;
import com.mtx.ecommerce.model.Category;
import com.mtx.ecommerce.model.Product;
import com.mtx.ecommerce.repository.BrandRepository;
import com.mtx.ecommerce.repository.CategoryRepository;
import com.mtx.ecommerce.repository.ProductRepository;
import com.mtx.ecommerce.security.model.Role;
import com.mtx.ecommerce.security.model.User;
import com.mtx.ecommerce.security.repository.RoleRepository;
import com.mtx.ecommerce.security.repository.UserRepository;
import static com.mtx.ecommerce.util.Constants.DefaultData.A13;
import static com.mtx.ecommerce.util.Constants.DefaultData.A13_DESCRIPTION;
import static com.mtx.ecommerce.util.Constants.DefaultData.A13_IMAGE;
import static com.mtx.ecommerce.util.Constants.DefaultData.ADMIN_EMAIL;
import static com.mtx.ecommerce.util.Constants.DefaultData.APPLE;
import static com.mtx.ecommerce.util.Constants.DefaultData.APPLE_DESCRIPTION;
import static com.mtx.ecommerce.util.Constants.DefaultData.APPLE_LOGO;
import static com.mtx.ecommerce.util.Constants.DefaultData.CATEGORY_1;
import static com.mtx.ecommerce.util.Constants.DefaultData.CATEGORY_2;
import static com.mtx.ecommerce.util.Constants.DefaultData.SAMSUNG;
import static com.mtx.ecommerce.util.Constants.DefaultData.SAMSUNG_DESCRIPTION;
import static com.mtx.ecommerce.util.Constants.DefaultData.SAMSUNG_LOGO;
import static com.mtx.ecommerce.util.Constants.DefaultData.SELLER_EMAIL;
import static com.mtx.ecommerce.util.Constants.DefaultData.USER_EMAIL;
import static com.mtx.ecommerce.util.Constants.Roles.ADMIN;
import static com.mtx.ecommerce.util.Constants.Roles.ADMIN_DESCRIPTION;
import static com.mtx.ecommerce.util.Constants.Roles.SELLER;
import static com.mtx.ecommerce.util.Constants.Roles.SELLER_DESCRIPTION;
import static com.mtx.ecommerce.util.Constants.Roles.USER;
import static com.mtx.ecommerce.util.Constants.Roles.USER_DESCRIPTION;
import java.util.HashSet;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Override
    public void run(String... args) throws Exception {
        try {
            checkRoles();
            checkUsers();
            checkBrands();
            checkCategories();
            checkProducts();
        } catch (Exception ex) {
            System.out.println("Something went wront: " + ex.toString());
        }
    }

    private void checkRoles() {
        if (!roleRepository.existsByName(ADMIN)) {
            Role admin = new Role();
            admin.setName(ADMIN);
            admin.setDescription(ADMIN_DESCRIPTION);
            roleRepository.save(admin);
        }
        if (!roleRepository.existsByName(USER)) {
            Role user = new Role();
            user.setName(USER);
            user.setDescription(USER_DESCRIPTION);
            roleRepository.save(user);
        }
        if (!roleRepository.existsByName(SELLER)) {
            Role user = new Role();
            user.setName(SELLER);
            user.setDescription(SELLER_DESCRIPTION);
            roleRepository.save(user);
        }
    }

    private void checkUsers() {
        if (!userRepository.existsByEmail(ADMIN_EMAIL)) {
            User user = new User();
            user.setFirstName(ADMIN);
            user.setLastName(ADMIN);
            user.setRoles(new HashSet<>());
            user.getRoles().add(roleRepository.findByName(ADMIN).get());
            user.setEmail(ADMIN_EMAIL);
            user.setPassword(bcrypt.encode("Admin@1234"));
            userRepository.save(user);
        }
        if (!userRepository.existsByEmail(USER_EMAIL)) {
            User user = new User();
            user.setFirstName(USER);
            user.setLastName(USER);
            user.setRoles(new HashSet<>());
            user.getRoles().add(roleRepository.findByName(USER).get());
            user.setEmail(USER_EMAIL);
            user.setPassword(bcrypt.encode("User@1234"));
            userRepository.save(user);
        }
        if (!userRepository.existsByEmail(SELLER_EMAIL)) {
            User user = new User();
            user.setFirstName(SELLER);
            user.setLastName(SELLER);
            user.setRoles(new HashSet<>());
            user.getRoles().add(roleRepository.findByName(SELLER).get());
            user.setEmail(SELLER_EMAIL);
            user.setPassword(bcrypt.encode("Seller@1234"));
            userRepository.save(user);
        }
    }

    private void checkBrands() {
        if (!brandRepository.existsByName(APPLE)) {
            Brand brand = new Brand();
            brand.setName(APPLE);
            brand.setDescription(APPLE_DESCRIPTION);
            brand.setImage(APPLE_LOGO);
            brandRepository.save(brand);
        }
        if (!brandRepository.existsByName(SAMSUNG)) {
            Brand brand = new Brand();
            brand.setName(SAMSUNG);
            brand.setDescription(SAMSUNG_DESCRIPTION);
            brand.setImage(SAMSUNG_LOGO);
            brandRepository.save(brand);
        }
    }

    private void checkCategories() {
        if (!categoryRepository.existsByName(CATEGORY_1)) {
            Category category = new Category();
            category.setName(CATEGORY_1);
            category.setDescription(CATEGORY_1);
            categoryRepository.save(category);
        }
        if (!categoryRepository.existsByName(CATEGORY_2)) {
            Category category = new Category();
            category.setName(CATEGORY_2);
            category.setDescription(CATEGORY_2);
            categoryRepository.save(category);
        }
    }

    private void checkProducts() {
        if (!productRepository.existsByName(A13)) {
            Product product = new Product();
            product.setName(A13);
            product.setDescription(A13_DESCRIPTION);
            product.setPrice(59000);
            product.setImage(A13_IMAGE);
            product.setBrand(brandRepository.findByName(SAMSUNG).get());
            product.setCategory(categoryRepository.findByName(CATEGORY_1).get());
            productRepository.save(product);
        }
    }

}
