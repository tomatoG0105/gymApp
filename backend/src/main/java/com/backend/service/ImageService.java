package com.backend.service;

import com.backend.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService
{
    Course uploadImageToCourse(MultipartFile file, int id) throws IOException;
    Course deleteImageFromCourse(int id);
    Instructor uploadImageToInstructor(MultipartFile file, int id) throws IOException;
    Instructor deleteImageFromInstructor(int id);
    Plan uploadImageToPlan(MultipartFile file, int id) throws IOException;
    Plan deleteImageFromPlan(int id);
    User uploadImageToUser(MultipartFile file, int id) throws IOException;
    User deleteImageFromUser(int id);
    byte[] downloadImageFromFileSystem(String fileName) throws IOException;
    String getImageType(String fileName);
}
