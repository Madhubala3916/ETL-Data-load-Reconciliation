package com.mbd.reportGenerate;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mbd.model.ErrorEntity;
import com.mbd.repository.ErrorEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ErrorEntityRepository errorEntityRepository;
    public ByteArrayInputStream generateErrorReport() {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Add a title
            Paragraph title = new Paragraph("Error Report");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Create a table for error data
            PdfPTable table = new PdfPTable(3); // Three columns: Error ID, Error Message, Entity Name
            table.setWidthPercentage(100);
            // Add table headers
            table.addCell("Error ID");
            table.addCell("Error Message");
            table.addCell("Entity Name"); // New column for Entity Name
            // Fetch error data from the repository
            List<ErrorEntity> errorEntities = errorEntityRepository.findAll();

            // Add error data to the table
            for (ErrorEntity errorEntity : errorEntities) {
                table.addCell(errorEntity.getErrorId().toString());
                table.addCell(errorEntity.getErrorMessage());
                table.addCell(errorEntity.getEntityName()); // Add Entity Name
            }
            // Add the table to the document
            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
