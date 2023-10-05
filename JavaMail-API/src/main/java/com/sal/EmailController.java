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
    private PdfGeneratorService pdfGeneratorService;
    @GetMapping("/sendEmail")
    public String sendEmail() throws IOException {
        String pdfFilePath = pdfGeneratorService.generatePDF();
        emailService.sendEmailWithAttachment("sudhanshusharmaskr@gmail.com", "Hello!!! I love you", "Report PDF.", pdfFilePath);
        return "Email sent!";
    }
}

