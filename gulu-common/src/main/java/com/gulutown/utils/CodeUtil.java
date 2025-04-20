package com.gulutown.utils;

import com.gulutown.properties.CodeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class CodeUtil {
    private final CodeProperties config;
    private final Random random = new SecureRandom();
    private final Set<String> generatedCodes = Collections.synchronizedSet(new HashSet<>());

    @Autowired
    public CodeUtil(CodeProperties config) {
        this.config = config;
    }

    public String generate() {
        String code;
        do {
            code = buildCode();
        } while (generatedCodes.contains(code));

        generatedCodes.add(code);
        return code;
    }

    private String buildCode() {
        StringBuilder sb = new StringBuilder();
        // 时间戳部分
        long ts = System.currentTimeMillis() % (long) Math.pow(10, config.getTimestampDigits());
        sb.append(String.format("%0" + config.getTimestampDigits() + "d", ts));

        // 随机字符部分
        for (int i = 0; i < config.getLength() - config.getTimestampDigits(); i++) {
            sb.append(config.getCharSet().charAt(random.nextInt(config.getCharSet().length())));
        }
        return sb.toString();
    }
}
