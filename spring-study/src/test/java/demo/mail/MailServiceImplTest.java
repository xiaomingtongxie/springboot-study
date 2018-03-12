package demo.mail;

import org.junit.Test;
import demo.DemoApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
//指定SpringBoot工程的Application启动类
//支持web项目
@WebAppConfiguration
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MailServiceImplTest {

    @Autowired
    private MailServiceImpl mailServiceImpl;


    @Test
    public void testMail() throws Exception {
       String result =  mailServiceImpl.testMail();
       assertEquals("testMail",result);
    }

    @Test
    public void sendMail() throws Exception {
        String result = mailServiceImpl.sendMail();
        assertEquals("sendMail",result);
    }

}