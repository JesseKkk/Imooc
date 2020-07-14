package com.jesse.shop.controller.storeadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Kong on 2020/6/24.
 */
@Controller("storeAdminController")
@RequestMapping(value = "/storeadmin", method = RequestMethod.GET)
public class StoreAdminController {

    @RequestMapping(value = "/storeoperation")
    public String storeOperation() {
        return "store/storeoperation";
    }

    @RequestMapping(value = "/storelist")
    public String storeList() {
        return "store/storelist";
    }

    @RequestMapping(value = "/storemanagement")
    public String storeManagement() {
        return "store/storemanagement";
    }

    @RequestMapping(value = "/productcategorymanagement")
    public String productCategoryManage() {
        return "store/productcategorymanagement";
    }

    @RequestMapping(value = "/productoperation")
    public String productOperation() {
        return "store/productoperation";
    }

    @RequestMapping(value = "/productmanagement")
    public String productManagement() {
        return "store/productmanagement";
    }
}
