package com.hdfk7.proto.base.model;

import cn.hutool.json.JSONUtil;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {
    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
