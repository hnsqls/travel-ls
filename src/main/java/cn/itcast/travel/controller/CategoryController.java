package cn.itcast.travel.controller;


import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 分类的控制层
 */
@RestController   // = @Controller +@ResponseBody
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查询导航栏信息
     */
    @GetMapping("/findAll")
    public  List<Category> findAll(){
        List<Category> list = categoryService.findAll();
        return list;
    }

}
