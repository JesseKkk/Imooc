package com.jesse.os.service.impl6;

import com.jesse.os.dao.OrderDao;
import com.jesse.os.dao.ProductDao;
import com.jesse.os.entity.Order;
import com.jesse.os.entity.Product;
import com.jesse.os.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addOrder(Order order) {
        order.setCreateTime(new Date());
        order.setStatus("待付款");

        orderDao.insert(order);
        Product product = productDao.select(order.getProductsId());
        product.setStock(product.getStock()-order.getNumber());
        productDao.update(product);
    }
}
