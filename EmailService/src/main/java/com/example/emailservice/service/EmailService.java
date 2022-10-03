package com.example.emailservice.service;

import com.example.emailservice.model.UserComplaint;
import com.example.emailservice.model.UserComplaintDTO;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public interface EmailService {
    public void sendSimpleEmail(String to,
                                String subject,
                                String text);

    public UserComplaintDTO sendEmail(String to,
                                      String subject,
                                      String text);

    public void sendNotification(SimpleMailMessage message);
}
