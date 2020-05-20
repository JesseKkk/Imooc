package com.jesse.os.dao;

import com.jesse.os.entity.Order;

import java.util.List;

public interface OrderDao {
    void insert(Order order);
    void update(Order order);
    void delete(String id);
    Order select(String id);
    List<Order> select();
}
