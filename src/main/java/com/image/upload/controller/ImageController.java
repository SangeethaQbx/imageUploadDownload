package com.image.upload.controller;

import com.image.upload.entity.ImageEntity;
import com.image.upload.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("v1/image")
public class ImageController {

    @Autowired
    private ImageService imageService;


    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/upload")
    public ImageEntity uploadImage(MultipartFile file) throws IOException {
       return imageService.uploadImage(file);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) throws IOException {
        byte[] image = imageService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);

    }
    }
