package tech.qijin.study.seata.storage.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.study.seata.storage.service.OrderService;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/create")
    public Object create() {
        return orderService.create();
    }

    @ResponseBody
    @RequestMapping("/list")
    public Object list() {
        return orderService.list();
    }
}
