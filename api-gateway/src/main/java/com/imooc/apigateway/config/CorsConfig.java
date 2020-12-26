package com.imooc.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/*
 * Copyright is owned by YONYOU.
 * 跨域配置
 * cors的意思： C-Cross O-Origin R-Resource S-Sharing 跨域资源共享
 * @Package: com.imooc.apigateway.config
 * @author: Candy520
 * @date: 2019/6/2 18:40
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setMaxAge(300L);

        source.registerCorsConfiguration("/**",config);

        return new CorsFilter(source);
    }
}
