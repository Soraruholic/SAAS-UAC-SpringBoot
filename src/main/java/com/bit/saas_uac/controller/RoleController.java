package com.bit.saas_uac.controller;

import com.bit.saas_uac.entity.Role;
import com.bit.saas_uac.mapper.RoleMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "角色管理")
@RestController
public class RoleController {
    @Autowired
    private RoleMapper roleMapper;

    @Operation(summary = "查询所有角色信息")
    @GetMapping("/role/all")
    public List<Role> getAllRole() {
        return roleMapper.selectList(null);
    }

    @Operation(summary = "查询单个角色信息")
    @GetMapping("/role/single")
    public Role getRole(String roleID) {
        return roleMapper.selectById(roleID);
    }

    @Operation(summary = "增加角色")
    @PostMapping("/role")
    public String addRole(Role role) {
        roleMapper.insert(role);
        return "ADD_SUCCESS";
    }

    @Operation(summary = "删除角色")
    @DeleteMapping("/role")
    public String deleteRole(String roleID) {
        roleMapper.deleteById(roleID);
        return "DELETE_SUCCESS";
    }
}
