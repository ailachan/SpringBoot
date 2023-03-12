package com.example.controller;

import com.example.exception.BusinessException;
import com.example.pojo.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("all")
@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Result addProduct(@RequestBody Product product) {
        boolean flag = productService.addProduct(product);
        return new Result(flag ? Code.INTEGER_OK : Code.INSERT_ERR, flag);
    }

    @GetMapping
    public Result queryAllProduct() {
/*        try{
            int i = 1/0;
        }catch (Exception e){//捕获系统中已经预料到的某一代码的异常,转为SystemException自定义异常抛出,并用异常处理器进行进一步处理
            throw new SystemException(Code.SYSTEM_ERR,"系统异常请稍后在试");
        }*/
        List<Product> products = productService.queryAllProduct();
        Integer code = products != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = products != null ? "" : "查询失败";
        return new Result(code,msg,products);
    }

    @PutMapping
    public Result modifyProduct(@RequestBody Product product) {
        boolean flag = productService.modifyProduct(product);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{pid}")
    public Result deleteProductById(@PathVariable Integer pid) {
        boolean flag = productService.deleteProductById(pid);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{pid}")
    public Result queryByIdProduct(@PathVariable Integer pid) {
        if (pid < 0){//抛出已经预料到的业务异常
            throw new BusinessException(Code.BUSINESS_ERR,"业务异常,请您输入正确的网址");
        }
        Product product = productService.queryByIdProduct(pid);
        Integer code = product != null ? Code.QUERY_OK : Code.QUERY_ERR;
        String msg = product != null ? "" : "查询失败";
        return new Result(code,msg,product);
    }
}
