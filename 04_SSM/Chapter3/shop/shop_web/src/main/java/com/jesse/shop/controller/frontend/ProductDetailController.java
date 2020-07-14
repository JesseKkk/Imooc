package com.jesse.shop.controller.frontend;

import com.jesse.shop.biz.ProductBiz;
import com.jesse.shop.entity.Product;
import com.jesse.shop.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kong on 2020/7/8.
 */
@Controller("productDetailController")
@RequestMapping("/frontend")
public class ProductDetailController {
    @Autowired
    private ProductBiz productBiz;

    @RequestMapping(value = "/listproductdetailpageinfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listProductDetailPageInfo(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        long productId = HttpServletRequestUtil.getLong(request, "productId");

        Product product = null;
        if (productId != -1) {
            product = productBiz.getProductById(productId);
            modelMap.put("product", product);
            modelMap.put("success", true);
        }else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty productId");
            return modelMap;
        }
        return modelMap;
    }
}
