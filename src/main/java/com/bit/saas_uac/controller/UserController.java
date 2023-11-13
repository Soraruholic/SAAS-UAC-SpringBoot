package com.bit.saas_uac.controller;

import com.bit.saas_uac.entity.User;
import com.bit.saas_uac.mapper.UserMapper;
import com.bit.saas_uac.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "用户管理")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    // 基础模块
    // 查询所有用户
    @Operation(summary = "查询所有用户基本信息")
    @GetMapping("/user/all")
    public List<User> getAllUser() {
        return userMapper.selectList(null);
        // return logUserMapper.find();
    }

    @Operation(summary = "查询单个用户基本信息")
    @GetMapping("/user/single")
    public User getUser(String userID) {
        return userMapper.selectById(userID);
    }


    // 注册模块
    @Operation(summary = "注册用户")
    @PostMapping("/user")
    public String registerUser(@RequestBody User user) {
        // TODO: 初始化密码最近一次更新时刻
        userMapper.insert(user);
        // TODO: 根据用户的ID和名字，生成GoogleAuthenticator的密钥与二维码
        // String QRCode = GoogleAuthenticator.generateQRCode();
        String QRCode = "QRCode";
        return QRCode;
    }

    // 登录
    @Operation(summary = "登录用户")
    @GetMapping("/user/")
    public String loginUser(String userName, String userPassword) {
        // 密码验证
        // LogUser user = logUserMapper.selectByName(userName);
        return "LOGIN_SUCCESS";
    }

    // 找回/重置密码
    @Operation(summary = "找回/重置密码")
    @PatchMapping("/user/password")
    public String resetPassword(String userName, String userPassword) {
        // TODO: 更新密码
        return "RESET_SUCCESS";
    }

    // Role
    // Page One : Assign/Deprive Roles (User & Role)

    // Page Two : Create/Destroy Roles (Permission & Role)
    // Role : http://role1/role2/role3
    //    @GetMapping("path/of/certain/role/*")
    //    public List<Role> getRolePath() {
    //    }

    // AccessControl (Filter/Interceptor)
    // FunctionalPermission  URL ==> /functions/name
    // DataPermission URL ==> /data/url/of/certain/resource
}
