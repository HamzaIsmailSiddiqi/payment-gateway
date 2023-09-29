package com.zap.payment.user.service.utils;

public class ValidationUtil {

    public static StringBuilder doValidate(StringBuilder sb, final String fieldTitle, final String fieldValue,
                                           final int maxFieldSize, final int minFieldSize, boolean isLengthCheckRequired) {

        isNullOrEmpty(fieldTitle, fieldValue, sb);
        if (isLengthCheckRequired) {
            if (isLesserThanMinSize(fieldValue, maxFieldSize)) {
                sb.append(fieldTitle).append(" cannot be Lesser than ").append(minFieldSize).append(" characters.\n");
            } else if (isGreaterThanMaxSize(fieldValue, maxFieldSize)) {
                sb.append(fieldTitle).append(" cannot be Greater than ").append(maxFieldSize).append(" characters.\n");
            }
        }
        return sb;
    }

    public static void isNullOrEmpty(String fieldTitle, String value, StringBuilder sb) {
        if (value == null || value.equals("")) {
            sb.append(fieldTitle).append(" cannot be Empty.\n");
        }
    }

    private static Boolean isGreaterThanMaxSize(String value, int size) {
        return value.length() > size ? true : false;
    }

    private static Boolean isLesserThanMinSize(String value, int size) {
        return value.length() > size ? true : false;
    }


}
