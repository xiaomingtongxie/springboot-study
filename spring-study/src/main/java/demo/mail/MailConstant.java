package demo.mail;


public class MailConstant {

    /**
     * smtp 服务器
     */
    public static final String MAIL_SMTP_HOST = "mail.smtp.host";
    /**
     * smtp服务器的端口
     */
    public static final String MAIL_SMTP_PORT = "mail.smtp.port";
    /**
     * 如果为true,STARTTLS则在发出任何登录命令之前，启用命令（如果服务器支持）将连接切换到TLS保护的连接。
     * 请注意，必须配置适当得信任存储，以便客户端信任服务器得证书。默认为false
     */
    public static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    /**
     * 如果为true,则尝试使用AUTH命令认证用户。默认为false.
     */
    public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    /**
     * 指定使用指定套接字工厂时要连接的端口。如果未设置，将使用默认端口。
     */
    public static final String MAIL_SMTP_SOCKETFACTORY_PORT = "mail.smtp.socketFactory.port";
    /**
     * 如果设置为true,则无法使用指定的套接字工厂类创建套接字将导致使用java.net.Socket该类创建套接字。默认为true.
     */
    public static final String MAIL_SMTP_SOCKETFACTORY_FALLBACK = "mail.smtp.socketFactory.fallback";
    /**
     * Transport对象才会向SMTP服务器提交用户认证信息
     */
    public static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
    /**
     * 发件人地址
     */
    public static final String MAIL_FROM = "mail.from";
    /**
     * ssl 被smtp认证
     */
    public static final String MAIL_SMTP_SSL_TRUST = "mail.smtp.ssl.trust";
    /**
     * 用户名
     */
    public static final String MAIL_USERNAME = "mail.username";
    /**
     * 密码
     */
    public static final String MAIL_CRYPTOGRAM = "mail.password";

    /**
     * 私有构造器，坏味道
     */
    private MailConstant() {
        //do nothing
    }
}
