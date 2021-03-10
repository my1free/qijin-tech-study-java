package tech.qijin.study.seata.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.study.seata.account.db.mapper.AccountTblMapper;
import tech.qijin.study.seata.account.db.model.AccountTbl;
import tech.qijin.study.seata.account.db.model.AccountTblExample;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountTblMapper accountTblMapper;

    public Object create() {
        return "Success";
    }

    public List<AccountTbl> list() {
        return accountTblMapper.selectByExample(new AccountTblExample());
    }
}
