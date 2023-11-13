package com.bit.saas_uac.controller;

import com.bit.saas_uac.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "验证码管理")
@RestController
public class AuthenticatorController {
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

    @Operation(summary = "2FA登录验证")
    @GetMapping("/auth-code/google-auth")
    public String verifyGoogleAuthCode(String userName, String googleAuthCode) {
        // TODO: 执行GoogleAuthenticator的验证
        return "GOOGLE_AUTH_SUCCESS";
    }
}
