package net.slc.ef.qualification.react.graphqlserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class AppConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); // Allow requests from any origin
        configuration.addAllowedMethod("POST"); // Allow only POST requests
        configuration.addAllowedMethod("GET"); // Allow only POST requests
        configuration.addAllowedHeader("authorization"); // Allow the authorization header

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Apply CORS to the endpoint
        source.registerCorsConfiguration("/graphql/**", configuration); // Apply CORS to the GraphQL endpoint

        return source;
    }

}
