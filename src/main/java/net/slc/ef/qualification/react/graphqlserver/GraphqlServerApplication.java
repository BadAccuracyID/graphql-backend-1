package net.slc.ef.qualification.react.graphqlserver;

import net.slc.ef.qualification.react.graphqlserver.model.Player;
import net.slc.ef.qualification.react.graphqlserver.model.PlayerStatistics;
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
            Player player = new Player();
            player.setName("BadAccuracyID");
            Long id = playerService.createPlayer(player).getId();

            PlayerStatistics playerStatistics = playerStatisticsService.getPlayerStatisticsByPlayerId(id).orElseThrow();
            playerStatistics.setWins(100);
            playerStatistics.setLosses(18);
            playerStatistics.setKills(1000);
            playerStatistics.setDeaths(200);
            playerStatistics.setAssists(500);
            playerStatistics.setMoney(100000);
            playerStatisticsService.updatePlayerStatistics(playerStatistics);

            player = new Player();
            player.setName("sh_likes_to_win");
            id = playerService.createPlayer(player).getId();

            playerStatistics = playerStatisticsService.getPlayerStatisticsByPlayerId(id).orElseThrow();
            playerStatistics.setWins(1000);
            playerStatistics.setLosses(1);
            playerStatistics.setKills(10000);
            playerStatistics.setDeaths(2000);
            playerStatistics.setAssists(5000);
            playerStatistics.setMoney(1000000);
            playerStatisticsService.updatePlayerStatistics(playerStatistics);

            player = new Player();
            player.setName("FlxC4t");
            id = playerService.createPlayer(player).getId();

            playerStatistics = playerStatisticsService.getPlayerStatisticsByPlayerId(id).orElseThrow();
            playerStatistics.setWins(84);
            playerStatistics.setLosses(16);
            playerStatistics.setKills(5437);
            playerStatistics.setDeaths(1234);
            playerStatistics.setAssists(2345);
            playerStatistics.setMoney(1000);
            playerStatisticsService.updatePlayerStatistics(playerStatistics);

            player = new Player();
            player.setName("sh_likes_to_lose");
            id = playerService.createPlayer(player).getId();

            playerStatistics = playerStatisticsService.getPlayerStatisticsByPlayerId(id).orElseThrow();
            playerStatistics.setWins(1);
            playerStatistics.setLosses(1000);
            playerStatistics.setKills(2000);
            playerStatistics.setDeaths(10000);
            playerStatistics.setAssists(5000);
            playerStatistics.setMoney(1000000);
            playerStatisticsService.updatePlayerStatistics(playerStatistics);

            player = new Player();
            player.setName("elseif_condition");
            id = playerService.createPlayer(player).getId();

            playerStatistics = playerStatisticsService.getPlayerStatisticsByPlayerId(id).orElseThrow();
            playerStatistics.setWins(100);
            playerStatistics.setLosses(100);
            playerStatistics.setKills(1000);
            playerStatistics.setDeaths(1000);
            playerStatistics.setAssists(1000);
            playerStatistics.setMoney(100000);
            playerStatisticsService.updatePlayerStatistics(playerStatistics);
        };
    }
}
