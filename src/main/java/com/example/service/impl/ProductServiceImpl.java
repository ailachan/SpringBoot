package com.example.service.impl;

import com.example.mapper.ProductMapper;
import com.example.pojo.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public boolean addProduct(Product product) {
        return productMapper.insertProduct(product)>0;//受影响的行数是否大于0
    }

    @Override
    public List<Product> queryAllProduct() {
        return productMapper.selectAll();
    }

    @Override
    public boolean modifyProduct(Product product) {
        return productMapper.updateProduct(product)>0;
    }

    @Override
    public boolean deleteProductById(Integer pid) {

        return productMapper.deleteById(pid)>0;
    }

    @Override
    public Product queryByIdProduct(Integer pid) {
        return productMapper.selectById(pid);
    }
}
