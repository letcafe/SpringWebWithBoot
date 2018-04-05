package com.edoctor.service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Locale;

public interface EmailService {

    void sendTextMail(final String recipientEmail, final String subject, final String recipientName , final Locale locale) throws MessagingException;

    void sendSimpleMail(final String recipientEmail, final String subject, final String recipientName , final Locale locale) throws MessagingException;

    void sendMailWithAttachment(String recipientEmail, final String subject, String recipientName, String attachmentFileName, byte[] attachmentBytes, String attachmentContentType, Locale locale) throws MessagingException;

    void sendMailWithInline(String recipientEmail, String subject, String recipientName, String imageResourceName, byte[] imageBytes, String imageContentType, Locale locale) throws MessagingException;

    String getEditableMailTemplate() throws IOException;

    void sendEditableMail(String recipientEmail, final String subject, String recipientName, String htmlContent, Locale locale) throws MessagingException;
}
