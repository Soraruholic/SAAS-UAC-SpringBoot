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
@TableName("Role")
public class Role {
    @TableId
    private String roleID;
    private String roleMethod;
    private String roleDescription;

    @TableField(exist = false)
    private List<Role> roleList;

    @TableField(exist = false)
    private List<User> userList;
}
