package com.mtx.ecommerce.service.impl;

import com.mtx.ecommerce.service.IEmailService;
import static com.mtx.ecommerce.util.Constants.Emailer.HTML_TYPE;
import static com.mtx.ecommerce.util.Constants.Emailer.MAIL_SEND;
import static com.mtx.ecommerce.util.Constants.Emailer.WELCOME_SUBJECT;
import static com.mtx.ecommerce.util.Constants.Emailer.WELCOME_TEMPLATE_PATH;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private SendGrid sendGridClient;

    @Autowired
    private String sendGridEmail;

    @Override
    public Response sendWelcome(String to) throws IOException {
        return sendEmail(to, WELCOME_SUBJECT, new Content(HTML_TYPE, readStringFrom(WELCOME_TEMPLATE_PATH)));
    }

    private Response sendEmail(String to, String subject, Content content) throws IOException {
        Mail mail = new Mail(new Email(sendGridEmail), subject, new Email(to), content);
        mail.setReplyTo(new Email(sendGridEmail));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint(MAIL_SEND);
            request.setBody(mail.build());
            return sendGridClient.api(request);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    private String readStringFrom(String filename) throws IOException {
        StringBuilder builder = new StringBuilder();
        String str;
        File htmlFile = new File(filename);
        BufferedReader in = new BufferedReader(new FileReader(htmlFile));
        while ((str = in.readLine()) != null) {
            builder.append(str);
        }
        in.close();
        return builder.toString();
    }
}
