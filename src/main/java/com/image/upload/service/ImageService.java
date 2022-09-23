package com.image.upload.service;

import com.image.upload.entity.ImageEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    public ImageEntity uploadImage(MultipartFile file) throws IOException;


    byte[] downloadImage(String fileName) throws IOException;
}
