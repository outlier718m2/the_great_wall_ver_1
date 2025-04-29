package com.thegreatwall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 인증 처리 및 권한 설정
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
            .authorizeRequests()
                // 정적 리소스 및 공개 경로 설정
                .antMatchers(
                    "/", 
                    "/index.html", 
                    "/static/**", 
                    "/thegreatwall/**",
                    "/thegreatwall/static/**",
                    "/thegreatwall/auth/**",
                    "/thegreatwall/index.html",
                    "/auth/**"
                ).permitAll()  // 누구나 접근할 수 있는 페이지
                .anyRequest().authenticated()  // 나머지 페이지는 인증 필요
                .and()
            .formLogin()
                .loginPage("/thegreatwall/auth/login")  // React 라우팅과 일치하는 로그인 페이지 경로
                .loginProcessingUrl("/api/auth/login")  // 실제 로그인 처리 API 경로
                .defaultSuccessUrl("/thegreatwall", true)  // 로그인 성공 후 리다이렉트 경로
                .permitAll()  // 로그인 페이지는 누구나 접근 가능
                .and()
            .logout()
                .logoutUrl("/api/auth/logout")  // 로그아웃 처리 API 경로
                .logoutSuccessUrl("/thegreatwall/auth/login")  // 로그아웃 성공 후 리다이렉트 경로
                .permitAll();  // 로그아웃도 누구나 가능
            
        // SPA를 위한 프레임 옵션 설정
        http.headers().frameOptions().sameOrigin();
    }
    
    // 비밀번호 암호화를 위한 BCryptPasswordEncoder 설정
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}