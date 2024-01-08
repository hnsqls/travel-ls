package cn.itcast.travel.service;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.SmsResult;
import cn.itcast.travel.domain.User;

/*
业务逻辑层接口 规范
 */
public interface UserService {
    /**
     * 发送短信验证码
     * @param telephone
     * @return  返回结果
     */
    SmsResult sendSmsCheckCode(String telephone);

    /**
     * 用户注册
     * @param user
     * @return
     */
    ResultInfo registered(User user);


    /**
     *
     * 登录
     * @param user
     * @return
     */
    ResultInfo login(User user);
}
