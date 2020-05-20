package com.jesse.icake.biz.impl;

import com.jesse.icake.biz.CatalogBiz;
import com.jesse.icake.dao.CatalogDao;
import com.jesse.icake.entity.Catalog;
import com.jesse.icake.global.DaoFactory;

import java.util.List;

public class CatalogBizImpl implements CatalogBiz {

    private CatalogDao catalogDao = DaoFactory.getInstance().getDao(CatalogDao.class);

    public void add(List<Catalog> list) {
        catalogDao.batchInsert(list);
    }

    public void remove(int id) {
        catalogDao.delete(id);
    }

    public Catalog getRoot() {
        return catalogDao.select(10000);
    }
}
