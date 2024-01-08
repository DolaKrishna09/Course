package com.app.controller;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import com.app.Service.ExtractedDataService;
import com.app.entity.ExtractedData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private ExtractedDataService extractedDataService;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            // Convert MultipartFile to a File
            File convertedFile = convertMultipartFileToFile(file);

            // Log the absolute path of the file
            System.out.println("Absolute Path of the File: " + convertedFile.getAbsolutePath());

            // Extract text from the Word document using Apache POI
            String extractedData = extractTextFromWordDocument(convertedFile);

            // Save extracted data to the database
            extractedDataService.saveExtractedData(extractedData);

            return new ResponseEntity<>(extractedData, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error extracting data from Word document", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<ExtractedData>> getAllExtractedData() {
        List<ExtractedData> extractedDataList = extractedDataService.getAllExtractedData();
        return new ResponseEntity<>(extractedDataList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ExtractedData> getExtractedDataById(@PathVariable Long id) {
        Optional<ExtractedData> optionalExtractedData = extractedDataService.getExtractedDataById(id);
        return optionalExtractedData.map(data -> new ResponseEntity<>(data, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateExtractedData(@PathVariable Long id, @RequestParam String newData) {
        extractedDataService.updateExtractedData(id, newData);
        return new ResponseEntity<>("Data updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExtractedData(@PathVariable Long id) {
        extractedDataService.deleteExtractedData(id);
        return new ResponseEntity<>("Data deleted successfully", HttpStatus.OK);
    }

    private File convertMultipartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        file.transferTo(convertedFile);
        return convertedFile;
    }

    private String extractTextFromWordDocument(File docxFile) throws IOException {
    	  try (FileInputStream fis = new FileInputStream(docxFile);
    	             XWPFDocument document = new XWPFDocument(fis)) {

    	            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
    	            return extractor.getText();
    	        }
    	    }
}
