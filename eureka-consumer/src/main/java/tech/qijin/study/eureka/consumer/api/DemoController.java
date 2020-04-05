package tech.qijin.study.eureka.consumer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author michealyang
 * @date 2020-04-05
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@RestController
@RequestMapping("/consumer")
public class DemoController {
    private final String PROVER_HOST = "EUREKA-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("call")
    public Object call() {
        return restTemplate.getForEntity("http://" + PROVER_HOST + "/provider/echo?input=consumer", String.class).getBody();
    }
}
