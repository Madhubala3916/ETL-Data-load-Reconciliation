package com.sal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
    @GetMapping("/sendEmail")
    public String sendEmail() {
        emailService.sendEmail("simiaktar527@gmail.com", "Hello, World!", "This is a test email from Spring Boot.");
        return "Email sent!";
    }
}




