package com.example.ktraspringbootrestapi.service;

import com.example.ktraspringbootrestapi.exception.NotFoundException;
import com.example.ktraspringbootrestapi.model.PagaUser;
import com.example.ktraspringbootrestapi.model.User;
import com.example.ktraspringbootrestapi.model.UserDto;
import com.example.ktraspringbootrestapi.repository.UserRepository;
import com.example.ktraspringbootrestapi.request.UpsertPasswordRequest;
import com.example.ktraspringbootrestapi.request.UpsertUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileService fileService;


    public List<UserDto> getUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    public UserDto findUserById(int id) {
        if(userRepository.findUserById(id).isPresent()){
            UserDto userDto = new UserDto(
                    userRepository.findUserById(id).get().getId(),
                    userRepository.findUserById(id).get().getName(),
                    userRepository.findUserById(id).get().getEmail(),
                    userRepository.findUserById(id).get().getPhone(),
                    userRepository.findUserById(id).get().getAddress(),
                    userRepository.findUserById(id).get().getAvatar()
            );

            return userDto;
        }
        else throw new NotFoundException("Not found exception with " + id);
    }

    public UserDto createUser(UpsertUserRequest request) {
        User user = userRepository.createUser(request);
        UserDto userDto = new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getAvatar()
        );
        return userDto;
    }

    public UserDto updateUser(UpsertUserRequest request,int id) {
        userRepository.updateUser(request,id);
        return findUserById(id);
    }

    public void delUser(int id) {
        userRepository.delUser(id);
    }

    public List<User> findAll() {
        return userRepository.findALl();
    }

    public void updateAvatar(UpsertUserRequest request, int id) {
        userRepository.updateAvatar(request,id);
    }

    public void updatePassword(UpsertPasswordRequest request, int id) {
        userRepository.updatePassword(request,id);
    }

    public String fotgotPassword(int id) {
        return userRepository.fotgotPassword(id);
    }

    public PagaUser getPageUser(int page, int limit) {
        return userRepository.getPageUser(page,limit);
    }

    public String uploadFile(int id, MultipartFile file) {
        userRepository.findUserById(id).orElseThrow(() -> new NotFoundException("Not found id with " + id));
        return fileService.uploadFile(id, file);
    }
    public byte[] readFile(int id, String fileID) {
        userRepository.findUserById(id).orElseThrow(() -> new NotFoundException("Not found id with " + id));
        return fileService.readFile(id,fileID);
    }

    public List<String> getFiles(int id) {
        userRepository.findUserById(id).orElseThrow(() -> new NotFoundException("Not found id with " + id));
        return fileService.getFiles(id);
    }

    public void deleteFile(int id, String fileId) {
        userRepository.findUserById(id).orElseThrow(() -> new NotFoundException("Not found id with " + id));
        fileService.deleteFile(id,fileId);
    }
}
