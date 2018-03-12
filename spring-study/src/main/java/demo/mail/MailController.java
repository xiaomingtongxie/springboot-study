package demo.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping(value = "/mail")
public class MailController {

    @Autowired
    private MailUtil mailUtil;

    @GetMapping(value = "/send")
    public String testmail(){

        MailBean mailBean = new MailBean();
        mailBean.setSubject("你好");

        List<String> recipients = new ArrayList<>();
        recipients.add("17080697@cnsuning.com");
        mailBean.setRecipients(recipients);

        MailContent content = new MailContent();
        content.setContent("夏部长 你好，我司正式录取你了。");
        content.setDate("123");
        content.setSubject("123");
        mailBean.setContent(content);
        mailUtil.send(mailBean);
        return "success.";
    }


    @GetMapping(value = "/host")
    public void test(){
        Properties props = new Properties();
        //设置服务器，gmail对应的端口为587 这里是最简配置 不用设置端口号
        props.put("mail.smtp.host", "smtp.gmail.com");
        //创建一个邮件Session
        Session session = Session.getInstance(props, null);

        try {
            // 创建mime类型邮件
            MimeMessage msg = new MimeMessage(session);
            //设置发件人
            msg.setFrom("xxx@gmail.com");
            //设置收件人
            msg.setRecipients(Message.RecipientType.TO,
                    "xxx@gmail.com");
            //设置邮件主题
            msg.setSubject("JavaMail hello world example");
            //设置发送时间
            msg.setSentDate(new Date());
            //邮件内容
            msg.setText("Hello, world!\n");
            //这里设置对应服务器 的邮箱账号密码就好，比如该例子是gmail
            Transport.send(msg, "xxx@gmail.com", "xxx@gmail.com");
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }
    }
}
