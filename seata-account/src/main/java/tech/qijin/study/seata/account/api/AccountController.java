package tech.qijin.study.seata.account.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.study.seata.account.service.AccountService;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @ResponseBody
    @RequestMapping("/create")
    public Object create() {
        return accountService.create();
    }

    @ResponseBody
    @RequestMapping("/list")
    public Object list() {
        return accountService.list();
    }
}
