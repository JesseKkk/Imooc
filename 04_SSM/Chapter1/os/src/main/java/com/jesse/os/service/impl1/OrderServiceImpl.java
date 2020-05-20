package com.jesse.os.service.impl1;

import com.jesse.os.dao.OrderDao;
import com.jesse.os.dao.ProductDao;
import com.jesse.os.entity.Order;
import com.jesse.os.entity.Product;
import com.jesse.os.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private PlatformTransactionManager transactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    public void addOrder(Order order) {
        order.setCreateTime(new Date());
        order.setStatus("待付款");

        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

        try {
            orderDao.insert(order);
            Product product = productDao.select(order.getProductsId());
            product.setStock(product.getStock()-order.getNumber());
            productDao.update(product);
            transactionManager.commit(transactionStatus);
        } catch (TransactionException e) {
            transactionManager.rollback(transactionStatus);
            e.printStackTrace();
        }
    }
}
