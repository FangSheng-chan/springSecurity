package com.ss.springsecuritydemo1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author fangsheng
 * @date 2021/8/3 5:00 下午
 */
@Configuration
class mikeSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() //定义自己编写的登录页面
                .loginPage("/login.html") //登录页面设置
                .loginProcessingUrl("/user/login") //登录访问路径
                .defaultSuccessUrl("/test/index").permitAll() //登录成功后跳转页面
                .and().authorizeRequests()
                .antMatchers("/", "/test/hello", "/user/login").permitAll() //设置哪些路径不被保护
                .anyRequest().authenticated()
                .and().csrf().disable(); //关闭csrf防护
    }
}
