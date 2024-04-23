package com.assessment.assessmenttest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.NullSecurityContextRepository;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor
public class SecurityConfig {
	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(AbstractHttpConfigurer::disable)
			.cors(CorsConfigurer::disable)
			.sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
			.oauth2ResourceServer(
				oauth2 -> oauth2.jwt(Customizer.withDefaults()))
			.securityContext(
				securityContext ->
					securityContext.securityContextRepository(new NullSecurityContextRepository()))
			.authorizeHttpRequests(
				authorize -> authorize.requestMatchers("/actuator/**").permitAll().anyRequest().authenticated())
			.exceptionHandling(
				exceptionHandling ->
					exceptionHandling
						.authenticationEntryPoint(this.jwtAuthenticationEntryPoint));

		return http.build();
	}
}
