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
        configuration.addAllowedOrigin("http://localhost:3000"); // Allow requests from any origin
        configuration.addAllowedMethod("POST"); // Allow only POST requests
        configuration.addAllowedMethod("GET"); // Allow only GET requests
        configuration.addAllowedMethod("DELETE"); // Allow only GET requests
        configuration.addAllowedMethod("HEAD"); // Allow only GET requests
        configuration.addAllowedHeader("authorization"); // Allow the authorization header
        configuration.addAllowedHeader("content-type"); // Allow the content type header
        configuration.addAllowedHeader("Access-Control-Allow-Origin"); // Allow the Access-Control-Allow-Origin header
        configuration.addAllowedHeader("Access-Control-Allow-Headers"); // Allow the Access-Control-Allow-Headers header
        configuration.addAllowedHeader("Access-Control-Allow-Methods"); // Allow the Access-Control-Allow-Methods header
        configuration.addAllowedHeader("Access-Control-Allow-Credentials"); // Allow the Access-Control-Allow-Credentials header
        configuration.addAllowedHeader("Access-Control-Max-Age"); // Allow the Access-Control-Max-Age header

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        source.registerCorsConfiguration("/graphql/**", configuration);
        return source;
    }


}
