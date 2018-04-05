package com.edoctor.service.impl;

import com.edoctor.conf.EmailConfig;
import com.edoctor.service.EmailService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class EmailServiceImpl implements EmailService {

    private static final String MESSAGE_FROM = "gdycn@qq.com";

    private static final String EMAIL_TEXT_TEMPLATE_NAME = "text/email-text";
    private static final String EMAIL_SIMPLE_TEMPLATE_NAME = "html/email-simple";
    private static final String EMAIL_WITH_ATTACHMENT_TEMPLATE_NAME = "html/email-withattachment";
    private static final String EMAIL_INLINE_IMAGE_TEMPLATE_NAME = "html/email-inlineimage";
    private static final String EMAIL_EDITABLE_TEMPLATE_CLASSPATH_RES = "classpath:mail/editablehtml/email-editable.html";

    private static final String BACKGROUND_IMAGE = "mail/images/background.png";
    private static final String LOGO_BACKGROUND_IMAGE = "mail/images/logo-background.png";
    private static final String THYMELEAF_BANNER_IMAGE = "mail/images/thymeleaf-banner.png";
    private static final String THYMELEAF_LOGO_IMAGE = "mail/images/thymeleaf-logo.png";

    private static final String PNG_MIME = "image/png";

    private ApplicationContext applicationContext;

    private JavaMailSender mailSender;

    private TemplateEngine htmlTemplateEngine;

    private TemplateEngine textTemplateEngine;

    private TemplateEngine stringTemplateEngine;
    
    @Autowired
    EmailServiceImpl(ApplicationContext applicationContext,
                     JavaMailSender mailSender,
                     @Qualifier("MyEmailEngine") TemplateEngine htmlTemplateEngine,
                     @Qualifier("MyEmailEngine") TemplateEngine textTemplateEngine,
                     @Qualifier("MyEmailEngine") TemplateEngine stringTemplateEngine) {
        this.applicationContext = applicationContext;
        this.mailSender = mailSender;
        this.htmlTemplateEngine = htmlTemplateEngine;
        this.textTemplateEngine = textTemplateEngine;
        this.stringTemplateEngine = stringTemplateEngine;
    }

    /*
     * Send plain TEXT mail
     */
    @Override
    public void sendTextMail(
            final String recipientEmail, final String subject, final String recipientName, final Locale locale)
            throws MessagingException {

        // Prepare the evaluation context
        final Context ctx = new Context(locale);
        ctx.setVariable("name", recipientName);
        ctx.setVariable("subscriptionDate", new Date());
        ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
        message.setSubject("Example plain TEXT email");
        message.setFrom(MESSAGE_FROM);
        message.setTo(recipientEmail);

        // Create the plain TEXT body using Thymeleaf
        final String textContent = this.textTemplateEngine.process(EMAIL_TEXT_TEMPLATE_NAME, ctx);
        message.setText(textContent);

        // Send email
        this.mailSender.send(mimeMessage);
    }


    /*
     * Send HTML mail (simple)
     */
    @Override
    public void sendSimpleMail(
            final String recipientEmail,final String subject, final String recipientName, final Locale locale)
            throws MessagingException {

        // Prepare the evaluation context
        final Context ctx = new Context(locale);
        ctx.setVariable("name", recipientName);
        ctx.setVariable("subscriptionDate", new Date());
        ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
        message.setSubject(subject);
        message.setFrom(MESSAGE_FROM);
        message.setTo(recipientEmail);

        // Create the HTML body using Thymeleaf
        final String htmlContent = this.htmlTemplateEngine.process(EMAIL_SIMPLE_TEMPLATE_NAME, ctx);
        message.setText(htmlContent, true /* isHtml */);

        // Send email
        this.mailSender.send(mimeMessage);
    }

    /*
     * Send HTML mail with attachment.
     */
    @Override
    public void sendMailWithAttachment(
            String recipientEmail, String subject, String recipientName, String attachmentFileName,
            byte[] attachmentBytes, String attachmentContentType, Locale locale)
            throws MessagingException {
        // Prepare the evaluation context
        final Context ctx = new Context(locale);
        ctx.setVariable("name", recipientName);
        ctx.setVariable("subscriptionDate", new Date());
        ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message
                = new MimeMessageHelper(mimeMessage, true /* multipart */, "UTF-8");
        message.setSubject(subject);
        message.setFrom(MESSAGE_FROM);
        message.setTo(recipientEmail);

        // Create the HTML body using Thymeleaf
        final String htmlContent = this.htmlTemplateEngine.process(EMAIL_WITH_ATTACHMENT_TEMPLATE_NAME, ctx);
        message.setText(htmlContent, true /* isHtml */);

        // Add the attachment
        final InputStreamSource attachmentSource = new ByteArrayResource(attachmentBytes);
        message.addAttachment(attachmentFileName, attachmentSource, attachmentContentType);

        // Send mail
        this.mailSender.send(mimeMessage);
    }

    /*
     * Send HTML mail with inline image
     */
    @Override
    public void sendMailWithInline(
            String recipientEmail, String subject, String recipientName, String imageResourceName,
            byte[] imageBytes, String imageContentType, Locale locale)
            throws MessagingException {
        // Prepare the evaluation context
        final Context ctx = new Context(locale);
        ctx.setVariable("name", recipientName);
        ctx.setVariable("subscriptionDate", new Date());
        ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));
        ctx.setVariable("imageResourceName", imageResourceName); // so that we can reference it from HTML

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message
                = new MimeMessageHelper(mimeMessage, true /* multipart */, "UTF-8");
        message.setSubject(subject);
        message.setFrom(MESSAGE_FROM);
        message.setTo(recipientEmail);

        // Create the HTML body using Thymeleaf
        final String htmlContent = this.htmlTemplateEngine.process(EMAIL_INLINE_IMAGE_TEMPLATE_NAME, ctx);
        message.setText(htmlContent, true /* isHtml */);

        // Add the inline image, referenced from the HTML code as "cid:${imageResourceName}"
        final InputStreamSource imageSource = new ByteArrayResource(imageBytes);
        message.addInline(imageResourceName, imageSource, imageContentType);

        // Send mail
        this.mailSender.send(mimeMessage);
    }

    /*
     * Send HTML mail with inline image
     */
    @Override
    public String getEditableMailTemplate() throws IOException {
        final Resource templateResource = this.applicationContext.getResource(EMAIL_EDITABLE_TEMPLATE_CLASSPATH_RES);
        final InputStream inputStream = templateResource.getInputStream();
        return IOUtils.toString(inputStream, EmailConfig.EMAIL_TEMPLATE_ENCODING);
    }

    /*
     * Send HTML mail with inline image
     */
    @Override
    public void sendEditableMail(String recipientEmail, String subject, String recipientName, String htmlContent, Locale locale) throws MessagingException {
        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message
                = new MimeMessageHelper(mimeMessage, true /* multipart */, "UTF-8");
        message.setSubject(subject);
        message.setFrom(MESSAGE_FROM);
        message.setTo(recipientEmail);

        // Prepare the evaluation context
        final Context ctx = new Context(locale);
        ctx.setVariable("name", recipientName);
        ctx.setVariable("subscriptionDate", new Date());
        ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));

        // Create the HTML body using Thymeleaf
        final String output = stringTemplateEngine.process(htmlContent, ctx);
        message.setText(output, true /* isHtml */);

        // Add the inline images, referenced from the HTML code as "cid:image-name"
        message.addInline("background", new ClassPathResource(BACKGROUND_IMAGE), PNG_MIME);
        message.addInline("logo-background", new ClassPathResource(LOGO_BACKGROUND_IMAGE), PNG_MIME);
        message.addInline("thymeleaf-banner", new ClassPathResource(THYMELEAF_BANNER_IMAGE), PNG_MIME);
        message.addInline("thymeleaf-logo", new ClassPathResource(THYMELEAF_LOGO_IMAGE), PNG_MIME);

        // Send mail
        this.mailSender.send(mimeMessage);
    }




}
