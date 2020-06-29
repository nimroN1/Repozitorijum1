package com.nimro.N1ERP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class N1ErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(N1ErpApplication.class, args);
	}
	
	/*
	 * @Bean public CorsFilter corsFilter() { UrlBasedCorsConfigurationSource source
	 * = new UrlBasedCorsConfigurationSource(); CorsConfiguration config = new
	 * CorsConfiguration(); config.setAllowCredentials(true);
	 * config.addAllowedOrigin("*"); config.addAllowedHeader("*");
	 * config.addExposedHeader("total-pages"); config.addAllowedMethod("*");
	 * source.registerCorsConfiguration("/**", config); return new
	 * CorsFilter((CorsConfigurationSource) source); }
	 */

}
