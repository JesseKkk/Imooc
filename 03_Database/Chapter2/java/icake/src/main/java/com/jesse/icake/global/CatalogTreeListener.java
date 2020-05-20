package com.jesse.icake.global;

import com.jesse.icake.biz.CatalogBiz;
import com.jesse.icake.biz.impl.CatalogBizImpl;
import com.jesse.icake.entity.Catalog;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CatalogTreeListener implements ServletContextListener {
    private CatalogBiz catalogBiz = new CatalogBizImpl();
    public void contextInitialized(ServletContextEvent sce) {
        Catalog root = catalogBiz.getRoot();
        sce.getServletContext().setAttribute("root", root);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
