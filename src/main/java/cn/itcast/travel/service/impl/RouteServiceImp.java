package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 线路的业务逻辑层
 */
@Service
public class RouteServiceImp implements RouteService {
    @Autowired
    private RouteDao routeDao;


    /**
     * 分页查询线路信息
     * @param cid
     * @param userCurrentPage
     * @param pageSize
     * @return
     */

    @Override
    public PageBean<Route> pageQuery(String cid, int userCurrentPage, int pageSize) {
        // 1.查询分页总记录数
        int totalCount = routeDao.findTotalCount(cid);

        if (totalCount<=0){
            return  new PageBean<Route>(0,0,userCurrentPage,pageSize,new ArrayList<Route>());
        }

        // 2. 计算总页数

        int totalPage = totalCount%pageSize ==0? totalCount/pageSize:(totalCount/pageSize)+1;

        //3当前页显示数
        //计算起始索引位置
        int start = (userCurrentPage - 1) *pageSize;
        Map map =new HashMap<>();
        map.put("cid",cid);
        map.put("start",start);
        map.put("pageSize",pageSize);
        List<Route> list = routeDao.findByPage(map);

        //4.封装分页对象，返回分页数据
        return new PageBean<>(totalCount,totalPage,userCurrentPage,pageSize,list);




    }

    /**
     * 查看香炉详细信息
     * @param rid
     * @return
     */
//    @Override
//    public Route findOne(String rid) {
//
//        //1 根据id查询线路基本信息
//        Route route =RouteDao.findById(rid);
//        if(route ==null){
//            return route;
//        }
//
//        //2 查询线路风景图集合
//
//
//
//        //3查询商家基本信息
//
//
//
//        //4获取天气信息
//
//
//
//        //5封装数据
//        return null;
//    }


}
