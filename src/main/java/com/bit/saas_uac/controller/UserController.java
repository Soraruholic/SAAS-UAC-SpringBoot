package com.bit.saas_uac.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bit.saas_uac.entity.LogUser;
import com.bit.saas_uac.mapper.LogUserMapper;
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
    private LogUserMapper logUserMapper;

    // 基础模块
    // 查询所有用户
    @Operation(summary = "查询所有用户基本信息")
    @GetMapping("/log-user/all")
    public List<LogUser> getAllUser() {
        return logUserMapper.selectList(null);
        // return logUserMapper.find();
    }

    @Operation(summary = "查询单个用户基本信息")
    @GetMapping("/log-user/single")
    public LogUser getUser(String userID) {
        return logUserMapper.selectById(userID);
    }

    // 注册模块
    // 获取邮箱验证码
    @Operation(summary = "获取邮箱验证码")
    @GetMapping("/auth-code/email")
    // https://authCode/email?userEmail=XXX
    public String getEmailAuthCode(String userEmail) {
        String authCode = Utils.getEmailAuthCode();
        // TODO: EmailSender.sendAuthCode(authCode, userEmail);
        return authCode;
    }

    @Operation(summary = "获取手机验证码")
    @GetMapping("/auth-code/phone")
    // https://authCode/phone?userPhone=XXX
    public String getPhoneAuthCode(String userPhone) {
        // TODO : String authCode = Utils.getPhoneAuthCode();
        // TODO : PhoneMessageSender.sendAuthCode(authCode, userPhone);
        String authCode = "手机验证码";
        return authCode;
    }

    @Operation(summary = "注册用户")
    @GetMapping("/log-user")
    public String registerUser(@RequestBody LogUser logUser) {
        // TODO: 初始化密码最近一次更新时刻
        logUserMapper.insert(logUser);
        // TODO: 根据用户的ID和名字，生成GoogleAuthenticator的密钥与二维码
        // String QRCode = GoogleAuthenticator.generateQRCode();
        String QRCode = "QRCode";
        return QRCode;
    }

    @Operation(summary = "2FA登录验证")
    @GetMapping("/auth-code/google-auth")
    public String verifyGoogleAuthCode(String userName, String googleAuthCode) {
        // TODO: 执行GoogleAuthenticator的验证
        return "GOOGLE_AUTH_SUCCESS";
    }

    // 登录
    @Operation(summary = "登录用户")
    @GetMapping("/log-user/")
    public String loginUser(String userName, String userPassword) {
        // 密码验证
        // LogUser user = logUserMapper.selectByName(userName);
        return "LOGIN_SUCCESS";
    }

    // 找回/重置密码
    @Operation(summary = "找回/重置密码")
    @PatchMapping("/log-user/password")
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
