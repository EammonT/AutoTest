package org.apitest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apitest.entity.User;

@Mapper
public interface UserDao extends BaseMapper<User>{

}
