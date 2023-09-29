package com.zap.payment.user.service.exceptions;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@CustomLog
public
class ErrorCode {

    // Let's cache the codes, we could dump them all for the client when needed
    private volatile static Map<String, ErrorCode> codes;

    static {
        codes = new HashMap<>();
    }

    public static final ErrorCode INTERNAL_ERROR = of("internal", "Encountered an unexpected internal problem.");
    public static ErrorCode INVALID_PARAMETER = of("invalid_parameter", "Invalid parameter");
    public static ErrorCode OTP_MISMATCH = of("otp_mismatch", "OTP does not match with the actual OTP");

    private static ErrorCode of(String key, String message) {
        if (codes == null) {
            codes = new HashMap<>();
        }
        return codes.computeIfAbsent(key, (k) -> new ErrorCode(k, message, null));
    }

    String key;
    String message;
    String param;

    public static void main(String[] args) {
        codes.keySet().stream().sorted().forEach(k -> System.out.printf("%s,\"%s\"%n", k, codes.get(k).getMessage()));
    }

}
