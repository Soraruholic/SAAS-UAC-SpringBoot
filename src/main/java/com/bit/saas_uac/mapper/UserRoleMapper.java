package com.bit.saas_uac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bit.saas_uac.entity.Role;
import com.bit.saas_uac.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    @Select("select * from UserRole where userID=#{userID}")
    public List<Role> findRolesByUserID(String userID);

    @Select("select * from UserRole where roleID=#{roleID}")
    public List<User> findUsersByRoleID(String roleID);

    @Insert("insert into UserRole (userID, roleID) values (#{userID}, #{roleID})")
    public void insertUserRole(String userID, String roleID);

    @Delete("delete from UserRole where userID=#{userID} and roleID=#{roleID}")
    public void deleteUserRole(String userID, String roleID);

}
