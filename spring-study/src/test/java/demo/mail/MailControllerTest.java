package demo.mail;

import demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
//指定SpringBoot工程的Application启动类
//支持web项目
//@WebAppConfiguration
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MailControllerTest {

    @Autowired
    private MailUtil mailUtil;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;

    @Test
    public void testmail() throws Exception {
        MailBean mailBean = new MailBean();
        mailBean.setSubject("你好");

        List<String> recipients = new ArrayList<>();
        recipients.add("2333@163.com");
        mailBean.setRecipients(recipients);

        MailContent content = new MailContent();
        content.setContent("这特么的是什么。");
        content.setDate("123");
        content.setSubject("123");
        mailBean.setContent(content);
        mailUtil.send(mailBean);
    }

    @Test
    public void test1() throws Exception {

        testRestTemplate.getForObject("/mail/send", String.class);

    }

}