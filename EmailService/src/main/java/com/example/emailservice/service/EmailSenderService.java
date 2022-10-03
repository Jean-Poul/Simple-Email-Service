package com.example.emailservice.service;

import com.example.emailservice.model.UserComplaint;
import com.example.emailservice.model.UserComplaintDTO;
import com.example.emailservice.repository.UserComplaintRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;


@Service
public class EmailSenderService implements EmailService {
    // For interacting with the database
    private final UserComplaintRepository userComplaintRepository;

    // Interface of a Java mail sender class
    private final JavaMailSender mailSender;

    public EmailSenderService(JavaMailSender mailSender, UserComplaintRepository userComplaintRepository) {
        this.mailSender = mailSender;
        this.userComplaintRepository = userComplaintRepository;
    }

    // For testing or string made mail (request)
    public void sendSimpleEmail(String to,
                                String subject,
                                String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("tryllehatten@hotmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        this.mailSender.send(message);
    }

    // For UserComplaint response
    public UserComplaintDTO sendEmail(String to,
                                      String subject,
                                      String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        // Our make believe datacenter for complaints
        message.setFrom("tryllehatten@hotmail.com");
        // Our make believe customer mail for receiving complaints
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        this.mailSender.send(message);

        userComplaintRepository.save(new UserComplaint(to, subject, text));
        // Here we need to pass the customer email which needs the notification
        sendNotification(message);

        // Could return Date from here
        return new UserComplaintDTO(new UserComplaint(to, subject, text));
    }

    // Auto generated notification
    public void sendNotification(SimpleMailMessage message) {
        // Here we need to either make a new mail to have a fully proof of concept or leave it as it is for now
        String subject = "Request has been received";
        String text = "Dear customer, thank you for your mail. \n" +
                "We have received your request and will start working on it immediately";
        message.setFrom("tryllehatten@hotmail.com");
        message.setTo(Objects.requireNonNull(message.getTo()));
        message.setSubject(subject);
        message.setText(text);
        this.mailSender.send(message);
        System.out.println("Notification has been send to customer");
    }
}


