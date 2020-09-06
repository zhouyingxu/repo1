package cn.itcast.service;



import cn.itcast.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 保存用户
     * @param account
     */
    void save(Account account);
}
