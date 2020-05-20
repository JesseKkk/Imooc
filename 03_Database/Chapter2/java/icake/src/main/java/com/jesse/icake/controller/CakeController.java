package com.jesse.icake.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jesse.icake.biz.CakeBiz;
import com.jesse.icake.biz.CatalogBiz;
import com.jesse.icake.biz.impl.CakeBizImpl;
import com.jesse.icake.biz.impl.CatalogBizImpl;
import com.jesse.icake.entity.Cake;
import com.jesse.icake.entity.Catalog;
import com.jesse.icake.utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CakeController {

    private CakeBiz cakeBiz = new CakeBizImpl();

    //  /admin/Cake/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum = request.getParameter("pageNum");
        if (pageNum == null) pageNum = "1";
        PageHelper.startPage(Integer.parseInt(pageNum), 20);
        List<Cake> list = cakeBiz.getAll();
        PageInfo pageInfo = PageInfo.of(list);
        request.setAttribute("pageInfo", pageInfo);
        request.getRequestDispatcher("/WEB-INF/pages/admin/cake_list.jsp").forward(request, response);
    }

    //  /admin/Cake/toAdd.do
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/admin/cake_add.jsp").forward(request, response);
    }

    //  /admin/Cake/add.do
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> map = (Map<String, String>)UploadUtils.uploadFile(request);
        Cake cake = new Cake();
        cake.setTitle(map.get("title"));
        cake.setCid(Integer.parseInt(map.get("cid")));
        cake.setImagePath(map.get("path"));
        cake.setPrice(Double.parseDouble(map.get("price")));
        cake.setTaste(map.get("taste"));
        cake.setSweetness(Integer.parseInt(map.get("sweetness")));
        cake.setWeight(Double.parseDouble(map.get("weight")));
        cake.setSize(Integer.parseInt(map.get("size")));
        cake.setMaterial(map.get("material"));
        cake.setStatus(map.get("status"));
        cakeBiz.add(cake);
        response.sendRedirect("list.do");
    }

    //  /admin/Cake/toEdit.do
    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cake cake = cakeBiz.get(id);
        request.setAttribute("cake",cake);
        request.getRequestDispatcher("/WEB-INF/pages/admin/cake_edit.jsp").forward(request, response);
    }

    //  /admin/Cake/edit.do
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> map = (Map<String, String>) UploadUtils.uploadFile(request);
        Cake cake = new Cake();
        cake.setId(Integer.parseInt(map.get("id")));
        cake.setTitle(map.get("title"));
        cake.setCid(Integer.parseInt(map.get("cid")));
        if (map.get("path") != null){
            cake.setImagePath(map.get("path"));
        }else{
            cake.setImagePath(map.get("imagePath"));
        }
        cake.setPrice(Double.parseDouble(map.get("price")));
        cake.setTaste(map.get("taste"));
        cake.setSweetness(Integer.parseInt(map.get("sweetness")));
        cake.setWeight(Double.parseDouble(map.get("weight")));
        cake.setSize(Integer.parseInt(map.get("size")));
        cake.setMaterial(map.get("material"));
        cake.setStatus(map.get("status"));
        cakeBiz.edit(cake);
        response.sendRedirect("list.do");
    }

    //  /admin/Cake/remove.do
    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        cakeBiz.remove(id);
        response.sendRedirect("list.do");
    }

    //  /admin/Cake/detail.do
    public void detail  (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cake cake = cakeBiz.get(id);
        request.setAttribute("cake", cake);
        request.getRequestDispatcher("/WEB-INF/pages/admin/cake_detail.jsp").forward(request, response);
    }

}
