package com.app.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dtos.FileModel;

@Service
public class FileServiceImplements implements FileService {

    @Override
    public FileModel uploadVideo(String path, MultipartFile file) throws IOException {
        FileModel filemodel = new FileModel();
        String fileName = file.getOriginalFilename();

        String filePath = path + File.separator + fileName;

        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }

        Files.copy(file.getInputStream(), Paths.get(filePath));
        filemodel.setVideoFileName(fileName);
        return filemodel;
    }

    @Override
    public InputStream getVideoFile(String path, String finalName, int id) throws FileNotFoundException {
        String fullPath = path + File.separator + finalName;
        InputStream inputStream = new FileInputStream(fullPath);
        return inputStream;
    }
}
