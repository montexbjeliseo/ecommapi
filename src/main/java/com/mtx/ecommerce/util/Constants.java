package com.mtx.ecommerce.util;

public class Constants {

    public static abstract class Roles {

        public static final String ADMIN = "ADMIN";
        public static final String USER = "USER";
        public static final String[] ALL = {ADMIN, USER};
        public static final String ADMIN_DESCRIPTION = "Can access all endpoint and modify any resource";
        public static final String USER_DESCRIPTION = "Can access all endpoint allowed for users and modify any owned resource";
    }

    public static abstract class Endpoints {

        public static final String ROOT = "/api";
        public static final String AUTH = ROOT + "/auth";
        public static final String REGISTER = "/register";
        public static final String REGISTER_PATH = AUTH + REGISTER;
    }

    public static abstract class Tables {

        public static final String USERS = "users";
        public static final String ROLES = "roles";
        public static final String USERS_ROLES = USERS + "_" + ROLES;
        public static final String USER_ID = "user_id";
        public static final String ROLE_ID = "role_id";
    }
    
    public static abstract class DefaultData {
        public static final String ADMIN_EMAIL = "admin@myecommerce.com";
        public static final String USER_EMAIL = "user@myecommerce.com";
    }

    public static abstract class Messages {

        public static abstract class AuthMessages {

            public static final String AlreadyExistsEmail = "Already exists email";
        }
    }

    public static abstract class Patterns {
        public static final String FIRSTNAME_PATTERN = "^[a-zA-Z][ a-zA-Z]*$";
        public static final String LASTNAME_PATTERN = "^[a-zA-Z][ a-zA-Z]*$";
        public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}:;',?/*~$^+=<>]).{8,20}$";
    }
}
