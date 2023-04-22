package com.hdfk7.proto.base.exception;

import com.hdfk7.proto.base.result.ResultCode;

public class TokenInvalidException extends BaseException {
    public TokenInvalidException() {
        super(ResultCode.TOKEN_INVALID_ERROR);
    }
}
