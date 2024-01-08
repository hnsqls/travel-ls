package cn.itcast.travel.domain;

public class SmsResult {

    private int code; //响应状态吗 0 表示成功 1或者其他表示是把
    private String msg; //提示信息
    private Object result;//响应的数据


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public SmsResult(int code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public SmsResult() {
    }

    @Override
    public String toString() {
        return "SmsResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
