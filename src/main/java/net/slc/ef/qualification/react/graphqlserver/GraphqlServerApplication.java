package net.slc.ef.qualification.react.graphqlserver;

import net.slc.ef.qualification.react.graphqlserver.service.PlayerService;
import net.slc.ef.qualification.react.graphqlserver.service.PlayerStatisticsService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlServerApplication.class, args);
    }

    @Bean
    protected ApplicationRunner init(PlayerService playerService, PlayerStatisticsService playerStatisticsService) {
        return args -> {


        };
    }
}
