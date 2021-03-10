package tech.qijin.study.seata.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.study.seata.account.db.mapper.OrderTblMapper;
import tech.qijin.study.seata.account.db.model.OrderTbl;
import tech.qijin.study.seata.account.db.model.OrderTblExample;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderTblMapper orderTblMapper;

    public Object create() {
        return "Success";
    }

    public List<OrderTbl> list() {
        return orderTblMapper.selectByExample(new OrderTblExample());
    }
}
