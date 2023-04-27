package net.slc.ef.qualification.react.graphqlserver.controller.playerstats;

import net.slc.ef.qualification.react.graphqlserver.model.PlayerStats;
import net.slc.ef.qualification.react.graphqlserver.model.PlayerStatsPage;
import net.slc.ef.qualification.react.graphqlserver.service.PlayerStatsService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@Controller
@CrossOrigin
public class PlayerStatisticsQuery {

    private final PlayerStatsService playerStatsService;

    public PlayerStatisticsQuery(PlayerStatsService playerStatsService) {
        this.playerStatsService = playerStatsService;
    }

    @QueryMapping
    public PlayerStatsPage playerStats(@Argument Integer pageNumber, @Argument Integer limit) {
        return playerStatsService.getPlayerStats(pageNumber, limit);
    }

    @QueryMapping
    public PlayerStatsPage topPlayersByWins(@Argument Integer pageNumber, @Argument Integer limit) {
        return playerStatsService.getTopPlayersByWins(pageNumber, limit);
    }

    @QueryMapping
    public PlayerStatsPage topPlayersByLosses(@Argument Integer pageNumber, @Argument Integer limit) {
        return playerStatsService.getTopPlayersByLosses(pageNumber, limit);
    }

    @QueryMapping
    public PlayerStatsPage topPlayersByKills(@Argument Integer pageNumber, @Argument Integer limit) {
        return playerStatsService.getTopPlayersByKills(pageNumber, limit);
    }

    @QueryMapping
    public PlayerStatsPage topPlayersByDeaths(@Argument Integer pageNumber, @Argument Integer limit) {
        return playerStatsService.getTopPlayersByDeaths(pageNumber, limit);
    }

    @QueryMapping
    public PlayerStatsPage topPlayersByAssists(@Argument Integer pageNumber, @Argument Integer limit) {
        return playerStatsService.getTopPlayersByAssists(pageNumber, limit);
    }

    @QueryMapping
    public PlayerStatsPage topPlayersByMoney(@Argument Integer pageNumber, @Argument Integer limit) {
        return playerStatsService.getTopPlayersByMoney(pageNumber, limit);
    }

    @QueryMapping
    public Optional<PlayerStats> playerStatsById(@Argument Long id) {
        return playerStatsService.getPlayerStatsById(id);
    }

    @QueryMapping
    public Optional<PlayerStats> playerStatsByPlayerId(@Argument Long id) {
        return playerStatsService.getPlayerStatsByPlayerId(id);
    }

    @QueryMapping
    public Optional<PlayerStats> playerStatsByPlayerName(@Argument String name) {
        return playerStatsService.getPlayerStatsByPlayerName(name);
    }
}
