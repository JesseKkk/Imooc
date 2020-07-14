package com.jesse.shop.controller.frontend;

import com.jesse.shop.biz.ProductBiz;
import com.jesse.shop.biz.ProductCategoryBiz;
import com.jesse.shop.biz.StoreBiz;
import com.jesse.shop.dto.ProductExecution;
import com.jesse.shop.entity.Product;
import com.jesse.shop.entity.ProductCategory;
import com.jesse.shop.entity.Store;
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
 * Created by Kong on 2020/7/9.
 */
@Controller("storeDetailController")
@RequestMapping("/frontend")
public class StoreDetailController {

    @Autowired
    private StoreBiz storeBiz;

    @Autowired
    private ProductBiz productBiz;

    @Autowired
    private ProductCategoryBiz productCategoryBiz;

    @RequestMapping(value = "/liststoredetailpageinfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> listStoreDetailPageInfo(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //获取前台传过来的storeId
        long storeId = HttpServletRequestUtil.getLong(request, "storeId");
        Store store = null;
        List<ProductCategory> productCategoryList = null;
        if (storeId != -1) {
            store = storeBiz.getByStoreId(storeId);
            productCategoryList = productCategoryBiz.getProductCategoryList(storeId);
            modelMap.put("store", store);
            modelMap.put("productCategoryList", productCategoryList);
            modelMap.put("success", true);
        }else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty storeId");
        }
        return modelMap;
    }

    @RequestMapping(value = "/listproductsbystore", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listProductsByStore(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        long storeId = HttpServletRequestUtil.getLong(request, "storeId");
        if ((pageIndex > -1) && (pageSize > -1) && (storeId > -1)) {
             long productCategoryId = HttpServletRequestUtil.getLong(request, "productCategoryId");
             String productName = HttpServletRequestUtil.getString(request, "productName");
            Product productCondition = compactProductCondition4Search(storeId, productCategoryId, productName);
            ProductExecution pe = productBiz.getProductList(productCondition,pageIndex, pageSize);
            modelMap.put("productList", pe.getProductList());
            modelMap.put("count", pe.getCount());
            modelMap.put("success", true);
        }else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty pageSize or pageIndex or storeId");
        }
        return modelMap;
    }

    private Product compactProductCondition4Search(long storeId, long productCategoryId, String productName) {
        Product productCondition = new Product();
        Store store = new Store();
        store.setStoreId(storeId);
        productCondition.setStore(store);
        if (productCategoryId != -1l) {
            ProductCategory productCategory = new ProductCategory();
            productCategory.setProductCategoryId(productCategoryId);
            productCondition.setProductCategory(productCategory);
        }
        if (productName != null) {
            productCondition.setProductName(productName);
        }
        productCondition.setEnableStatus(1);
        return productCondition;
    }
}
