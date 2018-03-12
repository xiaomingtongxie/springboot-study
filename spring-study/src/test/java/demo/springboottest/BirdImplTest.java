package demo.springboottest;

import demo.DemoApplication;
import demo.springboottest.service.impl.BirdImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BirdImplTest {

    @Autowired
    private BirdImpl birdImpl;

    @Test
    public void run() throws Exception {
        String result = birdImpl.run();
        Assert.assertEquals("i can run",result);

    }

    @Test
    public void sayhello() throws Exception {
        String result = birdImpl.sayhello();
        Assert.assertEquals("hello world.",result);
    }

}