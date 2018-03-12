package demo.mail;

import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Override
    public String testMail() {
        System.out.println("this is testMail.");
        return "testMail";
    }

    @Override
    public String sendMail() {
        System.out.println("this is sendMail.");
        return "sendMail";
    }
}
