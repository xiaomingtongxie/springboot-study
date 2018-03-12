package demo.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Test {

    public static void main(String[] args) {

        //配置文件
        Properties props = new Properties();
        //设置邮箱服务器，有对应的默认端口
        props.put("mail.smtp.host", "my-mail-server");
        //获取一个邮箱session实例
        Session session = Session.getInstance(props, null);

        try {
            //邮件发送工具类参数对象
            MimeMessage msg = new MimeMessage(session);
            //设置发件人信息
            msg.setFrom("me@example.com");
            //设置收件人信息
            msg.setRecipients(Message.RecipientType.TO,
                    "you@example.com");
            //设置邮件主题
            msg.setSubject("JavaMail hello world example");
            //设置邮件时间
            msg.setSentDate(new Date());
            //设置邮件内容
            msg.setText("Hello, world!\n");
            //发送邮件，验证邮箱账号和密码
            Transport.send(msg, "me@example.com", "my-password");
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }
    }
}
