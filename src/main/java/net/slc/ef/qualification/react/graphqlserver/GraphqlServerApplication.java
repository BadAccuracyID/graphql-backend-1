package net.slc.ef.qualification.react.graphqlserver;

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
            playerService.addPlayer("BadAccuracyID");
            playerService.addPlayer("sh_likes_to_win");
            playerService.addPlayer("sh_likes_to_lose");
            playerService.addPlayer("sh_likes_to_assist");
            playerService.addPlayer("sh_likes_to_die");
            playerService.addPlayer("sh_likes_to_kill");

            playerService.getPlayerByName("BadAccuracyID").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(100);
                playerStats.setLosses(18);
                playerStats.setKills(1000);
                playerStats.setDeaths(200);
                playerStats.setAssists(500);
                playerStats.setMoney(100000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });

            playerService.getPlayerByName("sh_likes_to_win").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(1000);
                playerStats.setLosses(1);
                playerStats.setKills(10000);
                playerStats.setDeaths(2000);
                playerStats.setAssists(5000);
                playerStats.setMoney(1000000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });

            playerService.getPlayerByName("sh_likes_to_lose").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(1);
                playerStats.setLosses(1000);
                playerStats.setKills(2000);
                playerStats.setDeaths(10000);
                playerStats.setAssists(5000);
                playerStats.setMoney(1000000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });

            playerService.getPlayerByName("sh_likes_to_assist").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(100);
                playerStats.setLosses(18);
                playerStats.setKills(1000);
                playerStats.setDeaths(200);
                playerStats.setAssists(5000);
                playerStats.setMoney(100000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });

            playerService.getPlayerByName("sh_likes_to_die").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(100);
                playerStats.setLosses(18);
                playerStats.setKills(1000);
                playerStats.setDeaths(5000);
                playerStats.setAssists(200);
                playerStats.setMoney(100000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });

            playerService.getPlayerByName("sh_likes_to_kill").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(100);
                playerStats.setLosses(18);
                playerStats.setKills(5000);
                playerStats.setDeaths(200);
                playerStats.setAssists(1000);
                playerStats.setMoney(100000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });
        };
    }
}
