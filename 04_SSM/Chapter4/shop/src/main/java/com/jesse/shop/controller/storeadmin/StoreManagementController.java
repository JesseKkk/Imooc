package com.jesse.shop.controller.storeadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesse.shop.biz.AreaBiz;
import com.jesse.shop.biz.StoreBiz;
import com.jesse.shop.biz.StoreCategoryBiz;
import com.jesse.shop.dto.ImageHolder;
import com.jesse.shop.dto.StoreExecution;
import com.jesse.shop.entity.Area;
import com.jesse.shop.entity.PersonInfo;
import com.jesse.shop.entity.Store;
import com.jesse.shop.entity.StoreCategory;
import com.jesse.shop.enums.StoreStateEnum;
import com.jesse.shop.util.CodeUtil;
import com.jesse.shop.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kong on 2020/6/23.
 */
@Controller("storeManagementController")
@RequestMapping("/storeadmin")
public class StoreManagementController {
    @Autowired
    private StoreBiz storeBiz;
    @Autowired
    private StoreCategoryBiz storeCategoryBiz;
    @Autowired
    private AreaBiz areaBiz;

    @RequestMapping(value = "/getstoremanagementinfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getStoreManagementInfo(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        long storeId = HttpServletRequestUtil.getLong(request, "storeId");
        if (storeId <= 0) {
            Object currentStoreObj = request.getSession().getAttribute("currentStore");
            if (currentStoreObj == null){
                modelMap.put("redirect", true);
                modelMap.put("url", "/storeadmin/storelist");
            }else {
                Store currentStore = (Store)currentStoreObj;
                modelMap.put("redirect", false);
                modelMap.put("storeId", currentStore.getStoreId());
            }
        }else {
            Store currentStore = new Store();
            currentStore.setStoreId(storeId);
            request.getSession().setAttribute("currentStore", currentStore);
            modelMap.put("redirect", false);
        }
        return modelMap;
    }

    @RequestMapping(value = "/getstorelist", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getStoreList(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        PersonInfo user = (PersonInfo)request.getSession().getAttribute("user");
        try{
            Store storeCondition = new Store();
            storeCondition.setOwner(user);
            StoreExecution se = storeBiz.getStoreList(storeCondition,0,100);
            modelMap.put("storeList", se.getStoreList());
            modelMap.put("user", user);
            modelMap.put("success", true);
        }catch (Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/getstorebyid", method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getStoreById(HttpServletRequest request) {
        Map<String,Object> modelMap = new HashMap<String, Object>();
        Long storeId =  HttpServletRequestUtil.getLong(request,"storeId");
        if (storeId > -1) {
            try{
                Store store = storeBiz.getByStoreId(storeId);
                List<Area> areaList = areaBiz.getAreaList();
                modelMap.put("store", store);
                modelMap.put("areaList", areaList);
                modelMap.put("success", true);
            } catch (Exception e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.getMessage());
            }
        } else{
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty storeId");
        }
        return modelMap;
    }

    @RequestMapping(value = "/getstoreinitinfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getStoreInitInfo() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<StoreCategory> storeCategoryList = new ArrayList<StoreCategory>();
        List<Area> areaList = new ArrayList<Area>();
        try{
            storeCategoryList = storeCategoryBiz.getStoreCategoryList(new StoreCategory());
            areaList = areaBiz.getAreaList();
            modelMap.put("storeCategoryList", storeCategoryList);
            modelMap.put("areaList", areaList);
            modelMap.put("success", true);
        }catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }


    @RequestMapping(value = "/registerstore", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> registerStore(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "输入了错误的验证码");
            return modelMap;
        }
        //1、接收并转化响应的参数，包括店铺信息及图片信息
        String storeStr = HttpServletRequestUtil.getString(request, "storeStr");
        ObjectMapper mapper = new ObjectMapper();
        Store store = null;
        try{
            store = mapper.readValue(storeStr, Store.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }
        CommonsMultipartFile storeImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
            storeImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("storeImg");
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "上传图片不能为空");
            return modelMap;
        }
        //2、注册店铺
        if (store != null && storeImg != null) {
            PersonInfo owner = (PersonInfo) request.getSession().getAttribute("user");
            store.setOwner(owner);
            StoreExecution se = null;
            try {
                ImageHolder imageHolder = new ImageHolder(storeImg.getOriginalFilename(),storeImg.getInputStream());
                se = storeBiz.addStore(store, imageHolder);
            } catch (IOException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.getMessage());
            }
            if (se.getState() == StoreStateEnum.CHECK.getState()) {
                modelMap.put("success", true);
                //该用户可以操作的店铺列表
                List<Store> storeList = (List<Store>)request.getSession().getAttribute("storeList");
                if (storeList == null || storeList.size() == 0) {
                    storeList = new ArrayList<Store>();
                }
                storeList.add(se.getStore());
                request.getSession().setAttribute("storeList",storeList);
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", se.getStateInfo());
            }
            return modelMap;
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入店铺信息");
            return modelMap;
        }
    }

    @RequestMapping(value = "/modifystore", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> modifyStore(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "输入了错误的验证码");
            return modelMap;
        }
        //1、接收并转化响应的参数，包括店铺信息及图片信息
        String storeStr = HttpServletRequestUtil.getString(request, "storeStr");
        ObjectMapper mapper = new ObjectMapper();
        Store store = null;
        try{
            store = mapper.readValue(storeStr, Store.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }
        CommonsMultipartFile storeImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
            storeImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("storeImg");
        }
        //2、修改店铺信息
        if (store != null && store.getStoreId() != null) {
            StoreExecution se = null;
            try {
                if (storeImg == null) {
                    se = storeBiz.modifyStore(store, null);
                }else{
                    ImageHolder imageHolder = new ImageHolder(storeImg.getOriginalFilename(),storeImg.getInputStream());
                    se = storeBiz.modifyStore(store, imageHolder);

                }
            } catch (IOException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.getMessage());
            }
            if (se.getState() == StoreStateEnum.SUCCESS.getState()) {
                modelMap.put("success", true);
                List<Store> storeList = (List<Store>)request.getSession().getAttribute("storeList");
                for (Store s : storeList) {
                    if (s.getStoreId() == se.getStore().getStoreId()){
                        int i = storeList.indexOf(s);
                        storeList.remove(s);
                        storeList.add(i, se.getStore());
                    }
                }
                request.getSession().setAttribute("storeList",storeList);
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", se.getStateInfo());
            }
            return modelMap;
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入店铺Id");
            return modelMap;
        }
    }
}
