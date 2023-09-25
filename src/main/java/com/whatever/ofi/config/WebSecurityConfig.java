package com.whatever.ofi.config;

import com.whatever.ofi.Security.JwtFilter;
import com.whatever.ofi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final UserService userService;

    @Value("${jwt.secret}")
    private String secretKey;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // 특정 API에 대해 모든 사용자에게 접근 허용
                .antMatchers("*").permitAll()
//                .antMatchers("/user/register").permitAll()
//                .antMatchers("/board/return").permitAll()
//                .antMatchers("/user/login").permitAll()
//                .antMatchers("/search/recommand").permitAll()
//                .antMatchers("/search/updateData").permitAll()
//                .antMatchers("/chat/room").permitAll()
//                .antMatchers("/user/profile").permitAll()
//                .antMatchers("/coordinator/profile").permitAll()
//                .antMatchers("/board/create").permitAll()
//                .antMatchers("/main/test").permitAll()
//                .antMatchers("/main/user").permitAll()
//                .anyRequest().authenticated() // 나머지 API에 대해서는 인증을 요구

                .and()
                .addFilterBefore(new JwtFilter(userService, secretKey), UsernamePasswordAuthenticationFilter.class);


        http
                .cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable())
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((request, response, authentication) -> {
                    System.out.print("Success");
                })
                .deleteCookies("JSESSIONID", "token") // 로그아웃 후 삭제할 쿠키 지정
                .permitAll() // /logout 엔드포인트에 대한 접근은 모든 사용자에게 허용
                .and()
                .httpBasic().disable();
        return http.build();
    }
}
