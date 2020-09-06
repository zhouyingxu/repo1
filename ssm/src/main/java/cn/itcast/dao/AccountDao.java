package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
    账户dao接口
 */

public interface AccountDao {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 保存用户
     * @param account
     */
    @Insert("insert into account(name,money) values(#{name},#{money})")
    void save(Account account);

}
