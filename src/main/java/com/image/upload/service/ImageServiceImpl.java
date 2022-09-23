package com.image.upload.service;

import com.image.upload.entity.ImageEntity;
import com.image.upload.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ImageEntity uploadImage(MultipartFile file) throws IOException {
         final String path ="E:\\practise coding project\\";
         String fullPath=path+file.getOriginalFilename();
         ImageEntity imageEntity=new ImageEntity();
         imageEntity.setImageName(file.getOriginalFilename());
         imageEntity.setContentType(file.getContentType());
         imageEntity.setImagePath(fullPath);
         file.transferTo(new File(fullPath));
         return imageRepository.save(imageEntity);

    }

    @Override
    public byte[] downloadImage(String fileName) throws IOException {
        Optional<ImageEntity> imageName = imageRepository.findByImageName(fileName);
        String fullPath = imageName.get().getImagePath();
        return Files.readAllBytes(new File(fullPath).toPath());

    }
}
