package tech.qijin.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class DingUtil {
    private final String webhook = "https://oapi.dingtalk.com/robot/send?access_token=682f95d4102455e92b853549957059027d99f98b9ec54a6380b502e8af7e6e38";
    @Autowired
    private RestTemplate restTemplate;
    private String infoBg = "http://ec2-52-80-189-105.cn-north-1.compute.amazonaws.com.cn/green.jpg";
    private String errorBg = "http://ec2-52-80-189-105.cn-north-1.compute.amazonaws.com.cn/red.jpg";

    @PostConstruct
    public void init() {
        ding("saffds");
    }

    public void ding(String message) {
        String bg = false ? infoBg : errorBg;
        Map<String, Object> data = new HashMap<>();
        data.put("msgtype", "markdown");
        Map<String, String> content = new HashMap<>();
        content.put("title", "大乐透通知");
        content.put("text", String.format("![ss](%s)\n ding! %s", bg, message));
        data.put("markdown", content);
        String response = restTemplate.postForObject(webhook, data, String.class);
        System.out.println(response);
    }
}
