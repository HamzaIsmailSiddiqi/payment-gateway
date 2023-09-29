package com.zap.wallet.common.exceptions;

import com.zap.wallet.common.exceptions.config.ErrorCode;

public class ZAPException extends RuntimeException {

    private String errorCode;

    private String errorMessageKey;

    public ZAPException(String errorCode, String errorMessageKey) {
        this.errorCode = errorCode;
        this.errorMessageKey = errorMessageKey;
    }

    public ZAPException(String errorCode, String errorMessageKey, Throwable cause) {
        super(errorMessageKey, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessageKey() {
        return errorMessageKey;
    }

}
