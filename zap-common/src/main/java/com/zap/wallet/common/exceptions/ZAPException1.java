package com.zap.wallet.common.exceptions;

import com.zap.wallet.common.exceptions.config.ErrorCode;

import static java.lang.String.format;

public class ZAPException1 extends RuntimeException {

    protected ErrorCode errorCode;


    public ZAPException1(ErrorCode errorCode) {
        this(errorCode, errorCode.getMessage(), null);
    }

    public ZAPException1(ErrorCode errorCode, String message) {
        this(errorCode, message, null);
    }

    public ZAPException1(ErrorCode errorCode, Throwable cause) {
        this(errorCode, errorCode.getMessage(), cause);
    }

    public ZAPException1(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }


    public static class InvalidParameter extends ZAPException1 {

        public InvalidParameter(String paramName) {
            super(enhanceErrorCode(ErrorCode.INVALID_PARAMETER, paramName), format("Invalid parameter %s", paramName), null);
        }

        public InvalidParameter(String paramName, String message) {
            super(enhanceErrorCode(ErrorCode.INVALID_PARAMETER, paramName), message, null);
        }

        public InvalidParameter(String paramName, String message, Object... args) {
            super(enhanceErrorCode(ErrorCode.INVALID_PARAMETER, paramName), format(message, args), null);
        }

        public InvalidParameter(String paramName, String message, Throwable t, Object... args) {
            super(enhanceErrorCode(ErrorCode.INVALID_PARAMETER, paramName), format(message, args), t);
        }

        public InvalidParameter(ErrorCode errorCode, String paramName) {
            super(enhanceErrorCode(errorCode, paramName), format("Invalid parameter %s", paramName), null);
        }

        public InvalidParameter(ErrorCode errorCode, String paramName, String message) {
            super(enhanceErrorCode(errorCode, paramName), message, null);
        }

        public InvalidParameter(ErrorCode errorCode, String paramName, String message, Object... args) {
            super(enhanceErrorCode(errorCode, paramName), format(message, args), null);
        }

        public InvalidParameter(ErrorCode errorCode, String paramName, String message, Throwable t, Object... args) {
            super(enhanceErrorCode(errorCode, paramName), format(message, args), t);
        }

        private static ErrorCode enhanceErrorCode(ErrorCode errorCode, String paramName) {
            return ErrorCode.builder()
                .key(errorCode.getKey())
                .message(errorCode.getMessage())
                .param(paramName).build();
        }
    }

    public static class AuthenticationFailure extends ZAPException1 {
        public AuthenticationFailure(ErrorCode errorCode) {
            super(errorCode, errorCode.getMessage(), null);
        }

        public AuthenticationFailure(ErrorCode errorCode, String message) {
            super(errorCode, message);
        }

        public AuthenticationFailure(ErrorCode errorCode, String message, Throwable t) {
            super(errorCode, message, t);
        }
    }

    public static class NotFound extends ZAPException1 {
        public NotFound(ErrorCode errorCode, String message) {
            super(errorCode, message);
        }

        public NotFound(ErrorCode errorCode, String message, Throwable t) {
            super(errorCode, message, t);
        }
    }

    public static class NotAllowed extends ZAPException1 {
        public NotAllowed(ErrorCode errorCode) {
            super(errorCode);
        }

        public NotAllowed(ErrorCode errorCode, String message) {
            super(errorCode, message);
        }

        public NotAllowed(ErrorCode errorCode, String message, Throwable t) {
            super(errorCode, message, t);
        }
    }

    public static class MissingExternalCredential extends ZAPException1 {
        public MissingExternalCredential(ErrorCode errorCode) {
            super(errorCode);
        }

        public MissingExternalCredential(ErrorCode errorCode, String message) {
            super(errorCode, message);
        }

        public MissingExternalCredential(ErrorCode errorCode, String message, Throwable t) {
            super(errorCode, message, t);
        }
    }

}

