package com.ericknunes.backend.service;

import com.ericknunes.web.domain.frontend.FeedbackPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.to.adress}")
    private String defaultToAdress;
    /**
     * Creates a simple Mail Message from a feedbackPojo.
     * @param feedback The feedback pojo
     * @return
     */
    protected SimpleMailMessage prepareSimpleMailMessageFromFeedbackPojo(FeedbackPojo feedback){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(defaultToAdress);
        message.setFrom(feedback.getEmail());
        message.setSubject("[Erick Nunes Spring Boot]: Feedback receive from " + feedback.getFirstName() + " " +feedback.getLastName() + "!");
        message.setText(feedback.getFeedBack());
        return message;
    }

    @Override
    public void sendFeedbackEmail(FeedbackPojo feedbackPojo) {
        sendGenericEmailMessage(prepareSimpleMailMessageFromFeedbackPojo(feedbackPojo));
    }
}
