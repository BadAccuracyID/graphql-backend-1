package net.slc.ef.qualification.react.graphqlserver.controller.playerstats;

import net.slc.ef.qualification.react.graphqlserver.model.PlayerStatistics;
import net.slc.ef.qualification.react.graphqlserver.service.PlayerStatisticsService;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class PlayerStatisticsMutator {

    private final PlayerStatisticsService playerStatisticsService;

    public PlayerStatisticsMutator(PlayerStatisticsService playerStatisticsService) {
        this.playerStatisticsService = playerStatisticsService;
    }

    @MutationMapping
    public PlayerStatistics updatePlayerStats(@Arguments Map<String, Object> args) {
        long playerId = Long.parseLong(args.get("playerId").toString());
        PlayerStatistics playerStatistics = playerStatisticsService.getPlayerStatisticsByPlayerId(playerId).orElseThrow();

        if (args.containsKey("wins"))
            playerStatistics.setWins(Integer.parseInt(args.get("wins").toString()));
        if (args.containsKey("losses"))
            playerStatistics.setLosses(Integer.parseInt(args.get("losses").toString()));
        if (args.containsKey("kills"))
            playerStatistics.setKills(Integer.parseInt(args.get("kills").toString()));
        if (args.containsKey("deaths"))
            playerStatistics.setDeaths(Integer.parseInt(args.get("deaths").toString()));
        if (args.containsKey("assists"))
            playerStatistics.setAssists(Integer.parseInt(args.get("assists").toString()));
        if (args.containsKey("money"))
            playerStatistics.setMoney(Integer.parseInt(args.get("money").toString()));

        return playerStatisticsService.updatePlayerStatistics(playerStatistics);
    }

    @MutationMapping
    public PlayerStatistics resetPlayerStats(@Arguments Map<String, Object> args) {
        PlayerStatistics playerStatistics = playerStatisticsService.getPlayerStatistics((Long) args.get("id")).orElseThrow();
        playerStatistics.setWins(0);
        playerStatistics.setLosses(0);
        playerStatistics.setKills(0);
        playerStatistics.setDeaths(0);
        playerStatistics.setAssists(0);
        playerStatistics.setMoney(0);

        return playerStatisticsService.updatePlayerStatistics(playerStatistics);
    }
}
