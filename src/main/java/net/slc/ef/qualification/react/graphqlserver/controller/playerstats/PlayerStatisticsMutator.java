package net.slc.ef.qualification.react.graphqlserver.controller.playerstats;

import net.slc.ef.qualification.react.graphqlserver.model.PlayerStats;
import net.slc.ef.qualification.react.graphqlserver.service.PlayerStatsService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class PlayerStatisticsMutator {

    private final PlayerStatsService playerStatsService;

    public PlayerStatisticsMutator(PlayerStatsService playerStatsService) {
        this.playerStatsService = playerStatsService;
    }

    @MutationMapping
    // Long playerId, Integer wins, Integer losses, Integer kills, Integer deaths, Integer assists, Integer money
    public PlayerStats updatePlayerStats(@Argument Long playerId, @Argument Integer wins, @Argument Integer losses, @Argument Integer kills, @Argument Integer deaths, @Argument Integer assists, @Argument Integer money) {
        return playerStatsService.updatePlayerStats(playerId, wins, losses, kills, deaths, assists, money);
    }

    @MutationMapping
    public PlayerStats resetPlayerStats(@Argument Long playerId) {
        return playerStatsService.resetPlayerStats(playerId);
    }
}
