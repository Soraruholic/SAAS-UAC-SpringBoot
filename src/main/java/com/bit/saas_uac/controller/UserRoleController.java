package com.bit.saas_uac.controller;

import com.bit.saas_uac.entity.Role;
import com.bit.saas_uac.entity.User;
import com.bit.saas_uac.mapper.RoleMapper;
import com.bit.saas_uac.mapper.UserMapper;
import com.bit.saas_uac.mapper.UserRoleMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "用户-角色依赖管理")
public class UserRoleController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;


    @Operation(summary = "查询单个用户的含角色信息")
    @GetMapping("/user-role/single")
    public User getRolesForUser(String userID) {
        return userMapper.selectRolesForUser(userID);
    }

    @Operation(summary = "查询单个角色的含用户信息")
    @GetMapping("/role-user/single")
    public Role getUsersForRole(String roleID) {
        return roleMapper.selectUsersForRole(roleID);
    }

    @Operation(summary = "查询所有用户的含角色信息")
    @GetMapping("/user-role/all")
    public List<User> getRolesForUsers() {
        return userMapper.selectRolesForUsers();
    }

    @Operation(summary = "查询所有角色的含用户信息")
    @GetMapping("/role-user/all")
    public List<Role> getUsersForRoles() {
        return roleMapper.selectUsersForRoles();
    }

    @Operation(summary = "为用户添加角色")
    @PostMapping("/user-role")
    public String addUserRole(String userID, String roleID) {
        userRoleMapper.insertUserRole(userID, roleID);
        return "ADD_USER_ROLE_SUCCESS";
    }

    @Operation(summary = "为用户删除角色")
    @DeleteMapping("/user-role")
    public String deleteUserRole(String userID, String roleID) {
        userRoleMapper.deleteUserRole(userID, roleID);
        return "DELETE_USER_ROLE_SUCCESS";
    }
}
