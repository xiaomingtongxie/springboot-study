package demo.mail;

import org.springframework.stereotype.Service;

@Service
public interface MailService {


    String testMail();

    String sendMail();

}
