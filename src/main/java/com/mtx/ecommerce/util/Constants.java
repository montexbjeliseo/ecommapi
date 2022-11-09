package com.mtx.ecommerce.util;

public class Constants {

    public static abstract class Roles {

        public static final String ADMIN = "ADMIN";
        public static final String USER = "USER";
        public static final String SELLER = "SELLER";
        public static final String[] ALL = {ADMIN, USER, SELLER};
        public static final String ADMIN_DESCRIPTION = "Can access all endpoint and modify any resource";
        public static final String USER_DESCRIPTION = "Can access all endpoint allowed for users and modify any owned resource";
        public static final String SELLER_DESCRIPTION = "Can access all endpoint allowed for sellers and modify any owned resource";
    }

    public static abstract class Endpoints {

        public static final String ROOT = "/api";
        public static final String AUTH = ROOT + "/auth";
        public static final String REGISTER = "/register";
        public static final String REGISTER_PATH = AUTH + REGISTER;
        public static final String LOGIN = "/login";
        public static final String LOGIN_PATH = AUTH + LOGIN;
        public static final String ME = "/me";
        public static final String USER = ROOT + "/users";
        public static final String ID = "/{id}";
        public static final String PRODUCT = ROOT + "/products";
        public static final String CATEGORY = ROOT + "/categories";
        public static final String BRAND = ROOT + "/brands";
        public static final String SEARCH = "/search";
        public static final String COMMENT = PRODUCT + "/{product_id}/comments";
    }

    public static abstract class Tables {

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String USERS = "users";
        public static final String ROLES = "roles";
        public static final String USERS_ROLES = USERS + "_" + ROLES;
        public static final String USER_ID = "user_id";
        public static final String ROLE_ID = "role_id";
        public static final String PRODUCTS = "products";
        public static final String PRODUCT_ID = "product_id";
        public static final String PRODUCT_IMAGES = "product_images";
        public static final String CATEGORIES = "categories";
        public static final String CATEGORY_ID = "category_id";
        public static final String BRANDS = "brands";
        public static final String BRAND_ID = "brand_id";
        public static final String COMMENTS = "comments";
    }

    public static abstract class DefaultData {

        public static final String ADMIN_EMAIL = "admin@myecommerce.com";
        public static final String USER_EMAIL = "user@myecommerce.com";
        public static final String SELLER_EMAIL = "seller@myecommerce.com";
    }

    public static abstract class Messages {

        public static abstract class AuthMessages {

            public static final String ALREADY_EXISTS_EMAIL = "Already exists email";
            public static final String USERNAME_NOT_FOUND = "Username not found";
        }

        public static abstract class Validations {

            public static final String FIRSTNAME_MESSAGE = "Firstname cannot contain numbers or special characters";
            public static final String LASTNAME_MESSAGE = "Lastname cannot contain numbers or special characters";
            public static final String PASSWORD_MESSAGE = "Password must be between 8 and 20 characters and must contain at least one uppercase letter, one special character and one number";
            public static final String EMAIL_MESSAGE = "Email is required";

        }
    }

    public static abstract class Patterns {

        public static final String FIRSTNAME_PATTERN = "^[a-zA-Z][ a-zA-Z]*$";
        public static final String LASTNAME_PATTERN = "^[a-zA-Z][ a-zA-Z]*$";
        public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}:;',?/*~$^+=<>]).{8,20}$";
        public static final String NAME_PATTERN = "^[a-zA-Z][ a-zA-Z0-9\\+\"]*$";
        public static final String DESCRIPTION_PATTERN = "[ a-zA-Z0-9\\+\\*\\?\\¿\\¡\\!\\.\\\"\\:\\-\\*\\@\\\\\\/\\%\\=\\#\\$\\|\\<\\>\\(\\)\\[\\]\\^\\,\\&\\']*$";
        public static final String COMMENT_PATTERN = "[ a-zA-Z0-9\\+\\*\\?\\¿\\¡\\!\\.\\\"\\:\\-\\*\\@\\\\\\/\\%\\=\\#\\$\\|\\<\\>\\(\\)\\[\\]\\^\\,\\&\\']*$";
    }

    public static abstract class Filter {

        public static final String AUTHORIZATION = "Authorization";
        public static final String BEARER = "Bearer ";
        public static final long JWT_TOKEN_VALIDITY = 1000 * 60 * 60 * (long) 8; // 8 Horas
    }

    public static abstract class Emailer {

        public static final String TEMPLATE_PATH = "src/main/resources/templates/";
        public static final String MAIL_SEND = "mail/send";
        public static final String HTML_TYPE = "text/html";
        public static final String WELCOME_SUBJECT = "Bienvenido a Ecommapi";
        public static final String WELCOME_TEMPLATE_PATH = TEMPLATE_PATH + "welcome.html";
    }

    public static abstract class CustomQueries {

        public static final String Q = "q";
        public static final String PAGE = "page";
        public static final String PAGE_SIZE = "page_size";
        public static final int DEFAULT_PAGE = 0;
        public static final int DEFAULT_PAGE_SIZE = 10;

        public static final String EXISTS_DUPLICATED_NAME_BRAND_PRODUCT = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM Product p WHERE (p.name = :name AND p.brand.id = :brand_id)";
        public static final String EXISTS_DUPLICATED_NAME_BRAND_PRODUCT_ID = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM Product p WHERE NOT(p.id = :id) AND (p.name = :name AND p.brand.id = :brand_id)";
        public static final String FIN_ALL_PRODUCT_WITH_PARAMS = "SELECT p FROM Product p WHERE (p.name LIKE %:q%) OR (p.description LIKE %:q%) ORDER BY p.name";
    }
}
