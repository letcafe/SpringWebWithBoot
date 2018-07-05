package com.edoctor.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY =
            "SELECT phone_number,PASSWORD(password),true " +
                    "FROM company_admin " +
                    "where phone_number = ?";

    private DataSource dataSource;

    @Autowired
    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // 允许加载所有的静态资源而不拦截
                .antMatchers("/js/**", "/css/**", "/images/**", "/fonts/**", "/audio/**").permitAll()
                // 允许特定路径被直接访问
                .antMatchers("/index", "/websock").permitAll()
                // 为匹配到的URL只需要对用户进行身份认证
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/index", true).failureUrl("/login?error").
                // 设置以上页面允许访问，即默认只允许直接登录
                permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).
                withUser("user").password(new BCryptPasswordEncoder().encode("pwd")).roles("USER").and()
                .withUser("admin").password("pwd").roles("USER", "ADMIN");
    }

}
