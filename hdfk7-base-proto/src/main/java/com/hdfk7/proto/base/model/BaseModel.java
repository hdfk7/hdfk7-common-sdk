package com.hdfk7.proto.base.model;

import com.hdfk7.proto.base.util.JsonUtil;

public abstract class BaseModel {
    @Override
    public String toString() {
        return JsonUtil.toJsonStr(this);
    }
}
