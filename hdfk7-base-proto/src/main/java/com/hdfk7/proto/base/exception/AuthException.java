package com.hdfk7.proto.base.exception;

import com.hdfk7.proto.base.result.ResultCode;

public class AuthException extends BaseException {
    public AuthException() {
        super(ResultCode.AUTH_ERROR);
    }
}
