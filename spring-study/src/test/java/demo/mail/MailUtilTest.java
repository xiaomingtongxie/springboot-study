package demo.mail;

import demo.DemoApplication;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class MailUtilTest {

    @Autowired
    private MailUtil mailUtil;

    @Test
    public void send() throws Exception {
        MailBean mailBean = new MailBean();
        List<String> internetAddresses = new ArrayList<>();
        internetAddresses.add("xiaomingtongxie@163.com");
        MailContent mailContent = new MailContent();
        mailContent.setContent("邮件内容为：23333333");

        mailBean.setSubject("测试邮件发送");
        mailBean.setRecipients(internetAddresses);
        mailBean.setContent(mailContent);
        mailUtil.send(mailBean);

    }

}