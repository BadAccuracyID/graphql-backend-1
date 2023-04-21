package net.slc.ef.qualification.react.graphqlserver;

import net.slc.ef.qualification.react.graphqlserver.model.Player;
import net.slc.ef.qualification.react.graphqlserver.model.PlayerStats;
import net.slc.ef.qualification.react.graphqlserver.service.PlayerService;
import net.slc.ef.qualification.react.graphqlserver.service.PlayerStatsService;
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
    protected ApplicationRunner init(PlayerService playerService, PlayerStatsService playerStatsService) {
        return args -> {
//            Player player = new Player();
//            player.setName("BadAccuracyID");
//            Long id = playerService.addPlayer("BadAccuracyID").getId();
//
//            PlayerStats playerStats = playerStatsService.getPlayerStatisticsByPlayerId(id).orElseThrow();
//            playerStats.setPlayer(player);
//            playerStats.setWins(100);
//            playerStats.setLosses(18);
//            playerStats.setKills(1000);
//            playerStats.setDeaths(200);
//            playerStats.setAssists(500);
//            playerStats.setMoney(100000);
//            playerStatsService.updatePlayerStatistics(playerStats);
//
//            player = new Player();
//            player.setName("sh_likes_to_win");
//            id = playerService.createPlayer(player).getId();
//
//            playerStats = playerStatsService.getPlayerStatisticsByPlayerId(id).orElseThrow();
//            playerStats.setWins(1000);
//            playerStats.setLosses(1);
//            playerStats.setKills(10000);
//            playerStats.setDeaths(2000);
//            playerStats.setAssists(5000);
//            playerStats.setMoney(1000000);
//            playerStatsService.updatePlayerStatistics(playerStats);
//
//            player = new Player();
//            player.setName("FlxC4t");
//            id = playerService.createPlayer(player).getId();
//
//            playerStats = playerStatsService.getPlayerStatisticsByPlayerId(id).orElseThrow();
//            playerStats.setWins(84);
//            playerStats.setLosses(16);
//            playerStats.setKills(5437);
//            playerStats.setDeaths(1234);
//            playerStats.setAssists(2345);
//            playerStats.setMoney(1000);
//            playerStatsService.updatePlayerStatistics(playerStats);
//
//            player = new Player();
//            player.setName("sh_likes_to_lose");
//            id = playerService.createPlayer(player).getId();
//
//            playerStats = playerStatsService.getPlayerStatisticsByPlayerId(id).orElseThrow();
//            playerStats.setWins(1);
//            playerStats.setLosses(1000);
//            playerStats.setKills(2000);
//            playerStats.setDeaths(10000);
//            playerStats.setAssists(5000);
//            playerStats.setMoney(1000000);
//            playerStatsService.updatePlayerStatistics(playerStats);
//
//            player = new Player();
//            player.setName("elseif_condition");
//            id = playerService.createPlayer(player).getId();
//
//            playerStats = playerStatsService.getPlayerStatisticsByPlayerId(id).orElseThrow();
//            playerStats.setWins(100);
//            playerStats.setLosses(100);
//            playerStats.setKills(1000);
//            playerStats.setDeaths(1000);
//            playerStats.setAssists(1000);
//            playerStats.setMoney(100000);
//            playerStatsService.updatePlayerStatistics(playerStats);
        };
    }
}
