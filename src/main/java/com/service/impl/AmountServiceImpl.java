package com.service.impl;

import com.dao.AmountDao;
import com.entity.Amount;
import com.service.AmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author wyj
 * @date 2020/12/11 14:42
 */
@Service
public class AmountServiceImpl implements AmountService {

    @Autowired
    private AmountDao amountDao;

    @Override
    public List<Amount> getAmountList() {
        return amountDao.queryAmount();
    }

    @Override
    public Amount getAmountById(int id) {
        return amountDao.queryAmountById(id);
    }

    @Override
    @Transactional
    public boolean addAmount(Amount amount) {
        if(amount.getName()!=null && !"".equals(amount.getName())){
            amount.setCreatedTime(new Date());
            amount.setModifiedTime(new Date());
            try {
                int effectedNum = amountDao.insertAmount(amount);
                if (effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("插入区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败！"+e.getMessage());
            }

        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    @Transactional
    public boolean modifyAmount(Amount amount) {
        if(amount.getId()!=null && !"".equals(amount.getId())){
            amount.setCreatedTime(new Date());
            amount.setModifiedTime(new Date());
            try {
                int effectedNum = amountDao.updateAmount(amount);
                if (effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("更新区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败！"+e.toString());
            }
        }else{
            throw new RuntimeException("更新信息不能为空！");
        }
    }

    @Override
    public boolean deleteAmount(int id) {
        if (id > 0) {
            try {
                int effectedNum = amountDao.deleteAmount(id);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败" + e.toString());
            }
        } else {
            throw new RuntimeException("区域Id不能为空");
        }
    }
}
