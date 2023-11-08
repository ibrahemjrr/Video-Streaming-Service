package com.example.filestorage.controller;

import com.example.filestorage.util.S3Util;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    @PostMapping("/")
    public String uploadToS3(@RequestBody MultipartFile file, @RequestParam("name") String name) {
        try {
            S3Util.uploadFile(name, file.getInputStream());
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }
}
