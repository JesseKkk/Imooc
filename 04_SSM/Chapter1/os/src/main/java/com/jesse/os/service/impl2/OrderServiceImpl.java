package com.jesse.os.service.impl2;

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
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private TransactionTemplate transactionTemplate;

    public void addOrder(final Order order) {
        order.setCreateTime(new Date());
        order.setStatus("待付款");

        transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try {
                    orderDao.insert(order);
                    Product product = productDao.select(order.getProductsId());
                    product.setStock(product.getStock()-order.getNumber());
                    productDao.update(product);
                } catch (TransactionException e) {
                    e.printStackTrace();
                    transactionStatus.setRollbackOnly();
                }
                return null;
            }
        });
    }
}
