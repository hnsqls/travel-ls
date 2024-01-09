package cn.itcast.travel.controller;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private RouteService routeService;

    /**
     * 分页查询线路信息
     * @param cid
     * @param currentPage
     * @param size
     * @return
     */
    @GetMapping("/pageQuery")
    public PageBean<Route> pageQuery(String cid, String currentPage,String size){
        // 1.进行参数处理
        int userCurrentPage = 1; //设置当前页默认值为1， 如果前端没有传输过来，当前页面就用默认第一页查询
        if(!StringUtils.isEmpty(currentPage)){
            //不等于空
            userCurrentPage =Integer.parseInt(currentPage)>=1?Integer.parseInt(currentPage):1;
        }
        int pageSize = 5;
        if (!StringUtils.isEmpty(size)){
            pageSize = Integer.parseInt(size)>=1?Integer.parseInt((size)) :5;

        }

        // 2 调用业务逻辑层 ，进行分页查询
        PageBean<Route> pageBean =routeService.pageQuery(cid,userCurrentPage,pageSize);
        return  pageBean;


    }



//    public  Route findOne(String rid){
//        //1 校验rid
//        if (rid == null){
//            return  new Route();
//        }
//        //2调用业务罗杰，查询线路详情
//        Route route = routeService.findOne(rid);
//
//    }

}
