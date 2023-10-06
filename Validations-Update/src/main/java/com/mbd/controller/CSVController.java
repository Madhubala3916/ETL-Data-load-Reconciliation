package com.mbd.controller;

import com.mbd.helper.CSVHelper;
import com.mbd.message.ResponseMessage;
import com.mbd.service.CSVService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import static com.mbd.helper.CSVHelper.logger;

@Controller
@Validated
@RequestMapping("/api/csv")
public class CSVController {
    @Autowired
    CSVService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            }
//            catch (ValidationException ve) {
//                // Handle validation errors and log them
//                logger.warning("Validation failed during CSV import: " + ve.getMessage());
//                message = "Validation failed: " + ve.getMessage();
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
//            }
        catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!" + e.getMessage() ;
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a CSV file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }






//    @GetMapping("/csvfiles")
//    public ResponseEntity<List<Csvfile>> getAllCsvfiles(){
//        try {
//            List<Csvfile> csvfiles = fileService.getAllCsvFiles();
//
//            if (csvfiles.isEmpty()){
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(csvfiles,HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
