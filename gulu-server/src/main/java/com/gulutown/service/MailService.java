package com.gulutown.service;

public interface MailService {

    /**
     * 发送纯文本数据
     * @param to 发送目标地址
     * @param subject 主题
     * @param text 内容
     */
    void sendTextMessage(String to,String subject,String text);
}
