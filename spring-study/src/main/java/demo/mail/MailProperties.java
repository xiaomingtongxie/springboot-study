package demo.mail;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

public class MailProperties {

    private static Logger logger = LoggerFactory.getLogger(MailProperties.class);

    private static final String BONDEL_NAME = "mail";

    private static final ResourceBundle bundel = ResourceBundle.getBundle(BONDEL_NAME);


    public static String getValue(String key) {

        //参数校验
        if (StringUtils.isBlank(key)) {
            System.out.println("发生了未知异常！");
        }

        String value = null;
        try {
            value = bundel.getString(StringUtils.trim(key));
        } catch (Exception e) {
            logger.warn(String.format("value not existed: %s", key), e);
        }

        return StringUtils.isBlank(value) ? StringUtils.EMPTY : value;
    }

}
