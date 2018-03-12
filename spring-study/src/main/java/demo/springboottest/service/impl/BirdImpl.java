package demo.springboottest.service.impl;

import demo.springboottest.service.Ibird;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BirdImpl implements Ibird {

    Logger logger  = LoggerFactory.getLogger(BirdImpl.class);

    @Override
    public String run() {
        logger.info("call run()");
        return "i can run";
    }

    @Override
    public String sayhello() {
        logger.info("call sayhello()");
        return "hello world.";
    }
}
