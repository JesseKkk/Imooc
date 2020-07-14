package com.jesse.shop.controller.frontend;

import com.jesse.shop.biz.AreaBiz;
import com.jesse.shop.biz.StoreBiz;
import com.jesse.shop.biz.StoreCategoryBiz;
import com.jesse.shop.dto.StoreExecution;
import com.jesse.shop.entity.Area;
import com.jesse.shop.entity.Store;
import com.jesse.shop.entity.StoreCategory;
import com.jesse.shop.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kong on 2020/7/8.
 */
@Controller("storeListController")
@RequestMapping("/frontend")
public class StoreListController {

    @Autowired
    private AreaBiz areaBiz;

    @Autowired
    private StoreCategoryBiz storeCategoryBiz;

    @Autowired
    private StoreBiz storeBiz;

    @RequestMapping(value = "/liststorespageinfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listStoresPageInfo(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //试着从前端请求中获取parentId
        long parentId = HttpServletRequestUtil.getLong(request, "parentId");
        List<StoreCategory> storeCategoryList = null;
        if (parentId != -1){
            //如果parentId存在，则取出该一级StoreCategory下的二级StoreCategory列表
            try{
                StoreCategory storeCategoryCondition = new StoreCategory();
                StoreCategory parent = new StoreCategory();
                parent.setStoreCategoryId(parentId);
                storeCategoryCondition.setParent(parent);
                storeCategoryList = storeCategoryBiz.getStoreCategoryList(storeCategoryCondition);
            }catch (Exception e){
                modelMap.put("success", false);
                modelMap.put("errMsg", e.getMessage());
                return modelMap;
            }
        }else {
            try{
                //如果parentId不存在，则取出所有一级StoreCategory（用户在首页选择的是全部商店列表）
                storeCategoryList = storeCategoryBiz.getStoreCategoryList(null);
            }catch (Exception e){
                modelMap.put("success", false);
                modelMap.put("errMst", e.getMessage());
                return modelMap;
            }
        }
        modelMap.put("storeCategoryList", storeCategoryList);
        List<Area> areaList = null;
        try{
            //获取区域列表信息
            areaList = areaBiz.getAreaList();
            modelMap.put("areaList", areaList);
            modelMap.put("success", true);
        }catch (Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }
        return modelMap;
    }

    @RequestMapping(value = "/liststores", method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> listStores(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        //非空判断
        if ((pageIndex > -1) && (pageSize > -1)){
            long parentId = HttpServletRequestUtil.getLong(request, "parentId");
            long storeCategoryId = HttpServletRequestUtil.getInt(request, "storeCategoryId");
            int areaId = HttpServletRequestUtil.getInt(request, "areaId");
            String storeName = HttpServletRequestUtil.getString(request, "storeName");
            Store storeCondition = compactStoreCondition4Search(parentId, storeCategoryId, areaId, storeName);
            StoreExecution se = storeBiz.getStoreList(storeCondition, pageIndex, pageSize);
            modelMap.put("storeList", se.getStoreList());
            modelMap.put("count", se.getCount());
            modelMap.put("success", true);
        }else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty pageSize or pageIndex");
        }
        return modelMap;
    }

    private Store compactStoreCondition4Search(long parentId, long storeCategoryId, int areaId, String storeName){
        Store storeCondition = new Store();
        if (parentId != -1l){
            //查询某个一个StoreCategory下面的所有二级StoreCategory里面的店铺列表
            StoreCategory childCategory = new StoreCategory();
            StoreCategory parentCategory = new StoreCategory();
            parentCategory.setStoreCategoryId(parentId);
            childCategory.setParent(parentCategory);
            storeCondition.setStoreCategory(childCategory);
        }
        if (storeCategoryId != -1l){
            //查询某个二级StoreCategory下面的店铺列表
            StoreCategory storeCategory = new StoreCategory();
            storeCategory.setStoreCategoryId(storeCategoryId);
            storeCondition.setStoreCategory(storeCategory);
        }
        if (areaId != -1l){
            //查询位于某个区域Id下的店铺列表
            Area area = new Area();
            area.setAreaId(areaId);
            storeCondition.setArea(area);
        }
        if (storeName != null){
            //查询名字里包含storeName的店铺列表
            storeCondition.setStoreName(storeName);
        }
        //前端展示的店铺的都是审核成功的店铺
        storeCondition.setEnableStatus(1);
        return storeCondition;
    }

}
