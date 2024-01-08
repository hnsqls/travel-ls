package cn.itcast.travel.controller;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.SmsResult;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import org.ini4j.spi.RegEscapeTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 发送短信验证码
     * @param  telephone 手机号
     * @return 响应结果
     */
    @GetMapping("/sendSmsCheckCode")
    @ResponseBody //设置参数为json
    public SmsResult sendSmsCheckCode(String telephone){
        //1.校验手机号是否合法
        if(telephone.equals("") || telephone==null){
           return new SmsResult(1 ,"手机号不合法重新输入","");
        }
        //2调用业务逻辑层
        SmsResult smsResult = userService.sendSmsCheckCode(telephone);

        //3.返回业务逻辑处理结果
        return  smsResult;
    }

    /**
     * 用户注册
     * @param user
     * @param checkCodeKey
     * @param check
     * @return
     */
    @PostMapping("/registered")
    @ResponseBody
    public ResultInfo registered(User user, String checkCodeKey, String check){
        //1.校验验证码正确
        if (!check.equals(checkCodeKey)){
            //验证码不正确进入if
            return new ResultInfo(false,"验证码错误");
        }

        //2.调用业务逻辑层进行注册业务逻辑处理
        ResultInfo resultInfo = userService.registered(user);

        //3.返回注册结果到前端
        return  resultInfo;
    }

    /**
     * 登录
     * @param user
     * @param check
     * @param session
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public  ResultInfo login(User user, String check, HttpSession session){
        //1.校验验证码获取session中随机图片验证码
        String check_code = (String)session.getAttribute("CHECK_CODE");
        if (!(check != null &&check.equalsIgnoreCase(check_code))){
            //验证码不合法
            return  new ResultInfo(false,"验证码不合法");
        }

        //2 调用业务逻辑层进行登录判断
        ResultInfo resultInfo = userService.login(user);

        //3 返回结果
        return  resultInfo;

    }

    /**
     * 登录用户回显
     */
    @GetMapping("/findOne")
    @ResponseBody
    public  User findOne(HttpSession session){
        User user = (User)session.getAttribute("user" );
        //2.响应登录信息
        return user;

    }


    @GetMapping("/exit")
    public  String exit (HttpSession session){
        //1.销毁session中的登录对象
        session.removeAttribute("user");

        //2. 重定向，跳转到登录页面
        return "redirect:/login.html";
    }

}
