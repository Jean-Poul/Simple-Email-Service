package com.example.emailservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserComplaintDTO {
    private String customerName;
    private String customerAddress;
    private String[] toEmailArr;
    private String toEmail;
    private String subject;
    private String text;

    public UserComplaintDTO(String[] to, String subject, String text) {
        this.toEmailArr = to;
        this.subject = subject;
        this.text = text;
    }

    public UserComplaintDTO(UserComplaint userComplaint) {
        this.toEmail = userComplaint.getToEmail();
        this.subject = userComplaint.getSubject();
        this.text = userComplaint.getText();
    }
}
