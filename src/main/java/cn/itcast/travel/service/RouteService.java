package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

/**
 * 线路业务逻辑层接口
 */
public interface RouteService {
    /**
     *分页查询线路
     * @param cid
     * @param userCurrentPage
     * @param pageSize
     * @return
     */
    PageBean<Route> pageQuery(String cid, int userCurrentPage, int pageSize);

    /**
     * 传讯线路详情信息
     * @param rid
     * @return
     */
//    Route findOne(String rid);
}
