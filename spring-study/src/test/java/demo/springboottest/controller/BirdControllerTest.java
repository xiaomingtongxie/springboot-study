package demo.springboottest.controller;

import demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BirdControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    /**
     * 不带参数 get请求
     *
     * @throws Exception
     */
    @Test
    public void run() throws Exception {
        String resutlt = testRestTemplate.getForObject("/bird/run", String.class);
        assertEquals("i can run", resutlt);
    }

    /**
     * 不带参数post请求
     *
     * @throws Exception
     */
    @Test
    public void sayHello() throws Exception {
        Map<String, Object> map = new HashMap<>();
        String result = testRestTemplate.postForObject("/bird/hello", String.class, String.class);
        assertEquals("hello world.", result);
    }

    /**
     * 带参数的get请求
     * @throws Exception
     */
    @Test
    public void runwithparam() throws Exception {
        Map<String,String> runmap = new HashMap<>();
        runmap.put("param","xiaobaitu");
        String resutlt = testRestTemplate.getForObject("/bird/runparam?param={param}", String.class,runmap);
        assertEquals("i can run", resutlt);
    }

    /**
     * 带参数的post请求
     * @throws Exception
     */
    @Test
    public void sayhellowithparam() throws Exception {
        Map<String,String> map = new HashMap<>();
        map.put("name","xiaobaitu");
        map.put("age","oo");
        map.put("Content-Type","application/json");

//        Bird bird = new Bird();
        String resutlt = testRestTemplate.postForObject("/bird/runparam", map,String.class);
        assertEquals("hello world.", resutlt);
    }

}