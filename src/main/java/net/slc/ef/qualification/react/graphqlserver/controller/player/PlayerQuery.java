package net.slc.ef.qualification.react.graphqlserver.controller.player;

import net.slc.ef.qualification.react.graphqlserver.model.Player;
import net.slc.ef.qualification.react.graphqlserver.model.PlayerPage;
import net.slc.ef.qualification.react.graphqlserver.service.PlayerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/graphql")
public class PlayerQuery {

    private final PlayerService playerService;

    public PlayerQuery(PlayerService playerService) {
        this.playerService = playerService;
    }

    @QueryMapping
    public PlayerPage players(@Argument Integer pageNumber, @Argument Integer limit) {
        return playerService.getPlayers(pageNumber, limit);
    }

    @QueryMapping
    public Optional<Player> playerById(@Argument Long id) {
        return playerService.getPlayerById(id);
    }

    @QueryMapping
    public Optional<Player> playerByName(@Argument String name) {
        return playerService.getPlayerByName(name);
    }
}
