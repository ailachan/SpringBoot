package com.example.service;

import com.example.mapper.ProductMapper;
import com.example.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest//自动读取当前目录或子目录的启动类
public class ProduceServiceTest {
    @Autowired
    public ProductService productService;

    @Autowired
    public ProductMapper productMapper;

    @Test
    public void selectAll(){
        List<Product> products = productService.queryAllProduct();
        System.out.println(products.toString());
    }
    @Test
    public void selectById(){
        Product product = productService.queryByIdProduct(22);
        System.out.println(product.toString());
    }

    @Test
    public void selectById2(){
        Product product = productMapper.selectById2(22);
        System.out.println(product.toString());
    }

}
