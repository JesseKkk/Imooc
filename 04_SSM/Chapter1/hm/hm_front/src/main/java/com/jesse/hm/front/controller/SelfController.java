package com.jesse.hm.front.controller;

import com.jesse.hm.common.entity.Category;
import com.jesse.hm.common.entity.Dept;
import com.jesse.hm.common.service.CategoryService;
import com.jesse.hm.common.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kong on 2020/5/22.
 */
@Controller("selfController")
public class SelfController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    DeptService deptService;

    //  /index.do
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.getAll();
        request.setAttribute("LIST",categories);
        Map<Integer,List<Dept>> map = new HashMap<>();
        for (Category cate: categories){
            List<Dept> deptList = deptService.getCid(cate.getId());
            map.put(cate.getId(),deptList);
        }
        request.setAttribute("MAP",map);
        request.getRequestDispatcher("hospital_detail.jsp").forward(request,response);
    }
}
