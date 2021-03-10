package tech.qijin.study.seata.storage.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.study.seata.storage.service.StorageService;

@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @ResponseBody
    @RequestMapping("/create")
    public Object create() {
        return storageService.create();
    }

    @ResponseBody
    @RequestMapping("/list")
    public Object list() {
        return storageService.list();
    }
}
