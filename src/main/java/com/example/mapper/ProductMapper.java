package com.example.mapper;

import com.example.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@SuppressWarnings("all")
@Mapper
public interface ProductMapper {

    @Insert("insert into product (pid,pname, pprice, pnum) values (null,#{pname},#{pprice},#{pnum});")
    public int insertProduct(Product product);

    @Select("select * from product;")
    public List<Product> selectAll();

    @Update("update product set PNAME = #{pname},PPRICE = #{pprice},PNUM = #{pnum} where PID = #{pid};")
    public int updateProduct(Product product);

    @Delete("delete from product where PID = #{id};")
    public int deleteById(Integer id);

    @Select("select * from product where PID = #{id};")
    public Product selectById(Integer id);

    public Product selectById2(Integer id);
}
