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

    @PostConstruct
    public void init() {
        ding("saffds");
    }

    public void ding(String message) {
        Map<String, Object> data = new HashMap<>();
        data.put("msgtype", "text");
        Map<String, String> content = new HashMap<>();
        content.put("content", String.format("ding! %s", message));
        data.put("text", content);
        restTemplate.postForObject(webhook, data, String.class);
    }
}
