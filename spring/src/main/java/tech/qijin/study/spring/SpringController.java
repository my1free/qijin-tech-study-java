package tech.qijin.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
    @Autowired
    private SpringService springService;
    @MyAutowired
    private MySpringService mySpringService;

    @ResponseBody
    @RequestMapping("/")
    public Object index() {
        return springService.go();
    }
}
