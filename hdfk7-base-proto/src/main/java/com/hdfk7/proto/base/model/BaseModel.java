package com.hdfk7.proto.base.model;

import cn.hutool.json.JSONUtil;

public abstract class BaseModel {
    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
