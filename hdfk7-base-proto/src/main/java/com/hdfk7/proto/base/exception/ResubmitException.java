package com.hdfk7.proto.base.exception;

import com.hdfk7.proto.base.result.ResultCode;

public class ResubmitException extends BaseException {
    public ResubmitException() {
        super(ResultCode.RESUBMIT_ERROR);
    }
}
