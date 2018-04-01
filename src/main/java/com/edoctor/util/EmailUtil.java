package com.edoctor.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Component
public class EmailUtil {


    @Autowired
    JavaMailSender mailSender;

    public void sendSimpleTextEmail(String from, String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    /**
     * send email to somebody with files in project directory, please notice your file root path is "/resource/emailAttachments"
     * @param from your emailAddress,should be the same as smtp server sender email address
     * @param to your destination address
     * @param subject email subject
     * @param text email body
     * @param attachmentsName attachment files name in "/resource/emailAttachments"
     * @throws MessagingException file may not in "/resource/emailAttachments" path or smtp server return bad response
     */
    public void sendEmailWithFile(String from, String to, String subject, String text, List<String> attachmentsName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        // multipart设置是否包含文件
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
        Iterator<String> attachmentsIterator = attachmentsName.iterator();
        while(attachmentsIterator.hasNext()) {
            String file = attachmentsIterator.next();
            helper.addAttachment(file, new ClassPathResource("/emailAttachments/" + file));
        }
        mailSender.send(message);
    }

}
