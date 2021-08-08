package com.ss.springsecuritydemo1.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ss.springsecuritydemo1.entity.Users;
import com.ss.springsecuritydemo1.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserDetailsService")
public class MyUserDetailService implements UserDetailsService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //先通过username 查询数据库是否有这个用户
        // 条件构造器
        QueryWrapper<Users> userQueryWrapper = new QueryWrapper<>();
        // where username = ?
        userQueryWrapper.eq("username", username);
        Users user = this.usersMapper.selectOne(userQueryWrapper);
        //数据库没有当前用户名，认证失败
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        //权限设置
        List<GrantedAuthority> auths = AuthorityUtils.
                commaSeparatedStringToAuthorityList("admins,ROLE_sale");
        System.out.println("登录成功");
        //从查询数据库返回的user对象，得到用户名和密码
        return new User(user.getUsername(),
                new BCryptPasswordEncoder().encode(user.getPassword()), auths);
    }
}
