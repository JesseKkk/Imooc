package com.jesse.transation.dao;

import com.jesse.transation.entity.Testa;
import org.springframework.stereotype.Repository;

/**
 * Created by Kong on 2020/7/12.
 */
@Repository("testaDao")
public interface TestaDao {
    int insertTesta(Testa testa);
    int deleteTestaById(int id);
}
