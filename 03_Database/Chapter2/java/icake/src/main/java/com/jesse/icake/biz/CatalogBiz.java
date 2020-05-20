package com.jesse.icake.biz;

import com.jesse.icake.entity.Catalog;

import java.util.List;

public interface CatalogBiz {
    void add(List<Catalog> list);
    void remove(int id);
    Catalog getRoot();
}
