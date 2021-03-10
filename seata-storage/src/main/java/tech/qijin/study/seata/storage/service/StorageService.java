package tech.qijin.study.seata.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.study.seata.storage.db.mapper.StorageTblMapper;
import tech.qijin.study.seata.storage.db.model.StorageTbl;
import tech.qijin.study.seata.storage.db.model.StorageTblExample;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private StorageTblMapper storageTblMapper;

    public Object create() {
        return "Success";
    }

    public List<StorageTbl> list() {
        return storageTblMapper.selectByExample(new StorageTblExample());
    }
}
