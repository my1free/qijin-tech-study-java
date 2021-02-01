package tech.qijin.study.metrics.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.study.metrics.service.MxBeanService;

@Slf4j
@RestController
@RequestMapping("metrics")
public class MetricsController {
    @Autowired
    private MxBeanService mxBeanService;
    @Value("#{'${module:${spring.application.name}}'}")
    private String applicationName;

    @RequestMapping("/info")
    public Object info() throws InterruptedException {
        int cost = RandomUtils.nextInt(50, 100);
        Thread.sleep(cost);
        return mxBeanService.info();
    }
}
