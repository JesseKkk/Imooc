package com.jesse.shop.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Kong on 2020/7/8.
 */
@Controller("frontendController")
@RequestMapping("/frontend")
public class FrontendController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String index(){
        return "frontend/index";
    }

    @RequestMapping(value = "/storelist", method = RequestMethod.GET)
    private String showStoreList(){
        return "frontend/storelist";
    }

    @RequestMapping(value = "/productdetail", method = RequestMethod.GET)
    private String showProductDetail(){
        return "frontend/productdetail";
    }

    @RequestMapping(value = "/storedetail", method = RequestMethod.GET)
    private String showStoreDetail(){
        return "frontend/storedetail";
    }
}
