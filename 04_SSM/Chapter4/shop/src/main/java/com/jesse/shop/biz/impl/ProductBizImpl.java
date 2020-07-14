package com.jesse.shop.biz.impl;

import com.jesse.shop.biz.ProductBiz;
import com.jesse.shop.dao.ProductDao;
import com.jesse.shop.dao.ProductImgDao;
import com.jesse.shop.dto.ImageHolder;
import com.jesse.shop.dto.ProductExecution;
import com.jesse.shop.entity.Product;
import com.jesse.shop.entity.ProductImg;
import com.jesse.shop.enums.ProductStateEnum;
import com.jesse.shop.exceptions.ProductOperationException;
import com.jesse.shop.util.ImageUtil;
import com.jesse.shop.util.PageCalculator;
import com.jesse.shop.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kong on 2020/6/29.
 */
@Service("productBiz")
public class ProductBizImpl implements ProductBiz {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;

    //1、处理缩略图，获取缩略图相对路径并赋值给product
    //2、往tb_product写入商品信息，获取productId
    //3、结合productId批量处理商品详情图
    //4、将商品详情图列表批量插入tb_product_img中

    @Transactional
    public ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList) throws ProductOperationException {
       if (product != null && product.getStore() != null && product.getStore().getStoreId() != null){
            //给商品设置上默认属性
           product.setCreateTime(new Date());
           product.setLastEditTime(new Date());
           //默认为上架状态
           product.setEnableStatus(1);
           //若商品缩略图不为空则添加
           if (thumbnail != null){
               addThumbnail(product, thumbnail);
           }
           try{
               //创建商品信息
               int effectedNum = productDao.insertProduct(product);
               if (effectedNum <= 0){
                   throw  new ProductOperationException("创建商品失败");
               }
           }catch (Exception e){
               throw new ProductOperationException("创建商品失败：" + e.toString());
           }
           //若商品详情图不为空则添加
           if (productImgHolderList != null && productImgHolderList.size() > 0){
               addproductImgList(product,productImgHolderList);
           }
           return new ProductExecution(ProductStateEnum.SUCCESS, product);
       }else {
           //传参为空则返回空值错误信息
           return new ProductExecution(ProductStateEnum.EMPTY);
       }
    }

    @Transactional(readOnly = true)
    public Product getProductById(long productId) {
        return productDao.queryProductById(productId);
    }

    //1、若缩略图参数有值，则处理缩略图
    //若原先存放在缩略图则先删除在添加新图，之后获取缩略图相对路径并赋值给product
    //2、若商品详情图列表有值，对商品详情图片列表进行同样的操作
    //3、将tb_product_img下面的该商品原先的商品详情图记录全部清除
    //4、更新tb_product_img以及tb_product的信息
    @Transactional
    public ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList) throws ProductOperationException {
        //空值判断
        if (product != null && product.getStore() != null && product.getStore().getStoreId() != null){
            //给商品设置上默认属性
            product.setLastEditTime(new Date());
            //若商品缩略图不为空且原有缩略图不为空则删除原有缩略图并添加
            if (thumbnail != null){
                //先获取一遍原有信息，因为原有的信息里有原图片地址
                Product tempProduct = productDao.queryProductById(product.getProductId());
                if (tempProduct.getImgAddr() != null){
                    ImageUtil.deleteFileOrPath(tempProduct.getImgAddr());
                }
                addThumbnail(product, thumbnail);
            }
            //如果有新存入的商品详情图，则将原先的删除，并添加新的图片
            if (productImgHolderList != null && productImgHolderList.size() > 0){
                deleteProductImgList(product.getProductId());
                addproductImgList(product,productImgHolderList);
            }
            try{
                //更新商品信息
                int effectedNum = productDao.updateProduct(product);
                if (effectedNum <= 0){
                    throw new ProductOperationException("更新商品信息失败");
                }
                return new ProductExecution(ProductStateEnum.SUCCESS,product);
            }catch (Exception e){
                throw new ProductOperationException("更新商品信息失败：" + e.toString());
            }
        }else {
            return new ProductExecution(ProductStateEnum.EMPTY);
        }
    }

    @Transactional(readOnly = true)
    public ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize) {
        //页码转换为数据库的行码，并调用dao层取回指定页码的商品列表
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        List<Product> productList = productDao.queryProductList(productCondition, rowIndex, pageSize);
        //基于同样的查询条件查询该查询条件下的商品总数
        int count = productDao.queryProductCount(productCondition);
        ProductExecution pe = new ProductExecution();
        pe.setProductList(productList);
        pe.setCount(count);
        return pe;
    }

    private void addThumbnail(Product product, ImageHolder thumbnail) {
        //获取store图片目录的相对值路径
        String dest = PathUtil.getStoreImagePath(product.getStore().getStoreId());
        String thumbnailAddr = ImageUtil.generateThumbnail(thumbnail,dest);
        product.setImgAddr(thumbnailAddr);
    }


    private void addproductImgList(Product product, List<ImageHolder> productImgHolderList) {
        String dest = PathUtil.getStoreImagePath(product.getStore().getStoreId());
        List<ProductImg> productImgList = new ArrayList<ProductImg>();
        //遍历图片一次去处理，并添加进productImg实体类中
        for (ImageHolder productImgHolder : productImgHolderList){
            String imgAddr = ImageUtil.generateNormalImg(productImgHolder,dest);
            ProductImg productImg = new ProductImg();
            productImg.setImgAddr(imgAddr);
            productImg.setProductId(product.getProductId());
            product.setCreateTime(new Date());
            productImgList.add(productImg);
        }
        //如果确实是有图片需要添加的，就执行批量添加操作
        if (productImgList.size() > 0){
            try{
                int effectedNum = productImgDao.batchInsertProductImg(productImgList);
                if (effectedNum <= 0){
                    throw new ProductOperationException("创建商品详情图片失败");
                }
            }catch (Exception e){
                throw new ProductOperationException("创建商品详情图片失败：" + e.toString());
            }
        }
    }

    private void deleteProductImgList(long productId){
        List<ProductImg> productImgList = productImgDao.queryProductImgList(productId);
        //删除原来的图片
        for (ProductImg productImg : productImgList){
            ImageUtil.deleteFileOrPath(productImg.getImgAddr());
        }
        //删除数据库原来有的图片的信息
        productImgDao.deleteProductImgByProductId(productId);
    }
}
