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
        public static final String LOGIN = "/login";
        public static final String LOGIN_PATH = AUTH + LOGIN;
        public static final String ME = "/me";
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
    }

    public static abstract class Filter {

        public static final String AUTHORIZATION = "Authorization";
        public static final String BEARER = "Bearer ";
    }

    public static abstract class Emailer {

        public static final String TEMPLATE_PATH = "src/main/resources/templates/";
        public static final String MAIL_SEND = "mail/send";
        public static final String HTML_TYPE = "text/html";
        public static final String WELCOME_SUBJECT = "Bienvenido a Ecommapi";
        public static final String WELCOME_TEMPLATE_PATH = TEMPLATE_PATH + "welcome.html";
    }
}
