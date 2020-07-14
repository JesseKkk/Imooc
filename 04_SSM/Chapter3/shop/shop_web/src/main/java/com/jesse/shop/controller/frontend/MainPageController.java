package com.jesse.shop.controller.frontend;

import com.jesse.shop.biz.HeadLineBiz;
import com.jesse.shop.biz.StoreCategoryBiz;
import com.jesse.shop.entity.HeadLine;
import com.jesse.shop.entity.StoreCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kong on 2020/6/30.
 */
@Controller("mainPageController")
@RequestMapping("/frontend")
public class MainPageController {
    @Autowired
    private StoreCategoryBiz storeCategoryBiz;

    @Autowired
    private HeadLineBiz headLineBiz;

    //初始化前端展示系统的主页信息，包括获取以及店铺类别列表以及头条列表
    @RequestMapping(value = "/listmainpageinfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> listMainPageInfo() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<StoreCategory> storeCategoryList = new ArrayList<StoreCategory>();
        try{
            //获取以及店铺类别列表（即parentId为空的StoreCategory）
            storeCategoryList = storeCategoryBiz.getStoreCategoryList(null);
            modelMap.put("storeCategoryList", storeCategoryList);
        }catch (Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }
        List<HeadLine> headLineList = new ArrayList<HeadLine>();
        try{
            //获取状态为可用（1）的头条列表
            HeadLine headLineCondition = new HeadLine();
            headLineCondition.setEnableStatus(1);
            headLineList = headLineBiz.getHeadLineList(headLineCondition);
            modelMap.put("headLineList", headLineList);
        }catch (Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }
        modelMap.put("success", true);
        return modelMap;
    }
}
