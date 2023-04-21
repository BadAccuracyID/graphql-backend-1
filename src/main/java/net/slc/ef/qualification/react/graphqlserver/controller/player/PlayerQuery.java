package net.slc.ef.qualification.react.graphqlserver.controller.player;

import net.slc.ef.qualification.react.graphqlserver.model.Player;
import net.slc.ef.qualification.react.graphqlserver.service.PlayerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class PlayerQuery {

    private final PlayerService playerService;

    public PlayerQuery(PlayerService playerService) {
        this.playerService = playerService;
    }

    @QueryMapping
    public Iterable<Player> players() {
        return playerService.getAllPlayers();
    }

    @QueryMapping
    public Optional<Player> player(@Argument Long id) {
        return playerService.getPlayerById(id);
    }

    @QueryMapping
    public Player playerByName(@Argument String name) {
        return playerService.getPlayerByName(name);
    }
}
