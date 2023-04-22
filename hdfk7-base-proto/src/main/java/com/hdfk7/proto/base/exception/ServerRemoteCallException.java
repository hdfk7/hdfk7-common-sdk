package com.hdfk7.proto.base.exception;

import com.hdfk7.proto.base.result.ResultCode;

public class ServerRemoteCallException extends BaseException {
    public ServerRemoteCallException() {
        super(ResultCode.SERVER_REMOTE_CALL_ERROR);
    }
}
