package com.example.emailservice.controller;

import com.example.emailservice.model.UserComplaint;
import com.example.emailservice.model.UserComplaintDTO;
import com.example.emailservice.service.EmailSenderService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/emails")
public class EmailResource {
    private final EmailSenderService emailSenderService;

    public EmailResource(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/test/message")
    public String testEmail() {
        // Insert mail you want to send the message too
        this.emailSenderService.sendSimpleEmail(
                "",
                "Greetings Customer (app school project test)!",
                "We have received your message"
        );
        return "Test message has been sent.";
    }

    @PostMapping("/message")
    public UserComplaintDTO responseEmail(@RequestBody UserComplaint userComplaint) {
        return emailSenderService.sendEmail(userComplaint.getToEmail(), userComplaint.getSubject(), userComplaint.getText());
    }
}
