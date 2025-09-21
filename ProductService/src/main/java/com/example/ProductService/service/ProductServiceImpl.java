package com.example.ProductService.service;

import com.example.ProductService.entity.Product;
import com.example.ProductService.exception.ProductServiceCustomException;
import com.example.ProductService.model.ProductRequest;
import com.example.ProductService.model.ProductResponse;
import com.example.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product...");
        Product product
                = Product.builder()
                .productName(productRequest.getProductName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();
        log.info("Product Added...");
        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("Getting Product By Id {}...",productId);
        Product product=productRepository.findById(productId)
                .orElseThrow(()->new ProductServiceCustomException("Product Not Found By Given Id","PRODUCT_NOT_FOUND"));

                ProductResponse productResponse=new ProductResponse();

                //Only use when all the properties of product and productResponse are same
                copyProperties(product,productResponse);
        return productResponse;

        //............ Other Way..............

//        return ProductResponse.builder()
//                .productId(product.getProductId())
//                .productName(product.getProductName())
//                .price(product.getPrice())
//                .quantity(product.getQuantity())
//                .build();
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce Quantity {} for Id: {} ",quantity,productId);
        Product product=productRepository.findById(productId)
                .orElseThrow(()->new ProductServiceCustomException("Product Not Found By Given Id","PRODUCT_NOT_FOUND"));

        if(product.getQuantity()<quantity){
            throw new ProductServiceCustomException("Product Quantity is Less than Given Quantity","INSUFFICIENT_PRODUCT_QUANTITY");
        }
        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);
        log.info("Product Quantity Updated Successfully");
    }
}
