package com.vish.spring.security.config;

import static org.springframework.security.config.Customizer.withDefaults;

import com.vish.spring.entity.UserData;
import com.vish.spring.repository.UserRepo;
import com.vish.spring.security.UserDataDetailService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.UrlPathHelper;

@Configuration
@EnableWebSecurity
public class AppSecurity {

  @Autowired
  UserDataDetailService userDataDetailService;

  @Bean
  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(auth -> auth.requestMatchers("/register/**").permitAll()
            .requestMatchers("/registration").permitAll()
            .anyRequest().authenticated()
        ).formLogin(
            form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/vehicle")
                .permitAll()
        )
        .httpBasic(withDefaults());
    return http.build();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDataDetailService).passwordEncoder(passwordEncoder());
  }

  @Bean
  public static HandlerInterceptor interceptLogin() {
    return new HandlerInterceptor(){
      final String current = "current";
      final UrlPathHelper urlPathHelper = new UrlPathHelper();
      @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if ("/login".equals(urlPathHelper.getLookupPathForRequest(request)) && isAuthenticated()) {
          String encodedRedirectURL = response.encodeRedirectURL(
              request.getContextPath() + "/vehicle");
          response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
          response.setHeader("Location", encodedRedirectURL);

          return false;
        } else {
          return true;
        }
      }

      private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
            isAssignableFrom(authentication.getClass())) {
          return false;
        }
        return authentication.isAuthenticated();
      }
    };
  }
}
