package net.slc.ef.qualification.react.graphqlserver.controller.player;

import net.slc.ef.qualification.react.graphqlserver.model.Player;
import net.slc.ef.qualification.react.graphqlserver.service.PlayerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class PlayerMutator {

    private final PlayerService playerService;

    public PlayerMutator(PlayerService playerService) {
        this.playerService = playerService;
    }

    @MutationMapping
    public Player addPlayer(@Argument String name) {
        return playerService.addPlayer(name);
    }

    @MutationMapping
    public Player updatePlayer(@Argument Long id, @Argument String name) {
        return playerService.updatePlayer(id, name);
    }

    @MutationMapping
    public Long removePlayer(@Argument Long id) {
        return playerService.removePlayer(id);
    }

    @MutationMapping
    public Long removePlayerByName(@Argument String name) {
        return playerService.removePlayerByName(name);
    }

}
