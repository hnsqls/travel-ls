package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 线路持久层
 */
@Mapper
public interface RouteDao {
    /**
     * 查询总记录数
     * @param cid
     * @return
     */
    @Select("select count(*) from tab_route where cid = #{cid}")
    int findTotalCount(String cid);
    /**
     * 分页查询
     * @param map
     * @return
     */
    @Select("select * from tab_route where cid = #{cid} limit #{start},#{pageSize}")
    List<Route> findByPage(Map map);
}
