package demo.mail;

public class SendMailThread implements Runnable{


    private MailBean mailBean;

    public SendMailThread(MailBean mailBean) {
        this.mailBean = mailBean;
    }

    public MailBean getMailBean() {
        return mailBean;
    }

    public void setMailBean(MailBean mailBean) {
        this.mailBean = mailBean;
    }

    @Override
    public void run() {
        MailUtil.send(mailBean);
    }
}
