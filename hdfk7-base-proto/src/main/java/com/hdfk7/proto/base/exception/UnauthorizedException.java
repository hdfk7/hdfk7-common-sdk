package com.hdfk7.proto.base.exception;

import com.hdfk7.proto.base.result.ResultCode;

public class UnauthorizedException extends BaseException {
    public UnauthorizedException() {
        super(ResultCode.UNAUTHORIZED_ERROR);
    }
}
