package demo.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class MailUtil {

    private static final Logger logger = LoggerFactory.getLogger(MailUtil.class);
    //线程池核心线程数
    private static final int COREPOOLSIZE = 1;
    //线程池最大线程数
    private static final int MAXMUMPOOLSIZE = 10;
    //超过核心线程数，空闲线程等待任务的最长时间 单位 毫秒，0 的意思是 空闲线程直接销毁
    private static final long KEEPALIVETIME = 0;
    //当线程池中线程数等于核心线程数时，新创建的线程任务放到阻塞队列中去
    private static final BlockingQueue<Runnable> EMAIL_QUEUE = new LinkedBlockingDeque<>(10);

    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(COREPOOLSIZE, MAXMUMPOOLSIZE, KEEPALIVETIME,
            TimeUnit.SECONDS, EMAIL_QUEUE, new ThreadPoolExecutor.AbortPolicy());

    public static void send(MailBean mailBean) {
        try {
            MailSend.send(mailBean.getRecipients(), mailBean.getSubject(), mailBean.getContent());
        } catch (Exception e) {
            logger.error("mailutil error : ", e);
        }finally {
            logger.info("邮件发送  成功了！");
        }
    }
}
