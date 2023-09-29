package com.sal;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PdfGeneratorService {

    public String generatePDF() throws IOException {
        PDDocument document = new PDDocument();

        try {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.newLineAtOffset(50, 700);
            contentStream.showText("Hello, this is a sample PDF generated with PDFBox.");
            contentStream.endText();

            contentStream.close();

            String pdfFilePath = "sample.pdf";
            document.save(pdfFilePath);

            return pdfFilePath;
        } finally {
            document.close();
        }
    }
}
