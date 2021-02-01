package tech.qijin.study.transaction.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.study.transaction.mysql.db1.model.User1;
import tech.qijin.study.transaction.mysql.db2.model.User2;
import tech.qijin.study.transaction.service.BaseService;

import java.util.List;

@RestController
@RequestMapping("/")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/user1")
    public List<User1> user1() {
        return baseService.listUser1();
    }

    @GetMapping("/user2")
    public List<User2> user2() {
        return baseService.listUser2();
    }

    @GetMapping("/user1/update")
    public Integer updateUser1() {
        return baseService.updateUser1();
    }

    @GetMapping("/user2/update")
    public Integer updateUser2() {
        return baseService.updateUser2();
    }

    @GetMapping("/user12/update")
    public Boolean updateUser12() {
        return baseService.updateUser12();
    }
}
