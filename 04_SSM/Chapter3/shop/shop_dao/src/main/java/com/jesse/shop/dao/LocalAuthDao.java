package com.jesse.shop.dao;

import com.jesse.shop.entity.LocalAuth;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Kong on 2020/7/10.
 */
@Repository("localAuthDao")
public interface LocalAuthDao {
    LocalAuth queryLocalByUserNameAndPwd(@Param("username") String username, @Param("password") String password);

}
