package org.apitest.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apitest.entity.User;
import org.apitest.mapper.UserMapper;
import org.apitest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "API Test",description = "Api Test")
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public String hello(){
        return "Hello API";
    }

    @GetMapping("/test")
    public String test(@Parameter(description = "Id test")@RequestParam String id){
        return "Test"+id;
    }
    @GetMapping("/test/{id}")
    public String restfulTest(@Parameter(description = "Id restful test")@PathVariable String id){
        return "restfulTest"+id;
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user){
        userService.save(user);
        return "添加用户成功！";
    }

    @RequestMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.list());
    }

    @GetMapping("/user")
    public User getUserById(@RequestParam(name = "id") int id){
        return userService.getById(id);
    }

    @GetMapping("/user/{id}")
    public User restfulGetUserById(@PathVariable int id){
        return userService.getById(id);
    }

    @PatchMapping("/user")
    public User updateUser(@RequestBody User user){
        userService.updateById(user);
        return userService.getById(user.getId());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<List<User>> deleteUserById(@PathVariable int id){
        userService.removeById(id);
        return ResponseEntity.ok(userService.list());
    }

    @GetMapping("/user_test")
    public String getSpecified(int id){
//        List<User> userList = userMapper.selectList(new QueryWrapper<User>().eq("id", id));
        List<User> userList = userService.list(new QueryWrapper<User>().eq("id", id));
        return userList.toString();
    }

}
