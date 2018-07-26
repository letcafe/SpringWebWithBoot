package com.edoctor.api;

import com.edoctor.bean.RestMessage;
import com.edoctor.enums.EMAIL_LOCALE;
import com.edoctor.service.EmailService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;

import java.util.Locale;

@Api(value = "消息队列统计及操作API")
@RestController
@RequestMapping("/api/v1/email")
public class EmailApi {

    private EmailService emailService;

    @Autowired
    EmailApi(EmailService emailService) {
        this.emailService = emailService;
    }

    @ApiOperation(value = "发送一封纯文本邮件", httpMethod = "POST", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/textEmail", method = RequestMethod.POST, produces = "application/json")
    public RestMessage<String> textEmail(
            @ApiParam(name = "recipientEmail", required = true, value = "邮箱地址") @RequestParam(name = "recipientEmail", defaultValue = "letcafe@outlook.com") String recipientEmail,
            @ApiParam(name = "subject", required = true, value = "邮件标题") @RequestParam(name = "subject") String subject,
            @ApiParam(name = "recipientName", required = true, value = "接受邮件人的亲切称呼") @RequestParam(name = "recipientName") String recipientName,
            @ApiParam(name = "locale", required = true, value = "所在国家语言环境") @RequestParam(name = "locale") EMAIL_LOCALE locale
            ) throws MessagingException {
        RestMessage<String> restMessage = new RestMessage<>();
        Locale emailLocale = new Locale(locale.toString(),"");
        emailService.sendTextMail(recipientEmail, subject, recipientName, emailLocale);
        restMessage.setCode(200).setMsg("success").setData(null);
        return restMessage;
    }

    @ApiOperation(value = "发送一封简单的HTML邮件", httpMethod = "POST", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/simpleEmail", method = RequestMethod.POST, produces = "application/json")
    public RestMessage<String> simpleEmail(
            @ApiParam(name = "recipientEmail", required = true, value = "邮箱地址") @RequestParam(name = "recipientEmail", defaultValue = "letcafe@outlook.com") String recipientEmail,
            @ApiParam(name = "subject", required = true, value = "邮件标题") @RequestParam(name = "subject") String subject,
            @ApiParam(name = "recipientName", required = true, value = "接受邮件人的亲切称呼") @RequestParam(name = "recipientName") String recipientName,
            @ApiParam(name = "locale", required = true, value = "所在国家语言环境") @RequestParam(name = "locale") EMAIL_LOCALE locale
    ) throws MessagingException {
        RestMessage<String> restMessage = new RestMessage<>();
        Locale emailLocale = new Locale(locale.toString(),"");
        emailService.sendSimpleMail(recipientEmail, subject, recipientName, emailLocale);
        restMessage.setCode(200).setMsg("success").setData(null);
        return restMessage;
    }

    @ApiOperation(value = "发送一封带附件的电子邮件", httpMethod = "POST", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/attachmentEmail", method = RequestMethod.POST, produces = "application/json")
    public RestMessage<String> attachmentEmail(
            @ApiParam(name = "recipientEmail", required = true, value = "邮箱地址") @RequestParam(name = "recipientEmail", defaultValue = "letcafe@outlook.com") String recipientEmail,
            @ApiParam(name = "subject", required = true, value = "邮件标题") @RequestParam(name = "subject") String subject,
            @ApiParam(name = "recipientName", required = true, value = "接受邮件人的亲切称呼") @RequestParam(name = "recipientName") String recipientName,
            @ApiParam(name = "file", required = true, value = "发送的附件") @RequestParam(name = "file") MultipartFile file,
            @ApiParam(name = "locale", required = true, value = "所在国家语言环境") @RequestParam(name = "locale") EMAIL_LOCALE locale
    ) throws MessagingException, IOException {
        RestMessage<String> restMessage = new RestMessage<>();
        Locale emailLocale = new Locale(locale.toString(),"");
        emailService.sendMailWithAttachment(
                recipientEmail, subject, recipientName, file.getOriginalFilename(),
                file.getBytes(), file.getContentType(), emailLocale);
        restMessage.setCode(200).setMsg("success").setData(null);
        return restMessage;
    }

    @ApiOperation(value = "发送内联图片的电子邮件", httpMethod = "POST", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/inlineEmail", method = RequestMethod.POST, produces = "application/json")
    public RestMessage<String> inlineEmail(
            @ApiParam(name = "recipientEmail", required = true, value = "邮箱地址") @RequestParam(name = "recipientEmail", defaultValue = "letcafe@outlook.com") String recipientEmail,
            @ApiParam(name = "subject", required = true, value = "邮件标题") @RequestParam(name = "subject") String subject,
            @ApiParam(name = "recipientName", required = true, value = "接受邮件人的亲切称呼") @RequestParam(name = "recipientName") String recipientName,
            @ApiParam(name = "file", required = true, value = "发送的附件") @RequestParam(name = "file") MultipartFile file,
            @ApiParam(name = "locale", required = true, value = "所在国家语言环境") @RequestParam(name = "locale") EMAIL_LOCALE locale
    ) throws MessagingException, IOException {
        RestMessage<String> restMessage = new RestMessage<>();
        Locale emailLocale = new Locale(locale.toString(),"");
        emailService.sendMailWithInline(
                recipientEmail, subject, recipientName, file.getOriginalFilename(),
                file.getBytes(), file.getContentType(), emailLocale);
        restMessage.setCode(200).setMsg("success").setData(null);
        return restMessage;
    }

    @ApiOperation(value = "发送可再编辑的电子邮件", httpMethod = "POST", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success: insert successfully", response = RestMessage.class),
            @ApiResponse(code = 400, message = "error: mongo db come across an error", response = RestMessage.class)})
    @RequestMapping(value = "/editableEmail", method = RequestMethod.POST, produces = "application/json")
    public RestMessage<String> editableEmail(
            @ApiParam(name = "recipientEmail", required = true, value = "邮箱地址") @RequestParam(name = "recipientEmail", defaultValue = "letcafe@outlook.com") String recipientEmail,
            @ApiParam(name = "subject", required = true, value = "邮件标题") @RequestParam(name = "subject") String subject,
            @ApiParam(name = "recipientName", required = true, value = "接受邮件人的亲切称呼") @RequestParam(name = "recipientName") String recipientName,
            @ApiParam(name = "file", required = true, value = "发送的附件") @RequestParam(name = "file") MultipartFile file,
            @ApiParam(name = "locale", required = true, value = "所在国家语言环境") @RequestParam(name = "locale") EMAIL_LOCALE locale
    ) throws MessagingException, IOException {
        RestMessage<String> restMessage = new RestMessage<>();
        Locale emailLocale = new Locale(locale.toString(),"");
        emailService.sendEditableMail(
                recipientEmail, subject, recipientName, emailService.getEditableMailTemplate(), emailLocale);
        restMessage.setCode(200).setMsg("success").setData(null);
        return restMessage;
    }

}
