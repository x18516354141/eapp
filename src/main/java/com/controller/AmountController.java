package com.controller;

import com.entity.Amount;
import com.service.AmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wyj
 * @date 2020/12/11 15:09
 */
@RestController
@RequestMapping("/superadmin")
public class AmountController {

    @Autowired
    private AmountService amountService;

    @RequestMapping(value = "/listamount",method = RequestMethod.GET)
    private Map<String,Object> listAmount(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Amount> list = amountService.getAmountList();
        modelMap.put("amountList",list);
        return modelMap;
    }

    @RequestMapping(value = "/getamountbyid",method = RequestMethod.GET)
    private Map<String,Object> getAmountById(Integer id){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Amount amount = amountService.getAmountById(id);
        modelMap.put("amount",amount);
        return modelMap;
    }

    @RequestMapping(value = "/addamount",method = RequestMethod.POST)
    private Map<String,Object> addAmount(@RequestBody Amount amount){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",amountService.addAmount(amount));
        return modelMap;
    }

    @RequestMapping(value = "/modifyamount",method = RequestMethod.POST)
    private Map<String,Object> modifyAmount(@RequestBody Amount amount){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",amountService.modifyAmount(amount));
        return modelMap;
    }

    @RequestMapping(value = "/removeamount",method = RequestMethod.GET)
    private Map<String,Object> removeAmount(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",amountService.deleteAmount(areaId));
        return modelMap;
    }

}
