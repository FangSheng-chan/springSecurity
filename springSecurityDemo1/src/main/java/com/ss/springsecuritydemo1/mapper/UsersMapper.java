package com.ss.springsecuritydemo1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ss.springsecuritydemo1.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper extends BaseMapper<Users> {
}
