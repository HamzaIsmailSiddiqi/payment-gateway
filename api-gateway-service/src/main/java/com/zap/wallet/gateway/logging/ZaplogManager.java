package com.zap.wallet.gateway.logging;

public class ZaplogManager {

    private static ZAPLog.LalogEnhancer enhancer;

    public static void setLogEnhancer(ZAPLog.LalogEnhancer enhancer) {
        ZaplogManager.enhancer = enhancer;
    }

    public static ZAPLog getLogger(Class<?> clazz) {
        return new ZAPLogLog4J2Impl(clazz, enhancer);
    }

    public static ZAPLog getLogger(String loggerName) {
        return new ZAPLogLog4J2Impl(loggerName, enhancer);
    }

}
