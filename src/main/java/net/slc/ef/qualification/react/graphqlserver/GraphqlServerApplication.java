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
            Player newPlayer = Player.builder()
                    .name("BadAccuracyID")
                    .motto("Regretting is a waste of time.")
                    .avatar("https://luckynetwork.net/_next/image?url=https%3A%2F%2Fmc-heads.net%2Favatar%2FLyraMS&w=256&q=75")
                    .instagram("https://www.instagram.com/efrnnthel/")
                    .build();
            playerService.addPlayer(newPlayer.getName(), newPlayer.getMotto(), newPlayer.getAvatar(), newPlayer.getInstagram());

            newPlayer = Player.builder()
                    .name("sh_likes_to_win")
                    .motto("I'm not a hacker, I'm just good.")
                    .avatar("https://luckynetwork.net/_next/image?url=https%3A%2F%2Fmc-heads.net%2Favatar%2FBlazePxly&w=256&q=75")
                    .instagram("https://www.instagram.com/stefaniesheryl/")
                    .build();
            playerService.addPlayer(newPlayer.getName(), newPlayer.getMotto(), newPlayer.getAvatar(), newPlayer.getInstagram());

            newPlayer = Player.builder()
                    .name("sh_likes_to_lose")
                    .motto("I'm not good, I'm just a hacker.")
                    .avatar("https://luckynetwork.net/_next/image?url=https%3A%2F%2Fmc-heads.net%2Favatar%2FFunaa&w=256&q=75")
                    .instagram("https://www.instagram.com/stefaniesheryl/")
                    .build();
            playerService.addPlayer(newPlayer.getName(), newPlayer.getMotto(), newPlayer.getAvatar(), newPlayer.getInstagram());

            newPlayer = Player.builder()
                    .name("sh_likes_to_assist")
                    .motto("Assisting is a waste of time.")
                    .avatar("https://luckynetwork.net/_next/image?url=https%3A%2F%2Fmc-heads.net%2Favatar%2Fnerozvox&w=256&q=75")
                    .instagram("https://www.instagram.com/stefaniesheryl/")
                    .build();
            playerService.addPlayer(newPlayer.getName(), newPlayer.getMotto(), newPlayer.getAvatar(), newPlayer.getInstagram());

            newPlayer = Player.builder()
                    .name("sh_likes_to_die")
                    .motto("Dying is a waste of time.")
                    .avatar("https://luckynetwork.net/_next/image?url=https%3A%2F%2Fmc-heads.net%2Favatar%2FKimRokSoo&w=256&q=75")
                    .instagram("https://www.instagram.com/stefaniesheryl/")
                    .build();
            playerService.addPlayer(newPlayer.getName(), newPlayer.getMotto(), newPlayer.getAvatar(), newPlayer.getInstagram());

            newPlayer = Player.builder()
                    .name("sh_likes_to_kill")
                    .motto("Killing is a waste of time.")
                    .avatar("https://luckynetwork.net/_next/image?url=https%3A%2F%2Fmc-heads.net%2Favatar%2FAfif87123&w=256&q=75")
                    .instagram("https://www.instagram.com/stefaniesheryl/")
                    .build();
            playerService.addPlayer(newPlayer.getName(), newPlayer.getMotto(), newPlayer.getAvatar(), newPlayer.getInstagram());

            newPlayer = Player.builder()
                    .name("TheSilentGamer")
                    .motto("I let my actions speak for me.")
                    .avatar("https://luckynetwork.net/_next/image?url=https%3A%2F%2Fmc-heads.net%2Favatar%2FNotch&w=256&q=75")
                    .instagram("https://www.instagram.com/thesilentgamer/")
                    .build();
            playerService.addPlayer(newPlayer.getName(), newPlayer.getMotto(), newPlayer.getAvatar(), newPlayer.getInstagram());

            newPlayer = Player.builder()
                    .name("FastFingers")
                    .motto("Speed is the key.")
                    .avatar("https://luckynetwork.net/_next/image?url=https%3A%2F%2Fmc-heads.net%2Favatar%2FTechnoblade&w=256&q=75")
                    .instagram("https://www.instagram.com/fastfingers/")
                    .build();
            playerService.addPlayer(newPlayer.getName(), newPlayer.getMotto(), newPlayer.getAvatar(), newPlayer.getInstagram());

            newPlayer = Player.builder()
                    .name("StrategistMaster")
                    .motto("Strategy wins battles.")
                    .avatar("https://luckynetwork.net/_next/image?url=https%3A%2F%2Fmc-heads.net%2Favatar%2Fxqlv&w=256&q=75")
                    .instagram("https://www.instagram.com/strategistmaster/")
                    .build();
            playerService.addPlayer(newPlayer.getName(), newPlayer.getMotto(), newPlayer.getAvatar(), newPlayer.getInstagram());

            newPlayer = Player.builder()
                    .name("LuckyCharm")
                    .motto("Luck favors the bold.")
                    .avatar("https://luckynetwork.net/_next/image?url=https%3A%2F%2Fmc-heads.net%2Favatar%2Famongus&w=256&q=75")
                    .instagram("https://www.instagram.com/luckycharmgamer/")
                    .build();
            playerService.addPlayer(newPlayer.getName(), newPlayer.getMotto(), newPlayer.getAvatar(), newPlayer.getInstagram());

            newPlayer = Player.builder()
                    .name("TheSneakyOne")
                    .motto("You'll never see me coming.")
                    .avatar("https://luckynetwork.net/_next/image?url=https%3A%2F%2Fmc-heads.net%2Favatar%2FTommyInnit&w=256&q=75")
                    .instagram("https://www.instagram.com/thesneakyone/")
                    .build();
            playerService.addPlayer(newPlayer.getName(), newPlayer.getMotto(), newPlayer.getAvatar(), newPlayer.getInstagram());

            playerService.getPlayerByName("BadAccuracyID").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(100);
                playerStats.setLosses(18);
                playerStats.setKills(1000);
                playerStats.setDeaths(200);
                playerStats.setAssists(500);
                playerStats.setMoney(10000000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });

            playerService.getPlayerByName("sh_likes_to_win").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(10000);
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
                playerStats.setLosses(10000);
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
                playerStats.setAssists(50000);
                playerStats.setMoney(100000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });

            playerService.getPlayerByName("sh_likes_to_die").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(100);
                playerStats.setLosses(18);
                playerStats.setKills(1000);
                playerStats.setDeaths(50000);
                playerStats.setAssists(200);
                playerStats.setMoney(100000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });

            playerService.getPlayerByName("sh_likes_to_kill").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(100);
                playerStats.setLosses(18);
                playerStats.setKills(50000);
                playerStats.setDeaths(200);
                playerStats.setAssists(1000);
                playerStats.setMoney(100000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });

            playerService.getPlayerByName("TheSilentGamer").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(250);
                playerStats.setLosses(50);
                playerStats.setKills(3000);
                playerStats.setDeaths(500);
                playerStats.setAssists(1500);
                playerStats.setMoney(500000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });

            playerService.getPlayerByName("FastFingers").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(300);
                playerStats.setLosses(100);
                playerStats.setKills(4000);
                playerStats.setDeaths(700);
                playerStats.setAssists(2000);
                playerStats.setMoney(600000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });

            playerService.getPlayerByName("StrategistMaster").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(500);
                playerStats.setLosses(200);
                playerStats.setKills(2500);
                playerStats.setDeaths(1000);
                playerStats.setAssists(4000);
                playerStats.setMoney(800000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });

            playerService.getPlayerByName("LuckyCharm").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(1000);
                playerStats.setLosses(500);
                playerStats.setKills(6000);
                playerStats.setDeaths(3000);
                playerStats.setAssists(1000);
                playerStats.setMoney(2000000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });

            playerService.getPlayerByName("TheSneakyOne").ifPresent(player -> {
                PlayerStats playerStats = new PlayerStats();
                playerStats.setPlayer(player);
                playerStats.setWins(400);
                playerStats.setLosses(300);
                playerStats.setKills(5000);
                playerStats.setDeaths(1500);
                playerStats.setAssists(3000);
                playerStats.setMoney(700000);
                playerStatsService.updatePlayerStats(player.getId(), playerStats.getWins(), playerStats.getLosses(), playerStats.getKills(), playerStats.getDeaths(), playerStats.getAssists(), playerStats.getMoney());
            });
        };
    }
}
