package com.etl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etl.service.EmailService;
import com.etl.service.ReportService;

@RestController
@RequestMapping("/pdf")
public class ReportController {
	
//    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
    @Autowired
    private ReportService pdfReportService;
    
    @Autowired
    private EmailService emailService; // Inject your EmailService
    
    
    @GetMapping("/errorReport")
    public ResponseEntity<byte[]> generateErrorReportAndSendEmail() {
        // Generate the error report as a byte array
        byte[] pdfReport = pdfReportService.generateErrorReport().readAllBytes();

        // Send the email with the PDF report as an attachment
        emailService.sendEmailWithAttachment(
                "rasikapradhan1@gmail.com", // Replace with the recipient's email address
                "Error Report",
                "Please find the attached Error Report.",
                pdfReport,
                "error_report.pdf"
        );

        // Print a message in the console
        System.out.println("Email sent successfully.");

        // Set response headers for downloading the PDF
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "error_report.pdf");

        // Return the PDF as a response
        return new ResponseEntity<>(pdfReport, headers, HttpStatus.OK);
    }

}
