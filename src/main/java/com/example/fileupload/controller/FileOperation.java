package com.example.fileupload.controller;

import com.example.fileupload.exceptions.derived.InvalidOperationException;
import com.example.fileupload.service.fileoperation.FileOperationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@RestController
@RequestMapping("file/")
public class FileOperation {

     @Autowired
    private FileOperationService fileOperationService;

     @ApiOperation(value = "Return Streaming Response for files",consumes = "String: FileName with extension")
    @GetMapping("/{fileName}")
    public StreamingResponseBody downloadFile(@PathVariable String fileName,HttpServletResponse response) throws IOException {
        File file  = fileOperationService.getFile(fileName);
        try{
            InputStream inputStream = new FileInputStream(file);
            response.setContentType(Files.probeContentType(file.toPath()));
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"");
             return outputStream -> {
                int nRead;
                byte[] data = new byte[2048];
                while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                    outputStream.write(data, 0, nRead);
                }
            };
        }catch(Exception e){
            throw new InvalidOperationException("Could not download file... Check File Name");
        }
    }

    @ApiOperation(value = "For copying the file",consumes = "String: File Name with extension")
    @PostMapping("/{fileName}")
    public ResponseEntity<String> copyFile(@PathVariable String fileName){
        String response = fileOperationService.copyFile(fileName);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "For deleting of the file",consumes = "String: File Name with extension")
    @PutMapping("/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName){
         String response = fileOperationService.deletFile(fileName);
        System.out.println("deleting response = "+response);
        return ResponseEntity.ok(response);
    }




}

