package com.sal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private PdfGeneratorService pdfGeneratorService; // Inject the PdfGeneratorService
    @GetMapping("/sendEmail")
    public String sendEmail() throws IOException {
        String pdfFilePath = pdfGeneratorService.generatePDF();
        emailService.sendEmailWithAttachment("simiaktar527@gmail.com", "Hello, World!", "This is a test email from Spring Boot with PDF attachment.", pdfFilePath);
        return "Email sent!";
    }
}

