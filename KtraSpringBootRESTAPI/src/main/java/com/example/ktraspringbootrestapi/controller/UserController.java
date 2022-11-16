package com.example.ktraspringbootrestapi.controller;

import com.example.ktraspringbootrestapi.model.PagaUser;
import com.example.ktraspringbootrestapi.model.User;
import com.example.ktraspringbootrestapi.model.UserDto;
import com.example.ktraspringbootrestapi.repository.UserRepository;
import com.example.ktraspringbootrestapi.request.UpsertPasswordRequest;
import com.example.ktraspringbootrestapi.request.UpsertUserRequest;
import com.example.ktraspringbootrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;
    // Get all
    @GetMapping("usersall")
    public List<User> getAll(){
        return userService.findAll();
    }

    // 1. Lấy danh sách users (có phân trang - pagination)
    // GET http://localhost:8080/api/v1/users (mặc định page = 1, limit = 10)
    @GetMapping("users")
    public PagaUser getPageUser(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return userService.getPageUser(page,limit);
    }

    //2. Tìm kiếm user theo tên
    //GET http://localhost:8080/api/v1/search?name={nameValue}
    @GetMapping("users/search")
    public List<UserDto> getUserByName(@RequestParam String name){
        return userService.getUserByName(name);
    }
    //3. Lấy chi tiết user theo id
    //GET http://localhost:8080/api/v1/users/{id}
    @GetMapping("users/{id}")
    public UserDto findUserById(@PathVariable int id){
        return userService.findUserById(id);
    }
    //4. Tạo mới user
    //POST http://localhost:8080/api/v1/users
    @PostMapping("users")
    public UserDto creatUser(@RequestBody UpsertUserRequest request){
        return userService.creatUser(request);
    }
    //5. Cập nhật thông tin user
    //PUT http://localhost:8080/api/v1/users/{id}
    @PutMapping("users/{id}")
    public UserDto updateUser(@RequestBody UpsertUserRequest request,@PathVariable int id){
        return userService.updateUser(request,id);
    }
    //6. Xóa user
    //DELETE http://localhost:8080/api/v1/users/{id}
    @DeleteMapping("users/{id}")
    public void delUser(@PathVariable int id){
        userService.delUser(id);
    }
    //7. Thay đổi ảnh avatar
    //PUT http://localhost:8080/api/v1/users/{id}/update-avatar
    @PutMapping("users/{id}/update-avatar")
    public void updateAvatar(@RequestBody UpsertUserRequest request,@PathVariable int id){
        userService.updateAvatar(request,id);
    }
    //8. Thay đổi mật khẩu
    //PUT http://localhost:8080/api/v1/users/{id}/update-password
    @PutMapping("users/{id}/update-password")
    public void updatePassword(@RequestBody UpsertPasswordRequest request, @PathVariable int id){
        userService.updatePassword(request,id);
    }
    //9. Quên mật khẩu
    //POST http://localhost:8080/api/v1/users/{id}/fotgot-password
    @PostMapping("users/{id}/fotgot-password")
    public String fotgotPassword(@PathVariable int id){
        return userService.fotgotPassword(id);
    }

}
