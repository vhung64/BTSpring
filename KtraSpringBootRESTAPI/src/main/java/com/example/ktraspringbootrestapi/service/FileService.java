package com.example.ktraspringbootrestapi.service;

import com.example.ktraspringbootrestapi.exception.BadRequestException;
import com.example.ktraspringbootrestapi.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {
    Path rootPath = Paths.get("uploads");

    public FileService(){
        creatFolder(rootPath.toString());
    }

    private void creatFolder(String path){
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
    }
    public String uploadFile(int id, MultipartFile file){
        // tao folder
        Path userPath = rootPath.resolve(String.valueOf(id));
        creatFolder(userPath.toString());

        // Validate file
        validateFile(file);

        // Upload
        String fileID = String.valueOf(Instant.now().getEpochSecond());
        Path filePath = userPath.resolve(String.valueOf(fileID));
        File targetFile = filePath.toFile();
        try (OutputStream os = new FileOutputStream(targetFile)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi trong quá trình upload file");
        }

        return "/api/v1/users/" + id + "/files/" + fileID;
    }

    private void validateFile(MultipartFile file) {
        // Kiem tra ten
        String fileName = file.getOriginalFilename();
        if(fileName == null || fileName.isEmpty()){
            throw new BadRequestException("tên không được trống");
        }
        // Duoi
        String fileExtension = getFileExtension(fileName);
        if(!checkFileExtension(fileExtension)){
            throw new BadRequestException("file khong dung dinh dang");
        }
        // dung luong
        double fileSize = (double) (file.getSize() / Math.pow(2,20));
        if (fileSize > 2){
            throw new BadRequestException("File phai nho hon 2 mb");
        }
    }
    private String getFileExtension(String fileName){
        int lastIndexOf = fileName.lastIndexOf('.');
        return fileName.substring(lastIndexOf + 1);
    }
    private boolean checkFileExtension(String fileExtension){
        List<String> list = new ArrayList<>(List.of("png", "jpg", "jpeg"));
        return list.contains(fileExtension.toLowerCase());
    }

    public byte[] readFile(int id, String fileID) {
        Path userPath = rootPath.resolve(String.valueOf(id));
        Path filePath = userPath.resolve(String.valueOf(fileID));
        if(!userPath.toFile().exists() || !filePath.toFile().exists()){
            throw new NotFoundException("khong co file");
        }

        try {
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Loi doc file");
        }
    }

    public List<String> getFiles(int id) {
        Path userPath = rootPath.resolve(String.valueOf(id));
        if(!userPath.toFile().exists()){
            return new ArrayList<>();
        }else {
            File userDir = userPath.toFile();
            File[] files = userDir.listFiles();
            return Arrays.stream(files)
                    .map(file -> file.getName())
                    .sorted(Comparator.reverseOrder())
                    .map(fileName -> "/api/v1/users/" + id + "/files/" + fileName)
                    .collect(Collectors.toList());
        }
    }

    public void deleteFile(int id,String fileID) {
        Path userPath = rootPath.resolve(String.valueOf(id));
        Path filePath = userPath.resolve(String.valueOf(fileID));
        if(!userPath.toFile().exists() || !filePath.toFile().exists()){
            throw new NotFoundException("khong co file");
        }
        if(!filePath.toFile().delete()){
            throw new RuntimeException("Loi khi xoa file");
        }
    }
}
