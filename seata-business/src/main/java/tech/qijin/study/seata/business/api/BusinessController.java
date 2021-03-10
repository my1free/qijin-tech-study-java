package tech.qijin.study.seata.business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.study.seata.business.service.BusinessService;

@RestController
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @ResponseBody
    @RequestMapping("/purchase")
    public void purchase() {
        businessService.purchase();
    }
}
