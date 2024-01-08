package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/*
用户持久层
 */
@Mapper
public interface UserDao {

    /**
     *
     * @param username
     * @return
     */
    @Select("select * from tab_user where username =#{username}")
    User findUserByUsername(String username);


    /**
     * 保存用户信息
     * @param user 用户信息
     * @return  返回几条数据受影响
     */
    @Insert("insert into tab_user (username,password,name,birthday,sex,telephone,email)values(#{username},#{password},#{name},#{birthday},#{sex},#{telephone},#{email})")
    int insertUser(User user);
}
