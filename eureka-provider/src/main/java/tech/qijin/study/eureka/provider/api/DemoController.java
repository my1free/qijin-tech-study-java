package tech.qijin.study.eureka.provider.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author michealyang
 * @date 2020-04-05
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@RestController
@EnableDiscoveryClient
@RequestMapping("/provider")
public class DemoController {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/echo")
    public Object echo(String input) {
        return "Response From Server: " + input;
    }
}
