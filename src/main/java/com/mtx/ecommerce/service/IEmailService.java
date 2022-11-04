package com.mtx.ecommerce.service;

import com.sendgrid.Response;
import java.io.IOException;

public interface IEmailService {
    Response sendWelcome(String to) throws IOException ;
}
