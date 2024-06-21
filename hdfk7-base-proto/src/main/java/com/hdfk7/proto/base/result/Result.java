package com.hdfk7.proto.base.result;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Getter
@Schema(description = "响应实体")
public class Result<T> implements Serializable {
    @Schema(description = "响应CODE")
    private int code;
    @Schema(description = "响应提示信息")
    private String msg;
    @Schema(description = "响应数据")
    private T data;

    public Result() {
        this(ResultCode.SUCCESS);
    }

    public Result(ResultCode resultCode) {
        this(resultCode, null);
    }

    public Result(ResultCode resultCode, String message) {
        this(resultCode, message, null);
    }

    public Result(ResultCode resultCode, String message, T data) {
        bindCode(resultCode.getCode()).bindMsg(StringUtils.isEmpty(message) ? resultCode.getMsg() : message).bindData(data);
    }

    public Result<T> bindData(T data) {
        this.data = data;
        return this;
    }

    public Result<T> bindMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result<T> bindCode(int code) {
        this.code = code;
        return this;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == ResultCode.SUCCESS.getCode();
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
