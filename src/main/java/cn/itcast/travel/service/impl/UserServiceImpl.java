package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.SmsResult;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.utils.SMSUtils;
import cn.itcast.travel.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用户业务逻辑层
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public SmsResult sendSmsCheckCode (String telephone){

        //1.调用工具类生成验证码
        String code = ValidateCodeUtils.generateValidateCode(6) +"";

        //调用阿里云发送短信
        Map<String , String > map =null;
        try {
            map = SMSUtils.sendSms(telephone,code);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(map != null&&map.get("Code").equals("OK")){
            return  new SmsResult(0,"短信发送成果",code);
        }
        return  new SmsResult(1,"短信发送失败","");
    }


    /**
     * 用户注册
     * @param user
     * @return 注册结果
     */
    public ResultInfo registered (User user){
        //1.校验用户是否存在
        User u = userDao.findUserByUsername(user.getUsername());
        if (u != null){
            return  new ResultInfo(false,"用户名已经存在");
        }
        //2.保存用户信息
        int i = userDao.insertUser(user);

        if (i <= 0) {
            return  new ResultInfo(false,"注册失败");
        }
        return  new ResultInfo(true,"注册成功");

    }

    /**
     * 登录功能
     * @param user
     * @return
     */
    @Autowired
    private HttpSession session;
    @Override
    public ResultInfo login(User user) {
        //1.校验用户名是否存在
        User u = userDao.findUserByUsername(user.getUsername());
        if (u == null)
        {
            return new ResultInfo(false,"用户名输入错误");
        }
        //2,校验密码是否正确
        if (!u.getPassword().equals(user.getPassword())){
            return  new ResultInfo(false,"输入的密码错误");
        }

        //3 保存用户信息到session
        session.setAttribute("user",u);
        return  new ResultInfo(true,"登录成功");
    }

}
