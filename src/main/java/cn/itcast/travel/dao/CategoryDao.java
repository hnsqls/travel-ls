package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 分类持久层
 */
@Mapper
public interface CategoryDao {

    /**
     * 查询所有分类信息
     * @return
     */
    @Select("select * from tab_category order by cid")
    List<Category> findAll();
}
