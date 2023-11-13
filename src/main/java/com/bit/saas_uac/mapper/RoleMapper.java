package com.bit.saas_uac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bit.saas_uac.entity.Role;
import com.bit.saas_uac.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select * from Role where roleID=#{roleID}")
    @Results({
            @Result(column = "roleID", property = "roleID"),
            @Result(column = "roleMethod", property = "roleMethod"),
            @Result(column = "roleDescription", property = "roleDescription"),
            @Result(column = "roleID", property = "userList", javaType = List.class,
                    many=@Many(select="com.bit.saas_uac.mapper.UserRoleMapper.findUsersByRoleID")
            )
    })
    Role selectUsersForRole(String roleID);

    @Select("select * from Role")
    @Results({
            @Result(column = "roleID", property = "roleID"),
            @Result(column = "roleMethod", property = "roleMethod"),
            @Result(column = "roleDescription", property = "roleDescription"),
            @Result(column = "roleID", property = "userList", javaType = List.class,
                    many=@Many(select="com.bit.saas_uac.mapper.UserRoleMapper.findUsersByRoleID")
            )
    })
    List<Role> selectUsersForRoles();

    @Select("select * from Role where roleID=#{roleID} and roleMethod=#{roleMethod}")
    public Role selectByIdMethod(String roleID, String roleMethod);
}
