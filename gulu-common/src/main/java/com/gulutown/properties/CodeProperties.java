package com.gulutown.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "code.generate")
@Data
public class CodeProperties {
    private Integer length;
    private Integer timestampDigits;
    private String CharSet;
}
