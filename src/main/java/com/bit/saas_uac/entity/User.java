package com.bit.saas_uac.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@TableName("User")
public class User {
    @TableId
    private String userID;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private String lastPasswordResetDate;

    @TableField(exist = false)
    private List<Role> roleList;
}
