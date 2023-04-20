package net.slc.ef.qualification.react.graphqlserver.controller.player;

import net.slc.ef.qualification.react.graphqlserver.model.Player;
import net.slc.ef.qualification.react.graphqlserver.model.PlayerStatistics;
import net.slc.ef.qualification.react.graphqlserver.service.PlayerService;
import net.slc.ef.qualification.react.graphqlserver.service.PlayerStatisticsService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerMutator {

    private final PlayerService playerService;
    private final PlayerStatisticsService statisticsService;

    public PlayerMutator(PlayerService playerService, PlayerStatisticsService statisticsService) {
        this.playerService = playerService;
        this.statisticsService = statisticsService;
    }

    @MutationMapping
    public Player addPlayer(@Argument String name) {
        Player player = new Player();
        player.setName(name);

        return playerService.createPlayer(player);
    }

    @MutationMapping
    public Player updatePlayer(@Argument Long id, @Argument String name) {
        Player player = playerService.getPlayer(id).orElseThrow();
        player.setName(name);

        return playerService.updatePlayer(player);
    }

    @MutationMapping
    public Long removePlayer(@Argument Long id) {
        return playerService.deletePlayer(id);
    }

    @MutationMapping
    public String removePlayerByName(@Argument String name) {
        return playerService.deletePlayerByName(name);
    }

}
