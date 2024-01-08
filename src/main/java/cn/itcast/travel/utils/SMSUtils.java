package cn.itcast.travel.utils;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;

import java.util.Map;

public class SMSUtils {
    public static  final String AccessKeyID="LTAI5t8S5GwJt1NQyZyPFJqX";
    public static  final String AccessKeySecret="M5Hc63akjzKiOx4XwHWyMmOJfIUwhC";
    public static  final String SignName="品优购";
    public static  final String TemplateCode="SMS_142946316";
    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     *
     * 用户登录名称 henangongfcheng@1349930181259166.onaliyun.com
     * AccessKey ID LTAI5tNaHPoNrE9ePTGRGB2W
     * AccessKey Secret Bqu6415vnsX5cTvdTOfwqG01Kbigmk
     */
    public static Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        //1.创建配置类对象 设置阿里云短信参数 秘钥
        Config config = new Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // Endpoint 请参考 https://api.aliyun.com/product/Dysmsapi
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new Client(config);// 根基配置对象返回阿里云短信操作对象
    }

    /**
     * 阿里云短信发送
     * @param phone  手机号
     * @param code 验证码
     * @return
     * @throws Exception
     */
    public static Map<String,String> sendSms(String phone,String code) throws Exception {
        //1.调用静态方法 获取Client 对象
        Client client = createClient(AccessKeyID,AccessKeySecret);
        //2.创建阿里云短信的请求对象 设置请求参数 签名 模板 手机号 验证码
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName(SignName)
                .setTemplateCode(TemplateCode)
                .setPhoneNumbers(phone)
                .setTemplateParam("{\"code\":\""+code+"\"}");
        //3.获取阿里云短信执行对象
        RuntimeOptions runtime = new RuntimeOptions();
        SendSmsResponse resp = client.sendSmsWithOptions(sendSmsRequest, runtime);
        com.aliyun.teaconsole.Client.log(Common.toJSONString(resp));
        Map<String, Object> stringObjectMap = resp.toMap();
        Map<String, String> body = ( Map<String, String>)stringObjectMap.get("body");
        return body;
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> map = sendSms("18537082605", "1234");
        System.out.println(map);
    }


}
