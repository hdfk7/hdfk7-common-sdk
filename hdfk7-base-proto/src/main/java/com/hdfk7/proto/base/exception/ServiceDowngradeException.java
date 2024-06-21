package com.hdfk7.proto.base.exception;

import com.hdfk7.proto.base.result.ResultCode;

public class ServiceDowngradeException extends BaseException {
    public ServiceDowngradeException() {
        super(ResultCode.SERVICE_DOWNGRADE_ERROR);
    }
}
