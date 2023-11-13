package com.bit.saas_uac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bit.saas_uac.entity.LogUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogUserMapper extends BaseMapper<LogUser> {
}
