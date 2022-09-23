package com.image.upload.repository;

import com.image.upload.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageEntity,Integer> {


    Optional<ImageEntity> findByImageName(String fileName);
}
