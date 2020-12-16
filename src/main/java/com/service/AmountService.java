package com.service;

import com.entity.Amount;

import java.util.List;

/**
 * @author wyj
 * @date 2020/12/11 14:40
 */
public interface AmountService {
    List<Amount> getAmountList();
    Amount getAmountById(int amountId);
    boolean addAmount(Amount amount);
    boolean modifyAmount(Amount amount);
    boolean deleteAmount(int amountId);
}
