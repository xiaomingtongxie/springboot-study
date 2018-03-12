package demo.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class MailSend {

    private static final Logger logger = LoggerFactory.getLogger(MailSend.class);

    /**
     * 发送邮件的props 文件
     */
    private static Properties props;
    /**
     * 邮件登录 权限验证
     */
    private static MailAuthenticator authenticator;
    /**
     * 邮件服务器session
     */
    private static Session session;
    /**
     * 发送邮件 工具
     */
    private static Transport transport;
    /**
     * 邮件附件(目前还不支持附件上传的功能）
     */
    private static Multipart multipart;

    /**
     * 初始化
     *
     */
    static {

        // 初始化props
        props = new Properties();
        props.put(MailConstant.MAIL_SMTP_HOST, MailProperties.getValue(MailConstant.MAIL_SMTP_HOST));
        props.put(MailConstant.MAIL_SMTP_PORT, MailProperties.getValue(MailConstant.MAIL_SMTP_PORT));
        props.put(MailConstant.MAIL_SMTP_STARTTLS_ENABLE, MailProperties.getValue(MailConstant.MAIL_SMTP_STARTTLS_ENABLE));
        props.put(MailConstant.MAIL_SMTP_AUTH, MailProperties.getValue(MailConstant.MAIL_SMTP_AUTH));
        props.put(MailConstant.MAIL_SMTP_SOCKETFACTORY_PORT, MailProperties.getValue(MailConstant.MAIL_SMTP_SOCKETFACTORY_PORT));
        props.put(MailConstant.MAIL_SMTP_SOCKETFACTORY_FALLBACK, MailProperties.getValue(MailConstant.MAIL_SMTP_SOCKETFACTORY_FALLBACK));
        props.put(MailConstant.MAIL_TRANSPORT_PROTOCOL, MailProperties.getValue(MailConstant.MAIL_TRANSPORT_PROTOCOL));
        props.put(MailConstant.MAIL_FROM, MailProperties.getValue(MailConstant.MAIL_FROM));
        props.put(MailConstant.MAIL_SMTP_SSL_TRUST, MailProperties.getValue(MailConstant.MAIL_SMTP_SSL_TRUST));
        // 验证
        authenticator = new MailAuthenticator(MailProperties.getValue(MailConstant.MAIL_USERNAME),
                MailProperties.getValue(MailConstant.MAIL_CRYPTOGRAM));
        // 创建session
        session = Session.getDefaultInstance(props, authenticator);

    }

    /**
     * 群发邮件
     *
     * @param recipients 收件人们
     * @param subject 主题
     * @param content 内容
     * @throws AddressException
     * @throws MessagingException
     */
    @SuppressWarnings("static-access")
    protected static void send(List<String> recipients, String subject, MailContent content) {
        try {
            // 创建mime类型邮件
            final MimeMessage message = new MimeMessage(session);
            // 设置发信人
            message.setFrom(new InternetAddress(authenticator.getUserName()));
            // 设置收件人们
            final int num = recipients.size();
            InternetAddress[] addresses = new InternetAddress[num];
            for (int i = 0; i < num; i++) {
                addresses[i] = new InternetAddress(recipients.get(i));
            }
            message.setRecipients(Message.RecipientType.TO, addresses);
            // 设置主题
            message.setSubject(subject);
            // 设置邮件内容
            message.setContent(MailHtml.getMailHtml(content.getDate(), content.getSubject(), content.getContent()),
                    "text/html;charset=utf-8");
            // 发送时间
            message.setSentDate(new Date());
            message.saveChanges();
            // 发送
            logger.info("===protocol is ============" +  props.get(MailConstant.MAIL_TRANSPORT_PROTOCOL) );
            transport = session.getTransport(((String) props.get(MailConstant.MAIL_TRANSPORT_PROTOCOL)).trim());
            // 真正的连接邮件服务器并进行身份验证

            transport.connect((String.valueOf(props.get(MailConstant.MAIL_SMTP_HOST)).trim()),
                    Integer.parseInt(String.valueOf(props.get(MailConstant.MAIL_SMTP_PORT))), authenticator.getUserName(),
                    authenticator.getUserPass());
            transport.send(message);
        } catch (Exception e) {
            logger.error("mailsend send error : ", e);
        } finally {
            try {
                transport.close();
            } catch (MessagingException e) {
                logger.error("mailsend send close error : ", e);
            }
        }
    }
}
