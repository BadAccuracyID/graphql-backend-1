package net.slc.ef.qualification.react.graphqlserver.controller.playerstats;

import net.slc.ef.qualification.react.graphqlserver.model.Player;
import net.slc.ef.qualification.react.graphqlserver.model.PlayerStatistics;
import net.slc.ef.qualification.react.graphqlserver.service.PlayerStatisticsService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class PlayerStatisticsQuery {

    private final PlayerStatisticsService playerStatisticsService;

    public PlayerStatisticsQuery(PlayerStatisticsService playerStatisticsService) {
        this.playerStatisticsService = playerStatisticsService;
    }

    @QueryMapping
    public Iterable<PlayerStatistics> playerStats() {
        return playerStatisticsService.getAllPlayerStatistics();
    }

    @QueryMapping
    public Iterable<Player> topPlayersByWins(@Argument int limit) {
        return playerStatisticsService.getTopPlayersByWins(limit);
    }

    @QueryMapping
    public Optional<PlayerStatistics> playerStatsById(@Argument Long id) {
        return playerStatisticsService.getPlayerStatistics(id);
    }

    @QueryMapping
    public Optional<PlayerStatistics> playerStatsByPlayerId(@Argument Long id) {
        return playerStatisticsService.getPlayerStatisticsByPlayerId(id);
    }

    @QueryMapping
    public Optional<PlayerStatistics> playerStatsByPlayerName(@Argument String name) {
        return playerStatisticsService.getPlayerStatisticsByPlayerName(name);
    }
}
