package com.codingapi.tm.netty.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.codingapi.tm.manager.service.TxManagerService;
import com.codingapi.tm.netty.model.TxGroup;
import com.codingapi.tm.netty.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 关闭事务组
 * create by lorne on 2017/11/11
 */
@Service(value = "ctg")
public class ActionCTGServiceImpl implements IActionService{


    @Autowired
    private TxManagerService txManagerService;

    @Override
    public String execute(String modelName,String key,JSONObject params ) {
        String res = "";
        String groupId = params.getString("g");
        int state = params.getInteger("s");
        boolean bs = txManagerService.closeTransactionGroup(groupId,state);

        res = bs ? "1" : "0";
        return res;
    }
}
