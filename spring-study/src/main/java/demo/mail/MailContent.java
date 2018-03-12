package demo.mail;

public class MailContent {

    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 内容时间
     */
    private String date;
    /**
     * 内容
     */
    private String content;

    public MailContent() {
    }

    public MailContent(String subject, String date, String content) {
        this.subject = subject;
        this.date = date;
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MailContent{" +
                "subject='" + subject + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
