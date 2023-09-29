package com.zap.wallet.gateway.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:response_messages.properties")
public class ResponseMessagesConfig {

    @Autowired
    private Environment environment;

    public String getPropertyValue(String key) {
        return this.environment.getProperty(key);
    }

}
