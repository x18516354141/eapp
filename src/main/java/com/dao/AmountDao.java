package com.dao;

import com.entity.Amount;

import java.util.List;

/**
 * @author wyj
 * @date 2020/12/11 11:22
 */
public interface AmountDao {
    List<Amount> queryAmount();
    Amount queryAmountById(Integer id);
    int insertAmount(Amount amount);
    int updateAmount(Amount amount);
    int deleteAmount(Integer id);
}
