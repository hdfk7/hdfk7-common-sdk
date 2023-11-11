package com.hdfk7.proto.base.result;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;

import java.util.List;

public enum ResultCode {
    SYS_ERROR(-1, "前方道路拥挤，请稍后再试！"),
    SUCCESS(0, "成功"),
    AUTH_ERROR(1, "登录失败，请检查用户名和密码是否匹配！"),
    RESUBMIT_ERROR(2, "重复请求，已忽略！"),
    SERVER_REMOTE_CALL_ERROR(3, "服务远程调用异常"),
    TOKEN_INVALID_ERROR(4, "无效的令牌"),
    SERVICE_DOWNGRADE(5, "流量过载，服务降级！"),
    WE_CHAT_MINI_LOGIN_ERROR(6, "微信授权登录失败"),
    ;

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        bindCode(code).bindMsg(msg);
    }

    public ResultCode bindMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResultCode bindCode(int code) {
        this.code = code;
        return this;
    }

    public <T> Result<T> bindResult(Result<T> result) {
        return result.bindCode(this.code).bindMsg(this.msg);
    }

    public <T> Result<T> bindResult(T data) {
        return new Result<T>().bindCode(this.code).bindMsg(this.msg).bindData(data);
    }

    public <T> Result<T> bindResult(Object data, Class<T> clazz) {
        T o = JSONUtil.toBean(JSONUtil.toJsonStr(data), clazz);
        return new Result<T>().bindCode(this.code).bindMsg(this.msg).bindData(o);
    }

    public <T> Result<List<T>> bindResult(List<?> data, Class<T> clazz) {
        List<T> o = JSONUtil.toList(JSONUtil.toJsonStr(data), clazz);
        return new Result<List<T>>().bindCode(this.code).bindMsg(this.msg).bindData(o);
    }

    public <T> Result<Page<T>> bindResult(PageDTO<?> page, Class<T> clazz) {
        List<T> list = JSONUtil.toList(JSONUtil.toJsonStr(page.getRecords()), clazz);
        page.setRecords(null);
        //noinspection unchecked
        Page<T> o = JSONUtil.toBean(JSONUtil.toJsonStr(page), Page.class);
        o.setRecords(list);
        return new Result<Page<T>>().bindCode(this.code).bindMsg(this.msg).bindData(o);
    }

    public <T> Result<T> bindResult() {
        return bindResult((T) null);
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
