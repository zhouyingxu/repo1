package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run1() throws  Exception {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //创建SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取到代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> all = accountDao.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
        sqlSession.close();
        is.close();
    }

    @Test
    public void run2() throws  Exception {
        Account account = new Account();
        account.setName("沙扬娜拉");
        account.setMoney(800d);
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //创建SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取到代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        accountDao.save(account);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }
}
