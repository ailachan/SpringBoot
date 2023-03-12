package com.example.service;

import com.example.pojo.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//事务的bean配置在配置数据源后springboot已自动配置,直接添加此注解即可直接使用
@Transactional//为每一个方法上添加一个事务,发生异常回滚,前提是异常没有被手动tryCatch
public interface ProductService {

    public boolean addProduct(Product product);

    public List<Product> queryAllProduct();

    public boolean modifyProduct(Product product);

    public boolean deleteProductById(Integer pid);

    public Product queryByIdProduct(Integer pid);
}
