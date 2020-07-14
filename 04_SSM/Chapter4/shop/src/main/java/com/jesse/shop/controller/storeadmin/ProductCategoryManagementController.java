package com.jesse.shop.controller.storeadmin;

import com.jesse.shop.biz.ProductCategoryBiz;
import com.jesse.shop.dto.ProductCategoryExecution;
import com.jesse.shop.dto.Result;
import com.jesse.shop.entity.ProductCategory;
import com.jesse.shop.entity.Store;
import com.jesse.shop.enums.ProductCategoryStateEnum;
import com.jesse.shop.exceptions.ProductOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kong on 2020/6/28.
 */
@Controller("productCategoryManagementController")
@RequestMapping("/storeadmin")
public class ProductCategoryManagementController {
    @Autowired
    private ProductCategoryBiz productCategoryBiz;

    @RequestMapping(value = "/getproductcategorylist", method = RequestMethod.GET)
    @ResponseBody
    private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request){

        Store currentStore = (Store)request.getSession().getAttribute("currentStore");
        List<ProductCategory> list = null;
        if (currentStore != null && currentStore.getStoreId()>0){
            list= productCategoryBiz.getProductCategoryList(currentStore.getStoreId());
            return new Result<List<ProductCategory>>(true,list);
        }else {
            ProductCategoryStateEnum ps = ProductCategoryStateEnum.INNER_ERROR;
            return new Result<List<ProductCategory>>(false,ps.getState(),ps.getStateInfo());
        }
    }

    @RequestMapping(value = "/addproductcategorys", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> addProductCategorys(@RequestBody List<ProductCategory> productCategoryList, HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Store currentStore = (Store)request.getSession().getAttribute("currentStore");
        for (ProductCategory pc : productCategoryList){
            pc.setStoreId(currentStore.getStoreId());
        }
        if (productCategoryList != null && productCategoryList.size() > 0){
            try{
                ProductCategoryExecution pe = productCategoryBiz.batchAddProductCategory(productCategoryList);
                if (pe.getState() == ProductCategoryStateEnum.SUCCESS.getState()){
                    modelMap.put("success", true);
                }else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg",pe.getStateInfo());
                }
            }catch (ProductOperationException e){
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
            }

        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg", "请至少输入一个商品类别");
        }
        return modelMap;
    }

    @RequestMapping(value = "/removeproductcategory", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> removeProductCategory(Long productCategoryId, HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        if (productCategoryId != null && productCategoryId > 0){
            try{
                Store currentStore = (Store)request.getSession().getAttribute("currentStore");
                ProductCategoryExecution pe = productCategoryBiz.deleteProductCategory(productCategoryId, currentStore.getStoreId());
                if (pe.getState() == ProductCategoryStateEnum.SUCCESS.getState()){
                    modelMap.put("success", true);
                }else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", pe.getStateInfo());
                }
            }catch (ProductOperationException e){
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
            }
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg", "请至少选择一个商品类别");
        }
        return modelMap;
    }
}
