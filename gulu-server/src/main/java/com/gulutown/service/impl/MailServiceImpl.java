package com.gulutown.service.impl;

import com.gulutown.constant.EmailCodeMessage;
import com.gulutown.exception.EmailSendException;
import com.gulutown.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;
    @Value("${spring.mail.username}")
    private String sendMail;


    /**
     * 发送纯文本数据
     * @param to 发送目标地址
     * @param subject 主题
     * @param text 内容
     */
    public void sendTextMessage(String to,String subject,String text) {
        try {
            // true表示可以支持复杂类型
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(javaMailSenderImpl.createMimeMessage(),true);
            // 邮件发送地址
            mimeMessageHelper.setFrom(sendMail);
            // 目标地址
            mimeMessageHelper.setTo(to.split(","));
            // 邮件主题
            mimeMessageHelper.setSubject(subject);
            // 邮件内容
            mimeMessageHelper.setText(text);
            // 发送时间
            mimeMessageHelper.setSentDate(new Date());

            // 发送
            javaMailSenderImpl.send(mimeMessageHelper.getMimeMessage());
            log.info("邮件发送成功：{}",to);
        } catch (MessagingException e) {
            throw new EmailSendException(EmailCodeMessage.CODE_SEND_LOSE);
        }

    }
}
