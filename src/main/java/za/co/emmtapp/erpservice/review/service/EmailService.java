package za.co.emmtapp.erpservice.review.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import za.co.emmtapp.erpservice.review.model.dto.ApplicationReviewDTO;


@Service
@AllArgsConstructor
public class EmailService {

    private static final String LOGO_IMAGE = "templates/images/logo.png";
    private static final String MAIL_ICON = "templates/images/mailIcon.jpg";
    private static final String JPG_MIME = "image/jpg";

    private static final String PNG_MIME = "image/png";

    private final TemplateEngine templateEngine;

    private final JavaMailSender javaMailSender;


    public void sendProfileConfirmationMail(ApplicationReviewDTO applicationReviewDTO, String recipient, String subject) throws MessagingException {
        Context context = new Context();
        context.setVariable("applicationReviewDto", applicationReviewDTO);
        context.setVariable("springLogo", LOGO_IMAGE);
        context.setVariable("mailIcon", MAIL_ICON);

        String process = templateEngine.process("profiler", context);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true, "UTF-8");

        helper.setText(process, true);
        ClassPathResource clr = new ClassPathResource(LOGO_IMAGE);
        ClassPathResource clx = new ClassPathResource(MAIL_ICON);
        helper.addInline("springLogo", clr, PNG_MIME);
        helper.addInline("mailIcon", clx, JPG_MIME);

        helper.setTo(recipient);
        helper.setSubject(subject);
        javaMailSender.send(mimeMessage);
    }
}
