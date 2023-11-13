package com.bit.saas_uac.controller;

import com.bit.saas_uac.entity.Role;
import com.bit.saas_uac.mapper.RoleMapper;
import com.bit.saas_uac.mapper.UserRoleMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "访问控制")
@RestController
public class AccessController {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Operation(summary = "查询用户是否有权限进行操作/访问资源")
    @GetMapping("/access")
    public String access(String userID, String url, String method) {
        // 根据用户ID,查询用户的角色列表
        List<Role> roleList = userRoleMapper.findRolesByUserID(userID);
        // 根据角色ID列表,查询角色的描述，并且进行匹配
        for (Role role : roleList) {
            // 根据角色描述,查询角色的权限列表
            String roleID = role.getRoleID();
            Role _role = roleMapper.selectByIdMethod(roleID, method);
            if (_role != null) {
                String roleDescription = _role.getRoleDescription();
                System.out.println(roleDescription);
                // 根据权限列表，进行匹配
                // 匹配规则: 若权限可以局部匹配,则返回"ACCESS_GRANTED"
                // 若权限不可以局部匹配,则返回"ACCESS_DENIED"
                if (roleDescription != null && url.startsWith(roleDescription)) {
                    return "ACCESS_GRANTED";
                }
            }
        }
        return "ACCESS_DENIED";
    }
}
