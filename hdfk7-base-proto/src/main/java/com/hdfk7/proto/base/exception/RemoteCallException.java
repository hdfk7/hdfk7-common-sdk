package com.hdfk7.proto.base.exception;

import com.hdfk7.proto.base.result.ResultCode;

public class RemoteCallException extends BaseException {
    public RemoteCallException() {
        super(ResultCode.REMOTE_CALL_ERROR);
    }
}
