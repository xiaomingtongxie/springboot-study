package demo.mail;

import java.util.List;

public class MailBean {

    /**
     * 发件人地址
     */
    private String fromAddress;
    /**
     * 收件人地址
     */
    private String toAddress;
    /**
     * 邮箱用户名
     */
    private String userName;
    /**
     * 邮箱用户名密码
     */
    private String userPassword;
    /**
     * 多个收件人
     */
    private List<String> recipients;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private MailContent content;

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public MailContent getContent() {
        return content;
    }

    public void setContent(MailContent content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MailBean{" +
                "fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", recipients=" + recipients +
                ", subject='" + subject + '\'' +
                ", content=" + content +
                '}';
    }
}
