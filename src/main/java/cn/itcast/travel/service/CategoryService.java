package cn.itcast.travel.service;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * 分类
 */
public interface CategoryService {

    List<Category> findAll();

}
