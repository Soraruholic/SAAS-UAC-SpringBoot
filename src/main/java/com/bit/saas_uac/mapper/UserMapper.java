package com.bit.saas_uac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bit.saas_uac.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from User where userID=#{userID}")
    @Results({
        @Result(column = "userID", property = "userID"),
        @Result(column = "userName", property = "userName"),
        @Result(column = "userPassword", property = "userPassword"),
        @Result(column = "userEmail", property = "userEmail"),
        @Result(column = "userPhone", property = "userPhone"),
        @Result(column = "lastPasswordResetDate", property = "lastPasswordResetDate"),
        @Result(column = "userID", property = "roleList", javaType = List.class,
            many=@Many(select="com.bit.saas_uac.mapper.UserRoleMapper.findRolesByUserID")
        )
    })
    User selectRolesForUser(String userID);


    @Select("select * from User")
    @Results({
        @Result(column = "userID", property = "userID"),
        @Result(column = "userName", property = "userName"),
        @Result(column = "userPassword", property = "userPassword"),
        @Result(column = "userEmail", property = "userEmail"),
        @Result(column = "userPhone", property = "userPhone"),
        @Result(column = "lastPasswordResetDate", property = "lastPasswordResetDate"),
        @Result(column = "userID", property = "roleList", javaType = List.class,
            many=@Many(select="com.bit.saas_uac.mapper.UserRoleMapper.findRolesByUserID")
        )
    })
    List<User> selectRolesForUsers();
}
