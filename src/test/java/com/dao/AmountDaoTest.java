package com.dao;

import com.entity.Amount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmountDaoTest {
    @Autowired
    private  AmountDao amountDao;

    @Test
    public void queryAmount() {
        List<Amount> amountList= amountDao.queryAmount();
        assertEquals(3,amountList.size());
        System.out.println("长度是多少:"+amountList.size());
    }

    @Test
    public void queryAmountById() {
        Amount amount =amountDao.queryAmountById(2);
        assertEquals("电子书刊",amount.getName());
        System.out.println("第二条数据的具体情况:"+amount.getName());
    }

    @Test
    public void insertAmount() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date=new Date();
        String dfDate=df.format(date);
        Amount amount = new Amount();
        amount.setName("肖肖肖肖");
        amount.setStatus(1);
        amount.setCreatedTime(date);
        amount.setModifiedTime(date);
        int effectedNum = amountDao.insertAmount(amount);
        assertEquals(1,effectedNum);
        System.out.println("effectedNum:"+effectedNum);
    }

    @Test
    public void updateAmount() {
        Amount amount = new Amount();
        amount.setName("旭旭旭旭");
        amount.setId(1);
        amount.setModifiedTime(new Date());
        int effectedNum = amountDao.updateAmount(amount);
        assertEquals(1,effectedNum);
        System.out.println("effectedNum:"+effectedNum);
    }

    @Test
    public void deleteAmount() {
        int effectedNum = amountDao.deleteAmount(1183);
        assertEquals(1, effectedNum);
        System.out.println("effectedNum:" + effectedNum);
    }
}